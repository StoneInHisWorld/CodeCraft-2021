package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:12
 *
 * Edited by HHW
 * 2021/3/11 16:27
 */

public class PMType {
    //型号由id更名为type，因为服务器还有个属性id，后续操作会用到
    String type;
    int cpu;
    int memory;
    int cost;
    int dailyCost;

    public PMType() { }

    public PMType(String type, int cpu, int memory, int cost, int dailyCost) {
        this.type = type;
        this.cpu = cpu;
        this.memory = memory;
        this.cost = cost;
        this.dailyCost = dailyCost;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDailyCost() {
        return dailyCost;
    }

    public void setDailyCost(int dailyCost) {
        this.dailyCost = dailyCost;
    }

    @Override
    public String toString() {
        return "PMType{" +
                "type='" + type + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", cost=" + cost +
                ", dailyCost=" + dailyCost +
                '}';
    }
}
