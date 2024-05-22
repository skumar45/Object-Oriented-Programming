
    /**
     * An action that can be taken by an entity.
     * Actions can be either an activity (involving movement, gaining health, etc)
     * or an animation (updating the image being displayed).
     */
    public final class Animation implements Action {
        private final Entity entity;
        private final int repeatCount;

        public Animation( Entity entity, int repeatCount) {

            this.entity = entity;
            this.repeatCount = repeatCount;
        }

        public void executeAction(EventScheduler scheduler) {
            ((ActionScheduler)entity).nextImage();

            if (repeatCount != 1) {
                scheduler.scheduleEvent(entity, Factory.createAnimationAction(entity, Math.max(repeatCount - 1, 0)), ((ActionScheduler)entity).animationPeriod);
            }
        }


    }

