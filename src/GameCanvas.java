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

    public int xPlayer = 400;
    public int yPlayer = 200;

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

        this.setupEnemy();
        this.setupStar();

    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background();
        this.createPlayer();
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.repaint();
    }


    public void runAll() {
        this.createStar();
        this.createEnemy();

        this.stars.forEach(star -> star.run());
        this.enemies.forEach(enemy -> enemy.run());


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
            Enemy enemy = new Enemy(
                    this.loadImage("resources/images/circle.png"),
                    this.random.nextInt(1024),
                    this.random.nextInt(600),
                    10,
                    10,
                    this.random.nextInt(4) + 1,
                    this.random.nextInt(5) + 1
            );
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

    private void createPlayer() {
        Player player = new Player(this.loadImage("resources/images/circle.png"),
                xPlayer,
                yPlayer,
                30,
                30,
                0,
                0
        );
        player.render(graphics);
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
