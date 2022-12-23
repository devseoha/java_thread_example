package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try{
            System.out.println("숫자를 입력해주세요.");
            Scanner sc = new Scanner(System.in);
            while(!sc.hasNextInt()){
                sc.next();
                System.out.println("숫자를 입력해주세요.");
            }
            int endNum = sc.nextInt();
            int i=0;
            long beforeTime = System.currentTimeMillis();
            while(true){
                i++;
                int num = (int)((Math.random()*10000)%10);
                Thread thread = new Thread(new CalculatorRunnable(num, endNum));
                thread.start();
                if(Calculator.data == endNum){
                    long afterTime = System.currentTimeMillis();
                    long secDiffTime = (afterTime - beforeTime);
                    System.out.println(endNum+" 만들기");
                    System.out.println(i+"개의 스레드 생성됨");
                    System.out.println(secDiffTime+"ms만에 완료함");
                    break;
                }
            }

            System.out.println("===========================");
            Calculator.data = 0;

            beforeTime = System.currentTimeMillis();

            int j=0;
            while(true){
                j++;
                int num = (int)((Math.random()*10000)%10);
                Calculator.sum(num, endNum);
                if(Calculator.data == endNum){
                    long afterTime = System.currentTimeMillis();
                    long secDiffTime = (afterTime - beforeTime);
                    System.out.println(endNum+" 만들기");
                    System.out.println("메인스레드 1개가 "+ j + "번만에 완료함");
                    System.out.println(secDiffTime+"ms만에 완료함");
                    break;
                }
            }

        }catch (Exception err){
            System.out.println("에러가 발생했습니다. "+err);
        }
    }
}