package Commands;

import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.net.Socket;

public class Info  implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        return FlatCollection.getInfo();
    }

    @Override
    public String getName() {
        return "info";
    }
}
