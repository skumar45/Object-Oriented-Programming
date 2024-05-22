import processing.core.PImage;

import java.util.List;

public abstract class ActionScheduler extends Entity {

    protected double actionPeriod;
    protected final double animationPeriod;
    protected int imageIndex;

    protected ActionScheduler(String id, Point position, List<PImage> images, double actionPeriod, double animationPeriod, int imageIndex) {
        super(id, position, images);
        this.actionPeriod = actionPeriod;
        this.animationPeriod = animationPeriod;
        this.imageIndex = imageIndex;
    }


    public void nextImage() {
        imageIndex = imageIndex + 1;
    }


    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore) {
        scheduler.scheduleEvent(this, Factory.createActivityAction(this, world, imageStore), actionPeriod);
        scheduler.scheduleEvent(this, Factory.createAnimationAction(this, 0), animationPeriod);
    }


    public double getAnimationPeriod() {
        return animationPeriod;
    }



}
