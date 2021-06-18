package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Stuff.Commandable;

import Utility.DBworking;
import Utility.FlatCollection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.net.Socket;

public class AddIfMax implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        DBworking.loadAllFlats();
        new ServerSender().send(socket, FlatCollection.generateId(),1);
        Flat newFlat = (Flat)new ServerReceiver().receive(socket);
        newFlat.setUser(user);
        Flat maxFlat = FlatCollection.getCollection().stream().max(Flat::compareTo).get();
        if (newFlat.compareTo(maxFlat) > 0) {
            FlatCollection.insert(newFlat);
            DBworking.uploadAllFlats();
            return "Цена квартиры больше чем у самой большой,добавлена в коллекцию.";
        }
        return
                "Цена квартиры меньше чем у самой большой,в коллекцию не добавлена." ;
    }

    @Override
    public String getName() {
        return "add_if_max";
    }
}

