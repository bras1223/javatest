/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.javafx;

import drawing.domain.IPaintable;
import drawing.domain.Images;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Polygon;
import java.awt.Color;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;


/**
 *
 * @author Luuk
 */
public class JavaFXPaintable implements IPaintable {

    GraphicsContext gc;
    JavaFXPaintable(GraphicsContext gc) {
        this.gc = gc;
    }

    @Override
    public void setColor(Color color) {
        gc.setFill(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));
        gc.setStroke(javafx.scene.paint.Color.rgb(color.getRed(), color.getGreen(), color.getBlue()));
    }

    @Override
    public void paintOval(Oval oval) {
        int x = oval.getAnchor().x;
        int y= oval.getAnchor().y;
        
        gc.fillOval(x, y, oval.getWidth(), oval.getHeight());
    }

    @Override
    public void paintLine(Point from, Point to, int Weight) {
       gc.strokeLine(from.x, from.y, to.x, to.y);
    }

    @Override
    public void paintText(PaintedText text) {
        int x = text.getAnchor().x;
        int y= text.getAnchor().y;
        gc.fillText(text.getContent(), x, y);
    }

    @Override
    public void paintImage(Images image) {
        int x = image.getAnchor().x;
        int y= image.getAnchor().y;
        File src = image.getFile();
        Image img = new Image(src.getPath());
        
        gc.drawImage(img, x, y);
    }
    
    
    @Override
    public void Clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }


    
}
