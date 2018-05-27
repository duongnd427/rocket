import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;

    public int width;
    public int height;

    public Star(BufferedImage image, int width, int height) {
        this.image = image;
        this.position = new Vector2D();
        this.width = width;
        this.height = height;
        this.velocity = new Vector2D();
    }


    public void run() {
        this.position = this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)position.x, (int)position.y, this.width, this.height, null);
    }
}
