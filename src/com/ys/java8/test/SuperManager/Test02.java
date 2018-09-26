package com.ys.java8.test.SuperManager;

import java.io.*;
import java.math.BigDecimal;
import java.net.*;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
/**
 * 类相关的工具类
 * @author <a href="mailto:ohergal@gmail.com">ohergal</a>
 *
 */
public class Test02 {

    public static void main(String[] args) throws Exception{
        List<Class> classes = Test02.getAllClassByInterface(Class.forName("com.ys.java8.Demo"));
        for (Class clas :classes) {
            System.out.println(clas.getName());
        }
    }
    /**
     * 取得某个接口下所有实现这个接口的类
     * */
    public static List<Class> getAllClassByInterface(Class c) {
        List<Class>  returnClassList = null;

        if(c.isInterface()) {
            // 获取当前的包名
            String packageName = c.getPackage().getName();
            // 获取当前包下以及子包下所以的类
            List<Class<?>> allClass = getClasses(packageName);
            if(allClass != null) {
                returnClassList = new ArrayList<Class>();
                for(Class classes : allClass) {
                    // 判断是否是同一个接口
                    if(c.isAssignableFrom(classes)) {
                        // 本身不加入进去
                        if(!c.equals(classes)) {
                            returnClassList.add(classes);
                        }
                    }
                }
            }
        }

        return returnClassList;
    }


    /*
     * 取得某一类所在包的所有类名 不含迭代
     */
    public static String[] getPackageAllClassName(String classLocation, String packageName){
        //将packageName分解
        String[] packagePathSplit = packageName.split("[.]");
        String realClassLocation = classLocation;
        int packageLength = packagePathSplit.length;
        for(int i = 0; i< packageLength; i++){
            realClassLocation = realClassLocation + File.separator+packagePathSplit[i];
        }
        File packeageDir = new File(realClassLocation);
        if(packeageDir.isDirectory()){
            String[] allClassName = packeageDir.list();
            return allClassName;
        }
        return null;
    }

    public static List<Class<?>> getClasses(String packageName){

        //第一个class类的集合
        List<Class<?>> classes = new ArrayList<Class<?>>();
        //是否循环迭代
        boolean recursive = true;
        //获取包的名字 并进行替换
        String packageDirName = packageName.replace('.', '/');
        //定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            //循环迭代下去
            while (dirs.hasMoreElements()){
                //获取下一个元素
                URL url = dirs.nextElement();
                //得到协议的名称
                String protocol = url.getProtocol();
                //如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    //获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    //以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                } else if ("jar".equals(protocol)){
                    //如果是jar包文件
                    //定义一个JarFile
                    JarFile jar;
                    try {
                        //获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        //从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        //同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            //获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            //如果是以/开头的
                            if (name.charAt(0) == '/') {
                                //获取后面的字符串
                                name = name.substring(1);
                            }
                            //如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                //如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    //获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.');
                                }
                                //如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive){
                                    //如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        //去掉后面的".class" 获取真正的类名
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            //添加到classes
                                            classes.add(Class.forName(packageName + '.' + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return classes;
    }

    /**
     * 以文件的形式来获取包下的所有Class
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     */
    public static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, List<Class<?>> classes){
        //获取此包的目录 建立一个File
        File dir = new File(packagePath);
        //如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        //如果存在 就获取包下的所有文件 包括目录
        File[] dirfiles = dir.listFiles(new FileFilter() {
            //自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
            public boolean accept(File file) {
                return (recursive && file.isDirectory()) || (file.getName().endsWith(".class"));
            }
        });
        //循环所有文件
        for (File file : dirfiles) {
            //如果是目录 则继续扫描
            if (file.isDirectory()) {
                findAndAddClassesInPackageByFile(packageName + "." + file.getName(),
                        file.getAbsolutePath(),
                        recursive,
                        classes);
            }
            else {
                //如果是java类文件 去掉后面的.class 只留下类名
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    //添加到集合中去
                    classes.add(Class.forName(packageName + '.' + className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Map<String, BigDecimal> getLatAndLngByAddress(String addr){
        String address = "";
        String lat = "";
        String lng = "";
        try {
            address = java.net.URLEncoder.encode(addr,"UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String url = String.format("http://api.map.baidu.com/geocoder/v2/?"
                +"ak=njMkhHol3MfYZqG2i9lu2alZQpy583je&output=json&address=%s",address);
        URL myURL = null;
        URLConnection httpsConn = null;
        //进行转码
        try {
            myURL = new URL(url);
        } catch (MalformedURLException e) {

        }
        try {
            httpsConn = (URLConnection) myURL.openConnection();
            if (httpsConn != null) {
                InputStreamReader insr = new InputStreamReader(
                        httpsConn.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(insr);
                String data = null;
                if ((data = br.readLine()) != null) {
                    lat = data.substring(data.indexOf("\"lat\":")
                            + ("\"lat\":").length(), data.indexOf("},\"precise\""));
                    lng = data.substring(data.indexOf("\"lng\":")
                            + ("\"lng\":").length(), data.indexOf(",\"lat\""));
                }
                insr.close();
            }
        } catch (IOException e) {

        }
        Map<String, BigDecimal> map = new HashMap<String, BigDecimal>();
        map.put("lat", new BigDecimal(lat));
        map.put("lng", new BigDecimal(lng));
//
//        try {
//            getCoordinate(map.get("lat") + "", map.get("lng") + "");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        return map;
    }

//    public String getCoordinate(String lng,String lat) throws IOException {
//        StringBuilder resultData = new StringBuilder();
//        //秘钥换成你的秘钥，申请地址在下边
//        String url ="http://api.map.baidu.com/geocoder/v2/?ak="
//                +"njMkhHol3MfYZqG2i9lu2alZQpy583je"+"&location=" + lat + ","+ lng + "&output=json&pois=1";
//        URL myURL = null;
//        URLConnection httpsConn = null;
//        try {
//            myURL = new URL(url);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        InputStreamReader insr = null;
//        BufferedReader br = null;
//        try {
//            httpsConn = (URLConnection) myURL.openConnection();// 不使用代理
//            if (httpsConn != null) {
//                insr = new InputStreamReader( httpsConn.getInputStream(), "UTF-8");
//                br = new BufferedReader(insr);
//                String data = null;
//                while((data= br.readLine())!=null){
//                    resultData.append(data);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if(insr!=null){
//                insr.close();
//            }
//            if(br!=null){
//                br.close();
//            }
//        }
//        System.out.println(resultData);
//        String province= JSONObject.fromObject(resultData.toString()).getJSONObject("result")
//                .getJSONObject("addressComponent").getString("city");
//        return "city";
//    }
}

