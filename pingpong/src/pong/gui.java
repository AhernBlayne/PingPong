package pong;
/**
 * This is my gui class which i use to create  my pingpong gui
 * @author Blayne Ahern
 * @version 3.0
 * @since 2019-26-11
 *
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class gui extends JFrame implements ActionListener {
private String name;


    public gui(){
        pingpong game = new pingpong();
        JFrame frame = new JFrame("ping pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(game);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(game);
        frame.setLocation( 800,300 );
    } //end constructor

    public gui(String name){
        JFrame frame = new JFrame(name);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JRootPane root = frame.getRootPane();
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("match history");
        bar.add(menu);
        menu.add("Open");
        menu.add("Close");
        root.setJMenuBar(bar);
        root.getContentPane().add(new JButton("Press Me"));
        frame.pack();
        frame.setVisible(true);
    }


    public String getname(){
        return name;
    }
    public void setname(String name){ this.name = name;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    } //end actionPerformed


}//end class
