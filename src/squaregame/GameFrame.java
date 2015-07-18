/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squaregame;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author Mo
 */
public class GameFrame extends JFrame {

    private int number = 0;

    public GameFrame() {
        super("Awsome Game");
        makeFrame();
    }

    public void makeFrame() {
        
        Engine e = new Engine();
        add(e);
        addMouseListener(e);
        
        pack();
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        
        Timer t = new Timer(60, e);
        t.start();
    }

    public void getSum() {
        System.out.println("Does nothing");
    }
}
