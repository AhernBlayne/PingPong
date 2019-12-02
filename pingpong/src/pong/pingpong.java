package pong;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class pingpong extends JPanel implements KeyListener {

    public int width = 500;
    public int height = 500;
    private int updaterate = 30;
    private final int pwidth = 10, pheight = 50;
    private int xd,yd,pxd,pyd;
    ball b = new ball(xd, yd, 16, 16, 250, 250);
    paddle p = new paddle(pxd, pyd, 10, 50, 0, 250);
    paddle p2 = new paddle(pxd, pyd, 10, 50, 489, 250);
    public int score1,score2;
    signin gui = new signin();

    public pingpong() {
        this.setPreferredSize(new Dimension(width, height));
        String answer = JOptionPane.showInputDialog(null,"what ball speed would you like? (slow,medium or fast?)");
        String answer2 = JOptionPane.showInputDialog(null,"what ball size would you like? (small,medium,large?)");
        if(answer2.equals("small")){b.setBheight(16); b.setBwidth(16);}
        else if(answer2.equals("medium")){b.setBheight(32); b.setBwidth(32); p.setpheight(55);   p2.setpheight(55);}
        else if(answer2.equals("large")){b.setBheight(48); b.setBwidth(48); p.setpheight(60); p2.setpheight(60); }
        if(answer.equals("slow")){ b.setXd(3);
            b.setyd(2); pyd = 5;}
        else if (answer.equals("medium")){b.setXd(6);
            b.setyd(5); pyd= 10;}
        else if (answer.equals("fast")){b.setXd(8);
            b.setyd(7); pyd = 15;}
        if(answer == "" || answer2 ==""){JOptionPane.showMessageDialog(null,"Default settings selected");}
        // Start the ball bouncing (in its own thread)
        Thread gameThread = new Thread() { // adapted from https://www.ntu.edu.sg/home/ehchua/programming/java/J8a_GameIntro-BouncingBalls.html also https://www.geeksforgeeks.org/multithreading-in-java/ to teach me about threads.
            public void run() {
                while (true) {
                    ballbounce();
                    // Refresh the display
                    repaint(); // Callback paintComponent()
                    // Delay for timing control and give other threads a chance
                    try {
                        Thread.sleep(1000 / updaterate); // (milliseconds) Also issue here cause my frame rate is tied to the game physics. adapted from https://www.journaldev.com/1020/thread-sleep-java
                    } catch (InterruptedException ex) {}
                }
            }
        };
        gameThread.start();

        // start player thread
        Thread playerThread = new Thread() { // both players in one thread to prevent bias
            public void run() {
                while (true) {
                    move();
                    repaint();
                    try {
                        Thread.sleep(1000 / updaterate); // milliseconds
                    } catch (InterruptedException ex) {}
                }
            }
        };
        playerThread.start();

    }


    private void move() { // my movement method for my paddles
        if (p.getpyPos() < 0) p.setpyPos(0);
        if (p.getpyPos() >= height - p.getpheight()) p.setpyPos(450); // my paddle clamp for when the paddle attempts to go off screen. if paddle goes over bounds then set position the limit of the bounds.

        p.setpxPos(p.getpxPos() + p.getpXd());
        p.setpyPos(p.getpyPos() + p.getpyd());

        if (p2.getpyPos() < 0) p2.setpyPos(0);
        if (p2.getpyPos() >= height - p2.getpheight()) p2.setpyPos(450); // my paddle clamp for when the paddle attempts to go off screen. if paddle goes over bounds then set position the limit of the bounds.

        p2.setpxPos(p2.getpxPos() + p2.getpXd());
        p2.setpyPos(p2.getpyPos() + p2.getpyd());

    }
    public void ballbounce() {

        b.setxPos(b.getxPos() + b.getXd());
        b.setyPos(b.getyPos() + b.getyd());

        if (b.getyPos() <= 0 || b.getyPos() >= height - b.getBheight()) b.setyd(b.getyd() * -1);
        if (b.getxPos() <= 0 || b.getxPos() >= width - b.getBwidth()) b.setXd(b.getXd() * -1);
        if (b.getxPos() <= 0) {
            b.setxPos(250);
            b.setyPos(250);
            score1++;
            if (score1 == 3) {
                b.setXd(0);
                b.setyd(0);
                this.setVisible(false);
                gui.setscore1(score1);
                gui.setscore2(score2);
                gui.setVisible(true);
            }

        }
        if (b.getxPos() >= width - b.getBwidth()) {
            b.setxPos(250);
            b.setyPos(250);
           score2++;
            if (score2 == 3) {
                b.setXd(0);
                b.setyd(0);
                this.setVisible(false);
                gui.setscore1(score1);
                gui.setscore2(score2);
                gui.setVisible(true);
            }
        }
        if (p.getpxPos() < b.getxPos() + b.getBwidth() &&
                p.getpxPos() + pwidth > b.getxPos() &&
                p.getpyPos() < b.getyPos() + b.getBheight() &&
                p.getpyPos() + pheight > b.getyPos() || p2.getpxPos() < b.getxPos() + b.getBwidth() &&
                p2.getpxPos() + pwidth > b.getxPos() &&
                p2.getpyPos() < b.getyPos() + b.getBheight() &&
                p2.getpyPos() + pheight > b.getyPos()) { //collision detection (aabb--Axis Aligned Bounding Box)
            b.setXd(b.getXd() * -1);
            new playmusic("pong (online-audio-converter.com).wav");
        }
    }



    public void paintComponent(Graphics g) { //drawing everything including score on screen.

        super.paintComponent(g);

        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, width, height);

        //ball
        g.setColor(Color.white);
        g.fillRect(b.getxPos(), b.getyPos(), b.getBwidth(), b.getBheight());

        //player
        g.setColor(Color.white);
        g.fillRect(p.getpxPos(), p.getpyPos(), p.getpwidth(), p.getpheight());

        //player 2
        g.setColor(Color.white);
        g.fillRect(p2.getpxPos(), p2.getpyPos(), p2.getpwidth(), p2.getpheight());
        //player 1 score
        g.drawString("Score:" + score1, 20, 20);
        //player 2 score
        g.drawString("Score:" + score2, 440, 20);


    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) { // check if a key was entered and if so move the player.
        int key = e.getKeyCode();
        //setting key to a letter binding. Number value corresponding with the letter pressed
        System.out.print(key);
        //key events for player 1

        if (key == KeyEvent.VK_W) {
            p.setpyd(-pyd);
        }
        if (key == KeyEvent.VK_S) {
            p.setpyd(pyd);
        }
        if (key == KeyEvent.VK_UP) {
            p2.setpyd(-pyd);
        }
        if (key == KeyEvent.VK_DOWN) {
            p2.setpyd(pyd);
        }

    }

    public void keyReleased(KeyEvent e) { // check if entered key was released if so stop the player movement.
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_W) {
            p.setpyd(0);
        }
        if (key == KeyEvent.VK_S) {
            p.setpyd(0);
        }
        if (key == KeyEvent.VK_UP) {
            p2.setpyd(0);
        }
        if (key == KeyEvent.VK_DOWN) {
            p2.setpyd(0);
        }
    }
    public static void main(String args[]) {
        signin gui = new signin();
        gui.setVisible(true);
    }

}