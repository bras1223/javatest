/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.javafx;

import drawing.domain.Drawing;
import drawing.domain.Images;
import drawing.domain.Oval;
import drawing.domain.PaintedText;
import drawing.domain.Polygon;
import drawing.domain.Spline;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

/**
 *
 * @author Luuk
 */
public class DrawingTool extends Application{
       private Drawing drawing = new Drawing();     
       private Parent root;
       private DrawingToolController controller;
               
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("DrawingTool.fxml"));
        root = (Parent) loader.load();
        controller = loader.getController();
        
        drawing.setName("first");
        drawing.setHeight(500);
        drawing.setWidth(500);
        
        addItems();
        
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        draw();
    }
    public void addItems() {
        String imageSource = "/drawing/domain/dobbel4.png";
        Images firstImage = new Images(new File(imageSource), 50, new Point(450,30), Color.CYAN);
        drawing.addDrawingItem(firstImage);
        
        Oval firstOval = new Oval(150, 120, new Point(40, 300), Color.GREEN);
        drawing.addDrawingItem(firstOval);
        
        PaintedText firstText = new PaintedText("Dit is een text.", new Font("Segoe UI", Font.BOLD, 15), new Point(450,200), Color.RED);
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
        Polygon firstPolygon = new Polygon(6, new Point(130, 40), verticles, Color.YELLOW);
        drawing.addDrawingItem(firstPolygon);
        
        Spline firstSpline = new Spline(20, 50, new Point(200, 400), Color.MAGENTA);
        drawing.addDrawingItem(firstSpline); 
    }
    public void draw() {
        Canvas canvas = controller.getCanvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        JavaFXPaintable paintable = new JavaFXPaintable(gc);
        drawing.paint(paintable);
    }           
}
