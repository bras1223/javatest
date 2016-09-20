/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;
import java.util.*;
import java.awt.Point;
import java.awt.Color;
import java.io.Serializable;
/**
 *
 * @author Luuk
 */

public abstract class DrawingItem implements Comparable<DrawingItem>, Serializable{
    private Point anchor;
    private Color color;
            
    protected DrawingItem previousState;

    public Point getAnchor() {
        return anchor;
    }

    public Color getColor() {
        return color;
    }

    public void setAnchor(Point anchor) {
        this.anchor = anchor;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DrawingItem getPreviousState() {
        return previousState;
    }

    public DrawingItem(Point anchor, Color color, DrawingItem previousState) {
        this.anchor = anchor;
        this.color = color;
        this.previousState = previousState;
    }
    
    public DrawingItem(Point anchor, Color color) {
        this.anchor = anchor;
        this.color = color;
    }
    
    public void paint(IPaintable paintable){
        
    }
    
    @Override
    public int compareTo(DrawingItem otherItem) { 
        Point initPoint = new Point(0,0);
        if(otherItem.anchor.distance(initPoint) < this.anchor.distance(initPoint)) { 
            return 1;
        } else if((otherItem.anchor.distance(initPoint)) == (this.anchor.distance(initPoint))) {
            return 0;
        } else{
            return -1;
        }
        
    }
}
