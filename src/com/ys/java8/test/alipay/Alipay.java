package com.ys.java8.test.alipay;

import org.junit.Test;
import sun.net.util.IPAddressUtil;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author HuaDong
 * @date 2019/9/2 13:45
 */
public class Alipay {

    /**
     * 存放文件的目录
     */
    private final static String BILL_PATH = "D:\\idea\\java8-in-action\\src\\com\\ys\\java8\\test";

    /**
     * 解压文件zip
     *
     * @param zipFile 需要解压文件
     * @param descDir 解压完成之后输出的文件夹
     * @throws IOException
     */
    private void zipDecompressing(File zipFile, String descDir) {
        try {
            Charset gbk = Charset.forName("gbk");
            ZipInputStream Zin = new ZipInputStream(new FileInputStream(zipFile), gbk);//输入源zip路径
            BufferedInputStream Bin = new BufferedInputStream(Zin);
            String Parent = descDir; //输出路径（文件夹目录）
            File Fout = null;
            ZipEntry entry;
            try {
                while ((entry = Zin.getNextEntry()) != null && !entry.isDirectory()) {
                    Fout = new File(Parent, entry.getName());
                    if (!Fout.exists()) {
                        (new File(Fout.getParent())).mkdirs();
                    }
                    FileOutputStream out = new FileOutputStream(Fout);
                    BufferedOutputStream Bout = new BufferedOutputStream(out);
                    int b;
                    while ((b = Bin.read()) != -1) {
                        Bout.write(b);
                    }
                    Bout.close();
                    out.close();
                    System.out.println(Fout + "解压成功");
                }
                Bin.close();
                Zin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void demo02() {
        System.out.println("20887210029193170156_20190828_业务明细(汇总).csv".substring(0, 29));
    }

    @Test
    public void demo04() {
        System.out.println(isLanIp("192.168.1.186"));
        System.out.println(isLanIp("127"));
        System.out.println(isLanIp("192.168.1.222")); // true
        System.out.println(isLanIp("192.167.1.222")); // false
        System.out.println(isLanIp("172.15.2.3")); // false
        System.out.println(isLanIp("172.16.2.3")); // true
        System.out.println(isLanIp("172.32.2.3")); // false
        System.out.println(isLanIp("172.31.2.3")); //true
        System.out.println(isLanIp("10.31.2.3")); //true
        System.out.println(isLanIp("11.31.2.3")); //false
        System.out.println(isLanIp("213.31.2.3")); // false
        System.out.println(isLanIp("1.31.2.3")); //false
    }

    public static boolean isLanIp(String ip){
        if (IPAddressUtil.isIPv4LiteralAddress(ip)){
            Pattern patter = Pattern.compile("(^127\\.)|" +
                    "(^10\\.)|" +
                    "(^172\\.1[6-9]\\.)|(^172\\.2[0-9]\\.)|(^172\\.3[0-1]\\.)|" +
                    "(^192\\.168\\.)");
            return patter.matcher(ip).find();
        }
        return false;
    }
    /**
     * 按顺序关闭流
     */
    private void closeStream(BufferedReader bufferedReader, InputStreamReader inputStreamReader, InputStream inputStream) {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (inputStreamReader != null) {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void demo1() {
        String fileName = "20887210029193170156_20190808_业务明细.csv";//原来的解压文件
        String csvName = "";
        String name = fileName.split("\\.")[0];
        File fileDir = new File(BILL_PATH);
        File[] tempList = fileDir.listFiles();
        for (int i = 0; i < tempList.length; i++) {
            if (tempList[i].getName().contains(name) && !tempList[i].getName().contains("汇总") && !tempList[i].getName().contains("zip")) {
                System.out.println(tempList[i].getName());
                csvName = tempList[i].getName();
            }
        }

        File excel = new File(BILL_PATH + "/" + csvName);
        Charset gbk = Charset.forName("gbk");
        InputStreamReader inputStreamReader = null;
        InputStream fiStream = null;
        BufferedReader br = null;
        //行文件中所有数据
        List<String[]> dataList = new ArrayList<>();
        //暂时存放每一行的数据
        String rowRecord = "";
        try {
            fiStream = new FileInputStream(excel); //文件流对象
            inputStreamReader = new InputStreamReader(fiStream, Charset.forName("GBK"));
            br = new BufferedReader(inputStreamReader);
            while ((rowRecord = br.readLine()) != null) {
                String[] lineList = rowRecord.split("\\,");
                if (lineList.length > 4) {
                    dataList.add(lineList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(br, inputStreamReader, fiStream);
        }

        System.out.println(dataList);
    }

    @Test
    public void demo() {
        downLoadFromUrl("http://dwbillcenter.alipay.com/downloadBillFile.resource?bizType=trade&userId=20887210029193170156&fileType=csv.zip&bizDates=20190808&downloadFileName=20887210029193170156_20190808.csv.zip&fileId=%2Ftrade%2F20887210029193170156%2F20190808.csv.zip&timestamp=1567405361&token=edcf3c269f7e9e9a6b0c1fecd092b51e",
                "download.zip",
                BILL_PATH);
    }

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr
     * @param fileName
     * @param savePath
     * @throws IOException
     */
    public String downLoadFromUrl(String urlStr, String fileName, String savePath) {
        try {

            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // 设置超时间为3秒
            conn.setConnectTimeout(3 * 1000);
            // 防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            // 得到输入流
            InputStream inputStream = conn.getInputStream();
            // 获取自己数组
            byte[] getData = readInputStream(inputStream);

            // 文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            //解压
            zipDecompressing(file, savePath);

            return saveDir + File.separator + fileName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";

    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }
}
