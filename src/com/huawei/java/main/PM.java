package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/12 11:40
 */

import java.util.List;

public class PM {

    private PMType type;
    //服务器编号
    private int id;
    //两个节点剩余的CPU和内存容量
    private int ACPU_Remaining;
    private int BCPU_Remaining;
    private int AMem_Remaining;
    private int BMem_Remaining;
    //寄居在此的虚拟机
    private List<VM> vmList;
}
