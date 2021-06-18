package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;

import java.net.Socket;

public class Exit implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        System.out.println("Завершаю работу.");
        System.exit(0);
        return null;
    }

    @Override
    public String getName() {
        return "exit";
    }
}
