package Commands;

import Stuff.CommandWithoutArg;

import java.io.FileNotFoundException;
import java.net.Socket;

public class Help implements CommandWithoutArg {
    @Override
    public String execute(Object o, Socket socket, String user) {
        return "\nhelp : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\n" +
                "history : вывести последние 7 команд (без их аргументов)\n" +
                "sum_of_price : вывести сумму значений поля price для всех элементов коллекции\n" +
                "average_of_number_of_rooms : вывести среднее значение поля numberOfRooms для всех элементов коллекции\n" +
                "print_descending : вывести элементы коллекции в порядке убывания\n";
    }

    @Override
    public String getName() {
        return "help";
    }
}
