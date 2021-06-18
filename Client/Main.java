import Commands.*;
import Stuff.Commandable;
import Utility.*;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean flag = true;
        Scanner in = new Scanner(System.in);
        ClientSender clientSender = null;
        while(!ClientSender.serverisconnected) {
            try {
                System.out.print("Введите хост сервера\n~ ");
                ClientSender.host = in.nextLine();
                System.out.print("Введите порт сервера\n~ ");
                ClientSender.port = Integer.parseInt(in.nextLine());
                ClientSender.tryToConnect();
            } catch (Exception e) {
                System.out.println("Введены некорректные данные");
            }
        }

        Invoker invoker = new Invoker();
        invoker.regist( new Add(),new Help(),new Show(),new SumOfPrice(),new AverageOfNumberOfRooms(),
                        new AddIfMax(),new AddIfMin(),new Exit(),new Info(),new Remove(),
                        new Update(),new PrintDescending(),new ExecuteScript(),new History(),new Clear());
        ClientReceiver.receive();
        while (true) {
            try{
                while (ClientSender.serverisconnected) {
                    System.out.println("Введите команду для отправки на сервер: ");
                    System.out.print("~ ");
                    String s = in.nextLine();
                    Map<Commandable, String> commandparamMap = invoker.executeCommand(s);

                    if (commandparamMap != null && ClientSender.serverisconnected) {
                        ClientSender.send(commandparamMap);
                        System.out.println(ClientReceiver.receive());
                    }
                }
                ClientSender.tryToConnect();
            } catch (Exception e){
                e.printStackTrace();
                System.out.println("Произошла ошибка,попробуйте ещё раз");
            }
        }
    }
}
