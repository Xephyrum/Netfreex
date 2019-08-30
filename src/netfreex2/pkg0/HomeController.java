package netfreex2.pkg0;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static netfreex2.pkg0.NetFreex20.stage;

/**
 * FXML Controller class
 *
 * @author arria
 */
public class HomeController implements Initializable {
        
    private Path path;
    private List<String> subPathList = null;
    ArrayList<String> images = new ArrayList<String>(); 
    
    @FXML
    private AnchorPane parent;
    
    @FXML
    private JFXComboBox cmbSelection;
    
    @FXML
    private ScrollPane pnl_series, pnl_movies;
    
    @FXML
    private JFXButton btn_home, btn_series, btn_movies, btn_CW;
    
    @FXML
    private ImageView minimize;
    private JFXButton LoadImages;
    @FXML
    private JFXButton btn_settings;
    @FXML
    private JFXButton btn_help;
    @FXML
    private AnchorPane pnl_settings;
    @FXML
    private AnchorPane pnl_help;
    @FXML
    private JFXButton btn_watched;
    @FXML
    private ScrollPane pnl_watched;
    @FXML
    private Label lblUpload;
    @FXML
    private JFXTextField txtTitle;
    
    private String filePath;
    private String imagePath = "";
    
    @FXML
    private AnchorPane pnl_CW;
    @FXML
    private AnchorPane pnl_home;
    
    @FXML
    private ImageView series1;
    @FXML
    private ImageView series2;
    @FXML
    private ImageView series3;
    @FXML
    private ImageView series4;
    
    @FXML
    private ImageView movie1;
    @FXML
    private ImageView movie2;
    @FXML
    private ImageView movie3;
    @FXML
    private ImageView movie4;
    
