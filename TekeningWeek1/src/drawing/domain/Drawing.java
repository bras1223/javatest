/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;

import java.io.Serializable;
import java.util.*;

/**
 *
 * @author Luuk
 */
public class Drawing implements Serializable{
    private String name;
    private int width;
    private int height;
    
    private ArrayList<DrawingItem> items = new ArrayList<DrawingItem>(); 

    public String getName() {
        return name;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void addDrawingItem(DrawingItem item) {
        this.items.add(item);
    }
    public void deleteDrawingItem(DrawingItem item) {
        this.items.remove(item);
    }
    
    public void printItems() {
        Collections.sort(items);
        
        for(DrawingItem i : items) {
            System.out.println(i.toString());
        }
    }
    public void paint(IPaintable paintable) {
        for(DrawingItem d : items){
            d.paint(paintable);
        }
    }
}
