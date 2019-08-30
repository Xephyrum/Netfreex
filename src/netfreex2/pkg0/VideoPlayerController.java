/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netfreex2.pkg0;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSlider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author arria
 */
public class VideoPlayerController implements Initializable {

    private MediaPlayer mediaPlayer;
    
    @FXML
    private MediaView mediaView;
    @FXML
    private AnchorPane parent;
    @FXML
    private ImageView minimize;
    @FXML
    private JFXButton btnBack;
    @FXML
    private JFXButton openFile;
    @FXML
    private JFXButton btnBack2;
    @FXML
    private JFXButton btnBack1;
    @FXML
    private JFXButton btnPlay;
    
    @FXML
    private JFXButton btnPause;
    @FXML
    private JFXButton btnFast1;
    @FXML
    private JFXButton btnFast2;
    @FXML
    private Label lblTime;
    @FXML
    private JFXButton btnStop;
    private String filePath;
    
    @FXML
    private JFXSlider slider;
    
    @FXML
    private JFXSlider seekSlider;
    
    @FXML
    private VBox controllers;
    
    Boolean buttonflag = true;
    
    int currSID = 0;
    int currEpisode = 0;
    String time = "";
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // TODO
      
        /*File f = new File("test.txt");
        if(f.exists()){
            int a  = JOptionPane.showConfirmDialog(null, "Do you want to resume from where you last ended?");
            String fp = "", ct = "";
            if(a == JOptionPane.YES_OPTION){
                String sql = "SELECT SID, Episode FROM tbl_directory WHERE Root = '" + fp+"'";
                filePath = fp;
                time = ct;
                try{
                    PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                    ResultSet r = SQLUtilities.ExecuteQuery(s);
                    if(r.next()){
                        currSID = r.getInt(1);
                        currEpisode = r.getInt(2);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
                Scanner sc = new Scanner(System.in);
                try {
                    sc = new Scanner(new File("test.txt"));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                
                int i = 0;                                    
                while(sc.hasNextLine()){
                    if(i == 0)
                        fp = sc.nextLine();
                    else
                        ct = sc.nextLine();
                    i++;
                }
               
                if (fp != null) {
                System.out.println(fp);
                sql = "SELECT SID, Episode FROM tbl_directory WHERE Root = '" + fp+"'";
                try{
                    PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                    ResultSet r = SQLUtilities.ExecuteQuery(s);
                    if(r.next()){
                        currSID = r.getInt(1);
                        currEpisode = r.getInt(2);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No saved data for previously watched video.");
                        return;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                Media media = new Media(fp);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                
                DoubleProperty width = mediaView.fitWidthProperty(); 
                DoubleProperty height = mediaView.fitHeightProperty(); 
                
                
                width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
                height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));
                                
                mediaPlayer.setOnReady(() -> {
                lblTime.textProperty().bind(Bindings.createStringBinding(() ->{
                    Duration time = mediaPlayer.getCurrentTime();
                    return String.format("%4d:%02d:%04.1f",
                        (int)time.toHours(),
                        (int)time.toMinutes() % 60,
                        time.toSeconds() % 60);
                }, mediaPlayer.currentTimeProperty()));
                System.out.println(lblTime.toString());
                
                });
                
                seekSlider.maxProperty().bind(Bindings.createDoubleBinding(() -> 
                mediaPlayer.getTotalDuration().toSeconds(), mediaPlayer.totalDurationProperty()));
                
                slider.setValue(mediaPlayer.getVolume()*100);
                slider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        mediaPlayer.setVolume(slider.getValue()/100); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                                                                                   
                seekSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                    mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
                });
                
                mediaPlayer.setOnEndOfMedia(new Runnable(){
                    public void run(){
                        initMediaPlayer();
                    }
                });
                
                mediaView.toBack();
                seekSlider.toFront();
                controllers.toFront();
                mediaPlayer.setStartTime(Duration.seconds(Double.parseDouble(ct)));
                mediaPlayer.play();               
            }     
             }   
        
        }*/
    }

    @FXML
    private void close_app(MouseEvent event) {
        int a  = JOptionPane.showConfirmDialog(null, "Are you sure?");
        time = Double.toString(seekSlider.getValue());
        
        if(a == JOptionPane.YES_OPTION){
            String sql = "SELECT 1 FROM tbl_continue WHERE SID =" + currSID;
            System.out.println(currSID);
     
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
                
                if(r.next()){
                    String sql2 = "UPDATE tbl_continue SET Time = '" +time+"' WHERE SID = " + currSID;
     
                    try{
                        PreparedStatement s2 = SQLUtilities.connection.prepareStatement(sql2);
                        ResultSet r2 = SQLUtilities.ExecuteQuery(s2);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    String sql3 = "INSERT INTO tbl_continue(SID, Episode, Root, Time) VALUES ("+currSID+","+currEpisode+",'"+filePath+"','"+time+"')";
                    try{
                        PreparedStatement s3 = SQLUtilities.connection.prepareStatement(sql3);
                        ResultSet r3 = SQLUtilities.ExecuteQuery(s3);
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            try{ //CODE TO SAVE LAST PLAYED VIDEO
                File f = new File("test.txt");
                PrintWriter writer = new PrintWriter(f);
                writer.println(filePath);
                writer.println(seekSlider.getValue());
                writer.flush();
                writer.close();
            }catch(Exception e){
                e.printStackTrace();
            }            
         }               
        System.exit(0);
    }

    @FXML
    private void maximize(MouseEvent event) {
        Stage stage1 = (Stage)parent.getScene().getWindow();
        stage1 = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage1.setMaximized(true);
    }

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage1 = (Stage) parent.getScene().getWindow();
        stage1 = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }

    @FXML
    private void back(MouseEvent event) {
        try {
                Parent fxml = FXMLLoader.load(getClass().getResource("Home.fxml"));
                parent.getChildren().removeAll();
                parent.getChildren().setAll(fxml);
                mediaPlayer.stop();
                
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        FileChooser filechooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)", "*mp4*");
            filechooser.getExtensionFilters().add(filter);
            File file = filechooser.showOpenDialog(null);
            filePath = file.toURI().toString();
            
            
            String sql = "SELECT Root, Episode FROM tbl_directory WHERE Root = '" + filePath+"'";
                try{
                    PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                    ResultSet r = SQLUtilities.ExecuteQuery(s);
                    if(r.next()){
                        currSID = r.getInt(1);
                        currEpisode = r.getInt(2);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
                
            if (filePath != null) {
                System.out.println(filePath);
                /*tring sql = "SELECT SID, Episode FROM tbl_directory WHERE Root = '" + filePath+"'";
                try{
                    PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                    ResultSet r = SQLUtilities.ExecuteQuery(s);
                    if(r.next()){
                        currSID = r.getInt(1);
                        currEpisode = r.getInt(2);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Please upload your file first.");
                        return;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }*/
                Media media = new Media(filePath);
                mediaPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(mediaPlayer);
                
                DoubleProperty width = mediaView.fitWidthProperty(); 
                DoubleProperty height = mediaView.fitHeightProperty(); 
                
                
                width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
                height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));
                
                //mediaView.setFitHeight(500);
                
                mediaPlayer.setOnReady(() -> {
                lblTime.textProperty().bind(Bindings.createStringBinding(() ->{
                    Duration time = mediaPlayer.getCurrentTime();
                    return String.format("%4d:%02d:%04.1f",
                        (int)time.toHours(),
                        (int)time.toMinutes() % 60,
                        time.toSeconds() % 60);
                }, mediaPlayer.currentTimeProperty()));
                System.out.println(lblTime.toString());
                
                });
                
                seekSlider.maxProperty().bind(Bindings.createDoubleBinding(() -> 
                mediaPlayer.getTotalDuration().toSeconds(), mediaPlayer.totalDurationProperty()));
                
                slider.setValue(mediaPlayer.getVolume()*100);
                slider.valueProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        mediaPlayer.setVolume(slider.getValue()/100); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                
                                
                /*mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
                    @Override
                    public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                        seekSlider.setValue(newValue.toSeconds());
                    }
                });*/
                
                /*seekSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        //mediaPlayer.stop();
                        mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
                        //mediaPlayer.play();
                    }
                });*/
                             
                seekSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
                    mediaPlayer.seek(Duration.seconds(newValue.doubleValue()));
                });
                
                mediaPlayer.setOnEndOfMedia(new Runnable(){
                    public void run(){
                        System.out.println("Loading next episode");
                        initMediaPlayer();
                        
                    }
                });
                
                mediaView.toBack();
                seekSlider.toFront();
                controllers.toFront();
                mediaPlayer.play();               
            }     
    }
    
    @FXML
    private void FullScreen(MouseEvent event) {              
        Stage stage1 = (Stage) parent.getScene().getWindow();
        stage1 = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage1.setFullScreen(true);
            
    }
    
    public void initMediaPlayer(){
        String sql = "SELECT Root, SID, Episode FROM tbl_directory WHERE SID = " + currSID + "AND Episode = " + (currEpisode+1);
        String fp = "";
        try{
            PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
            ResultSet r = SQLUtilities.ExecuteQuery(s);
            if(r.next()){
                fp = r.getString(1);
                currSID = r.getInt(2);
                currEpisode = r.getInt(3);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        Media media = new Media(fp);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
                
        DoubleProperty width = mediaView.fitWidthProperty(); 
        DoubleProperty height = mediaView.fitHeightProperty(); 
                
                
        width.bind(Bindings.selectDouble(mediaView.sceneProperty(),"width"));
        height.bind(Bindings.selectDouble(mediaView.sceneProperty(),"height"));
                
        //mediaView.setFitHeight(500);
                
        mediaPlayer.setOnReady(() -> {
            lblTime.textProperty().bind(Bindings.createStringBinding(() ->{
            Duration time = mediaPlayer.getCurrentTime();
            return String.format("%4d:%02d:%04.1f",
                (int)time.toHours(),
                (int)time.toMinutes() % 60,
                time.toSeconds() % 60);
            }, mediaPlayer.currentTimeProperty()));
            System.out.println(lblTime.toString());
        });
                
        seekSlider.maxProperty().bind(Bindings.createDoubleBinding(() -> 
        mediaPlayer.getTotalDuration().toSeconds(), mediaPlayer.totalDurationProperty()));
                
        slider.setValue(mediaPlayer.getVolume()*100);
        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaPlayer.setVolume(slider.getValue()/100); //To change body of generated methods, choose Tools | Templates.
            }
        });
                
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                seekSlider.setValue(newValue.toSeconds());
            }
        });
                
                
        seekSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.seek(Duration.seconds(seekSlider.getValue()));
            }
        });
                
        mediaPlayer.setOnEndOfMedia(new Runnable(){
            public void run(){
                initMediaPlayer();
            }
        });
                
        mediaView.toBack();
        seekSlider.toFront();
        controllers.toFront();
        mediaPlayer.play();               
    }

    @FXML
    private void slowerVideo(ActionEvent event) {
        mediaPlayer.setRate(.5);
    }

    @FXML
    private void slowVideo(ActionEvent event) {
        mediaPlayer.setRate(.75);
    }

    @FXML
    private void playVideo(ActionEvent event) {
        //mediaPlayer.play();
        mediaPlayer.setRate(1);
        btnPause.toFront();
        mediaPlayer.play();
     
        }


    @FXML
    private void fastVideo(ActionEvent event) {
        mediaPlayer.setRate(1.5);
    }

    @FXML
    private void fasterVideo(ActionEvent event) {
        mediaPlayer.setRate(2);
    }

    @FXML
    private void stopVideo(ActionEvent event) {
        mediaPlayer.stop();
    }

    @FXML
    private void pauseVideo(ActionEvent event) {
        btnPlay.toFront();
        mediaPlayer.pause();
    }

    @FXML
    private void hideController(MouseEvent event) {
        controllers.toBack();
    }

    @FXML
    private void showController(MouseEvent event) {
        controllers.toFront();
    }

    }