package Commands;

import Stuff.CommandWithoutArg;
import Utility.Invoker;

import java.net.Socket;
import java.util.ArrayList;

public class History implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket,String user) {
        ArrayList<String> his = Invoker.getHistory();
        StringBuilder answer = new StringBuilder("Последние 7 команд:\n");
        if (his.size()<=7) his.forEach(x-> answer.append(x).append("\n"));
        else{
            for(int i=his.size()-1;i>=his.size()-7;i--){
                answer.append(his.get(i)+"\n");
            }
        }

        return answer.toString();
    }

    @Override
    public String getName() {
        return "history";
    }
}
