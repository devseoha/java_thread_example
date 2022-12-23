package org.example;

public class Calculator {
    static int data = 0;
    public static synchronized int sum(int num, int endNum){
        if (num + data > endNum) {
            num = endNum-data;
            return num + data;
        }
        data +=num;
        return num;
    }
}
