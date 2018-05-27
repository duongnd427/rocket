import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindows extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

//    Random random = new Random();

    public GameWindows()    {
        this.setSize(1024, 600);
        this.setupGameCanvas();
        this.event();

        this.setVisible(true);
    }

    public void gameLoop()  {
        while (true)    {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000)   {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
                }
        }
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }


    private void event() {
        this.keyboardEvent();
        this.windowsEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                {
                    gameCanvas.player.velocity.x = -5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    gameCanvas.player.velocity.x = 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    gameCanvas.player.velocity.y = -5;
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    gameCanvas.player.velocity.y = 5;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                gameCanvas.player.velocity.x = 0;
                gameCanvas.player.velocity.y = 0;
            }
        });
    }

    private void windowsEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

}
