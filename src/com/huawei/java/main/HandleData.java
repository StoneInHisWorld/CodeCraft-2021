package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 *
 * Edited by HHW
 * 2021/3/12 16:55
 *
 * Edited by HHW with YS
 * 2021/3/12 22:51
 */

import java.util.*;

public class HandleData {

    final private List<PMType> pmTypeList;
    final private List<VMType> vmTypeList;
    //已经购买的服务器
    private ArrayList<PM> pmList;
    //现有的虚拟机
//    private HashSet<Integer> vmList;
    private HashMap<Integer,VM> vmHashMap;

    static int id = 0;

    public HandleData(List<PMType> pmTypeList, List<VMType> vmTypeList) {
        this.pmTypeList = pmTypeList;
        this.vmTypeList = vmTypeList;
//        this.vmList = new HashSet<Integer>();
        this.pmList = new ArrayList<>();
        this.vmHashMap = new HashMap<Integer, VM>();
    }

    //处理一天的请求
    public boolean handleRequestOfADay(List<Request> today_Request) throws Exception {
        for (Request request:today_Request) {
            String op = request.getOp();
            String[] vmPar = request.getVmPar();
            if (op.equals("add")){
                addVM(vmPar);
            }else if (op.equals("del")){
                delVM(vmPar);
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
                int vmID = Integer.parseInt(vmPar[1]);
                vm = new VM(vmType);
//                vmList.add(vmID);
                vmHashMap.put(vmID, vm);
                break;
            }
        }
        if ( vm == null ){
           throw new Exception("No such kind of VM of current requst!");
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
        }
        //找不到合适的服务器则购买，再分配
        PM newPM = purchasePM();
        while (!newPM.deployVM(vm)){
            delLastPM();
            newPM = purchasePM();
        }
    }

    public PM purchasePM(){
        Random random = new Random();
        //随机获取一个服务器购买
        int index = random.nextInt(pmTypeList.size());
        PMType pmType = pmTypeList.get(index);
        PM pm = new PM(pmType, id++,
                pmType.getCpu()/2,pmType.getCpu()/2,
                pmType.getMemory()/2,pmType.getMemory()/2);
        pmList.add(pm);
        return pm;
    }

    private boolean delVM(String[] vmPar) throws Exception {
        int vmID = Integer.parseInt(vmPar[0]);
        VM vmToDel = vmHashMap.remove(vmID);
        if (vmToDel == null){
            throw new Exception("No such VM to delete");
        }
        int pmID = vmToDel.getPmID();
        PM pm = pmList.get(pmID);
        pm.undeployVM(vmToDel);
        return true;
    }

    private boolean addPM(){
        return true;
    }

    private boolean delLastPM(){
        pmList.remove(pmList.size()-1);
        id--;
        return true;
    }
}
