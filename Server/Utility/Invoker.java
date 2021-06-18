package Utility;


import Stuff.CommandWithoutArg;
import Stuff.Commandable;

import java.io.FileNotFoundException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {


    private static Map<String, Commandable> commands = new TreeMap<>();

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    public void regist(Commandable... commands) {
        for (Commandable command : commands) {
            Invoker.commands.put(command.getName(), command);
        }
    }

    public String executeCommand(String commandName, Socket socket,String user) {
        String answer = "";
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                answer+= ("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        answer+= ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (Exception e) {
                        answer+= commands.get(nameAndArgument[0]).execute(null,socket,user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        String s = nameAndArgument[2];
                       answer+= ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            answer+= commands.get(nameAndArgument[0]).execute(nameAndArgument[1],socket,user);
                        } catch (IndexOutOfBoundsException e2) {
                            answer+= ("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        }
                    }
                }
            }
        }

        return answer;
    }
}
