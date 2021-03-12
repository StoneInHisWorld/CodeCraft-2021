package com.huawei.java.main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YS
 * 2021/3/10 20:21
 *
 * Edited by HHW
 * 2021/3/11 16:27
 */

public class ReadData {

    private File file;
//    private List<PMType> pmList;
//    private List<VMType> vmList;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;

    public ReadData(){

    }

    //此方法在使用ReadData的其他方法之前，必须调用一次
    //用于初始化读取的文件以及对应的文件输入输出流，以及数据存储对象初始化
    public void init(String fileName) throws FileNotFoundException {
        file = new File(fileName);
//        pmList = new ArrayList<>();
//        vmList = new ArrayList<>();
        inputStreamReader = new InputStreamReader(new FileInputStream(file));
        bufferedReader = new BufferedReader(inputStreamReader);
    }

    //读取输入文件中所有类型的服务器（物理机）
    public List<PMType> readPMTypes(){
        //pmList改名为pmTypes，因此方法读取的是服务器的类型
        List<PMType> pmTypeTypes = new ArrayList<>();
//        File file = new File(fileName);
        try {
//            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            int pmCount;
            if((pmCount = Integer.parseInt(bufferedReader.readLine()))!=-1){
                System.out.println(pmCount);
                for(int i = 0;i < pmCount;i++){
                    line = bufferedReader.readLine();
                    String newLine = line.replace("(","").
                            replace(")","").replace(" ","");
//                    System.out.println(newLine);
//                    分割字符串存入PM对象
                    String[] strings = newLine.split(",");
                    String id = strings[0];
                    int cpu = Integer.parseInt(strings[1]);
                    int memory = Integer.parseInt(strings[2]);
                    int cost = Integer.parseInt(strings[3]);
                    int dailyCost = Integer.parseInt(strings[4]);
                    PMType pmType = new PMType(id,cpu,memory,cost,dailyCost);
                    pmTypeTypes.add(pmType);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pmTypeTypes;
    }

    //读取输入文件中所有类型的虚拟机
    public List<VMType> readVMTypes(){
        List<VMType> VMTypeTypes = new ArrayList<>();
//        fileName="C:\\Users\\YS\\Desktop\\华为\\training-1.txt";
//        File file=new File(fileName);
        try {
//            InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream(file));
//            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String line;
//            int pmCount;
//            pmCount= Integer.parseInt(bufferedReader.readLine());
//            System.out.println(pmCount);
//            for(int i=0;i<pmCount;i++){
//                bufferedReader.readLine();
//            }
            int vmCount = Integer.parseInt(bufferedReader.readLine());
            System.out.println(vmCount);
            for(int i = 0;i < vmCount;i++){
                line = bufferedReader.readLine();
                String newLine = line.replace("(","").replace(")","").replace(" ","");
//                    System.out.println(newLine);
//                    分割字符串存入PM对象
                String[] strings = newLine.split(",");
                String id = strings[0];
                int cpu = Integer.parseInt(strings[1]);
                int memory = Integer.parseInt(strings[2]);
                int note = Integer.parseInt(strings[3]);
                VMType vmType = new VMType(id, cpu, memory, note);
                VMTypeTypes.add(vmType);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return VMTypeTypes;
    }

    public int readDay() throws IOException {
        int day = Integer.parseInt(bufferedReader.readLine());
        return day;
    }

    public List<Request> readRequest_ofADay(){
        List<Request> requestList = new ArrayList<>();
        try {
            String line;
            int reqCount = Integer.parseInt(bufferedReader.readLine());
            System.out.println(reqCount);
            for(int i = 0;i < reqCount;i++){
                //读取并分割一行字符串以提取参数
                line = bufferedReader.readLine();
                String newLine = line.replace("(","").replace(")","").replace(" ","");
//                    System.out.println(newLine);
//                    分割字符串存入PM对象
                String[] strings = newLine.split(",");
                //创建 用户请求 对象
                String op = strings[0];
                Request request = new Request(op);
                String[] vmPar;
                if (op.equals("add")){
                    //第一个存类型，第二个存ID
                    vmPar = new String[2];
                    vmPar[0] = strings[1];
                    vmPar[1] = strings[2];
                }
                else if (op.equals("del")){
                    //存虚拟机的ID
                    vmPar = new String[1];
                    vmPar[0] = strings[1];
                }
                else {
                    throw new IllegalArgumentException("Unknow operation!");
                }
                request.setVmPar(vmPar);
                requestList.add(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return requestList;
    }
}
