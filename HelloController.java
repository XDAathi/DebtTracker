package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    String cu;
    @Override
    public void initialize(URL arg, ResourceBundle arg1){
        refresh();
    }

    public void refresh(){
        myListView.getItems().clear();
        myListViewAmt.getItems().clear();
        myListCredScore.getItems().clear();
        String[] temp = HelloApplication.names();
        myListView.getItems().addAll(temp);
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0 , String s, String t1) {
                cu = myListView.getSelectionModel().getSelectedItem();
                displayUser.setText(cu);
            }
        });

        String[] pay = HelloApplication.amtPay();
        myListViewAmt.getItems().addAll(pay);
        myListViewAmt.setMouseTransparent( true );
        myListViewAmt.setFocusTraversable( false );

        String[] credScore = HelloApplication.credScore();
        myListCredScore.getItems().addAll(credScore);
        myListCredScore.setMouseTransparent( true );
        myListCredScore.setFocusTraversable( false );
    }
    @FXML
    private void editName(ActionEvent event){
        final JFrame parent = new JFrame();
        ArrayList<Users> u = HelloApplication.readInData();
        for(int i = 0; i<u.size();i++){
            if(u.get(i).getName().equals(myListView.getSelectionModel().getSelectedItem())){
                String name = JOptionPane.showInputDialog(parent, "Enter new name", null);
                u.get(i).setName(name);
            }
        }
        HelloApplication.writeInAllData(u);
        refresh();
    }
    @FXML
    private void addTrans(ActionEvent event){
        final JFrame parent = new JFrame();
        ArrayList<Users> u = HelloApplication.readInData();
        for(int i = 0; i<u.size();i++){
            if(u.get(i).getName().equals(myListView.getSelectionModel().getSelectedItem())){
                String amt = JOptionPane.showInputDialog(parent, "Add transaction (amount-weeks)", null);

                u.get(i).addTrans(amt);
                //u.get(i).setAmtOwed();
                u.get(i).setCreditScore(HelloApplication.calculateCred(u.get(i).getAmtOwed(),u.get(i).getAllPayments()));
            }
        }
        HelloApplication.writeInAllData(u);
        refresh();
    }
    @FXML
    private void addAmtOwed(ActionEvent event){
        final JFrame parent = new JFrame();
        ArrayList<Users> u = HelloApplication.readInData();
        for(int i = 0; i<u.size();i++){
            if(u.get(i).getName().equals(myListView.getSelectionModel().getSelectedItem())){
                String amt = JOptionPane.showInputDialog(parent, "Add new debt amount", null);
                u.get(i).addAmtOwed(Integer.parseInt(amt));
            }
        }
        HelloApplication.writeInAllData(u);
        refresh();
    }
    @FXML
    private void nameAZ(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sort(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }
    @FXML
    private void nameZA(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sortZA(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }
    @FXML
    private void amtOwedH(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sortAmtHL(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }
    @FXML
    private void amtOwedL(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sortAmtLH(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }
    @FXML
    private void credH(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sortCredHL(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }
    @FXML
    private void credL(ActionEvent event){
        ArrayList<Users> u = HelloApplication.readInData();
        ArrayList<Users> sorted = HelloApplication.sortCredLH(u);
        HelloApplication.writeInAllData(sorted);
        refresh();
    }


    @FXML
    private void addUserPressed(){
        addUserPane.setStyle("-fx-background-color: rgb(53,71,79);");
        addUserWhite.setVisible(true);
        textPane.setStyle("-fx-background-color: rgb(34, 47, 52);");
        textWhite.setVisible(false);
        newUserScreen.toFront();
    }

    @FXML
    private void userPressed(){
        textPane.setStyle("-fx-background-color: rgb(53,71,79);");
        textWhite.setVisible(true);
        addUserPane.setStyle("-fx-background-color: rgb(34, 47, 52);");
        addUserWhite.setVisible(false);
        newUserScreen.toBack();
    }

    @FXML
    private void setCreateUser(){
        int payment = Integer.parseInt(amtPaymentsText.getText());
        ArrayList<String> allPayments = new ArrayList<String>();
        ArrayList<Users> u = HelloApplication.readInData();
        final JFrame parent = new JFrame();
        for(int i = 0; i<payment; i++) {
            String name = JOptionPane.showInputDialog(parent,
                    "Enter payment " + (i+1), null);
            allPayments.add(name);

        }
        JOptionPane.showMessageDialog(null, "User Added", "Message", JOptionPane.INFORMATION_MESSAGE);
        u.add(new Users(nameText.getText(),Integer.parseInt(amtOwedText.getText()),payment, allPayments,HelloApplication.calculateCred(Integer.parseInt(amtOwedText.getText()),allPayments)));
        HelloApplication.writeInAllData(u);
        refresh();
        amtOwedText.clear();
        nameText.clear();
        amtPaymentsText.clear();
    }

    @FXML
    public void setDeleteButton(){
        ArrayList<Users> u = HelloApplication.readInData();
        String selectedUser = myListView.getSelectionModel().getSelectedItem();
        if (selectedUser != null) {
            HelloApplication.deleteUser(selectedUser);
            refresh();
        } else {
            JOptionPane.showMessageDialog(null, "No user selected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    @FXML
    private void addName(String s){myListView.getItems().add(s);}
    @FXML
    private void addAmtOwed(String s){
        myListViewAmt.getItems().add(s);
    }
    @FXML
    private void addCreditScore(String s){
        myListCredScore.getItems().add(s);
    }

    @FXML
    private MenuButton edit;

    @FXML
    private Button delete;
    @FXML
    private ListView<String> myListView = new ListView<>();

    @FXML
    private ListView<String> myListViewAmt = new ListView<>();

    @FXML
    private ListView<String> myListCredScore = new ListView<>();
    @FXML
    private TextField amtOwedText;
    @FXML
    private Button createUser;
    @FXML
    private Label users;
    @FXML
    private Label amountOwed;
    @FXML
    private Label creditScore;
    @FXML
    private Label displayUser = new Label("");

    @FXML
    private Pane addUserPane;

    @FXML
    private Pane addUserWhite;

    @FXML
    private Pane textPane;

    @FXML
    private Pane textWhite;

    @FXML
    private Pane newUserScreen;

    @FXML
    private TextField nameText;

    @FXML
    private TextField amtPaymentsText;


}