package com.huawei.java.main;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // TODO: read standard input
        // TODO: process
        // TODO: write standard output
        // TODO: System.out.flush()
        ReadData readData = new ReadData();
        String fileName = "";
        List<PM> pmList = readData.getPMList(fileName);
        for(PM pm:pmList)
            System.out.println(pm);
        List<VM> vmList=readData.getVMList(fileName);
        for(VM vm:vmList)
            System.out.println(vm);
    }
}