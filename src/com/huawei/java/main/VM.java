package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:19
 */

public class VM {
    String id;
    int cpu;
    int memory;
    int node;

    public VM() {
    }

    public VM(String id, int cpu, int memory, int node) {
        this.id = id;
        this.cpu = cpu;
        this.memory = memory;
        this.node = node;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return "VM{" +
                "id='" + id + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", node=" + node +
                '}';
    }
}
