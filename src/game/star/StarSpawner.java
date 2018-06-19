package game.star;

import action.*;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class StarSpawner extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public StarSpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(30);
        this.createAction();
    }

//    public void createAction() {
//        Action waitAction = new WaitAction(30);
//        Action createAction = new ActionAdapter() {
//            @Override
//            public boolean run(GameObject owner) {
//                Star star = GameObjectManager.instance.recycle(Star.class);
//                star.position.set(1024,random.nextInt(600));
//                star.velocity.set(-(random.nextInt(3) + 1), 0);
//                return true;
//            }
//        };
//
//        Action sequenceAction = new SequenceAction(waitAction, createAction);
//        Action repeatAction = new RepeatActionForever(sequenceAction);
//
//        this.addAction(repeatAction);
//    }

    public void createAction() {
        this.addAction(
                new LimitAction(
                        new SequenceAction(
                                new WaitAction(30),
                                new ActionAdapter() {
                                    @Override
                                    public boolean run(GameObject owner) {
                                        Star star = GameObjectManager.instance.recycle(Star.class);
                                        star.position.set(1024,random.nextInt(600));
                                        star.velocity.set(-(random.nextInt(3) + 1), 0);
                                        return true;
                                    }
                                }
                        ),
                        10
                )
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            Star star = new Star();
//            star.position.set(1024, this.random.nextInt(600));
//            star.velocity.set(-(this.random.nextInt(3) + 1), 0);
//            GameObjectManager.instance.add(star);
//            this.frameCounter.reset();
//        }
    }
}
