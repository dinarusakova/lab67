package FlatStuff;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Flat implements Comparable, Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Timestamp creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private double area; //Максимальное значение поля: 843, Значение поля должно быть больше 0
    private Long numberOfRooms; //Поле не может быть null, Значение поля должно быть больше 0
    private Integer price; //Максимальное значение поля: 1819374195, Значение поля должно быть больше 0
    private Furnish furnish; //Поле может быть null
    private House house; //Поле может быть null
    private String user;

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Long numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    public Furnish getFurnish() {
        return furnish;
    }

    public void setFurnish(Furnish furnish) {
        this.furnish = furnish;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    @Override
    public String toString() {
        return "\nКвартира ID: " + this.id +
                "\n\tНазвание квартиры: " + this.name +
                "\n\tКоординаты: " + this.coordinates +
                "\n\tДата создания: " + this.creationDate +
                "\n\tПлощадь квартиры: " + this.area +
                "\n\tКоличество комнат: " + this.numberOfRooms +
                "\n\tЦена квартиры: " + this.price +
                "\n\tОтделка: " + this.furnish +
                "\n\tДом:\n\t" + this.house+
                "\tВладелец:\n\t" + this.user;
    }

    @Override
    public int compareTo(Object o) {
        return this.getPrice() - ((Flat) o).getPrice();
    }
}
