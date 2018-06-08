package game.player;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;


public class Player extends GameObject {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public BoxCollider boxCollider;

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
    }


    public void run() {
        super.run();
        this.playerMove.run(this);
        this.boxCollider.position.set(this.position.x - 10, this.position.y - 8);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }

}