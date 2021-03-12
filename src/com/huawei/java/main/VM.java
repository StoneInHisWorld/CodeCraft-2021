package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 *
 * Edited by HHW
 * 2021/3/12 16:55
 */

public class VM {

    final private VMType vmType;
    //虚拟机ID
    final private int vmID;
    //所在的服务器的编号
    private int pmID;
    //node有三个取值，“A”“B”“AB”“0”，代表其在服务器上存在的节点，0则是尚未分配
    private String node;

    public VM(VMType vmType, int vmID) {
        this.vmType = vmType;
        this.vmID = vmID;
    }

    public VMType getVmType() {
        return vmType;
    }

    public int getVmID() {
        return vmID;
    }

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
}
