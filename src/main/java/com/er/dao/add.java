package com.er.dao;

public class add {
    public int add(int a, int b) {
        try {
            a = b/0;
            return a +b;
        } catch (Exception e) {
            System.out.println("catch 语句块");
        } finally {
            System.out.println("finally 语句块");
        }
        return 0;
    }

    public static void main(String[] args) {
        add demo = new add();
        System.out.println("和是:" + demo.add(9, 34));
    }
}

