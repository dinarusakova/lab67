package Commands;

import FlatStuff.Flat;
import Stuff.CommandWithoutArg;
import Utility.FlatCollection;

import java.net.Socket;
import java.util.LinkedList;

public class PrintDescending implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        if(FlatCollection.getSize()==0) return "Коллекция пуста,выводить нечего.";
        LinkedList<Flat> array= new LinkedList<>(FlatCollection.getCollection());
        String ans="Квартиры в порядке убывания по цене:\n";
        for (int i=0;i< FlatCollection.getSize();i++){
            Flat flat = array.stream().max(Flat::compareTo).get();
            ans+=flat.toString()+"\n";
            array.remove(flat);
        }
        return ans;
    }

    @Override
    public String getName() {
        return "print_descending";
    }
}
