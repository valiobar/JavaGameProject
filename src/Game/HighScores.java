package Game;

import java.io.*;
import java.util.*;

/**
 * Created by vb on 18.4.2016 г..
 */
public class HighScores {
    private static TreeMap<Integer, String> highScores;

    public HighScores() {
        highScores=new TreeMap<>();
    }

    public static void save(Integer scores, String name) {
        if (!highScores.containsKey(scores)) {
            highScores.put(scores, name);
            if (highScores.keySet().size() > 10) {
                highScores.remove(Arrays.asList(highScores.keySet().toArray()).get(11));
            }
        }

        try (ObjectOutputStream fos = new ObjectOutputStream(new FileOutputStream("HighScores.save", false))) {
            fos.writeObject(highScores);
        } catch (IOException ex) {
            System.out.print(ex);
        }
    }
    public static  ArrayList<String> output(){
       readHighScores();
        ArrayList<String> output = new ArrayList<>();

        for (Map.Entry<Integer, String> entry : highScores.entrySet()) {
        output.add(String.format("Name: %s  Scores:%d ",entry.getValue(),entry.getKey()));

        }
        Collections.reverse(output);
        return output;
    }
private static void readHighScores(){
    try(ObjectInputStream ois =new ObjectInputStream(new FileInputStream("HighScores.save"))){
        highScores=(TreeMap<Integer, String>) ois.readObject();

    }
    catch (IOException ex){
        System.out.print(ex);
    }
    catch (ClassNotFoundException cnfex){
        System.out.print(cnfex);
    }
}
}

