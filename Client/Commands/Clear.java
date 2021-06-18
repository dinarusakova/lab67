package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.io.FileNotFoundException;
import java.net.Socket;

public class Clear implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user)  {
        if (FlatCollection.getSize()==0) return "Коллекция уже пуста.";
        FlatCollection.clear();
        return "Коллекция очищена!";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
