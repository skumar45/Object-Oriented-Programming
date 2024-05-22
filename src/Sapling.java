import processing.core.PImage;

import java.util.List;

public class Sapling extends PlantTransformable {

    private int health;
    private final int healthLimit;

    public Sapling(String id, Point position, List<PImage> images, int imageIndex, double actionPeriod, double animationPeriod, int health, int healthLimit) {
        super(id, position, images);
        this.health = health;
        this.healthLimit = healthLimit;
    }



    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler) {
        health++;
        if (!transform(world, scheduler, imageStore)) {
            scheduler.scheduleEvent(this, Factory.createActivityAction(this, world, imageStore), actionPeriod);
        }
    }



    @Override
    protected boolean transform(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (health <= 0) {
            Entity stump = Factory.createStump(WorldLoader.STUMP_KEY + "_" + id, position, imageStore.getImageList(WorldLoader.STUMP_KEY));

            world.removeEntity(scheduler, this);

            world.tryAddEntity(stump);

            return true;
        } else if (health >= healthLimit) {
            Entity tree = Factory.createTreeWithDefaults(WorldLoader.TREE_KEY + "_" + id, position, imageStore.getImageList(WorldLoader.TREE_KEY));

            world.removeEntity(scheduler, this);

            world.tryAddEntity(tree);
            tree.scheduleActions(scheduler, world, imageStore);

            return true;
        }

        return false;
    }




}
