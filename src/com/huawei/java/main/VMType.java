package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:19
 *
 * Edited by HHW
 * 2021/3/12 11:40
 *
 * Edited by HHW
 * 2021/3/12 16:55
 */

public class VMType {
    //型号由id更名为type，因为虚拟机还有个属性id，后续操作会用到
    final String type;
    final int cpu;
    final int memory;
    //结点由node更名为isDouble，我认为这样更清楚地标识该种类的虚拟机是否是双节点部署
    final boolean isDouble;

    public VMType(String type, int cpu, int memory, Boolean isDouble) {
        this.type = type;
        this.cpu = cpu;
        this.memory = memory;
        this.isDouble = isDouble;
    }

    public String getType() {
        return type;
    }

    public int getCpu() {
        return cpu;
    }

    public int getMemory() {
        return memory;
    }

    public boolean isDouble() {
        return isDouble;
    }

    @Override
    public String toString() {
        return "VMType{" +
                "type='" + type + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", isDouble=" + isDouble +
                '}';
    }
}
