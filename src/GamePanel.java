import java.util.Random;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.Dimension;

public class GamePanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 30;
    static final int GAME_UNITS = (SCREEN_HEIGHT*SCREEN_WIDTH)/UNIT_SIZE;
    static final int DELAY = 100;
    final int x[] = new int[GAME_UNITS];//this array will carry the x co-od of snake body 
    final int y[] = new int[GAME_UNITS];//this array will carry the y co-od of snake body 
    int bodyParts = 6;//inital size of the snake
    int applesEaten , appleX , appleY;//applex and y will be the co-od of apple which will appear randomly
    char direction = 'R';
    // R = right, L=left, U=up, D=down

    boolean running = false;
    Timer timer ;
    Random random; 

    GamePanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));//background size
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        startGame();
    }

    public void startGame(){
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g)
    {
        if(running)
        {
            for(int i=0;i<(SCREEN_HEIGHT/UNIT_SIZE);i++){
                g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);//parallel lines on x axis 
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);//parallel lines on y axis
            }
            g.setColor(Color.red);// seting the colour of apple 
            g.fillOval(appleX, appleY, UNIT_SIZE,UNIT_SIZE);// 2d apple 
    
            for(int i=0;i<bodyParts;i++)
            {
                if(i==0)//this postion is snakes head
                {
                    g.setColor(Color.green);//choosing a colour 
                    g.fillRect(x[i],y[i], UNIT_SIZE, UNIT_SIZE);// filling the colour at the co od which indicates the head(snake) width heigth will be unitsize
                }
                else//here positon of co od will be the snakes body
                {
                    g.setColor(new Color(50,180, 0));//custom colour
                    g.fillRect(x[i],y[i], UNIT_SIZE, UNIT_SIZE);
                }
            }    
        }
        else
        {
            gameOver(g);
        }
        
    }
    public void newApple(){
        appleX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE;//x co-od of apple , also typecasted so that there dont occur any error
        appleY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE;//y co od of apple 
    }//this will generate at random location on the screen
    
    
    public void move(){
        for(int i=bodyParts; i>0; i--)
        {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }//shifting the direction of snake in short movement of snake 
        //below y means up where in the y co-od is decreased and for down y co od is inscrease for left and right x co od is decrease and increase resp
        //for understanding make a graph in your mind
        switch(direction){
            case 'U':
            y[0] = y[0] - UNIT_SIZE;
            break;
            case 'D':
            y[0] = y[0] + UNIT_SIZE;
            break;
            case 'L':
            x[0] = x[0] - UNIT_SIZE;
            break;
            case 'R':
            x[0] = x[0] + UNIT_SIZE;
            break;
        }
    }
    public void checkApple()
    {
        if(x[0]==appleX && y[0]==appleY)
        {
            bodyParts++;
            applesEaten++;
            newApple();
        }

    }
    public void checkCollisions()
    {
        //checks if head collides with body
        for(int i = bodyParts;i>0;i--)
        {
            if((x[0] == x[i]) && (y[0]==y[i]))
            {
                running = false;
            }
        }
        //checks if head touch left border
        if(x[0] < 0)
        {running = false;}
        //checks if head touch right border
        if(x[0] > SCREEN_WIDTH)
        {running = false;}
        //checks if head touch up border
        if(y[0] < 0)
        {running = false;}
        //checks if head touch bottom border
        if(y[0] > SCREEN_HEIGHT)
        {running = false;}
        if(running == false)
        {timer.stop();}
    }
    public void gameOver(Graphics g)
    {
        g.setColor(Color.red);
        g.setFont(new Font("classic", Font.BOLD, 75));
        g.drawString("Game Over", SCREEN_WIDTH/8, SCREEN_HEIGHT/2);
        g.drawString("Score : "+Integer.toString(applesEaten), SCREEN_WIDTH/4, SCREEN_HEIGHT/4);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(running)
        {
            move();//with this snake will move
            checkApple();
            checkCollisions();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e)
        {
            switch(e.getKeyCode())
            {
                //left
                case KeyEvent.VK_LEFT:
                    if(direction != 'R')//this condition use bcoz if snake moving left then it cant move right
                    {direction='L';} 
                break;

                case KeyEvent.VK_A:
                    if(direction != 'R')//this condition use bcoz if snake moving left then it cant move right
                    {direction='L';} 
                break;
                //right
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L')//this condition use bcoz if snake moving left then it cant move right
                    {direction='R';} 
                break;

                case KeyEvent.VK_D:
                    if(direction != 'R')//this condition use bcoz if snake moving left then it cant move right
                    {direction='L';} 
                break;
                //down 
                case KeyEvent.VK_DOWN:
                    if(direction != 'U')//this condition use bcoz if snake moving left then it cant move right
                    {direction='D';} 
                break;

                case KeyEvent.VK_S:
                    if(direction != 'R')//this condition use bcoz if snake moving left then it cant move right
                    {direction='L';} 
                break;
                //up
                case KeyEvent.VK_UP:
                    if(direction != 'D')//this condition use bcoz if snake moving left then it cant move right
                    {direction='U';} 
                break;

                case KeyEvent.VK_W:
                    if(direction != 'R')//this condition use bcoz if snake moving left then it cant move right
                    {direction='L';} 
                break;

            }
        }
    }
}