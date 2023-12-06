package NewGameStructure.Model.Game;

import NewGameStructure.Model.Game.Entities.Characteristics.Health;
import NewGameStructure.Position;

public abstract class EntityModel {
    protected Position position;
    protected Health health;
    protected boolean isEnemy;

    public EntityModel(Position position, Health health, boolean isEnemy) {
        this.position = position;
        this.health = health;
        this.isEnemy = isEnemy;
    }

    public Position getPosition() {
        return position;
    }

    public Health getHealth() {
        return health;
    }

    public boolean isEnemy() {
        return isEnemy;
    }
}
