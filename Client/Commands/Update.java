package Commands;

import Stuff.Commandable;
import Utility.FlatCollection;

import java.net.Socket;

public class Update implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {
        int id;
        try {
            id = Integer.parseInt((String) o);
        } catch (Exception e) {
            return "Указанный параметр не является целым числом";
        }
        if (FlatCollection.isKeyFree(id)) return "Квартиры с id=" + id + " не существует.";
        System.out.println("Квартира с указанным id найдена.");
        //FlatCollection.update(new CreateFlat().create(String.valueOf(id)));
        return "Квартира с id=" + id + " успешно обновлена.";
    }

    @Override
    public String getName() {
        return "update";
    }
}

