/**
 * An action that can be taken by an entity.
 * Actions can be either an activity (involving movement, gaining health, etc)
 * or an animation (updating the image being displayed).
 */
public final class Activity implements Action {
    private final Entity entity;
    private final WorldModel world;
    private final ImageStore imageStore;

    public Activity(Entity entity,WorldModel world, ImageStore imageStore) {
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
    }
    public void executeAction(EventScheduler scheduler) {
        ((Executable)entity).executeActivity(world, imageStore, scheduler);

    }

}
