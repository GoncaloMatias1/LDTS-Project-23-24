package NewGameStructure.Model.Menu;

import NewGameStructure.Model.Game.EnemyWave;
import NewGameStructure.Model.Game.Entities.*;
import NewGameStructure.Model.Game.Projectile;
import NewGameStructure.Position;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel {
    private int width;
    private int height;
    private PlayerShip playerShip;

    private int score;
    private List<Projectile> projectiles = new ArrayList<>();
    private List<Projectile> enemyProjectiles = new ArrayList<>();
    private List<Shield> shields = new ArrayList<>();
    private EnemyWave enemyWave = new EnemyWave();

    public ArenaModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.playerShip = new PlayerShip(width / 2, height - 3, width, 3);
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

    public void initializeShields(int width, int height) {
        shields.clear();
        int shieldSpacing = width / 6;
        int shieldY = height - 7;
        for (int i = 0; i < 5; i++) {
            for (int j = -1; j<2; j++) {
                shields.add(new Shield(new Position((10 + i * shieldSpacing + shieldSpacing / 2) + j, shieldY)));
            }
        }
    }

    public void increaseScore(int points) {
        this.score += points;
    }

    // Getter for the score
    public int getScore() {
        return this.score;
    }

    public List<Shield> getShields() {
        return shields;
    }

    public List<Projectile> getEnemyProjectiles() {
        return enemyProjectiles;
    }

    public void playerHit() {
        this.playerShip.loseLife();
        if (this.playerShip.getLives() <= 0) {
            // Handle game over
        }
    }
    public EnemyWave getEnemyWave(){
        return enemyWave;
    }

    public List<Enemy> updateKills() {
        List<Enemy> enemiesToRemove = new ArrayList<>();
        List<Projectile> projectilesToRemove = new ArrayList<>();
        List<Shield> ShieldRemove = new ArrayList<>();

        for (Projectile projectile : projectiles) {
            projectile.update(); // Move the projectile
            if (projectile.getPosition().getY() == 0) {
                projectilesToRemove.add(projectile);
                continue;
            }
            for (Enemy enemy : enemyWave.getEnemies()) {
                if (projectile.checkCollision(enemy)) {
                    enemy.hit();
                    projectilesToRemove.add(projectile);
                    if (!enemy.isAlive()) {
                        enemiesToRemove.add(enemy);
                        increaseScore(enemy.getPointsAward() -1);
                    }
                    break;
                }
            }
            for(Shield shield: shields){
                if(projectile.getPosition().equals(shield.getPosition())){
                    shield.takeDamage();
                    projectilesToRemove.add(projectile);
                    if(!shield.isAlive()){
                        ShieldRemove.add(shield);
                    }
                    break;
                }
            }
        }

        projectiles.removeAll(projectilesToRemove);
        enemyWave.getEnemies().removeAll(enemiesToRemove);
        shields.removeAll(ShieldRemove);
        return enemiesToRemove;
    }

    public void updatePlayerHit(){
        List<Projectile> ProjectilesRemove = new ArrayList<>();
        List<Shield> ShieldRemove = new ArrayList<>();

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
            for(Shield shield: shields){
                if(shield.getPosition().equals(projectile.getPosition())){
                    shield.takeDamage();
                    ProjectilesRemove.add(projectile);
                    if(!shield.isAlive()){
                        ShieldRemove.add(shield);
                    }
                    break;
                }
            }
        }
        enemyProjectiles.removeAll(ProjectilesRemove);
        shields.removeAll(ShieldRemove);
    }

    public void setEnemyWave(EnemyWave enemyWave) {
        this.enemyWave = enemyWave;
    }
}
