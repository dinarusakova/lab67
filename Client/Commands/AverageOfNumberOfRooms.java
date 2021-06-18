package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.net.Socket;

public class AverageOfNumberOfRooms implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        double sum= FlatCollection.getCollection().stream().mapToLong(Flat::getNumberOfRooms).sum();
        double answer = sum / FlatCollection.getSize();
        return "Среднее количество комнат = "+ answer +".";
    }

    @Override
    public String getName() {
        return "average_of_number_of_rooms";
    }
}
