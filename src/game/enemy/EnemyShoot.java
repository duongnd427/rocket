package game.enemy;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;

public class EnemyShoot {

    public FrameCounter frameCounter = new FrameCounter(100);

    public EnemyShoot() {

    }

    public void run(Enemy enemy) {
//        if (this.frameCounter.run()) {
//            for (double angle = 0.0; angle <= 360; angle += 30) {
//                Bullet bulletEnemy = new Bullet();
//                bulletEnemy.position.set(enemy.position);
//                bulletEnemy.velocity.set(new Vector2D(3, 0));
//                GameObjectManager.instance.add(bulletEnemy);
//                this.frameCounter.reset();
//            }
//        }
    }
}


