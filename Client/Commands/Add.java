package Commands;

import Stuff.CommandWithoutArg;

import java.net.Socket;

public class Add implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        //FlatCollection.insert(new CreateFlat().create("free"));
        return "Квартира успешно добавлена в коллекцию.";
    }

    @Override
    public String getName() {
        return "add";
    }
}
