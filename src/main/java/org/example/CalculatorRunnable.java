package org.example;

class CalculatorRunnable implements Runnable{
    int num;
    int endNum;
    CalculatorRunnable(int n, int en) {
        num = n;
        endNum = en;
    };
    @Override
    public void run() {
        Calculator.sum(num, endNum);
    }
}