import processing.core.PImage;

import java.util.List;

public abstract class Executable extends ActionScheduler {
    protected Executable(String id, Point position, List<PImage> images) {
        super(id, position,images,0,0,0);
    }

    abstract void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler);

}
