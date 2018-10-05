package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Runtime unosRuntimeses= Runtime.getRuntime();
        Process proceso1 = null;
        InputStream inputStr = null;
        int b;

        Process proceso2 = null;
        OutputStream outStr = null;

        proceso1 = unosRuntimeses.exec("ls -la");
        inputStr = proceso1.getInputStream();
        proceso2 = unosRuntimeses.exec("tr 'd' 'D'");
        outStr = proceso2.getOutputStream();
        while ((b = inputStr.read()) != -1){
            outStr.write(b);
        }

        proceso1.waitFor();
        inputStr.close();
        outStr.close();

        inputStr = proceso2.getInputStream();
        while ((b = inputStr.read()) != -1){
            System.out.write(b);
        }

        proceso2.waitFor();
        inputStr.close();

    }
}
