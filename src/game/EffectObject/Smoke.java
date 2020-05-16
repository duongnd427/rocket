package game.EffectObject;

import base.FrameCounter;
import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Smoke extends GameObject {

    public FrameCounter frameCounter;
    public Vector2D velocity;
    public FrameCounter frameCounterSmoke;


    public Smoke() {
        this.frameCounter = new FrameCounter(1);

        this.velocity = new Vector2D();
    }

    @Override
    public void run(){
        super.run();
        this.position.subtractBy(this.velocity);
        ImageRenderer imageRenderer = (ImageRenderer)this.renderer;

        if(frameCounter.run()) {
            if (imageRenderer != null) {
                imageRenderer.width -= 1;
                imageRenderer.height -= 1;
                if (imageRenderer.width == 0 || imageRenderer.height == 0) {
                    this.isAlive = false;
                }
            }
            frameCounter.reset();
        }

    }
}
