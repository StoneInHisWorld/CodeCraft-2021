package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:19
 *
 * Edited by HHW
 * 2021/3/12 11:40
 *
 */

public class VMType {
    //型号由id更名为type，因为虚拟机还有个属性id，后续操作会用到
    String type;
    int cpu;
    int memory;
    int node;

    public VMType() {
    }

    public VMType(String type, int cpu, int memory, int node) {
        this.type = type;
        this.cpu = cpu;
        this.memory = memory;
        this.node = node;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCpu() {
        return cpu;
    }

    public void setCpu(int cpu) {
        this.cpu = cpu;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    @Override
    public String toString() {
        return "VMType{" +
                "type='" + type + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", node=" + node +
                '}';
    }
}
