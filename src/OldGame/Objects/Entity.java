package OldGame.Objects;

import OldGame.Objects.Characteristics.Health;
import OldGame.Objects.Characteristics.Position;

public abstract class Entity {
    protected Position position;
    protected Health health;
    protected boolean isEnemy;
    public void isDamaged(){
        health.lowerHealth();
    }

    public Position getPosition(){
        return position;
    }
    public Health getHealth(){
        return health;
    }
    public boolean getisEnemy(){
        return isEnemy;
    }
}
