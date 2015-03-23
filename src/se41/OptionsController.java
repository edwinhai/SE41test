/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se41;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author edwin
 */
public class OptionsController implements Initializable  {
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private Pane paneMainOptions;
    @FXML
    private FlowPane flowpaneMainMain;
    @FXML
    private FlowPane flowpaneMainChat;
    @FXML
    private Label lbChat;
    @FXML
    private FlowPane flowpaneMainColors;
    @FXML
    private Label lblColor;
    @FXML
    private FlowPane flowpaneMainProfile;
    @FXML
    private Label lblProfile;
    @FXML
    private FlowPane flowpaneMainLanguage;
    @FXML
    private Label lblLanguage;
    @FXML
    private Pane paneChatOptions;
    @FXML
    private FlowPane flowpaneChat;
    @FXML
    private FlowPane flowpaneMute;
    @FXML
    private Label lblMute;
    @FXML
    private CheckBox checkboxMute;
    @FXML
    private FlowPane flowpaneChatFilter;
    @FXML
    private Label lblFilter;
    @FXML
    private CheckBox checkboxChatFilter;
    @FXML
    private Pane paneProfileOptions;
    @FXML
    private FlowPane flowpaneProfile;
    @FXML
    private FlowPane flowpaneProfileName;
    @FXML
    private Label lblName;
    @FXML
    private TextField textfieldName;
    @FXML
    private FlowPane flowpaneProfilePhoto;
    @FXML
    private Label lblPhoto;
    @FXML
    private Button buttonBrowse;
    @FXML
    private Pane paneColorOptions;
    @FXML
    private FlowPane flowpaneColorsColorblind;
    @FXML
    private Label lblColorblind;
    @FXML
    private CheckBox checkboxColorBlind;
    @FXML
    private Pane paneLanguageOptions;
    @FXML
    private FlowPane flowpaneLanguage;
    @FXML
    private FlowPane flowpaneLanguageLanguage;
    @FXML
    private Label lblLanguage2;
    @FXML
    private CheckBox checkboxEnglish;
    @FXML
    private Pane paneside;
    @FXML
    private Circle circleAvatar;
    @FXML
    private Insets x1;
    @FXML
    private Button buttonshowsidebar;
    @FXML
    private Color x3;
    @FXML
    private Font x2;
    @FXML
    private Pane gridPane;

    private boolean sidebarvisible;
    
    private Locale language;

    public void setValues(Locale locale) {
        this.language = locale;
        if(language == Locale.ENGLISH) {
            checkboxEnglish.setSelected(true);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img = new Image(getClass().getClassLoader().getResourceAsStream( "se41/avi.png" ));
        ImagePattern pattern = new ImagePattern(img);
        circleAvatar.getCenterX();
        circleAvatar.setFill(pattern);
        
        //showSideBar();
    }    
    
    @FXML
    private void showSideBar() {
        if(sidebarvisible){
            sidebarvisible = false;
            this.paneside.setVisible(false);
        } else {
            sidebarvisible = true;
            this.paneside.setVisible(true);
        }
    }
    
    @FXML
    public void backToMain() {
        paneMainOptions.setVisible(true);
        paneChatOptions.setVisible(false);
        paneProfileOptions.setVisible(false);
        paneColorOptions.setVisible(false);
        paneLanguageOptions.setVisible(false);
    }
    
    @FXML
    public void toChatOptions() {
        paneMainOptions.setVisible(false);
        paneChatOptions.setVisible(true);
        paneProfileOptions.setVisible(false);
        paneColorOptions.setVisible(false);
        paneLanguageOptions.setVisible(false);
    }
    
    @FXML
    public void toProfileOptions() {
        paneMainOptions.setVisible(false);
        paneChatOptions.setVisible(false);
        paneProfileOptions.setVisible(true);
        paneColorOptions.setVisible(false);
        paneLanguageOptions.setVisible(false);
    }
    
    @FXML
    public void toColorOptions() {
        paneMainOptions.setVisible(false);
        paneChatOptions.setVisible(false);
        paneProfileOptions.setVisible(false);
        paneColorOptions.setVisible(true);
        paneLanguageOptions.setVisible(false);
    }
    
    @FXML
    public void toLanguageOptions() {
        paneMainOptions.setVisible(false);
        paneChatOptions.setVisible(false);
        paneProfileOptions.setVisible(false);
        paneColorOptions.setVisible(false);
        paneLanguageOptions.setVisible(true);
    }
    
    @FXML
    public void switchLanguage() {
        if(checkboxEnglish.isSelected()){
            this.language = Locale.ENGLISH;
        } else {
            this.language = Locale.FRENCH;
        }       
        loadView(this.language);
        
    }
    
    private void loadView(Locale locale) {
        try {
            URL location = getClass().getResource("FXMLOptions.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", locale));
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            ((OptionsController) fxmlLoader.getController()).setValues(locale);
            anchorpane.getChildren().add(root);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    public void toChat() throws Exception{
        Application Chat = new Chat(this.language);
        Chat.start(this.getStage());
    }
    
    @FXML
    public void toForum()throws Exception {
        Application Forum = new Forum(this.language);
        Forum.start(this.getStage());
    }
    
    private Stage getStage() {
        return (Stage) anchorpane.getScene().getWindow();
    }
    
}
