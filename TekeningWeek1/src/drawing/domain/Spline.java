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
public class Spline extends DrawingItem{
  
    private Point[] points = new Point[6];
    private int weight;
    private int degree;

    public int getWeight() {
        return weight;
    }

    public int getDegree() {
        return degree;
    }

    public Point[] getPoints() {
        return Arrays.copyOf(points, 5);
    }

    public void setWeight(int weight) {
        this.saveState();
        this.weight = weight;
    }

    public void setDegree(int degree) {
        this.saveState();
        this.degree = degree;
    }

    public Spline(int weight, int degree, Point anchor, Color color, DrawingItem previousState) {
        super(anchor, color, previousState);
        this.weight = weight;
        this.degree = degree;
    }
    
    public Spline(int weight, int degree, Point anchor, Color color) {
        super(anchor, color);
        this.weight = weight;
        this.degree = degree;
        points[0] = new Point(0,0);
        points[1] = new Point(50,20);
        points[2] = new Point(150, 100);
        points[3] = new Point(170,80);
        points[4] = new Point(300, 420);
        points[5] = new Point(350, 205);
    }       
    
    private void saveState() {
        this.previousState = new Spline(this.getWeight(), this.getDegree(), this.getAnchor(), this.getColor(), this.getPreviousState());
    }

    @Override
    public String toString() {
        String s = "Spline; weight: " + weight + " degree: " + degree + " x:" + this.getAnchor().x + " y:" + this.getAnchor().y;
        return s;
    }
    
    @Override
    public void paint(IPaintable paintable) {
        paintable.setColor(this.getColor());
        
         for (int i = 0; i < points.length - 1; i++) {
                Point start = points[i];
                Point end = points[i + 1];
                paintable.paintLine(start, end, this.weight);
            }
    }
}
