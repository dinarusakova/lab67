package Utility;

import FlatStuff.Flat;
import com.google.gson.Gson;

import java.io.*;
import java.util.LinkedList;

public class WriterToFile {
    static String filename;
    public static void writeLabToFile(LinkedList<Flat> flats) {
        Gson gson = new Gson();
        try {
            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(gson.toJson(flats).getBytes());
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}