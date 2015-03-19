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
 * @author edwin
 */
public class SE41 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        URL location = getClass().getResource("FXMLDocument.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        fxmlLoader.setResources(ResourceBundle.getBundle("resources.lang", Locale.GERMAN));
        Parent root = (Parent) fxmlLoader.load(location.openStream());
        //Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setMaxHeight(stage.getHeight());
        stage.setMaxWidth(stage.getWidth());
        stage.setMinHeight(stage.getHeight());
        stage.setMinWidth(stage.getWidth());
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
