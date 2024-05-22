import processing.core.PImage;

import java.util.List;

public final class Obstacle extends ActionScheduler {

    public Obstacle(String id, Point position, List<PImage> images, double actionPeriod, double animationPeriod) {
        super(id, position, images, actionPeriod, animationPeriod, 0);
    }

}
