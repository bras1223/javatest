/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;
import java.awt.Color;
import java.util.*;
import java.awt.Point;
/**
 *
 * @author Luuk
 */
public class Polygon extends DrawingItem{
    
    private Point[] verticles;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Point[] getVerticles() {
        return Arrays.copyOf(verticles, 5);
    }

    public void setWeight(int weight) {
        this.saveState();
        this.weight = weight;
    }

    public Polygon(int weight, Point anchor, Point[] verticles, Color color, DrawingItem previousState) {
        super(anchor, color, previousState);
        this.verticles = verticles;
        this.weight = weight;
    }
    
     public Polygon(int weight, Point anchor, Point[] verticles, Color color) {
        super(anchor, color);
        this.verticles= verticles;
        this.weight = weight;
    }
     
    private void saveState(){
         this.previousState = new Polygon(this.getWeight(), this.getAnchor(), this.verticles, this.getColor(), this.getPreviousState());
    }
    
    @Override
     public void paint(IPaintable paintable){
        paintable.setColor(this.getColor());
            
        for (int i = 0; i < verticles.length - 1; i++) {
                int starty = verticles[i].y + this.getAnchor().y;
                int startx = verticles[i].x + this.getAnchor().x;
                Point start = new Point(startx, starty);
                
                int endy = verticles[i + 1].y + this.getAnchor().y;
                int endx = verticles[i + 1].x + this.getAnchor().x;
                Point end = new Point(endx, endy);
                paintable.paintLine(start, end, this.weight);
            }
            
            int lastx = verticles[0].x + this.getAnchor().x;
            int lasty = verticles[0].y + this.getAnchor().y;
            
            int firstx = verticles[verticles.length-1].x + this.getAnchor().x;
            int firsty= verticles[verticles.length-1].y + this.getAnchor().y;
            paintable.paintLine(new Point(lastx, lasty), new Point(firstx, firsty), this.weight);
    }
     
    @Override
    public String toString() {
        String s = "Polygon; Weight: " + weight + " x:" + this.getAnchor().x + " y:" + this.getAnchor().y;
        return s;
    }
}
