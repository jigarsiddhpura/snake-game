import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DifFrame extends JFrame
{    
    DifFrame()
    {
        JTextField tf = new JTextField();
        tf.setBounds(50,50, 150,20); 
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        JButton b = new JButton("Click");
        JButton b1 = new JButton("newbutton");
        b.setBounds(150,150,150,150);
        b.addActionListener(
            new ActionListener()
            {  
            public void actionPerformed(ActionEvent e)
            {  
                tf.setText("Welcome to Javatpoint.");  
                b1.setBounds(40,40,40,40);
                
            }  
            }); 
                this.add(b);
                this.add(b1);
                this.add(tf);  
                this.setSize(400,400);  
                this.setLayout(null);  
                this.setVisible(true);
        
    }
    public static void Abc()
    {}
}