package com.huawei.java.main;

/**
 * Created by HHW
 * 2021/3/11 16:27
 *
 * Edited by HHW
 * 2021/3/12 16:55
 */

import java.util.Arrays;

public class Request {

    final private String op;
    //若 op equals "add" 则第一个存虚拟机的类型，第二个存VMID
    //若 op equals "del" 则只有一个参数为虚拟机的ID
    private String[] vmPar;

    public Request(String op){
        this.op = op;
//        //如果是添加操作
//        if (op.equals("add")){
//            vmPar = new String[2];
//        }
//        else if (op.equals("del")){
//            vmPar = new String[1];
//        }
    }

    public String getOp() {
        return op;
    }

    public String[] getVmPar() {
        return vmPar;
    }

    public void setVmPar(String[] vmPar) {
        this.vmPar = vmPar;
    }

    @Override
    public String toString() {
        return "Request{" +
                "op='" + op + '\'' +
                ", vmPar=" + Arrays.toString(vmPar) +
                '}';
    }
}
