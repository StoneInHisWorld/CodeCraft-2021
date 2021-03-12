package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 *
 * Edited by HHW
 * 2021/3/12 16:55
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HandleData {

    final private List<PMType> pmTypeList;
    final private List<VMType> vmTypeList;
    private ArrayList<PM> pmList;
    private LinkedList<VM> vmList;

    public HandleData(List<PMType> pmTypeList, List<VMType> vmTypeList) {
        this.pmTypeList = pmTypeList;
        this.vmTypeList = vmTypeList;
        this.vmList = new LinkedList<>();
        this.pmList = new ArrayList<>();
    }

    //处理一天的请求
    public boolean handleRequestOfADay(List<Request> today_Request) throws Exception {
        for (Request request:today_Request) {
            String op = request.getOp();
            String[] vmPar = request.getVmPar();
            if (op.equals("add")){
                addVM(vmPar);
            }else if (op.equals("del")){
                delPM();
            }else{
                throw new IllegalArgumentException("Unknow Operation!");
            }
        }
        return true;
    }

    private void addVM(String[] vmPar) throws Exception {
        //寻找对应匹配的类型
        VMType vmType;
        VM vm = null;
        //为当前添加的VM匹配到类型
        for (VMType type : vmTypeList) {
            if (type.getType().equals(vmPar[0])){
                vmType = type;
                vm = new VM(vmType, Integer.parseInt(vmPar[1]));
                break;
            }
        }
        if ( vm == null ){
           throw new Exception("No such VM of current requst!");
        }
        //为当前添加的VM分配服务器
        allocateVM(vm);
        //vmList.sort();
    }

    private void allocateVM(VM vm){
        //为新增的vm寻找现有的合适的服务器安排资源
        for (PM pm : pmList) {
            if (pm.deployVM(vm)){
               //如果部署成功
               return;
            }
            else {
                break;
            }
        }
        //购买服务器
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
