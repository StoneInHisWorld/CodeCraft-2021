package com.huawei.java.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YS
 * 2021/3/10 20:21
 */

public class ReadData {
    public List<PM> getPMList(String fileName){
        List<PM> pmList=new ArrayList<>();
        fileName="C:\\Users\\YS\\Desktop\\华为\\training-1.txt";
        File file=new File(fileName);
        try {
            InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            int pmCount;
            if((pmCount= Integer.parseInt(bufferedReader.readLine()))!=-1){
                System.out.println(pmCount);
                for(int i=0;i<pmCount;i++){
                    line=bufferedReader.readLine();
                    String newLine=line.replace("(","").replace(")","").replace(" ","");
//                    System.out.println(newLine);
//                    分割字符串存入PM对象
                    String[] strings=newLine.split(",");
                    String id=strings[0];
                    int cpu=Integer.parseInt(strings[1]);
                    int memory=Integer.parseInt(strings[2]);
                    int cost=Integer.parseInt(strings[3]);
                    int dailyCost=Integer.parseInt(strings[4]);
                    PM pm=new PM(id,cpu,memory,cost,dailyCost);
                    pmList.add(pm);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pmList;
    }

    public List<VM> getVMList(String fileName){
        List<VM> vmList=new ArrayList<>();
        fileName="C:\\Users\\YS\\Desktop\\华为\\training-1.txt";
        File file=new File(fileName);
        try {
            InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
            int pmCount;
            pmCount= Integer.parseInt(bufferedReader.readLine());
            System.out.println(pmCount);
            for(int i=0;i<pmCount;i++){
                bufferedReader.readLine();
            }
            int vmCount=Integer.parseInt(bufferedReader.readLine());
            for(int i=0;i<vmCount;i++){
                line=bufferedReader.readLine();
                String newLine=line.replace("(","").replace(")","").replace(" ","");
//                    System.out.println(newLine);
//                    分割字符串存入PM对象
                String[] strings=newLine.split(",");
                String id=strings[0];
                int cpu=Integer.parseInt(strings[1]);
                int memory=Integer.parseInt(strings[2]);
                int note=Integer.parseInt(strings[3]);
                VM vm=new VM(id,cpu,memory,note);
                vmList.add(vm);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vmList;
    }
}
