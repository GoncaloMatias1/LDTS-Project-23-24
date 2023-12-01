package NewGameStructure.Controller.Game;


import NewGameStructure.Model.Game.Entities.Characteristics.Position;
import NewGameStructure.Model.Game.EntityModel;

public class EntityController {
    private EntityModel model;

    public EntityController(EntityModel model) {
        this.model = model;
    }

    public void moveEntity(int deltaX, int deltaY) {
        Position position = model.getPosition();
        position.setX(position.getX() + deltaX);
        position.setY(position.getY() + deltaY);
    }
}

