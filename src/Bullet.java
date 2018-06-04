
public class Bullet extends GameObject {
    public Vector2D velocity;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 8, 8);
    }

    @Override
    public void run() {
        super.run();
        this.position = this.position.addUp(velocity);
    }

}
