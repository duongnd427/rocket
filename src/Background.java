import java.awt.*;

public class Background {

    public int x, y, width, height;
    Color color;

    public Background(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(x,y,width,height);
    }
}
