package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.Entities.*;
import NewGameStructure.Position;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int width;
    private int height;
    private PlayerShip playerShip;
    private List<Projectile> projectiles = new ArrayList<>();
    private List<Projectile> enemyProjectiles = new ArrayList<>();
    private List<Shield> shields = new ArrayList<>();
    private EnemyWave enemyWave = new EnemyWave();

    public ArenaModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.playerShip = new PlayerShip(width / 2, height - 3, width, 3); // 3 for initial lives
        initializeShields(width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayerShip getPlayerShip() {
        return playerShip;
    }

    public void movePlayerShipLeft() {
        playerShip.moveLeft();
    }

    public void movePlayerShipRight() {
        playerShip.moveRight();
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public void playerShoot() {
        projectiles.add(playerShip.shoot());
    }
    public void enemyShoot(){
        enemyProjectiles.add(enemyWave.randomShot());
    }

    private void initializeShields(int width, int height) {
        int shieldSpacing = width / 6; // Example spacing value
        int shieldY = height - 10; // Example Y position, adjust as needed
        for (int i = 0; i < 5; i++) {
            shields.add(new Shield(new Position(10 + i * shieldSpacing + shieldSpacing / 2, shieldY)));
        }
    }

    public List<Shield> getShields() {
        return shields;
    }

    public List<Projectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    // Method to handle player's life loss
    public void playerHit() {
        this.playerShip.loseLife();
        if (this.playerShip.getLives() <= 0) {
            // Handle game over
        }
    }
    public EnemyWave getEnemyWave(){
        return enemyWave;
    }
    public void removeProjectiles(List<Projectile> ProjectilesRemove){
        for (Projectile projectile : ProjectilesRemove){
            projectiles.remove(projectile);
        }
    }
    public void removeEnemyProjectiles(List<Projectile> ProjectilesRemove){
        for (Projectile projectile : ProjectilesRemove){
            enemyProjectiles.remove(projectile);
        }
    }


    public void updateKills() {
        List<Enemy> EnemiesRemove = new ArrayList<>();
        List<Projectile> ProjectilesRemove  = new ArrayList<>();

        for (Projectile projectile : projectiles) {
            projectile.update(); // Move the projectile
            if (projectile.getPosition().getY() == 0){
                ProjectilesRemove.add(projectile);
                break;
            }
            for (Enemy enemy : enemyWave.getEnemies()) {
                if (projectile.checkCollision(enemy)) {
                    enemy.hit();
                    EnemiesRemove.add(enemy);
                    ProjectilesRemove.add(projectile);
                    break;
                }
            }
        }
        enemyWave.removeEnemies(EnemiesRemove);
        removeProjectiles(ProjectilesRemove);
    }

    public void updatePlayerHit(){
        List<Projectile> ProjectilesRemove = new ArrayList<>();

        for (Projectile projectile : enemyProjectiles){
            projectile.updateEnemyBullet();
            if(projectile.getPosition().getY() == height - 1){
                ProjectilesRemove.add(projectile);
                break;
            }
            if(projectile.checkPlayerCollision(playerShip)){
                playerHit();
                ProjectilesRemove.add(projectile);
                break;
            }
        }
        removeEnemyProjectiles(ProjectilesRemove);
    }
}
