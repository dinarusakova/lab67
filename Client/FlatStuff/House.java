package FlatStuff;

import java.io.Serializable;

public class House implements Serializable {
    private String name; //Поле не может быть null
    private long year; //Значение поля должно быть больше 0


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return "\tНазвание дома: "+ this.getName()+ "\n\t\tГод постройки: "+this.getYear()+"\n";
    }
}
