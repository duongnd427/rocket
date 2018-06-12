package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {

    public FrameCounter frameCounter = new FrameCounter(3);
    public PlayerShoot() {
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                Bullet bulletPlayer = new Bullet();
                bulletPlayer.position.set(player.position);
                Vector2D rotate = player.playerMove.velocity.add
                        (new Vector2D(2, 0).rotate(player.playerMove.angle));
                bulletPlayer.velocity.set(rotate);
                GameObjectManager.instance.add(bulletPlayer);
                this.frameCounter.reset();
            }
        }
    }
}
