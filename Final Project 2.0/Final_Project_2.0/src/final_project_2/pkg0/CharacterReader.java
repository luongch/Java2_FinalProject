/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: CharacterReader.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class CharacterReader {
    private File file;
    int uniqueID;
    /**
     * constructor that takes a file name
     * @param fileName: file to be read
     */
    public CharacterReader(String fileName) {
        file = new File(fileName);
        
    }

    //read data from file and create objects as it reads
    /**
     * reads a file and generates characters object that is then put into array list
     * @return an arraylist of characters
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ArrayList<Characters> getData() throws FileNotFoundException, IOException {
        int id = 0;
        String name = new String();
        String cclass = new String();
        String type = new String();
        int combo = 0;
        int hp = 0;
        int attack = 0;
        int rcv = 0;
        
        
        ArrayList<Characters> characterArray = new ArrayList(); //create ArrayList
        FileReader one = new FileReader(file); 
        BufferedReader buf = new BufferedReader (one); 
        String line = buf.readLine(); //send first line into a string
        
        while(line != null) { //while the line is not null
            //chop up the string and put the stats into the correct variable holders
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            id = Integer.parseInt(tokenizer.nextToken());
            uniqueID = id;
            name = tokenizer.nextToken();
            cclass = tokenizer.nextToken();
            type = tokenizer.nextToken();
            combo = Integer.parseInt(tokenizer.nextToken());
            hp = Integer.parseInt(tokenizer.nextToken());
            attack = Integer.parseInt(tokenizer.nextToken());
            rcv = Integer.parseInt(tokenizer.nextToken());
            Characters uniqueID = new Characters(id,name,cclass,type,combo,hp,attack,rcv); //create the character object
            characterArray.add(uniqueID); //send the character to the character ArrayList
            line = buf.readLine(); //move to the next line so it will read the next character
        }

        
        buf.close();
        one.close();
        return characterArray;
    }
    /**
     * create an observable list that will be used to view all characters in list view
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public ObservableList<String> fillObvList() throws FileNotFoundException, IOException{      
        ObservableList<String> obvListFull = FXCollections.observableArrayList();
        FileReader one = new FileReader(file); 
        BufferedReader buf = new BufferedReader (one); 
        String line = buf.readLine(); //send first line into a string
        
        while(line != null) { //while the line is not null
            //chop up the string and put a string to be displayed
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            String character = new String();
            character += tokenizer.nextToken() + ", ";
            character += "Name: " + tokenizer.nextToken() + ", ";
            character += "Class: " + tokenizer.nextToken() + ", ";
            character += "Type: " + tokenizer.nextToken() + ", ";
            character += "Combo: " + tokenizer.nextToken() + ", ";
            character += "HP: " + tokenizer.nextToken() + ", ";
            character += "ATK: " + tokenizer.nextToken() + ", ";
            character += "RCV: " + tokenizer.nextToken();
            character += "\n";

            obvListFull.add(character); //send the character to the obv list
            line = buf.readLine(); //move to the next line so it will read the next character
        }

        
        buf.close();
        one.close();
        return obvListFull;
    }
    
}
