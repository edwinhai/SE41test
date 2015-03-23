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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Linda
 */
public class ForumMainController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Circle circleAvatar;
    @FXML
    private Button buttonshowsidebar;
    //panes van berichten
    @FXML
    private Pane paneMain1;
    @FXML
    private Pane paneMain2;
    @FXML
    private Pane paneMain3;
    @FXML
    private Pane paneZoek1;
    @FXML
    private Pane paneZoek2;
    @FXML
    private Pane paneZoek3;
    @FXML
    private Pane paneCategorie1;
    @FXML
    private Pane paneCategorie2;
    @FXML
    private Pane paneCategorie3;

    //panes
    @FXML
    private Pane paneside;
    @FXML
    private Pane paneMain;
    @FXML
    private Pane paneZoek;
    @FXML
    private Pane paneCategorieen;
    @FXML
    private Pane paneBericht;
    @FXML
    private Pane paneNieuw;
    @FXML
    private Pane paneCategorieOverzicht;
    @FXML
    private Pane gridPane;
    @FXML
    private Pane anchorpane;

    private Locale language;
    private String locatie = "Main";
    private boolean sidebarvisible;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Image img = new Image(getClass().getClassLoader().getResourceAsStream("se41/avi.png"));
        this.language = Locale.ENGLISH;
        ImagePattern pattern = new ImagePattern(img);
        circleAvatar.getCenterX();
        circleAvatar.setFill(pattern);
        sidebarvisible = true;
        //paneside.
        showSideBar();
    }

    public void setValues(Locale locale) {
        this.language = locale;
    }

    public void showSideBar() {
        if (sidebarvisible) {
            sidebarvisible = false;
            this.paneside.setVisible(false);
        } else {
            sidebarvisible = true;
            this.paneside.setVisible(true);
        }

    }

    public void setEnglish() {
        this.language = Locale.ENGLISH;
        loadView(Locale.ENGLISH);
    }

    public void setDutch() {
        this.language = Locale.FRENCH;
        loadView(Locale.FRENCH);
    }

    private void loadView(Locale locale) {
        try {
            URL location = getClass().getResource("FXMLForumMain.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
            fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", locale));
            Parent root = (Parent) fxmlLoader.load(location.openStream());
            anchorpane.getChildren().add(root);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void toOptions() throws Exception {
        Application Options = new Options(this.language);
        Options.start(this.getStage());
    }

    @FXML
    public void toChat() throws Exception {
        Application Chat = new Chat(this.language);
        Chat.start(this.getStage());
    }

    @FXML
    public void toForum() throws Exception {

    }

    @FXML
    public void toZoek() throws Exception {
        this.locatie = "Zoek";
        this.paneMain.setVisible(false);
        this.paneZoek.setVisible(true);
    }

    @FXML
    public void toCategorie() throws Exception {
        this.locatie = "Categorie";
        this.paneCategorieen.setVisible(true);
        this.paneMain.setVisible(false);
    }

    private void allePanesFalse() {
        paneMain1.setVisible(false);
        paneMain2.setVisible(false);
        paneMain3.setVisible(false);
        paneZoek1.setVisible(false);
        paneZoek2.setVisible(false);
        paneZoek3.setVisible(false);
        paneCategorie1.setVisible(false);
        paneCategorie2.setVisible(false);
        paneCategorie3.setVisible(false);
        paneside.setVisible(false);
        paneMain.setVisible(false);
        paneZoek.setVisible(false);
        paneCategorieen.setVisible(false);
        paneBericht.setVisible(false);
        paneNieuw.setVisible(false);
        paneCategorieOverzicht.setVisible(false);
    }

    private Stage getStage() {
        return (Stage) anchorpane.getScene().getWindow();
    }
}
