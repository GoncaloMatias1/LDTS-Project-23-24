package NewGameStructure.Model.Game;

import NewGameStructure.Position;

public abstract class EntityModel {
    protected Position position;
    protected int lives; // Use lives instead of Health
    protected boolean isEnemy;

    protected int minX; // Left boundary
    protected int maxX; // Right boundary

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

    public void moveLeft() {
        Position currentPosition = getPosition();
        if (currentPosition.getX() > minX) {
            currentPosition.setX(currentPosition.getX() - 1);
        }
    }

    public void moveRight() {
        Position currentPosition = getPosition();
        if (currentPosition.getX() < maxX) {
            currentPosition.setX(currentPosition.getX() + 1);
        }
    }


    public boolean isEnemy() {
        return isEnemy;
    }

    // Other methods...
}
