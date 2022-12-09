import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SnakeGame extends JFrame implements ActionListener
{
    Container c;
    JButton b;
    JLabel l1,l2;
    Choice c1;
    SnakeGame()
    {
        c= getContentPane();
        c.setLayout(new FlowLayout());
        b  = new JButton("Submit");
        l1 = new JLabel("Welcome to the Snake Game Zzzz");
        l2 = new JLabel("Select the mode :");
        c1 = new Choice();
        c1.add("Easy");c1.add("Normal");c1.add("Hard");c1.add("Very HArd");
        l1.setBounds(40,40,40,40);
        b.addActionListener(this);
        c.add(l1);
        c.add(l2);
        c.add(c1);
        c.add(b);
    }
    public void actionPerformed(ActionEvent e)
    {
     if(c1.getItem(c1.getSelectedIndex())=="Easy")
    {new GameFrame(90);}
    else if(c1.getItem(c1.getSelectedIndex())=="Normal")
    {new GameFrame(75);}
    else if(c1.getItem(c1.getSelectedIndex())=="Hard")
    {new GameFrame(50);}
    else if(c1.getItem(c1.getSelectedIndex())=="Very HArd")
    {new GameFrame(30);}
    }
    public static void main(String[] args) 
    {
        SnakeGame l = new SnakeGame();
        l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        l.setBounds(150,200,300,120);
        l.setVisible(true);
        l.setResizable(false);
        l.setTitle("Snake zzzz");
        // new DifFrame();
    }
}