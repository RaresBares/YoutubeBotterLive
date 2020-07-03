package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Main {
public static List<String> array = new ArrayList<>();
    public static String id;
    public static int number;

    public Main(){
    InputStream  is = this.getClass().getClassLoader().getResourceAsStream("proxy.txt");

    Scanner sc = new Scanner(is);
    while (sc.hasNextLine()){
        array.add(sc.nextLine());
    }
}

    public static void main(String[] args) throws IOException, InterruptedException {

        new Main();
       Scanner sc = new Scanner(System.in);
       System.out.println("Wie ist die ID?");
       id = sc.nextLine();

       System.out.println("Wieviele Threads");
       int a = sc.nextInt();
        for (int i = 0; i < a; i++) {
            new Bot().start();
        }

        while (true) {
            Thread.sleep(1000);
            System.out.println("Bots: " + number);
        }
    }
}
