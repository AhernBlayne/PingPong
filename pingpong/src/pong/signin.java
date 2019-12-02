package pong;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
// reference from bicycleframe3.java
public class signin extends JFrame implements ActionListener{

    JMenu signMenu;
    user [] users; // an array of users
    int c; // number of users in the array
    private int score1,score2;



    // constructor
    public signin( ) {
        newStore();
        setTitle     ( "Sign In!" );
        setSize      ( 500,500);
        setLocation  ( 800,300);
        Container pane = getContentPane();
        pane.setBackground(new Color(192,192,192));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        try {
            BufferedImage image = ImageIO.read(new File("ping.jpg"));
            JLabel mainLabel = new JLabel(new ImageIcon(image));
            mainLabel.setLayout(new FlowLayout());
            setContentPane(mainLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        csignMenu();
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(signMenu);

    }
    public void setscore1(int score1){this.score1 = score1;}
    public void setscore2(int score2){this.score2 = score2;}
    public int getscore1(){return score1;}
    public int getscore2(){return score2;}
    public void newStore() {
        users = new user[10];
        c = 0;
    }

    /** writes the array of users to the file "users.dat"
     */   // NEW
    public void save() throws IOException {
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new FileOutputStream ("users.dat"));
        oos.writeObject(users);
        oos.close();
        this.setVisible(false);
        gui g = new gui();
    }

    /** loads an array of users from the file "users.dat"
     */
    public void open() {
        c = 0;
        try{
            ObjectInputStream ois;
            ois = new ObjectInputStream(new FileInputStream ("users.dat"));
            users = (user []) ois.readObject();
            ois.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"error");
            e.printStackTrace();
        }
        while (users[c] !=null)
            c++;
    }

    /*public void check(String n,String w){
        if (c>0) {
            for (int p = 0; p < users.length; p++) {
                if (users[p].getuser().equals(n) && users[p].getpass().equals(w)) {
                    JOptionPane.showMessageDialog(null, "welcome back");
                } else {
                }

            }
        }
    } */


    public void sign(){
        String u = JOptionPane.showInputDialog("please enter username");
        String p = JOptionPane.showInputDialog("please enter password");
        user temps = new user(u,p,getscore1(),getscore2());
            //  check(u,p);
        users[c] = temps; // default user
        JOptionPane.showMessageDialog(null,"Welcome to the system!");
        // set the attributes: ask the user for username and password
        c++;
        try {
            save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void display(){
        JTextArea area = new JTextArea();
        if (c>0) {
            for (int i = 0; i<c; i++) // existing users get looped.
                area.append("user " + (i+1) + " " +users[i].toString()+"\n");
            JOptionPane.showMessageDialog(null,area);
        }
        else
            JOptionPane.showMessageDialog(null,"No users");
    } // end display


    public void actionPerformed (ActionEvent e) {
        if (e.getActionCommand() .equals ("Quit")){
            JOptionPane.showMessageDialog(null,"Shutting down the system");
            System.exit(0);
        }
        else if (e.getActionCommand() .equals ("Sign In")){
            sign();
        }
        else if (e.getActionCommand() .equals ("New File")){
            newStore();
        }
        else if (e.getActionCommand() .equals ("Open")){
            open();
            display();
        }
        else
            JOptionPane.showMessageDialog(null,"error");
    } // actionPerformed

    private void csignMenu(){
        // create the menu
        signMenu = new JMenu("user details");
        // declare a menu item (re-usable)
        JMenuItem item;
        item = new JMenuItem("Sign In");
        item.addActionListener(this);
        signMenu.add(item);
        item = new JMenuItem("Open");
        item.addActionListener(this);
        signMenu.add(item);
        item = new JMenuItem("New File");
        item.addActionListener(this);
        signMenu.add(item);
        // create the 'quit' option
        signMenu.addSeparator();
        item = new JMenuItem("Quit");
        item.addActionListener(this);
        signMenu.add(item);
    }

}