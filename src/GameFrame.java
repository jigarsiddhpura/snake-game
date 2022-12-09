import javax.swing.*;

public class GameFrame extends JFrame{

    // constructor
    GameFrame(int a)
    {
        this.add(new GamePanel(a));
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        // frame @ middle
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}



