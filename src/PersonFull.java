import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonFull extends Executable {


    private final int resourceLimit;



    public PersonFull(String id, Point position, List<PImage> images, int imageIndex, int resourceLimit, double actionPeriod, double animationPeriod) {
        super(id, position, images);
        this.resourceLimit = resourceLimit;
    }

    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> fullTarget = world.findNearest(position, new ArrayList<>(List.of(House.class)));

        if (fullTarget.isPresent() && moveTo(world, fullTarget.get(), scheduler)) {
            transform(world, scheduler, imageStore);
        } else {
            scheduler.scheduleEvent(this, Factory.createActivityAction(this, world, imageStore), actionPeriod);
        }
    }


    private void transform(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        Entity dude = Factory.createPersonSearching(id, position, actionPeriod, animationPeriod, resourceLimit, images);

        world.removeEntity(scheduler, this);

        world.tryAddEntity(dude);
        dude.scheduleActions(scheduler, world, imageStore);
    }


    //a little different
    public Point nextPosition(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.x - position.x);
        Point newPos = new Point(position.x + horiz, position.y);

        if (horiz == 0 || world.getOccupant(newPos).isPresent() && world.getOccupant(newPos).get().getClass() != Stump.class) {
            int vert = Integer.signum(destPos.y - position.y);
            newPos = new Point(position.x, position.y + vert);

            if (vert == 0 || world.getOccupant(newPos).isPresent() && world.getOccupant(newPos).get().getClass() != Stump.class) {
                newPos = position;
            }
        }

        return newPos;
    }


    public boolean moveTo(WorldModel world, Entity target, EventScheduler scheduler) {
        Point currentPosition = getPosition();
        Point targetPosition = target.getPosition();

        if (currentPosition.adjacent(targetPosition)) {
            moveTo(world, target, scheduler);
            return true;
        } else {
            Point nextPos = nextPosition(world, targetPosition);

            if (!currentPosition.equals(nextPos)) {
                world.moveEntity(scheduler, (Entity) this, nextPos);
            }
            return false;
        }
    }

}
