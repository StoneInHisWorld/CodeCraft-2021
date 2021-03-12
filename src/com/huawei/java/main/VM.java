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

public class VM {

    final private VMType vmType;
/*    //虚拟机ID
    final private int vmID;*/
    //所在的服务器的编号,-1表示没有分配服务器
    private int pmID;
    //node有三个取值，“A”“B”“AB”“0”，代表其在服务器上存在的节点，0则是尚未分配
    private String node;

    public VM(VMType vmType) {
        this.vmType = vmType;
/*        this.vmID = vmID;*/
        this.pmID = -1;
        this.node = "0";
    }

    public VMType getVmType() {
        return vmType;
    }

//    public int getVmID() {
//        return vmID;
//    }

    public int getPmID() {
        return pmID;
    }

    public void setPmID(int pmID) {
        this.pmID = pmID;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "VM{" +
                "vmType=" + vmType +
                ", pmID=" + pmID +
                ", node='" + node + '\'' +
                '}';
    }
}
