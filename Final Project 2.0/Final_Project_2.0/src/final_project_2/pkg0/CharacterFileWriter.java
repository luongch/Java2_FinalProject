/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: CharacterFileWriter.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class CharacterFileWriter {
    private File file;
    CharacterFileWriter(String fileName) {
        file = new File(fileName);
    }
    /**
     * writes the file using the data that is stored in the character array list
     * @param characterArray
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void writeCharacterFile(ArrayList<Characters> characterArray) throws FileNotFoundException, IOException{
        //go through the arraylist
        //get the data from the object
        //put into string id,name,class,type,combo,hp,attack,rcv
        //write the string to the file
        String character = new String();
        for (int sub = 0; sub < characterArray.size(); sub++) {
            character += characterArray.get(sub).getId() + ",";
            character += characterArray.get(sub).getName() + ",";
            character += characterArray.get(sub).getcClass() + ",";
            character += characterArray.get(sub).getType() + ",";
            character += characterArray.get(sub).getCombo() + ",";
            character += characterArray.get(sub).getHP() + ",";
            character += characterArray.get(sub).getAttack() + ",";
            character += characterArray.get(sub).getRCV();
            character += "\n";
        }
        
        FileWriter one = new FileWriter(file, false);
        BufferedWriter buf = new BufferedWriter(one);
        buf.write(character);
        buf.close();
        one.close();
        
    }
}
