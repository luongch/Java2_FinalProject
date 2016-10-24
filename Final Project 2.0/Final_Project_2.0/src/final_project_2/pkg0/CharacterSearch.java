/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: CharacterSearch.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class CharacterSearch {
    private ObservableList<String> obvList = FXCollections.observableArrayList();//used to hold strings for use in list view
    private Button test = new Button();
    /** 
     * searching character list for ID searched
     * @param tSearch is ID being searched
     * @param characterArray
     * @return obv list containing all matches(should only have 1 match)
     * @throws Exception if empty or not a number
     */
    public ObservableList<String> searchID(TextField tSearch, ArrayList<Characters> characterArray) throws Exception{    
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            if(isInt(tSearch.getText())) { //if it is an int
                int searchNumValue = Integer.parseInt(tSearch.getText()); //set id searched
                
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array looking for id
                    
                    if(searchNumValue == characterArray.get(sub).getId() ) { //if it finds a matching id return true
                        obvList.add(characterToString(characterArray,sub)); //add to the list
                    }
                }             
            }
            else { //if it is not a number
                throw new Exception("Please input a number");
            }   
        }
        return obvList; //return obv list so we can generate list view
    }
    /**
     * search character list for names that match
     * @param tSearch is the name being searched for
     * @param characterArray 
     * @return obv list containing all matches
     * @throws Exception 
     */
    public ObservableList<String> searchName(TextField tSearch, ArrayList<Characters> characterArray) throws Exception {
        System.out.println("name search");
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else { //if not empty
            String searchValue = tSearch.getText().toLowerCase(); //set the name searched   
            for(int sub = 0; sub < characterArray.size(); sub++) { //loop through the character array looking for the name
                
                if(searchValue.matches(characterArray.get(sub).getName().toLowerCase()) ) { //if name matches
                    obvList.add(characterToString(characterArray,sub)); //add to the obv list
                     
                }
            }
        }
        return obvList; //return obv list so we can generate list view

    }
    /**
     * checkings characters data with matching class
     * @param tSearch value searched
     * @param characterArray
     * @return obv list containing all the matches
     * @throws Exception if empty 
     */
    public ObservableList<String> searchClass(TextField tSearch, ArrayList<Characters> characterArray) throws Exception{
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            String searchValue = tSearch.getText().toLowerCase(); //set the class searched
            for(int sub = 0; sub < characterArray.size(); sub++) { //loop through the array looking for the class searched
                if(searchValue.matches(characterArray.get(sub).getcClass().toLowerCase()) ) { //if a match is found
                    obvList.add(characterToString(characterArray,sub)); //send the string to the obv list
                }
            }
            
        }
        return obvList;//send back to generate list view
    }
    /**
     * searching character array list for matching type values
     * @param tSearch is type searched
     * @param characterArray
     * @return obv list containing all matching types
     * @throws Exception 
     */
    public ObservableList<String> searchType(TextField tSearch, ArrayList<Characters> characterArray) throws Exception {
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            String searchValue = tSearch.getText().toLowerCase(); //set the type searched
            for(int sub = 0; sub < characterArray.size(); sub++) { //loop through characer array for type searched
                if(searchValue.matches(characterArray.get(sub).getType().toLowerCase()) ) { //if found
                    obvList.add(characterToString(characterArray,sub)); //add to obv list
                }
            }
        }
        return obvList;
    }
    /**
     * searching character array list for combo values searched
     * @param tSearch is the value searched
     * @param characterArray
     * @return obv list containing all matches found
     * @throws Exception : if empty or not a number
     */
    public ObservableList<String> searchCombo(TextField tSearch, ArrayList<Characters> characterArray) throws Exception {
        
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            if(isInt(tSearch.getText())) { //if it is an int
                int searchNumValue = Integer.parseInt(tSearch.getText()); //set combo searched
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array looking for combos
                    
                    if(searchNumValue == characterArray.get(sub).getCombo() ) { //if it finds a matching combo return true
                        obvList.add(characterToString(characterArray,sub)); //send to obv list
                    }
                }             
            }
            else { //if it is not a number
                throw new Exception("Please input a number");
            }   
        }
        return obvList; //return obv list to be used to generate list view
    }
    /**
     * checking character array for matched HP searches
     * @param tSearch: value searched
     * @param characterArray
     * @return: returns obv list containing all matches
     * @throws Exception: empty or not a number
     */
    public ObservableList<String> searchHP(TextField tSearch, ArrayList<Characters> characterArray) throws Exception{
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            if(isInt(tSearch.getText())) { //if it is an int
                int searchNumValue = Integer.parseInt(tSearch.getText()); //set HP searched
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array looking for HP
                    
                    if(searchNumValue == characterArray.get(sub).getHP() ) { //if it finds a matching HP return true
                        obvList.add(characterToString(characterArray,sub)); //send to obv list
                    }
                }             
            }
            else { //if it is not a number
                throw new Exception("Please input a number");
            }   
        }
        return obvList; //return obv list for later use
    }
    /**
     * searching character array list for matching searched ATK value
     * @param tSearch: value searched
     * @param characterArray 
     * @return: obv list containing matches
     * @throws Exception : empty or not a number
     */
    public ObservableList<String> searchATK(TextField tSearch, ArrayList<Characters> characterArray) throws Exception{
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            if(isInt(tSearch.getText())) { //if it is an int
                int searchNumValue = Integer.parseInt(tSearch.getText()); //set ATK searched
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array looking for ATK
                    
                    if(searchNumValue == characterArray.get(sub).getAttack() ) { //if it finds a matching ATK return true
                        obvList.add(characterToString(characterArray,sub)); //send to obv list
                    }
                }             
            }
            else { //if it is not a number
                throw new Exception("Please input a number");
            }   
        }
        return obvList; //return obv list for use in list view
    }
    /**
     * searching RCV searched in RCV stored for matches
     * @param tSearch
     * @param characterArray
     * @return an obv list which is later used to generate list view
     * @throws Exception: no input or if not a number
     */
    public ObservableList<String> searchRCV(TextField tSearch, ArrayList<Characters> characterArray) throws Exception{
        if(tSearch.getText() == null || tSearch.getText().isEmpty()) { //if empty
            throw new Exception("You must input something into the search bar");
        }
        else {
            if(isInt(tSearch.getText())) { //if it is an int
                int searchNumValue = Integer.parseInt(tSearch.getText()); //set RCV searched
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array looking for ATK
                    
                    if(searchNumValue == characterArray.get(sub).getRCV() ) { //if it finds a matching ATK return true
                    obvList.add(characterToString(characterArray,sub)); //add string to obv list
                    
                    }
                }             
            }
            else { //if it is not a number
                throw new Exception("Please input a number");
            }   
        }
        return obvList;
    }
    /**
     * checking if string is an int
     * @param s, string we are checking
     * @return true or false
     */
    private boolean isInt(String s){ //checks if the string is an integer
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * converts the character at a certain index to a string
     * @param characterArray is where the data is coming from
     * @param sub, the index at which we get the data from
     * @return a string for use in obv list
     */
    private String characterToString(ArrayList<Characters> characterArray, int sub) {
        String character = new String();
        character += characterArray.get(sub).getId() + ", ";
        character += "Name: " + characterArray.get(sub).getName() + ", ";
        character += "Class: " + characterArray.get(sub).getcClass() + ", ";
        character += "Type: " + characterArray.get(sub).getType() + ", ";
        character += "Combo: " + characterArray.get(sub).getCombo() + ", ";
        character += "HP: " + characterArray.get(sub).getHP() + ", ";
        character += "ATK: " + characterArray.get(sub).getAttack() + ", ";
        character += "RCV: " + characterArray.get(sub).getRCV();
        character += "\n";
        return character;
    }
}
