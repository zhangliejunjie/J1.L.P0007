package data;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileDAO {
    public static void writeTextFile(String fileName, ArrayList<Phone> data) throws FileNotFoundException {
        PrintWriter w = new PrintWriter(fileName);
        for (Phone d : data) {
            w.println(d);
        }
        w.close();
    }
    //cuối file văn bản có byte đặc biệt gọi là EOF
    public static ArrayList<Phone> readTextFile(String fileName) throws FileNotFoundException, IOException {
        FileReader f = new FileReader(fileName);
        BufferedReader bf = new BufferedReader(f);
        ArrayList<Phone> list = new ArrayList<>();
        while (bf.ready()) { //con chốt chặn EOF            
            String s = bf.readLine();
            String[] tmp = s.split(",");
            if (tmp.length == 7) {
                Phone d = new Phone(tmp[0], Integer.parseInt(tmp[1]), 
                        Integer.parseInt(tmp[2]), Double.parseDouble(tmp[3]), Double.parseDouble(tmp[4]), tmp[5], tmp[6]);                
                list.add(d);
            }
        }
        return list;
    } 
}
