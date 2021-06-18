package Utility;


import Commands.Help;
import Stuff.CommandWithoutArg;
import Stuff.Commandable;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Invoker {


    private static Map<String, Commandable> commands = new TreeMap<>();


    private static ArrayList<String> history = new ArrayList<>();


    public static ArrayList<String> getHistory() {
        return history;
    }

    public Commandable getCommand(String commandname) {
        return commands.get(commandname);
    }

    public void regist(Commandable... commands) {
        for (Commandable command : commands) {
            Invoker.commands.put(command.getName(), command);
        }
    }
    public void addToHistory(String commandName){
        if (!commandName.equals("history"))
            history.add(commandName);
    }

    public Map<Commandable, String> executeCommand(String commandName) {
        Map<Commandable, String> answer = new HashMap<>();
        String[] nameAndArgument = commandName.split(" ");
        if (!commandName.equals("")) {
            if (commands.get(nameAndArgument[0]) == null) {
                System.out.println("Такой команды не существует, введите \"help\", чтобы ознакомиться со всем перечнем команд.");
            } else if (commandName.equals("help")) {
                System.out.println(commands.get("help").execute(null,null,null));
                return null;
            } else if (commandName.equals("history")){
                System.out.println(commands.get("history").execute(null,null,null));
                return null;
            } else if (commandName.equals("exit")){
                System.out.println(commands.get("exit").execute(null,null,null));
                return null;
            }
            else {
                try {
                    CommandWithoutArg commandWithoutArg = (CommandWithoutArg) commands.get(nameAndArgument[0]);
                    try {
                        String s = nameAndArgument[1];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        return null;
                    } catch (Exception e) {
                        answer.put(commands.get(nameAndArgument[0]),"");
                        this.addToHistory(nameAndArgument[0]);
                    }
                } catch (Exception e) {
                    try {
                        String s = nameAndArgument[2];
                        System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                        return null;
                    } catch (IndexOutOfBoundsException e1) {
                        try {
                            answer.put(commands.get(nameAndArgument[0]),nameAndArgument[1]);
                            this.addToHistory(nameAndArgument[0]);
                            return answer;
                        } catch (IndexOutOfBoundsException e2) {
                            System.out.println("Неверный формат команды, введите \"help\", чтобы ознакомиться с форматами команд.");
                            return null;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
