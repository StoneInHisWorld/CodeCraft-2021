package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:12
 *
 * Edited by HHW
 * 2021/3/11 16:27
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

    private ReadData readData;

    public static void main(String[] args) {
        // TODO: read standard input
        // TODO: process
        // TODO: write standard output
        // TODO: System.out.flush()
        ReadData readData = new ReadData();
        String fileName = "C:\\Users\\hhw\\Documents\\Tencent Files\\1195290789\\" +
                "FileRecv\\华为软件精英大赛\\training-data\\training-1.txt";
        try {
            readData.init(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<PMType> pmTypeTypes = readData.readPMTypes();
        for (PMType pmType : pmTypeTypes)
            System.out.println(pmType);

        List<VMType> vmTypeTypes = readData.readVMTypes();
        for (VMType vmType : vmTypeTypes)
            System.out.println(vmType);

        int day = 0;
        try {
            //获取一共有多少天
            day = readData.readDay();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0;i < day;i++) {
            List<Request> requestList = readData.readRequest_ofADay();
            //将所有请求输出
            for (Request request : requestList) {
                System.out.println(request.toString());
            }
        }
    }


}