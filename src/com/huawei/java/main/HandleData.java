package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 */

import java.util.List;

public class HandleData {

    final private List<PMType> pmTypes;
    final private List<VMType> vmTypes;

    public HandleData(List<PMType> pmTypes, List<VMType> vmTypes) {
        this.pmTypes = pmTypes;
        this.vmTypes = vmTypes;
    }

    //处理一天的请求
    public boolean handleRequestOfADay(List<Request> today_Request){
        for (Request request:today_Request) {
            String op = request.getOp();
            if (op.equals("add")){

            }else if (op.equals("del")){

            }else{
                throw new IllegalArgumentException("Unknow Operation!");
            }
        }
        return true;
    }

    private boolean addVM(){
        return true;
    }

    private boolean delVM(){
        return true;
    }

    private boolean addPM(){
        return true;
    }

    private boolean delPM(){
        return true;
    }
}
