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
    private HandleData handleData;

    public static void main(String[] args) throws Exception {
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

        List<PMType> pmTypeList = readData.readPMTypes();
        for (PMType pmType : pmTypeList)
            System.out.println(pmType);

        List<VMType> vmTypeList = readData.readVMTypes();
        for (VMType vmType : vmTypeList)
            System.out.println(vmType);

        int day = 0;
        try {
            //获取一共有多少天
            day = readData.readDay();
        } catch (IOException e) {
            e.printStackTrace();
        }

        HandleData handleData = new HandleData(pmTypeList, vmTypeList);
        for (int i = 0;i < day;i++) {
            //包含了这一天的请求
            List<Request> requestList = readData.readRequest_ofADay();
            //将所有请求输出
            for (Request request : requestList) {
                System.out.println(request.toString());
            }
            handleData.handleRequestOfADay(requestList);
        }
    }


}