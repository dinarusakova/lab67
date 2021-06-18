import Utility.NewClient;
import Utility.Server;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) throws IOException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Server.create();
        while (!Server.server.isClosed()) {
            Socket socket = Server.server.accept();
            forkJoinPool.execute(new NewClient(socket));
            System.out.println("Новый клиент с адресом " + socket.getLocalAddress() + socket.getPort());
        }
    }
}
