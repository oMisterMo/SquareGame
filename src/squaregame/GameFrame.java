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

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Window which the game is rendered to
 * <p>
 *
 * @version 0.1.0
 * @author Mohammed Ibrahim
 */
public class GameFrame extends JFrame {

    /**
     * Constructs a JFrame window
     */
    public GameFrame() {
        super("Awsome Game");
//        makeFrame();
    }

    /**
     * Initialises and creates a new game instance
     */
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
}
