/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;

/**
 *
 * @author Luuk
 */
public class TekeningWeek1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //------------------------DrawingItems initialisatie--------------------
        Drawing drawing = new Drawing();
        drawing.setName("first");
        drawing.setHeight(500);
        drawing.setWidth(500);
        
        String imageSource = "test";
        Images firstImage = new Images(new File(imageSource), 50, new Point(20,30), new Color(1));
        drawing.addDrawingItem(firstImage);
        
        Oval firstOval = new Oval(150, 120, new Point(40, 300), new Color(2));
        drawing.addDrawingItem(firstOval);
        
        PaintedText firstText = new PaintedText("first text", new Font("Garamond", Font.PLAIN , 11), new Point(20,50), new Color(3));
        drawing.addDrawingItem(firstText);
        
        Point[] verticles = new Point[8];
        verticles[0] = new Point(10,0);
        verticles[1] = new Point(0,10);
        verticles[2] = new Point(0,20);
        verticles[3] = new Point(10,30);
        verticles[4] = new Point(20,30);
        verticles[5] = new Point(30,20);
        verticles[6] = new Point(30,10);
        verticles[7] = new Point(20,0);
        Polygon firstPolygon = new Polygon(6, new Point(130, 40), verticles, new Color(4));
        drawing.addDrawingItem(firstPolygon);
        
        Spline firstSpline = new Spline(20, 50, new Point(200, 400), new Color(5));
        drawing.addDrawingItem(firstSpline);
        
        //Print items
        drawing.printItems();
    }
    
}
