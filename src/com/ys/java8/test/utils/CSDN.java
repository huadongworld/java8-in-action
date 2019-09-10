package com.ys.java8.test.utils;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class CSDN {

    private static String zhuye;
    private String sousuo = "/article/details/";

    static List<String> urls = new ArrayList<>();

    public CSDN() {
        urls = Arrays.asList(
                "https://blog.csdn.net/qq_36221788/article/details/100655660",
                "https://blog.csdn.net/qq_36221788/article/details/94564333",
                "https://blog.csdn.net/qq_36221788/article/details/94884591",
                "https://blog.csdn.net/qq_36221788/article/details/97249724",
                "https://blog.csdn.net/qq_36221788/article/details/98625693",
                "https://blog.csdn.net/qq_36221788/article/details/100184076",
                "https://blog.csdn.net/qq_36221788/article/details/99614973",
                "https://blog.csdn.net/qq_36221788/article/details/97876366",
                "https://blog.csdn.net/qq_36221788/article/details/100292015",
                "https://blog.csdn.net/qq_36221788/article/details/100584500"
        );
    }

    public static void randomUrl() {

        Random random = new Random();
        int index = random.nextInt(9) + 1;

        System.out.println(index);

        zhuye = urls.get(index);
    }

    public CSDN(String url) {
        zhuye = url;
    }

    public String getSousuo() {
        return sousuo;
    }

    public void setSousuo(String sousuo) {
        this.sousuo = sousuo;
    }

    public String open(String url) {
        StringBuffer str = new StringBuffer();
        BufferedReader in = null;
        try {
            URL u = new URL(url);
            in = new BufferedReader(new InputStreamReader(u.openStream(), "UTF-8"));
            while (true) {
                String s = in.readLine();
                if (s == null) break;
                else str.append(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return str.toString();
    }

    public HashSet<String> sousuoHTML(String str) {
        HashSet<String> set = new HashSet<String>();
        int st, end;
        while ((st = str.indexOf(zhuye + sousuo)) != -1) {
            if ((end = str.indexOf("\"", st)) != -1) {
                String s = str.substring(st, end);
                if (s.indexOf("#comments") != -1) {
                    s = s.substring(0, s.indexOf("#comments"));
                }
                set.add(s);
                str = str.substring(end);
            }
        }
        return set;
    }

    public int getFangke() {
        String str = open(zhuye);
        int i;
        if ((i = str.indexOf("访问：")) != -1) {
            str = str.substring(i);
            str = str.substring(str.indexOf("\"") + 1);
            str = str.substring(0, str.indexOf("\""));
        } else if ((i = str.indexOf("personal_list")) != -1) {
            str = str.substring(i);
            str.substring(str.indexOf("<em>") + 4, str.indexOf("</em>"));
        }
        int ii = 0;
        try {
            if (str.equals("")) {
                return 0;
            }
            ii = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return ii;
    }

    public void daili(String ip, String dk) {
        Properties prop = System.getProperties();
        // 设置http访问要使用的代理服务器的地址
        prop.setProperty("http.proxyHost", ip);
        // 设置http访问要使用的代理服务器的端口
        prop.setProperty("http.proxyPort", dk);
        // 设置不需要通过代理服务器访问的主机，可以使用*通配符，多个地址用|分隔
        prop.setProperty("http.nonProxyHosts", "localhost|192.168.168.*");
        // 设置安全访问使用的代理服务器地址与端口
        // 它没有https.nonProxyHosts属性，它按照http.nonProxyHosts 中设置的规则访问
        prop.setProperty("https.proxyHost", ip);
        prop.setProperty("https.proxyPort", dk);
        // 使用ftp代理服务器的主机、端口以及不需要使用ftp代理服务器的主机
        prop.setProperty("ftp.proxyHost", ip);
        prop.setProperty("ftp.proxyPort", dk);
        prop.setProperty("ftp.nonProxyHosts", "localhost|192.168.168.*");
        // socks代理服务器的地址与端口
        prop.setProperty("socksProxyHost", ip);
        prop.setProperty("socksProxyPort", dk);
        System.out.println("ip:" + ip + " :" + dk);
    }

    public static String[] dl = {
            "114.237.62.5:4256",
            "117.69.129.53:4226",
            "180.123.205.63:4243",
            "218.72.6.189:4263",
            "114.103.169.131:4235",
            "49.79.66.6:4256",
            "182.34.33.26:4234",
            "112.113.156.50:4256",
            "114.237.57.27:4256",
            "36.57.91.103:4226",
//            "119.5.224.191:4282",
            "119.85.4.74:4242",
//            "114.228.249.240:4275",
            "125.121.118.161:4265",
            "183.166.7.119:4251",
            "60.172.71.194:4270",
            "114.105.172.22:4287",
            "60.185.203.54:4226",
            "114.102.37.10:4231",
            "114.239.148.239:4258"
    };

    public static void main(String[] args) {
        int i = 0;
        CSDN csdn = new CSDN();
        while (true) {

            randomUrl();

            long a = System.currentTimeMillis();
            for (i = 0; i < dl.length; i++) {
                String[] dd = dl[i].split(":");
                csdn.daili(dd[0], dd[1]);
                HashSet<String> set = csdn.sousuoHTML(csdn.open(zhuye));
                for (String url : set) {
                    csdn.open(url);
                    System.out.println("正在打开：" + url);
                }
                System.out.println("电脑已访问" + (++i));
                System.out.println("访问量：" + csdn.getFangke());
            }
            long b = System.currentTimeMillis();
            long c = b - a;
            if (6000 - c > 0) {
                try {
                    Thread.sleep(6000 - c);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}