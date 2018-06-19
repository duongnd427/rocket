//package action;
//
//import base.FrameCounter;
//import base.GameObject;
//
//public class WaitLimitAction implements Action {
//
//    private Action action;
//    private int count;
//
//
//    public WaitLimitAction(Action action, int count) {
//        this.action = action;
//        this.count = count;
//    }
//
//    @Override
//    public boolean run(GameObject owner) {
//            if (this.action.run(owner)) {
//                if (owner.isAlive = false) {
//                    this.action.reset();
//                    this.count -= 1;
//                }
//            }
//            return this.count == 0;
//    }
//
//    @Override
//    public void reset() {
//
//    }
//
//}
