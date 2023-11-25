package com.goncalomatias1.l05gr06.Objects;

import com.goncalomatias1.l05gr06.Objects.Characteristics.Health;
import com.goncalomatias1.l05gr06.Objects.Characteristics.Position;

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
