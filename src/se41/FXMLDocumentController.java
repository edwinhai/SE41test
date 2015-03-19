/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se41;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/**
 *
 * @author edwin
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Circle circleAvatar;
    @FXML
    private Button buttonshowsidebar;
    @FXML
    private Pane paneside;
    @FXML
    private Pane gridPane;
    
    private boolean sidebarvisible;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img = new Image(getClass().getClassLoader().getResourceAsStream( "se41/avi.png" ));
        ImagePattern pattern = new ImagePattern(img);
        circleAvatar.getCenterX();
        circleAvatar.setFill(pattern);
        sidebarvisible = true;
        showSideBar();
    }    
    
    public void showSideBar() {
        if(sidebarvisible){
            sidebarvisible = false;
            this.paneside.setVisible(false);
        } else {
            sidebarvisible = true;
            this.paneside.setVisible(true);
        }
        
    }
    
}
