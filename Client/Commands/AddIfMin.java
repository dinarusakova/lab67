package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.net.Socket;

public class AddIfMin implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        Flat newFlat = null;//new CreateFlat().create("free");
        Flat minFlat = FlatCollection.getCollection().stream().min(Flat::compareTo).get();
        if (newFlat.compareTo(minFlat) < 0) {
            FlatCollection.insert(newFlat);
            return "Цена квартиры меньше чем у самой маленькой,добавлена в коллекцию.";
        }
        return
                "Цена квартиры больше чем у самой маленькой,в коллекцию не добавлена.";
    }

    @Override
    public String getName() {
        return "add_if_min";
    }
}

