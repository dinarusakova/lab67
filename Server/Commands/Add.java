package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.DBworking;
import Utility.FlatCollection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.net.Socket;

public class Add implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        DBworking.loadAllFlats();
        new ServerSender().send(socket, FlatCollection.generateId(),1);
        Flat flat = (Flat)new ServerReceiver().receive(socket);
        flat.setUser(user);
        FlatCollection.insert(flat);
        DBworking.uploadAllFlats();
        return "Квартира успешно добавлена в коллекцию.";
    }

    @Override
    public String getName() {
        return "add";
    }
}
