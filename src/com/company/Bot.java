package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URL;
import java.util.Random;
import java.util.Scanner;

public class Bot extends Thread {

    @Override
    public void run() {

        while (true) {
            try {
                Random randomGenerator = new Random();

                int index = randomGenerator.nextInt(Main.array.size());
                String pe = Main.array.get(index);
                Proxy.Type type = Type.HTTP;
                System.out.println(pe.split(":")[0] + "    " + pe.split(":")[1]);
                Proxy p = new Proxy(type, new InetSocketAddress(pe.split(":")[0], Integer.parseInt(pe.split(":")[1])));


                {
                    HttpURLConnection conn = (HttpURLConnection) new URL("http://m.youtube.com/watch?v=" + Main.id).openConnection(p);

                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Host", "m.youtube.com");
                    conn.setRequestProperty("Proxy-Connection", "keep-alive");
           //         conn.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1 Mobile/15E148 Safari/604.1");
                    conn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                    conn.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");


                    conn.setDoOutput(true);


                    InputStream src = conn.getInputStream();
                    String url = "";
                    Scanner in = new Scanner(src);

                    while (in.hasNext()) {

                        url += in.next();
                    }
                    url = url.split("videostatsWatchtimeUrl")[1].split("baseUrl\\\":\\\"")[1].split("\"}")[0].replace("\\u0026",
                            "&").replace(


                            "%2C", ",").replace("\\/", "/");
                    String cl = url.split("cl=")[1].split("&")[0];
                    String ei = url.split("ei=")[1].split("&")[0];
                    String of = url.split("of=")[1].split("&")[0];
                    String vm = url.split("vm=")[1].split("&")[0];

            //        conn.disconnect();
                    HttpURLConnection conn2 = (HttpURLConnection) new URL("http://s.youtube.com/api/stats/watchtime?ns=yt&el=detailpage&cpn=isWmmj2C9Y2vULKF&docid=" + Main.id + "&ver=2&cmt=7334&ei=" + ei + "&fmt=133&fs=0&rt=1003&of=" + of + "&euri&lact=4418&live=dvr&cl=" + cl + "&state=playing&vm=" + vm + "&volume=100&c=MWEB&cver=2.20200313.03.00&cplayer=UNIPLAYER&cbrand=apple&cbr=Safari%20Mobile&cbrver=12.1.15E148&cmodel=iphone&cos=iPhone&cosver=12_2&cplatform=MOBILE&delay=5&hl=ru&cr=GB&rtn=1303&afmt=140&lio=1556394045.182&idpj=&ldpj=&rti=1003&muted=0&st=7334&et=7634").openConnection(p);

                    conn2.setRequestMethod("GET");
                    conn2.setRequestProperty("Host", "m.youtube.com");
                    conn2.setRequestProperty("Proxy-Connection", "keep-alive");
                    conn2.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 12_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/12.1 Mobile/15E148 Safari/604.1");
                    conn2.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
                    conn2.setRequestProperty("Accept-Language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7");

                  //  conn2.disconnect();
                    Thread.sleep(5000);

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {

            }
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Main.number += 1;
        }
    }
}
