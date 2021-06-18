package FlatStuff;

import java.io.Serializable;

public class Coordinates implements Serializable {
    private Long x; //Значение поля должно быть больше -161, Поле не может быть null
    private float y;

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    @Override
    public String toString(){
        return "["+x+";"+y+"]";
    }
}
