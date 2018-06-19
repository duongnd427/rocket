package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {
    private FrameCounter frameCounter,specialCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(1);
    }

    public void run(Player player) {

        if (player.tripleShot){
            if(this.specialCounter == null)
                this.specialCounter = new FrameCounter(1000);
        }
        else{
            this.specialCounter = null;
        }

        if(this.specialCounter!=null){
            if(this.specialCounter.run()){
                player.tripleShot=false;
            }
        }


        if (KeyboardInput.instance.spacePressed) {
            if (this.frameCounter.run()) {
                Bullet bulletPlayer = GameObjectManager.instance.recycle(Bullet.class);
                bulletPlayer.position.set(player.position);

                Vector2D rotate = player.playerMove.velocity.add(
                        (new Vector2D(2, 0)).rotate(player.playerMove.angle)
                );

                bulletPlayer.velocity.set(rotate);
                this.frameCounter.reset();
                if(this.specialCounter!=null){
                    for(int angle = 90; angle <360; angle +=180){
                        Bullet specialBullet = GameObjectManager.instance.recycle(Bullet.class);
                        specialBullet.position.set(player.position);
                        specialBullet.velocity.set(player.playerMove.velocity
                                .add(player.playerMove.velocity
                                        .normalize()
                                        .rotate(angle)
                                        .multiply(6)));
                    }

                }

            }
        }
    }
}