    @FXML
    private void playMovie(MouseEvent event){
        
    }
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btn_home){
            pnl_home.toFront();
        }
        else if(event.getSource() == btn_series){
            images = new ArrayList<String>(); 
            pnl_series.toFront();
            int count = 0;
                       
            String sql = "SELECT Picture FROM tbl_masterList WHERE Type='Series'";
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
                while(r.next()){
                   images.add(r.getString(1));
                }   
            }catch(Exception e){
                e.printStackTrace();
            }
            
            count = images.size();
            
            if(count == 1){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString());
                series1.setImage(image);
            }
            
            else if(count == 2){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                series1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series2.setImage(image);
            }
            
            else if(count == 3){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                series1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series2.setImage(image);
                
                file = new File(images.get(2));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series3.setImage(image);
            }
            
            else if(count == 4){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                series1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series2.setImage(image);
                
                file = new File(images.get(2));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series3.setImage(image);
                
                file = new File(images.get(3));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                series4.setImage(image);
            }
        }
           
        else if(event.getSource() == btn_movies){
            pnl_movies.toFront();
            int count = 0;
            images = new ArrayList<String>();
            
            String sql = "SELECT Picture FROM tbl_masterList WHERE Type='Movies'";
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
                while(r.next()){
                   images.add(r.getString(1));
                }   
            }catch(Exception e){
                e.printStackTrace();
            }
            
            count = images.size();
            
            if(count == 1){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie1.setImage(image);
            }
            
            else if(count == 2){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie2.setImage(image);
            }
            
            else if(count == 3){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie2.setImage(image);
                
                file = new File(images.get(2));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie3.setImage(image);
            }
            
            else if(count == 4){
                File file = new File(images.get(0));
                Image image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie1.setImage(image);
                                                            
                file = new File(images.get(1));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie2.setImage(image);
                
                file = new File(images.get(2));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie3.setImage(image);
                
                file = new File(images.get(3));
                image = new Image(file.toURI().toString(), 159, 183, false, false);
                movie4.setImage(image);
            }
        }
        else if(event.getSource() == btn_CW){
            pnl_CW.toFront();
        }
        else if(event.getSource() == btn_help){
            pnl_help.toFront();
        }
        else if(event.getSource() == btn_settings){
            pnl_settings.toFront();
        }
        else if(event.getSource() == btn_watched){
            pnl_watched.toFront();
        }
        else if(event.getSource() == LoadImages){
           
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        lblUpload.setVisible(false);
        cmbSelection.getItems().add("Movies");
        cmbSelection.getItems().add("Series");
        
        SQLUtilities.Connect();
        if(SQLUtilities.Connect())
            System.out.println("Database connection successful!");
    }    

    @FXML
    private void close_app(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void maximize(MouseEvent event) {
        Stage primaryStage = (Stage)parent.getScene().getWindow();
       
        primaryStage = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        primaryStage.setMaximized(true);
        
        
    }
    

    @FXML
    private void minimize(MouseEvent event) {
        Stage stage1 = (Stage) parent.getScene().getWindow();
        stage1 = (Stage) ((ImageView)event.getSource()).getScene().getWindow();
        stage1.setIconified(true);
    }
    
    @FXML
    private void uploadPicture(MouseEvent event){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.jpg)", "*.jpg");
        fileChooser.getExtensionFilters().add(filter);
        File file = fileChooser.showOpenDialog(null);
        imagePath = file.getAbsolutePath();
        System.out.println(imagePath);
    }
    
    @FXML
    private void select_File(MouseEvent event){
        if(cmbSelection.getValue().toString().equalsIgnoreCase("Movies")){
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Select a file (*.mp4)", "*.mp4");
            fileChooser.getExtensionFilters().add(filter);
            File file = fileChooser.showOpenDialog(null);
            filePath = file.toURI().toString();
            lblUpload.setVisible(true);
        }
        
        else if(cmbSelection.getValue().toString().equalsIgnoreCase("Series")){
            DirectoryChooser directoryChooser = new DirectoryChooser();
            directoryChooser.setTitle("Open Resource Folder for TV Series");
            File file = directoryChooser.showDialog(stage);
            filePath = file.getAbsolutePath();
            //System.out.println(filePath);
            lblUpload.setVisible(true);
            
            path = Paths.get(filePath);
            
            try(Stream<Path> subPaths = Files.walk(path)){
                //subPaths.forEach(System.out::println);
                subPathList = subPaths.filter(Files::isRegularFile).map(Objects::toString).collect(Collectors.toList());
                System.out.println(subPathList);
                System.out.println(subPathList.size());
            }catch(Exception e){
                e.printStackTrace();
            }                                
        }  
    }
    
    @FXML 
    private void upload(MouseEvent event){
        String title = txtTitle.getText();
        String type = cmbSelection.getValue().toString();
        int sid = 1;
        
        String sql = "SELECT MAX(SID) FROM tbl_masterList";
        try{
            PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
            ResultSet r = SQLUtilities.ExecuteQuery(s);
            if(r.next()){
                sid = r.getInt(1);
                sid += 1;
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
        
        if(cmbSelection.getValue().toString().equalsIgnoreCase("Movies")){
            sql = "INSERT INTO tbl_masterList(SID, Title, Type, Picture) VALUES ("+sid+", '"+title+"', '"+type+"', '"+ imagePath + "')";
     
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
            }catch(Exception e){
                e.printStackTrace();
            }

            sql = "INSERT INTO tbl_directory(SID, Type, Root, Episode) VALUES ("+sid+", '"+type+"', '"+filePath+"', 1)";
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if(cmbSelection.getValue().toString().equalsIgnoreCase("Series")){
            Collections.sort(subPathList, new Comparator<String>(){
                private final Comparator<String> NATURAL_SORT = new WindowsExplorerComparator();
                    
                @Override
                public int compare(String o1, String o2) {;
                    return NATURAL_SORT.compare(o1 , o2);
                }
            });
            
            sql = "INSERT INTO tbl_masterList(SID, Title, Type, Picture) VALUES ("+sid+", '"+title+"', '"+type+"', 'NULL')";
     
            try{
                PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                ResultSet r = SQLUtilities.ExecuteQuery(s);
            }catch(Exception e){
                e.printStackTrace();
            }
            
            for(int i = 1; i<= subPathList.size(); i++){   
                
                String fp = subPathList.get(i-1);
                fp = fp.replace("\\", "/");
                fp = "file:/" + fp; //String manipulation to make filepath similar to URI
                fp = fp.replaceAll(" ", "%20");
                System.out.println(fp); 
                
                sql = "INSERT INTO tbl_directory(SID, Type, Root, Episode) VALUES ("+sid+", '"+type+"', '"+fp+"',"+i+")";
                try{
                    PreparedStatement s = SQLUtilities.connection.prepareStatement(sql);
                    ResultSet r = SQLUtilities.ExecuteQuery(s);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        lblUpload.setVisible(false);
        txtTitle.clear();
        cmbSelection.setValue(null);
        JOptionPane.showMessageDialog(null,"File Uploaded Successfully");  
    }

    @FXML
    private void OpenPlayer(MouseEvent event) {
        
        try {
                Parent fxml = FXMLLoader.load(getClass().getResource("VideoPlayer.fxml"));
                parent.getChildren().removeAll();
                parent.getChildren().setAll(fxml);
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    @FXML
    private void OpenForm(MouseEvent event) {
        
        pnl_home.toFront();
    }
    
}
