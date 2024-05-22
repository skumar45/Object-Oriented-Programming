/**
 * An action that can be taken by an entity.
 * Actions can be either an activity (involving movement, gaining health, etc)
 * or an animation (updating the image being displayed).
 */
public interface Action {

    void executeAction(EventScheduler scheduler);


}
