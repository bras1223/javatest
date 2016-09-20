/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawing.domain;
import java.awt.Color;
import java.util.*;
import java.awt.Point;
import java.awt.Font;
/**
 *
 * @author Luuk
 */
public class PaintedText extends DrawingItem{
    
    private String content;
    private Font font;

    public String getContent() {
        return content;
    }

    public Font getFont() {
        return font;
    }

    public void setContent(String content) {
        this.saveState();
        this.content = content;
    }

    public void setFont(Font font) {
        this.saveState();
        this.font = font;
    }

    public PaintedText(String content, Font font, Point anchor, Color color, DrawingItem previousState) {
        super(anchor, color, previousState);
        this.content = content;
        this.font = font;
    }
    
    public PaintedText(String content, Font font, Point anchor, Color color) {
        super(anchor, color);
        this.content = content;
        this.font = font;
    }
    
    private void saveState() {
         this.previousState = new PaintedText(this.getContent(), this.getFont(), this.getAnchor(), this.getColor(), this.getPreviousState());
    }
    
    @Override
    public void paint(IPaintable paintable) {
        paintable.setColor(this.getColor());
        paintable.paintText(this);
    }
    
    @Override
    public String toString() {
        String s = "PaintedText; Content: " + content + " font: " + font.toString() + " x:" + this.getAnchor().x + " y:" + this.getAnchor().y;
        return s;
    }
}
