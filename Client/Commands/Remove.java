package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Utility.FlatCollection;

import java.net.Socket;

public class Remove  implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {
        int id;
        try {
            id = Integer.parseInt((String) o);
        }catch (Exception e){return "Указанный параметр не является целым числом";}
        int size = FlatCollection.getSize();
        FlatCollection.remove(id);
        int newSize = FlatCollection.getSize();
        if (newSize<size) return "Квартира с id="+id+" успешно удалена.";
        else return "Квартира с id="+id+" не существует.";
    }

    @Override
    public String getName() {
        return "remove";
    }
}

