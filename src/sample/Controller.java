package sample;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXML;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Controller {
     @FXML
     private Button xbutton;
    @FXML
    private Button utton;
     @FXML
     private Label loginmessege;
    @FXML
    private Button loginbutton;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

     public void loginbuttonONAction (ActionEvent event){

         if(username.getText().isBlank()==false &&password.getText().isBlank()==false){

             loginvalidate();
         }else
             loginmessege.setText("Please enter username and password");

     }
     public void xbuttonOnAction (ActionEvent event){
         
         Stage stage=(Stage) xbutton.getScene().getWindow();
         stage.close();
     }
     public void loginvalidate (){
         databaseconnection connection=new databaseconnection();
         Connection connectDB= connection.getConnection();

         String verifylogin ="SELECT count(1) from admins WHERE username='"+ username.getText()+"'And password='"+password.getText()+"'";

        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifylogin);

            while ((queryResult.next())){
                if(queryResult.getInt(1)==1){
                    loginmessege.setText("congratulations!");
                }else{
                    loginmessege.setText("Invalid login, please try again");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

     }
}
