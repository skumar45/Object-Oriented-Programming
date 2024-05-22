import processing.core.PImage;

import java.util.List;

public abstract class Entity  {
    public  final String id;

    protected int health;
    protected Point position;

    protected final List<PImage> images;
    protected int imageIndex;

    protected Entity(String id, Point position, List<PImage> images) {
        this.id = id;
        this.position=position;
        this.images = images;
        this.imageIndex = 0;
    }
    PImage getCurrentImage() {
        return this.images.get(this.imageIndex % this.images.size());
    }

    public String log(){
        return this.getId().isEmpty() ? null :
                String.format("%s %d %d %s", this.getId(), this.getPosition().x, this.getPosition().y, this.getImageIndex());
    }

    public int getImageIndex() {
        return imageIndex;
    };

    String getId() {
        return id;
    };

    Point getPosition() {
        return position;
    }

    Point setPosition(Point pos){
        this.position = pos;
        return pos;
    }


    abstract void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore);
}



