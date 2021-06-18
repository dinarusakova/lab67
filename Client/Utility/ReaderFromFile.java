package Utility;

import java.io.*;
import java.util.Scanner;

public class ReaderFromFile {

    public static String read(String filename) throws Exception {
            String data = "";
            File file = new File(filename);
            byte[] buff = new byte[1024];
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            int bytes;
            while ((bytes = bufferedInputStream.read(buff)) != -1) {
                data += new String(buff, 0, bytes);
            }
            return data;
    }
}
