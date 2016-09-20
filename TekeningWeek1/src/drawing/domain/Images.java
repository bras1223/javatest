/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;
import java.awt.Color;
import java.awt.Point;
import java.io.File;
import java.util.*;
/**
 *
 * @author Luuk
 */
public class Images extends DrawingItem {
    private File file;
    private double size;

    public File getFile() {
        return file;
    }

    public double getSize() {
        return size;
    }

    public void setFile(File file) {
        this.saveState();
        this.file = file;
    }

    public void setSize(double size) {
        this.saveState();
        this.size = size;
    }

    public Images(File file, double size, Point anchor, Color color, DrawingItem previousState) {
        super(anchor, color, previousState);
        this.file = file;
        this.size = size;
    }
    public Images(File file, double size, Point anchor, Color color) {
        super(anchor, color);
        this.file = file;
        this.size = size;
    }     
    
    private void saveState() {
         this.previousState = new Images(this.getFile(), this.getSize(), this.getAnchor(), this.getColor(), this.getPreviousState());
    }   
    
    @Override
    public void paint(IPaintable paintable) {
        paintable.setColor(this.getColor());
        paintable.paintImage(this);
    }
    
    @Override
    public String toString(){
    String s = "Image; Bestand: " + this.file.toString() + " size: " + this.getSize() + " x:" + this.getAnchor().x + " y:" + this.getAnchor().y;
    return s;
    }
    
}
