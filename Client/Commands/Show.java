package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.io.FileNotFoundException;
import java.net.Socket;

public class Show implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        String ans = "";
        for (Flat flat : FlatCollection.getCollection()) {
            ans+=(flat);
        }
        return ans;
    }

    @Override
    public String getName() {
        return "show";
    }
}
