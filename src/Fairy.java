import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Fairy extends ActionScheduler {



    public Fairy(String id, Point position, List<PImage> images,  int imageIndex, double actionPeriod, double animationPeriod) {
        super(id,position,images,imageIndex,actionPeriod, 0);
    }

    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        Optional<Entity> fairyTarget = world.findNearest(position, new ArrayList<>(List.of(Stump.class)));

        if (fairyTarget.isPresent()) {
            Point tgtPos = fairyTarget.get().getPosition();

            if (moveTo(world, fairyTarget.get(), scheduler)) {

                Entity sapling = Factory.createSapling(WorldLoader.SAPLING_KEY + "_" + fairyTarget.get().getId(), tgtPos, imageStore.getImageList(WorldLoader.SAPLING_KEY));

                world.tryAddEntity(sapling);
                sapling.scheduleActions(scheduler, world, imageStore);
            }
        }
    }


    public boolean moveTo(WorldModel world, Entity target, EventScheduler scheduler) {
        Point currentPosition = getPosition();
        Point targetPosition = target.getPosition();
        world.removeEntity(scheduler, target);

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

    public Point nextPosition(WorldModel world, Point destPos) {
        int horiz = Integer.signum(destPos.x - position.x);
        Point newPos = new Point(position.x + horiz, position.y);

        if (horiz == 0 || world.getOccupant(newPos).isPresent() && world.getOccupant(newPos).get().getClass() != House.class) {
            int vert = Integer.signum(destPos.y - position.y);
            newPos = new Point(position.x, position.y + vert);

            if (vert == 0 || world.getOccupant(newPos).isPresent() && world.getOccupant(newPos).get().getClass() != House.class) {
                newPos = position;
            }
        }

        return newPos;
    }

}
