import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class GameCanvas extends JPanel {

    BufferedImage backBuffered;
    Graphics graphics;

    List<Star> stars;
    List<Enemy>enemies;



    public Player player;

    private Random random = new Random();
    private int countStar = 0;
    private int countEnemy = 0;


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupCharacter();
        this.setupBackBuffered();
        this.setVisible(true);
    }

    private void setupBackBuffered()    {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {

        this.enemies = new ArrayList<>();
        this.stars = new ArrayList<>();
        this.player = new Player();
        this.player.position.set(500, 300);

    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background();
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.repaint();
    }


    public void runAll() {
        this.createStar();
        this.createEnemy();

        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
    }

    private void createStar() {
        if (this.countStar == 10) {
            Star star = new Star(
                    this.loadImage("resources/images/star.png"),
                    1024,
                    this.random.nextInt(600),
                    5,
                    5,
                    -this.random.nextInt(4) - 1,
                    0
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy() {
        if (this.countEnemy == 50) {

            int m = random.nextInt(2);
            if (m == 0) m = -1;
            else m = 1;

            Enemy enemy = new Enemy(
                    this.loadImage("resources/images/circle.png"),10,10);
            enemy.position = new Vector2D(random.nextInt(1024), random.nextInt(600));
            enemy.velocity = new Vector2D(m*random.nextInt(5 + 1), m*random.nextInt(8 + 1));
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }

    private void background() {
        Background background = new Background(0,0,1024,600, Color.black);
        background.render(graphics);
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
