import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindows extends JFrame {

    GameCanvas gameCanvas;
    long lastTime = 0;

    Random random = new Random();

    public GameWindows()    {
        this.setSize(1024, 600); //kich thuoc cua so windows
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
                    gameCanvas.xPlayer -= 5;
                    if (gameCanvas.xPlayer < 0) {
                        gameCanvas.xPlayer = 1024;
                        gameCanvas.yPlayer = random.nextInt(600);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                {
                    gameCanvas.xPlayer += 5;
                    if (gameCanvas.xPlayer > 1024) {
                        gameCanvas.xPlayer = 0;
                        gameCanvas.yPlayer = random.nextInt(600);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP)
                {
                    gameCanvas.yPlayer -= 5;
                    if (gameCanvas.yPlayer < 0) {
                        gameCanvas.yPlayer = 600;
                        gameCanvas.xPlayer = random.nextInt(1024);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN)
                {
                    gameCanvas.yPlayer += 5;
                    if (gameCanvas.yPlayer > 600) {
                        gameCanvas.yPlayer = 0;
                        gameCanvas.xPlayer = random.nextInt(1024);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
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
