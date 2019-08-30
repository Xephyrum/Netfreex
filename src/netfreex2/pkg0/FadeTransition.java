/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netfreex2.pkg0;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 *
 * @author arria
 */
public class FadeTransition {
    
    public static void applyFadeTransition(Node node, Duration duration, EventHandler<ActionEvent> event){
        javafx.animation.FadeTransition fadeIn = new javafx.animation.FadeTransition(duration,node);
        fadeIn.setCycleCount(1);
        fadeIn.setFromValue(0.2);
        fadeIn.setToValue(1);
        fadeIn.setAutoReverse(true);
        fadeIn.setOnFinished(event);
        
        javafx.animation.FadeTransition fadeOut = new javafx.animation.FadeTransition(duration,node);
        fadeOut.setCycleCount(0);
        fadeOut.setFromValue(0.2);
        fadeOut.setToValue(1);
        fadeOut.setAutoReverse(true);
              
        fadeOut.play();
        
        fadeOut.setOnFinished((e) -> {
            fadeIn.play();
        });
    
    }
    
    
}
