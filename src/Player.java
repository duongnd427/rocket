import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {

    public Vector2D position;
    public Vector2D velocity;
    public Vector2D xyplayer;
    public Vector2D x,y,z;
    private Random random;

    private List<Vector2D> verties;
    private Polygon polygon;
    public Enemy enemy;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.random = new Random();
        this.x = new Vector2D();
        this.y = new Vector2D();
        this.z = new Vector2D();
        this.verties = Arrays.asList(
                x = new Vector2D(),
                y = new Vector2D(0, 16),
                z = new Vector2D(20, 8)
        );
        this.polygon = new Polygon();
    }

    public void run() {

        this.verties = Arrays.asList(x.addUp(velocity), y.addUp(velocity), z.addUp(velocity));
        this.setVerties();

        this.position = this.position.set(y.x + (z.x - y.x)/3, (x.y + y.y)/2);
        this.backToScreen();
    }



//    private void backToScreen() {
//        if (this.position.x > 1024)   {
//            this.position.set(0, this.random.nextInt(600));
//        }
//        if (this.position.x < 0)  {
//            this.position.set(1024, this.random.nextInt(600));
//        }
//        if (this.position.y > 600)    {
//            this.position.set(this.random.nextInt(1024), 0);
//        }
//        if (this.position.y < 0)    {
//            this.position.set(this.random.nextInt(1024), 600);
//        }
//    }

    private void backToScreen() {
        if (this.z.x > 1024) {
            x.x = 0;
            y.x = 0;
            z.x = 20;
        }
        if (this.x.x < 0) {
            x.x = 1004;
            y.x = 1004;
            z.x = 1024;
        }
        if (this.x.y < 0) {
            x.y = 584;
            y.y = 600;
            z.y = 592;
        }
        if (this.y.y > 600) {
            x.y = 0;
            y.y = 16;
            z.y = 8;
        }
    }

    private void setVerties(){
        List<Vector2D> vectorG = Arrays.asList(
                this.velocity.normalize().multiply(16),
                this.velocity.normalize().multiply((float)(8*Math.sqrt(2))),
                this.velocity.normalize().multiply((float)(8*Math.sqrt(2)))
        );

        this.verties = Arrays.asList(
                this.position.add(vectorG.get(0)),
                this.position.add(vectorG.get(1).rotate(135)),
                this.position.add(vectorG.get(2).rotate(-135))
        );

    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.red);
        this.polygon.reset();
        this.verties.forEach(vertex -> polygon.addPoint((int)vertex.x, (int) vertex.y));
        graphics.fillPolygon(this.polygon);
    }

}

