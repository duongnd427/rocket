package game.player;

import base.GameObject;
import base.Vector2D;
import game.effect.EffectShield;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject implements PhysicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;
    public RunHitObject runHitObject;
    public int live = 1;

    public Player() {
        this.renderer = new PolygonRenderer(
                Color.red,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.boxCollider = new BoxCollider(20, 16);
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.runHitObject = new RunHitObject(EffectShield.class);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.runHitObject.run(this);
    }



    @Override
    public void getHit(GameObject gameObject) {
        if (gameObject instanceof EffectShield){
            this.live+=3;
        }

    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}

