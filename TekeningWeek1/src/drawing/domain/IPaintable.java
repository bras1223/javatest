/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Point;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author Luuk
 */
public interface IPaintable {
    
    void setColor(Color color);
    
    void paintOval(Oval oval);
    
    void paintLine(Point from, Point to, int Weight);
    
    void paintText(PaintedText text);
    
    void paintImage(Images image);
    
    void Clear();
    
}
