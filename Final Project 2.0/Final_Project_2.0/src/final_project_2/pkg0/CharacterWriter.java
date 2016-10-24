/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: CharacterWriter.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;



public class CharacterWriter {
    /**
     * constructor
     * 
     */
    public CharacterWriter() {
        
    }
    /**
     * add character to the array list by reading the textfields and drop down and then creating a character which is then added to the character array list
     * @param textFieldArrayList
     * @param characterArray
     * @param classDD
     * @param typeDD 
     */
    public void addCharacter(ArrayList<TextField> textFieldArrayList, ArrayList<Characters> characterArray, ComboBox<String> classDD, ComboBox<String> typeDD){        
        String newCharacter = new String(); //store stats to be used to make an object
        
        for (int sub = 0; sub < textFieldArrayList.size(); sub++) {
            if(sub == 1) { //if it is getting the name then we also need to get the drop down options before the other stats
                newCharacter += textFieldArrayList.get(sub).getText() + ",";
                newCharacter += classDD.getValue() + ",";
                newCharacter += typeDD.getValue() + ",";
            }
            else { //otherwise do this normally
                newCharacter += textFieldArrayList.get(sub).getText() + ",";
            }
            
        }
        Characters newCharacterObject = new Characters(); //create holder for a character
        newCharacterObject = characterCreater(newCharacter); //create a new character and put it into the holder
        
        
        characterArray.add(newCharacterObject); //add the character to the character array list
        
    }
    /**
     * remove the character
     * @param characterArray
     * @param index
     * @throws Exception if empty
     */
    public void removeCharacter(ArrayList<Characters> characterArray,int index) throws Exception {
        if(characterArray.isEmpty()) {
            throw new Exception("character array list is empty");
        }
        else {
            characterArray.remove(index);
        }
        
    }
    /**
     * change the data on the character at the current index
     * @param textFieldArrayList
     * @param characterArray
     * @param index
     * @param classDD
     * @param typeDD 
     */
    public void modifyCharacterV2(ArrayList<TextField> textFieldArrayList, ArrayList<Characters> characterArray, int index,ComboBox<String> classDD, ComboBox<String> typeDD) {
        characterArray.get(index).setID(Integer.parseInt(textFieldArrayList.get(0).getText()));
        characterArray.get(index).setName(textFieldArrayList.get(1).getText());
        characterArray.get(index).setClass(classDD.getValue());
        characterArray.get(index).setType(typeDD.getValue());
        characterArray.get(index).setCombo(Integer.parseInt(textFieldArrayList.get(2).getText()));
        characterArray.get(index).setHP(Integer.parseInt(textFieldArrayList.get(3).getText()));
        characterArray.get(index).setAttack(Integer.parseInt(textFieldArrayList.get(4).getText()));
        characterArray.get(index).setRCV(Integer.parseInt(textFieldArrayList.get(5).getText()));  
    }
    /**
     * reads a string an creates an object
     * @param newCharacter
     * @return a character object
     */
    private Characters characterCreater(String newCharacter) {
        //make new object: id,name,class,type,combo,hp,attack,rcv
        StringTokenizer tokenizer = new StringTokenizer(newCharacter, ",");
        Characters newCharacterObject = new Characters();
        newCharacterObject.setID(Integer.parseInt(tokenizer.nextToken()));
        newCharacterObject.setName(tokenizer.nextToken());
        newCharacterObject.setClass(tokenizer.nextToken());
        newCharacterObject.setType(tokenizer.nextToken());
        newCharacterObject.setCombo(Integer.parseInt(tokenizer.nextToken()));
        newCharacterObject.setHP(Integer.parseInt(tokenizer.nextToken()));
        newCharacterObject.setAttack(Integer.parseInt(tokenizer.nextToken()));
        newCharacterObject.setRCV(Integer.parseInt(tokenizer.nextToken()));
        return newCharacterObject;
    }
}
