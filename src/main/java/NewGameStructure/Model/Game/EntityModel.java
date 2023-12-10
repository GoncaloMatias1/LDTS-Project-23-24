package NewGameStructure.Model.Game;

import NewGameStructure.Position;

public abstract class EntityModel {
    protected Position position;
    protected int lives; // Use lives instead of Health
    protected boolean isEnemy;

    public EntityModel(Position position, int lives, boolean isEnemy) {
        this.position = position;
        this.lives = lives; // Initialize with the given number of lives
        this.isEnemy = isEnemy;
    }

    // Getters and setters for position and lives...
    public Position getPosition() {
        return position;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isEnemy() {
        return isEnemy;
    }

    // Other methods...
}
