package game.EffectObject;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.util.Random;

public class Explosion extends GameObject {

    public FrameCounter frameCounter;
    public Vector2D velocity;
    public Random random;


    public Explosion() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(random.nextInt(3)+1);

        this.velocity = new Vector2D();
    }

    @Override
    public void run(){
        super.run();
        ImageRenderer imageRenderer = (ImageRenderer)this.renderer;
        this.position.addUp(velocity);

        if(frameCounter.run()) {
            if (imageRenderer != null) {
                imageRenderer.width -= 2;
                imageRenderer.height -= 2;
                if (imageRenderer.width <= 0 || imageRenderer.height <= 0) {
                    this.isAlive = false;
                }
            }
            frameCounter.reset();
        }

    }
}
