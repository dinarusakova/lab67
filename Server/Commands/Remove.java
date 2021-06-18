package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Utility.DBworking;
import Utility.FlatCollection;

import java.net.Socket;

public class Remove  implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {

        int id;
        try {
            id = Integer.parseInt((String) o);
        }catch (Exception e){return "Указанный параметр не является целым числом";}
        DBworking.loadAllFlats();
        int size = FlatCollection.getSize();
        Flat flattoremove;
        try {
            flattoremove = FlatCollection.getCollection().stream().filter(x -> x.getId() == id).findFirst().get();
        }catch (Exception e){
            return "Квартира с id="+id+" не существует";
        }
        if (flattoremove!=null && flattoremove.getUser().equals(user)) FlatCollection.remove(id);
        int newSize = FlatCollection.getSize();
        if (newSize<size){
            DBworking.uploadAllFlats();
            return "Квартира с id="+id+" успешно удалена.";
        }
        else return "Квартира с id="+id+" не принадлежит вам.";
    }

    @Override
    public String getName() {
        return "remove";
    }
}

