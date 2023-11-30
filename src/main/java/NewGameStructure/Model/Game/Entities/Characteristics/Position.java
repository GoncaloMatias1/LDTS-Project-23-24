package NewGameStructure.Model.Game.Entities.Characteristics;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    // Método para mover a posição. Pode ser adaptado para garantir que a posição não saia de um determinado limite.
    public void move(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    // Métodos adicionais como 'equals' e 'hashCode' podem ser sobrescritos se necessário.
    // ...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

