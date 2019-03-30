/* 
 * Copyright (C) 2018 Mohammed Ibrahim
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package squaregame;

import java.applet.AudioClip;
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
import javax.swing.JApplet;
import javax.swing.JComponent;

/**
 * A simple game engine using the Java Swing Toolkit.
 *
 * @version 0.1.0
 * @author Mohammed Ibrahim
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

    private AudioClip jump;

    /**
     * Loads assets from the default directory.
     */
    public Engine() {
        try {
            bg = ImageIO.read(getClass().getResource("background2.png"));
            jump = JApplet.newAudioClip(getClass().getResource("jump.wav"));
        } catch (IOException ex) {
            Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //FOR DRAWING
    @Override
    protected void paintComponent(Graphics g) {
        //upgrades g with more functions
        Graphics2D g2 = (Graphics2D) g;

        //Sets background color and draws background
        g2.setColor(new Color(205, 255, 140));
        g2.fillRect(0, 0, 600, 600);
        //Draws our background tree
        g2.drawImage(bg, bgX, bgY, null);
//        System.out.println("bgX: " + bgX);
        if (bgX < -1200) {
            bgX = 465;
            //g2.drawImage(bg, bgX2, bgY, null);
        }

        //Draws the ground
        g2.setColor(new Color(20, 20, 20));
        g2.fillRect(0, groundLevel, 600, 500);

        //Draws our square
        g2.setColor(Color.BLACK);
        g2.fillRect(squareX, squareY, squareSize, squareSize);

        g2.dispose();
    }

    //FOR MOVEMENT
    @Override
    public void actionPerformed(ActionEvent e) {
        //Scroll background
        bgX -= 4;

        //Checks if square in grounded
        if (squareY >= groundLevel - squareSize) {
            //System.out.println("onGround" + num++);
            grounded = true;
        }
        //If not on ground, move down
        if (!grounded) {
            //System.out.println("onGround" + num2++);
            squareY += 8;
        }
        //squareY--;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //grounded = false;
        if (grounded) {
            squareY -= jumpSize;
            grounded = false;
            jump.play();
        }

        repaint();//Repaints
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
