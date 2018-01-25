package com.vav.java;

public class Main {

    public static void main(String[] args) {
        lambdasThreadMultiline();
    }
    public static void threadStart(){
        //Usual way
        new Thread(new CodeToRun()).start();
    }
    public static void ananymousClassThreadStart(){

        //Using Anonymous class we do same thing by
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printing from runnable!");
            }
        }).start();
    }
    public static void lambdasThreadExample(){
        new Thread(()->System.out.println("Printing from runnable!")).start();
    }
    public static void lambdasThreadMultiline(){
        new Thread(()->{
            System.out.println("Printing from runnable!");
            System.out.println("Printing from runnable!");
            System.out.println("Printing from runnable!");
        }).start();
    }
}





class CodeToRun implements Runnable{

    @Override
    public void run() {
        System.out.println("Printing from runnable!");
    }
}
