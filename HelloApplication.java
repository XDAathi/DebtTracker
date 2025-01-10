package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;


public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 600);
        stage.setTitle("Peer Credit Tracker");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        launch();


    }
    public static ArrayList<Users> sortCredLH(ArrayList<Users> u) {
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        // Split the list into two halves
        for (int i = 0; i < u.size(); i++) {
            if (i < u.size() / 2) {
                first.add(u.get(i));
            } else {
                second.add(u.get(i));
            }
        }

        // Keep splitting the lists until they are one - base case
        if (first.size() > 1) {
            sortCredLH(first);
        }
        if (second.size() > 1) {
            sortCredLH(second);
        }

        // Merge the lists together by credit score in ascending order
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            int listOneCreditScore = first.get(index1).getCreditScore();
            int listTwoCreditScore = second.get(index2).getCreditScore();

            if (listOneCreditScore < listTwoCreditScore) { // Change comparison to < for LH
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }
        }

        // Copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // Copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }
    public static ArrayList<Users> sortAmtLH(ArrayList<Users> u) {
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        // Split the list into two halves
        for (int i = 0; i < u.size(); i++) {
            if (i < u.size() / 2) {
                first.add(u.get(i));
            } else {
                second.add(u.get(i));
            }
        }

        // Keep splitting the lists until they are one - base case
        if (first.size() > 1) {
            sortAmtLH(first);
        }
        if (second.size() > 1) {
            sortAmtLH(second);
        }

        // Merge the lists together by amount owed in ascending order
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            int listOneAmtOwed = first.get(index1).getAmtOwed();
            int listTwoAmtOwed = second.get(index2).getAmtOwed();

            if (listOneAmtOwed < listTwoAmtOwed) { // Change comparison to < for LH
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }
        }

        // Copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // Copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }

    public static ArrayList<Users> sortCredHL(ArrayList<Users> u) {
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        // Split the list into two halves
        for (int i = 0; i < u.size(); i++) {
            if (i < u.size() / 2) {
                first.add(u.get(i));
            } else {
                second.add(u.get(i));
            }
        }

        // Keep splitting the lists until they are one - base case
        if (first.size() > 1) {
            sortCredHL(first);
        }
        if (second.size() > 1) {
            sortCredHL(second);
        }

        // Merge the lists together by credit score in descending order
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            int listOneCreditScore = first.get(index1).getCreditScore();
            int listTwoCreditScore = second.get(index2).getCreditScore();

            if (listOneCreditScore > listTwoCreditScore) { // Change comparison to > for HL
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }
        }

        // Copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // Copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }
    public static ArrayList<Users> sortAmtHL(ArrayList<Users> u) {
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        // Split the list into two halves
        for (int i = 0; i < u.size(); i++) {
            if (i < u.size() / 2) {
                first.add(u.get(i));
            } else {
                second.add(u.get(i));
            }
        }

        // Keep splitting the lists until they are one - base case
        if (first.size() > 1) {
            sortAmtHL(first);
        }
        if (second.size() > 1) {
            sortAmtHL(second);
        }

        // Merge the lists together by amount owed in descending order
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            int listOneAmtOwed = first.get(index1).getAmtOwed();
            int listTwoAmtOwed = second.get(index2).getAmtOwed();

            if (listOneAmtOwed > listTwoAmtOwed) { // Change comparison to > for HL
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }
        }

        // Copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // Copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }
    public static ArrayList<Users> sort(ArrayList<Users> u){
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        //split the list into two halves
        for (int i = 0; i < u.size(); i++)
            if (i < u.size() / 2)
                first.add(u.get(i));
            else
                second.add(u.get(i));

        // keep splitting the lists until they are one - base case
        if (first.size() > 1)
            sort(first);
        if (second.size() > 1)
            sort(second);

        // merge the lists together by name
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            String listOneBookNum = first.get(index1).getName();
            String listTwoBookNum = second.get(index2).getName();

            if (listOneBookNum.compareTo(listTwoBookNum) < 0) {
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }

        }

        // copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }

    public static ArrayList<Users> sortZA(ArrayList<Users> u){
        ArrayList<Users> first = new ArrayList<Users>();
        ArrayList<Users> second = new ArrayList<Users>();

        // Split the list into two halves
        for (int i = 0; i < u.size(); i++) {
            if (i < u.size() / 2) {
                first.add(u.get(i));
            } else {
                second.add(u.get(i));
            }
        }

        // Keep splitting the lists until they are one - base case
        if (first.size() > 1) {
            sortZA(first);
        }
        if (second.size() > 1) {
            sortZA(second);
        }

        // Merge the lists together by name in reverse order
        int index1 = 0, index2 = 0;
        for (int i = 0; i < first.size() + second.size() && index1 < first.size() && index2 < second.size(); i++) {
            String listOneName = first.get(index1).getName();
            String listTwoName = second.get(index2).getName();

            if (listOneName.compareTo(listTwoName) > 0) { // Change comparison to > for Z-A
                u.set(i, first.get(index1));
                index1++;
            } else {
                u.set(i, second.get(index2));
                index2++;
            }
        }

        // Copy the remaining elements from the first list if any
        while (index1 < first.size()) {
            u.set(index1 + index2, first.get(index1));
            index1++;
        }

        // Copy the remaining elements from the second list if any
        while (index2 < second.size()) {
            u.set(index1 + index2, second.get(index2));
            index2++;
        }
        return u;
    }

    public static void deleteUser(String name){
        ArrayList<Users> u = readInData();
        for(int i =0;i<u.size(); i++){
            if(name.equals(u.get(i).getName())){
                u.remove(u.get(i));
                writeInAllData(u);
            }
        }
    }

    public static String[] names(){
        ArrayList<Users> u = readInData();
        String[] s = new String[u.size()];
        for(int i = 0; i<u.size();i++){
            s[i] = u.get(i).getName();
        }
        return s;
    }

    public static String[] amtPay(){
        ArrayList<Users> u = readInData();
        String[] s = new String[u.size()];
        for(int i = 0; i<u.size();i++){
            s[i] = String.valueOf(u.get(i).getAmtOwed());
        }
        return s;
    }
    public static String[] credScore(){
        ArrayList<Users> u = readInData();

        String[] s = new String[u.size()];
        for(int i = 0; i<u.size();i++){
            s[i] = String.valueOf(u.get(i).getCreditScore());
        }
        return s;
    }

    public static int calculateCred(int amtOwed, ArrayList<String> t){
        int maxCS = 900;
        int minCS = 100;
        int maxAmt = 50;
        int amtOutstanding = amtOwed;
        int CS = 500 - amtOutstanding;
        ArrayList<String> s = t;
        int paymentAmt[][] = new int[2][s.size()];
        for(int i = 0; i<s.size();i++) {
            String temp = s.get(i);
            int index = temp.indexOf("-");
            paymentAmt[0][i] = Integer.parseInt(temp.substring(0,index));
            paymentAmt[1][i] = Integer.parseInt(temp.substring(index+1));
        }

        for (int i = 0, addCS = 0; i < paymentAmt[0].length; i++ ){

            if (paymentAmt[0][i] > maxAmt)
                paymentAmt[0][i] = maxAmt;

            if (paymentAmt[1][i] < 2)
                addCS = paymentAmt[0][i]/(paymentAmt[1][i] + 1);

            else if (paymentAmt[0][i] > 2)
                addCS = (-1*(paymentAmt[0][i]/4))*(paymentAmt[1][i] - 2);

            else if (paymentAmt[0][i] < 0)
                System.out.println("Money Cannot be Payed Back in Negative Time");

            CS += addCS;

            if (CS > 900)
                CS = 900;
            if (CS < 100)
                CS = 100;
        }
        return CS;
    }
    public static ArrayList<Users> readInData(){
        ArrayList<Users> users = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/data.csv"));
            String line;
            while ((line = reader.readLine()) != null){
                String[] data = line.split(",");
                ArrayList<String> transactions = new ArrayList<String>();
                for(int i = 0; i<Integer.parseInt(data[2]); i++){
                    transactions.add(data[3+i]);
                }
                users.add(new Users(data[0], Integer.parseInt(data[1]),Integer.parseInt(data[2]), transactions, Integer.parseInt(data[data.length-1])));
            }

        }catch (IOException iox){
            System.out.println("Problem reading ");
        }
        return users;
    }
//    public static ArrayList<Users> readInData(){
//
//        ArrayList<Users> users = new ArrayList<>();
//        try {
//            InputStream inputStream = HelloApplication.class.getResourceAsStream("data.csv");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while ((line = reader.readLine()) != null){
//                String[] data = line.split(",");
//                ArrayList<String> transactions = new ArrayList<String>();
//                for(int i = 0; i<Integer.parseInt(data[2]); i++){
//                    transactions.add(data[3+i]);
//                }
//                users.add(new Users(data[0], Integer.parseInt(data[1]),Integer.parseInt(data[2]), transactions, Integer.parseInt(data[data.length-1])));
//            }
//
//        }catch (IOException iox){
//            System.out.println("Problem reading");
//        }
//        return users;
//    }

    public static void writeInAllData(ArrayList<Users> u){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/data.csv"));
            for(Users user: u){
                writer.write(user.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}