/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package se41;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Linda
 */
public class Forum   extends Application{

    public Locale language;
    public String forum;
    
    public Forum(Locale locale, String Forum) {
        this.language = locale;
        this.forum = Forum;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        URL location = null;
        if(forum.equals("Main"))
        {
        location = getClass().getResource("FXMLForumMain.fxml");
        }
        else if(forum.equals("Categorie"))
        {
        location = getClass().getResource("FXMLForumCategorie.fxml");
        }
        else if(forum.equals("Zoek"))
        {
        location = getClass().getResource("FXMLForumZoek.fxml");
        }
        else if(forum.equals("Chat"))
            {
        location = getClass().getResource("FXMLForumChat.fxml");
        }
        
        if(location==null)
        {
            location = getClass().getResource("FXMLForumMain.fxml");
        }
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", this.language));
        Parent root = (Parent) fxmlLoader.load(location.openStream());
        ((OptionsController) fxmlLoader.getController()).setValues(this.language);
        
        Scene scene = new Scene(root);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaxHeight(primaryStage.getHeight());
        primaryStage.setMaxWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        primaryStage.setMinWidth(primaryStage.getWidth());
    }
    
}
