package NewGameStructure.States.Menu;

import NewGameStructure.Application;
import NewGameStructure.Controller.Controller;
import NewGameStructure.Controller.Menu.ArenaController;
import NewGameStructure.GUI;
import NewGameStructure.Model.Game.Entities.Enemy;
import NewGameStructure.Model.Game.Entities.Projectile;
import NewGameStructure.Model.Menu.ArenaModel;
import NewGameStructure.States.State;
import NewGameStructure.View.Menu.ArenaView;
import NewGameStructure.View.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArenaState extends State<ArenaModel> {
    private List<Projectile> projectiles = new ArrayList<>();
    private List<Enemy> enemies = new ArrayList<>();

    public ArenaState(ArenaModel arenaModel) {
        super(arenaModel);
        // Initialize your enemies here or whenever a new level starts
        // Example: enemies.add(new Enemy(startX, startY, initialLives));
    }

    @Override
    protected View<ArenaModel> getView() {
        return new ArenaView(getModel());
    }

    @Override
    protected Controller<ArenaModel> getController() {
        return new ArenaController(getModel());
    }

    public void updateGame() {
        // Update projectiles
        for (Projectile projectile : projectiles) {
            projectile.update();
        }

        // Check for collisions
        Iterator<Projectile> projectileIterator = projectiles.iterator();
        while (projectileIterator.hasNext()) {
            Projectile projectile = projectileIterator.next();
            Iterator<Enemy> enemyIterator = enemies.iterator();
            while (enemyIterator.hasNext()) {
                Enemy enemy = enemyIterator.next();
                if (projectile.checkCollision(enemy)) {
                    enemy.hit();
                    projectileIterator.remove();
                    if (!enemy.isAlive()) {
                        enemyIterator.remove();
                    }
                    break; // Assuming one projectile can only hit one enemy
                }
            }
        }
        // Additional game update logic (moving enemies, spawning new enemies/projectiles, etc.)
    }

    // Call this method to add a projectile to the game
    public void fireProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    // Call this method to add an enemy to the game
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
    }

    @Override
    public void step(Application app, GUI gui) throws IOException {
        updateGame(); // Update game entities and check for collisions
        super.step(app, gui); // Continue with existing code to draw the view and handle control
    }
}
