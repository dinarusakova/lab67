package Utility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.concurrent.*;

public class ServerReceiver {
   ForkJoinPool forkJoinPool = new ForkJoinPool();
    public Object receive(Socket client) {
        Receiver receiver = new Receiver(client);
        Future future =forkJoinPool.submit(receiver);
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public class Receiver implements Callable {
        Socket client = null;

        public Receiver(Socket socket) {
            this.client = socket;
        }

        @Override
        public Object call() throws Exception {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
                return objectInputStream.readObject();
            } catch (ClassNotFoundException | IOException e) {
                return null;
            }
        }
    }
}