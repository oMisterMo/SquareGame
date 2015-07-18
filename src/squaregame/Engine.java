/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package squaregame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Mo
 */
public class Engine extends JComponent implements ActionListener, MouseListener {
    
    private int squareSize = 40;
    private int groundLevel = 500;
    
    private int squareX = 40;
    private int squareY = groundLevel - squareSize;
    
    private boolean grounded = true;
    private int jumpSize = 70;
    
    private Image bg;
    private int bgX = 0;
    private int bgY = 201;
    
    
    private int num = 0;//onground
    private int num2 = 0;//off ground
    
    public Engine(){
        try {
            bg = ImageIO.read(getClass().getResource("background2.png"));
        } catch (IOException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g){
        //upgrades g with more functions
        Graphics2D g2 = (Graphics2D)g;
        
        //Sets background color and draws background
        g2.setColor(new Color(205, 255, 140));
        g2.fillRect(0, 0, 600, 600);
        //Draws our background tree
        g2.drawImage(bg, bgX, bgY, null);
        
        //Draws the ground
        g2.setColor(new Color(20,20,20));
        g2.fillRect(0, groundLevel, 600, 500);
        
        //Draws our square
        g2.setColor(Color.BLACK);
        g2.fillRect(squareX, squareY, squareSize, squareSize);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Scroll background
        bgX -=4;
        
        //Checks if square in grounded
        if(squareY >= groundLevel-squareSize){
            System.out.println("onGround" + num++);
            grounded = true;
        }
        //If not on ground, move down
        if(!grounded){
            System.out.println("onGround" + num2++);
            squareY+=8;
        }
        //squareY--;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //grounded = false;
        squareY -= jumpSize;
        grounded = false;
        repaint();//Repaints duh
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
