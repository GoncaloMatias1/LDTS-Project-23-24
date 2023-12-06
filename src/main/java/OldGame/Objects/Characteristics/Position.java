package OldGame.Objects.Characteristics;

public class Position {
    private int x,y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public int getX() {return x;}
    public int getY() {return y;}

    public boolean equals(Object obj) {
        if (this == obj) return true;
        else if (obj == null) return false;
        else if (getClass() != obj.getClass()) return false;
        Position p = (Position) obj;
        return (x == p.getX() && y == p.getY());
    }
}


