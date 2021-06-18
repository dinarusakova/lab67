package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.io.FileNotFoundException;
import java.net.Socket;

public class SumOfPrice implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user)  {
        Double sum = FlatCollection.getCollection().stream().mapToDouble(Flat::getPrice).sum();
        return "Суммарная стоимость квартир в коллекции = "+sum.toString()+".";
    }

    @Override
    public String getName() {
        return "sum_of_price";
    }
}
