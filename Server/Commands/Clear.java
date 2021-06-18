package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.DBworking;
import Utility.FlatCollection;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Clear implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user)  {
        DBworking.loadAllFlats();
        if (FlatCollection.getSize()==0) return "Коллекция уже пуста.";
        LinkedList<Flat> newFlats = new LinkedList<>();
        FlatCollection.getCollection().stream().filter(x->!x.getUser().equals(user)).forEach(newFlats::add);
        FlatCollection.setCollection(newFlats);
        DBworking.uploadAllFlats();
        return "Из коллекции удалены все ваши элементы.";
    }

    @Override
    public String getName() {
        return "clear";
    }
}
