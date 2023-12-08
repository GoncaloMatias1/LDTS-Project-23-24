package NewGameStructure.Model.Game.Entities.Characteristics;

public class Health {
    private int currentHealth;
    private int maxHealth;

    public Health(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // A saúde começa no máximo por padrão.
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0; // A saúde não deve ficar negativa.
        }
    }

    public void heal(int amount) {
        currentHealth += amount;
        if (currentHealth > maxHealth) {
            currentHealth = maxHealth; // A saúde não deve exceder a saúde máxima.
        }
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return currentHealth > 0;
    }
}
