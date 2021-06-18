package Utility;

import FlatStuff.Flat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class FlatCollection {
    private static LinkedList<Flat> collection;
    private static LocalDateTime dateCreation;


    public FlatCollection(LinkedList<Flat> collection) {
        setCollection(collection);
        setDateCreation(LocalDateTime.now());
        System.out.println("Коллекция создана.");
    }

    public static LinkedList<Flat> getCollection() {
        return collection;
    }

    public static void setCollection(LinkedList<Flat> collection) {
        FlatCollection.collection = collection;
    }

    public static LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public static void setDateCreation(LocalDateTime dateCreation) {
        FlatCollection.dateCreation = dateCreation;
    }

    public static void clear() {
        collection.clear();
    }

    public static void insert(Flat flat) {
        collection.add(flat);
    }

    public static void update( Flat flat) {
        LinkedList<Flat> set = new LinkedList<>();
        for (Flat flat1 : FlatCollection.getCollection()) {
            if (flat1.getId().intValue() != flat.getId().intValue()) set.add(flat1);
        }
        set.add(flat);
        collection = set;
    }

    public static boolean isKeyFree(Integer ind) {
        for (Flat flat1 : FlatCollection.getCollection())
            if (flat1.getId().intValue() == ind.intValue()) return false;
        return true;
    }

    public static int generateId(){
        for (int i= 1;i<getSize()+2;i++){
            if (isKeyFree(i)) return i;
        }
        return 0;
    }


    public static void remove(Integer id) {
        LinkedList<Flat> set = new LinkedList<>();
        for (Flat flat1 : FlatCollection.getCollection()) {
            if (flat1.getId().intValue() != id.intValue()) set.add(flat1);
        }
        collection = set;
    }

    public static int getSize() {
        return collection.size();
    }

    public static String getInfo() {
        return "Тип коллекции: LinkedList;\nKоличество элементов коллекции: " + getSize() +
                ";\nДата создания коллекции: " + getDateCreation() + ".";
    }
}
