package Stuff;


import java.io.FileNotFoundException;
import java.io.Serializable;
import java.net.Socket;

public interface Commandable extends Serializable {
    public String execute(Object o, Socket socket,String user);
    public String getName();
}