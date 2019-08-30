/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netfreex2.pkg0;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author arria
 */
public class FXMLDocumentController implements Initializable {
    
    
    @FXML
    private AnchorPane parent;
    @FXML
    private ImageView minimize;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        FadeTransition.applyFadeTransition(parent, Duration.seconds(2), (e) -> {
            try {
                Parent fxml = FXMLLoader.load(getClass().getResource("Home.fxml"));
                parent.getChildren().removeAll();
                parent.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
     
        });
    }    

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

  

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage1 = (Stage)parent.getScene().getWindow();
        stage1 = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }


    @FXML
    private void maximize(MouseEvent event) {
        Stage primaryStage = (Stage)parent.getScene().getWindow();
       
        primaryStage = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        primaryStage.setMaximized(true);
        
         
        
        
    }
    
}
