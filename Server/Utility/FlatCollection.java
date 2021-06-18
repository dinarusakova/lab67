package Utility;

import FlatStuff.Flat;

import java.util.LinkedList;

public class FlatCollection {
    private static LinkedList<Flat> collection;

    public FlatCollection() {
        collection = new LinkedList<>();
    }

    synchronized public static LinkedList<Flat> getCollection() {
        return collection;
    }

    synchronized public static void setCollection(LinkedList<Flat> collection) {
        FlatCollection.collection = collection;
    }

    synchronized public static void clear() {
        collection.clear();
    }

    synchronized public static void insert(Flat flat) {
        collection.add(flat);
    }

    synchronized public static void update(Flat flat) {
        LinkedList<Flat> set = new LinkedList<>();
        for (Flat flat1 : FlatCollection.getCollection()) {
            if (flat1.getId().intValue() != flat.getId().intValue()) set.add(flat1);
        }
        set.add(flat);
        collection = set;
    }

    synchronized  public static boolean isKeyFree(Integer ind) {
        for (Flat flat1 : FlatCollection.getCollection())
            if (flat1.getId().intValue() == ind.intValue()) return false;
        return true;
    }

    synchronized public static int generateId() {
        for (int i = 1; i < getSize() + 2; i++) {
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
        return "Тип коллекции: LinkedList;\nKоличество элементов коллекции: " + getSize() + " .";
    }
}
