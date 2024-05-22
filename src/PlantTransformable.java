import processing.core.PImage;

import java.util.List;

public abstract class  PlantTransformable extends Executable {
    protected PlantTransformable(String id, Point position, List<PImage> images) {
        super(id, position, images);
    }

    public boolean transformPlant(WorldModel world, EventScheduler scheduler, ImageStore imageStore) {
        if (this instanceof Tree) {
            return transform(world, scheduler, imageStore);
        } else if (this instanceof Sapling) {
            return transform(world, scheduler, imageStore);
        } else {
            throw new UnsupportedOperationException(String.format("transformPlant not supported for %s", this));
        }
    }


    protected abstract boolean transform(WorldModel world, EventScheduler scheduler, ImageStore imageStore);
}
