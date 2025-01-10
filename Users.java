package com.example.demo;

import java.util.ArrayList;

public class Users {


    private String user;
    private int numPayments;

    private int amtOwed;
    private ArrayList<String> allPayments = new ArrayList<String>();

    private int creditScore;



    public Users(String user, int amtOwed, int numPayments, ArrayList<String> temp, int creditScore){
        this.user = user;
        this.amtOwed = amtOwed;
        this.numPayments = numPayments;
        this.allPayments = temp;
        this.creditScore = creditScore;
    }


    @Override
    public String toString() {
        String temp ="";
        for (int i = 0; allPayments.size()>i;i++){
            temp += allPayments.get(i)+",";
        }
        return user+","+amtOwed+","+numPayments+","+temp+creditScore+",";
    }

    public String getName(){
        return user;
    }

    public int getAmtOwed(){
        return amtOwed;
    }

    public int getCreditScore(){
        return creditScore;
    }

    public ArrayList<String> getAllPayments(){return allPayments;}

    public void setName(String s) {
        user = s;
    }
    public void addAmtOwed(int s) {
        amtOwed += s;
    }
    public void removeAmtOwed(int s) {
        amtOwed -= s;
    }

    public void addTrans(String s) {
        allPayments.add(s);
    }

    public void setCreditScore(int score){
        creditScore = score;
    }

    public void setAmtOwed(int s) {
        amtOwed -= s;
    }
}
