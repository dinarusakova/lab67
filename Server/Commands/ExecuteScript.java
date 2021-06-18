package Commands;

import Stuff.CommandWithoutArg;
import Stuff.Commandable;
import Utility.Invoker;
import Utility.ReaderFromFile;

import java.net.Socket;
import java.util.Scanner;

public class ExecuteScript  implements Commandable {
    @Override
    public String execute(Object o, Socket socket, String user) {
        StringBuilder answer = new StringBuilder();
        try {
            Invoker invoker = new Invoker();
            String filePath = (String) o;
            String data = ReaderFromFile.read(filePath);
            String[] commands = data.split("\r\n");
            for (String command : commands) {
                String[] temp = command.split(" ");
                if (temp[0].equals("execute_script"))
                    answer.append("\nОбнаружена возможная рекурсия. Уберите из файла команду \"execute_script\"\n");
                else {
                    answer.append("\nКоманда: \"" + command + "\":\n");
                    answer.append(invoker.executeCommand(command,socket,user));
                }
            }
        } catch (Exception e) {
            return ("Программа не может найти такой файл");

        }
        return answer.toString();
    }
    @Override
    public String getName() {
        return "execute_script";
    }
}

