package game.effect;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;

import java.util.Random;

public class EffectShield extends GameObject implements PhysicBody {

    public BoxCollider boxCollider;
    private FrameCounter frameCounter;
//    public RunHitObject runHitObject;
    private Random random;

    public EffectShield() {
        this.random = new Random();
        this.renderer = (renderer.Renderer) new ImageRenderer("resources/images/powerup_shield.png", 20,20);
        this.boxCollider = new BoxCollider(20,20);
        this.frameCounter = new FrameCounter(1000);

    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            EffectShield effectShield = GameObjectManager.instance.recycle(EffectShield.class);
            effectShield.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            this.boxCollider.position.set(this.position.x - 10, this.position.y - 10);
            this.frameCounter.reset();
        }

    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
