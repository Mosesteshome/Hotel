package sample;

import javafx.scene.Scene;

import java.sql.*;

public class databaseconnection {
    public Connection databaseLink;

    public Connection getConnection(){

        String databaseName="hotel_db";
        String databaseUser="root";
        String databasePassword="3141";
       String url="jdbc:mysql://localhost:3306/hotel?autoReconnect=true&useSSL=false";
        try{
            //Class.forName("com.mysql.cj.jdbc.Driver");
          databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
     return databaseLink;
    }

}
