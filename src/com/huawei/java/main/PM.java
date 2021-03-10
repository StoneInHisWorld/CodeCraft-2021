package com.huawei.java.main;

/**
 * Created by YS
 * 2021/3/10 21:12
 */

public class PM {
    String id;
    int cpu;
    int memory;
    int cost;
    int dailyCost;

    public PM() {
    }

    public PM(String id, int cpu, int memory, int cost, int dailyCost) {
        this.id = id;
        this.cpu = cpu;
        this.memory = memory;
        this.cost = cost;
        this.dailyCost = dailyCost;
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
        return "PM{" +
                "id='" + id + '\'' +
                ", cpu=" + cpu +
                ", memory=" + memory +
                ", cost=" + cost +
                ", dailyCost=" + dailyCost +
                '}';
    }
}
