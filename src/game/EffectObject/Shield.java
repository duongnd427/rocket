package game.EffectObject;

import base.FrameCounter;
import base.GameObject;
import game.player.Player;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

import java.awt.*;

public class Shield extends GameObject implements PhysicBody {


    public BoxCollider boxCollider;
    public FrameCounter frameCounter;

    public Shield() {
        this.boxCollider = new BoxCollider(30,30);
        this.renderer = new ImageRenderer("resources/images/powerup_shield.png",30,30, Color.green);
        this.frameCounter = new FrameCounter(300);
    }

    public void run(){
        this.boxCollider.position.set(this.position.x-15,this.position.y-15);
        if(this.frameCounter.run()){
            this.isAlive = false;
            this.frameCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        if(gameObject instanceof Player){
            this.isAlive = false;
        }

    }
}
