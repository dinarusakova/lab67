package Utility;


import FlatStuff.Coordinates;
import FlatStuff.Flat;
import FlatStuff.Furnish;
import FlatStuff.House;

import java.sql.*;
import java.util.List;

public class DBworking {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String password = "123456";

    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement preparedStatement;
    private static ResultSet rs;


    public static Boolean ConnectionToDB() throws SQLException {

        try {
            connection = DriverManager.getConnection(url, user, password);
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }

    public static Boolean userExist(String user, String password) throws SQLException {
        ConnectionToDB();
        try {
            preparedStatement = connection.prepareStatement("select *  from userdb d where exists( select * from userdb where d.login = ? and d.password= ?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return true;
            } else return false;
        } catch (SQLException e) {

        }
        return false;
    }


    public static Boolean addNewUser(String user, String password) throws SQLException {
        ConnectionToDB();
        try {
            preparedStatement = connection.prepareStatement("insert into userdb values (?,?)");
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
8
            return false;
        }
    }

    public static void uploadAllFlats()  {

        try {
            ConnectionToDB();
            stmt = connection.createStatement();
            stmt.execute("TRUNCATE flats");
            List<Flat> flats = FlatCollection.getCollection();
            flats.forEach(x -> {
                try {
                    preparedStatement = connection.prepareStatement("INSERT into flats values(?,?,?,?,?,?,?,?,?,?,?,?)");
                    preparedStatement.setInt(1, x.getId());
                    preparedStatement.setString(2, x.getName());
                    preparedStatement.setLong(3, x.getCoordinates().getX());
                    preparedStatement.setFloat(4, x.getCoordinates().getY());
                    preparedStatement.setTimestamp(5, x.getCreationDate());
                    preparedStatement.setDouble(6, x.getArea());
                    preparedStatement.setLong(7, x.getNumberOfRooms());
                    preparedStatement.setInt(8, x.getPrice());
                    preparedStatement.setString(9, x.getFurnish().toString());
                    preparedStatement.setString(10, x.getHouse().getName());
                    preparedStatement.setLong(11, x.getHouse().getYear());
                    preparedStatement.setString(12, x.getUser());
                    preparedStatement.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void loadAllFlats() {

        try {
            ConnectionToDB();
            FlatCollection.getCollection().clear();
            stmt = connection.createStatement();
            rs = stmt.executeQuery("select * from flats");
            while (rs.next()) {
                Flat flat = new Flat();
                flat.setId(rs.getInt(1));
                flat.setName(rs.getString(2));
                Coordinates coordinates = new Coordinates();
                coordinates.setX(rs.getLong(3));
                coordinates.setY(rs.getFloat(4));
                flat.setCoordinates(coordinates);
                flat.setCreationDate(rs.getTimestamp(5));
                flat.setArea(rs.getDouble(6));
                flat.setNumberOfRooms(rs.getLong(7));
                flat.setPrice(rs.getInt(8));
                flat.setFurnish(Furnish.valueOf(rs.getString(9)));
                House house = new House();
                house.setName(rs.getString(10));
                house.setYear(rs.getLong(11));
                flat.setHouse(house);
                flat.setUser(rs.getString(12));
                FlatCollection.getCollection().add(flat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}