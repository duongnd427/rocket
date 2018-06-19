package game.enemy;


import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import java.util.Random;

public class EnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
        this.createEnemy();
    }

    public void createEnemy() {
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(350),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                        enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                        return true;
                                    }
                                }
                                ),
                70
                )
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            this.frameCounter.reset();
//        }
    }
}
