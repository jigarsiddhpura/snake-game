import javax.swing.*;

public class GameFrame extends JFrame{

    // constructor
    GameFrame(){
        this.add(new GamePanel());
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        // frame @ middle
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}