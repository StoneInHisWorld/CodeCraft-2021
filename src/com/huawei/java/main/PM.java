package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 *
 * Edited by HHW
 * 2021/3/12 16:55
 */

import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;
import java.util.List;

public class PM {

    final private PMType type;
    //服务器编号
    private int id;
    //两个节点剩余的CPU和内存容量
    private int ACPU_Remaining;
    private int BCPU_Remaining;
    private int AMem_Remaining;
    private int BMem_Remaining;
    //部署在此的虚拟机
    private List<VM> vmList;

    public PM(PMType type, int id, int ACPU_Remaining, int BCPU_Remaining,
              int AMem_Remaining, int BMem_Remaining) {
        this.type = type;
        this.id = id;
        this.ACPU_Remaining = ACPU_Remaining;
        this.BCPU_Remaining = BCPU_Remaining;
        this.AMem_Remaining = AMem_Remaining;
        this.BMem_Remaining = BMem_Remaining;
        vmList = new ArrayList<>();
    }

    //是否能部署虚拟机
    public boolean deployVM(VM vm){
        VMType vmType = vm.getVmType();
        int CPUNeeds = vmType.getCpu();
        int MemNeeds = vmType.getMemory();
        //双节点部署
        if (vmType.isDouble()){
            //先检查A节点
            if (ACPU_Remaining >= CPUNeeds/2.0){
                if (AMem_Remaining >= MemNeeds/2.0){
                    //如果A节点两个资源都符合条件，再检查B节点
                    if (BCPU_Remaining >= CPUNeeds/2.0){
                        if (BMem_Remaining >= MemNeeds/2.0){
                            //如果两个节点都符合条件则将虚拟机加入列表
                            addVM("AB",vm);
                            return true;
                        }
                    }
                }
            }
        }
        //单节点部署
        else {
            //先检查A节点
            if (ACPU_Remaining >= CPUNeeds) {
                if (AMem_Remaining >= MemNeeds) {
                    //如果A节点两个资源都符合条件，将该虚拟机部署到本服务器中
                    addVM("A",vm);
                    return true;
                }
            } else if (BCPU_Remaining >= CPUNeeds) {
                if (BMem_Remaining >= MemNeeds) {
                    //如果B节点两个资源都符合条件，将该虚拟机部署到本服务器中
                    addVM("B",vm);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean addVM(String node, VM vm){
        VMType vmType = vm.getVmType();
        switch (node) {
            case "A":
                if (!vmType.isDouble()) {
                    throw new IllegalArgumentException("Mismatched VM!");
                }
                this.ACPU_Remaining -= vmType.getCpu();
                this.AMem_Remaining -= vmType.getMemory();
                if (ACPU_Remaining * AMem_Remaining < 0) {
                    throw new IllegalArgumentException("Resources shortage!");
                }
                vmList.add(vm);
                break;
            case "B":
                if (!vmType.isDouble()) {
                    throw new IllegalArgumentException("Mismatched VM!");
                }
                this.BCPU_Remaining -= vmType.getCpu();
                this.BMem_Remaining -= vmType.getMemory();
                if (BCPU_Remaining * BMem_Remaining < 0) {
                    throw new IllegalArgumentException("Resources shortage!");
                }
                vmList.add(vm);
                break;
            case "AB":
                if (vmType.isDouble()) {
                    throw new IllegalArgumentException("Mismatched VM!");
                }
                this.ACPU_Remaining -= vmType.getCpu() / 2.0;
                this.AMem_Remaining -= vmType.getMemory() / 2.0;
                this.BCPU_Remaining -= vmType.getCpu() / 2.0;
                this.BMem_Remaining -= vmType.getMemory() / 2.0;
                if (ACPU_Remaining * AMem_Remaining * BCPU_Remaining * BMem_Remaining < 0) {
                    throw new IllegalArgumentException("Resources shortage!");
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown node!");
        }
        return true;
    }

}
