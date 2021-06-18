package Utility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Scanner;

public class ClientReceiver {
    ClientSender clientSender;

    /**
     * The constant client.
     */
    public  static Socket sock;
    private static ByteBuffer buffer = ByteBuffer.allocate(10000);
    public static Object receive() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(sock.getInputStream());
        Object obj = objectInputStream.readObject();
        CreateFlat createFlat = new CreateFlat();
        Map<Object,Integer> answerMap = (Map<Object, Integer>) obj;
        obj = answerMap.entrySet().iterator().next().getKey();
        int a = answerMap.entrySet().iterator().next().getValue();
        if (a == 0) {
            return obj;
        }
        // новая квартира
        else if (a == 1){
            System.out.println("Необходимо заполнить доп.данные для выполнения команды");
            ClientSender.send(createFlat.create(obj));
            obj =receive();
        }
        //заполнить поля необходимые
        else if (a==3){
            System.out.println("Ответ с сервера: "+obj);
            System.out.print("~");
            Scanner reader = new Scanner(System.in);
            String s = reader.nextLine();
            ClientSender.send(s);
            ClientReceiver.receive();

        }

        return obj;
    }
}
