package Commands;

import FlatStuff.Flat;
import Stuff.Commandable;
import Utility.DBworking;
import Utility.FlatCollection;
import Utility.ServerReceiver;
import Utility.ServerSender;

import java.net.Socket;

public class Update implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {
        int id;
        DBworking.loadAllFlats();
        try {
            id = Integer.parseInt((String) o);
        } catch (Exception e) {
            return "Указанный параметр не является целым числом";
        }
        Flat flattoupdate;
        try {
            flattoupdate = FlatCollection.getCollection().stream().filter(x -> x.getId() == id).findFirst().get();
        }catch (Exception e){
            return "Квартира с id="+id+" не существует";
        }
        if (!flattoupdate.getUser().equals(user)) return "Квартира с id="+id+" не принадлежит вам";
        new ServerSender().send(socket, flattoupdate.getId(),1);
        Flat flat = (Flat)new ServerReceiver().receive(socket);
        flat.setUser(user);
        FlatCollection.update(flat);
        DBworking.uploadAllFlats();
        return "Квартира с id=" + id + " успешно обновлена.";
    }

    @Override
    public String getName() {
        return "update";
    }
}

