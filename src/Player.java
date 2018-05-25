import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    BufferedImage image;
    public int x, y, width, height, velocityX, velocityY;
    Random random = new Random();

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run() {
        if (x > 1024) {
            x = 0;
            y = random.nextInt(600);
        }
        if (y > 600) {
            y = 0;
            x = random.nextInt(1024);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, this.x, this.y, this.width, this.height, null);

    }


}

