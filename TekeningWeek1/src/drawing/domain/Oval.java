/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;
import java.awt.Color;
import java.awt.Point;
import java.util.*;
/**
 *
 * @author Luuk
 */
public class Oval extends DrawingItem {
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double width) {
        this.saveState();
        this.width = width;
    }

    public void setHeight(double height) {
        this.saveState();
        this.height = height;
    }

    public Oval(double width, double height, Point anchor, Color color, DrawingItem previousState) {
        super(anchor, color, previousState);
        this.width = width;
        this.height = height;
    }
    public Oval(double width, double height, Point anchor, Color color) {
        super(anchor, color);
        this.width = width;
        this.height = height;
    }
    
    private void saveState() {
         this.previousState = new Oval(this.getWidth(), this.getHeight(), this.getAnchor(), this.getColor(), this.getPreviousState());
    }
     
    @Override
    public void paint(IPaintable paintable) {
        paintable.setColor(this.getColor());
        paintable.paintOval(this);
    }
    
    @Override
    public String toString() {
        String s = "Oval; Width: " + width + " height: " + height + " x:" + this.getAnchor().x + " y:" + this.getAnchor().y;
        return s;
    }
}
