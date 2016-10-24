/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: Validations.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.util.ArrayList;
import javafx.scene.control.ComboBox;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Validations {
    /**
     * check to see if the character list is empty
     * @param characterArray
     * @param textFieldArrayList
     * @return
     * @throws Exception if chararacter array list is empty
     */
    public boolean checkEmpty(ArrayList<Characters> characterArray, ArrayList<TextField> textFieldArrayList) throws Exception {
        boolean emptyFlag = false;
        if(characterArray.isEmpty()) { //if it is empty
            emptyFlag = true;
            for(int sub = 0; sub<textFieldArrayList.size(); sub++) { //loop through the textfield and set all to null for visual aethetic
                textFieldArrayList.get(sub).setText(null);
            }
            throw new Exception("There are no characters in the database!");
        }
        return emptyFlag;
    }
    /**
     * validations before you can remove a character
     * @param textFieldArrayList
     * @param characterArray
     * @param index
     * @param labelArray
     * @param classDD
     * @param typeDD
     * @return
     * @throws Exception 
     */
    public boolean validateRemove(ArrayList<TextField> textFieldArrayList, ArrayList<Characters> characterArray, int index, ArrayList<Label> labelArray, ComboBox<String> classDD, ComboBox<String> typeDD) throws Exception{
        boolean removeFlag = false;
        if(characterArray.isEmpty()) { //if you press remove and the character array list is empty throw exception
            throw new Exception("All characters have been removed, please add one before trying to remove!");
        }
        if(!idCheck(textFieldArrayList,labelArray)) {
            //if it is not a number or blank throw exception, see method
        }
        if(Integer.parseInt(textFieldArrayList.get(0).getText()) != characterArray.get(index).getId()) { //if not matching
            labelArray.get(0).setText("ID does not match"); //set label
            throw new Exception("ID does not match"); //throw exception
        }
        if(!nameCheck(textFieldArrayList,labelArray)) { 
            //if name is empty it will throw exception, see methos
        }
        if (!textFieldArrayList.get(1).getText().equalsIgnoreCase(characterArray.get(index).getName())) { //if the name is not the exact you cant remove
                throw new Exception("Name does not match");
        }
        
        if(!classDD.getValue().matches(characterArray.get(index).getcClass())) { //if the class dropdown and the data on character array list dont match
            throw new Exception("Class does not match");
        }
        if(!typeDD.getValue().matches(characterArray.get(index).getType())) { //if the type dropdown and the data on the character array list dont match
            throw new Exception("Type does not match");
        }
        if(!comboCheck(textFieldArrayList, labelArray)) {
            //if combo isnt a number or empty, throw exceptions, see method
        }
        if(Integer.parseInt(textFieldArrayList.get(2).getText()) != characterArray.get(index).getCombo()) { //if combo doesnt match
                throw new Exception("Combo does not match");
        }
        if(!hpCheck(textFieldArrayList,labelArray)) {
            //if hp is empty or not a number, throw exceptions, see method
        }
        if(Integer.parseInt(textFieldArrayList.get(3).getText()) != characterArray.get(index).getHP()) { //if hp doesnt match
                throw new Exception("HP does not match");
        }
        if(!attackCheck(textFieldArrayList,labelArray)) {
            //if attack is not a number or empty, throw exception, see method
        }
        if(Integer.parseInt(textFieldArrayList.get(4).getText()) != characterArray.get(index).getAttack()) {//if attack doesnt match
            throw new Exception("Attack does not match"); 
        }
        if(!rcvCheck(textFieldArrayList,labelArray)) {
            //if rcv is not a number or empty, throw exception, see method
        }
        if(Integer.parseInt(textFieldArrayList.get(5).getText()) != characterArray.get(index).getRCV()) { //if rcv doesnt match
            throw new Exception("RCV does not match");
        }
        else { //if all validations pass
            for(int i=0; i<labelArray.size();i++) { //if all validations pass then remove all error messages
                labelArray.get(i).setText("");
            }
            removeFlag = true;
                        
        }
        return removeFlag;
        
    }
    /**
     * check to see if you can add a character
     * @param textFieldArrayList
     * @param characterArray
     * @param labelArray
     * @param index
     * @return
     * @throws Exception 
     */
    public boolean validateAdd(ArrayList<TextField> textFieldArrayList, ArrayList<Characters> characterArray, ArrayList<Label> labelArray,int index) throws Exception {
        boolean addFlag = false;
        if(isEmpty(textFieldArrayList)) { //if textfields are empty
            throw new Exception("Not everything is filled! Please fill in all text field then try again.");
        }
        if(!idCheck(textFieldArrayList,labelArray)) { //if empty or not a number, see method
            throw new Exception("Please enter an ID");
        }
        if(!nameCheck(textFieldArrayList,labelArray)) { //if empty
            throw new Exception("Please enter a name");
        }
        //no need to check class or type since something is always selected
        if(!comboCheck(textFieldArrayList,labelArray)) { //if empty or not a number, see method
            throw new Exception("Please enter a Combo");
        }
        if(!hpCheck(textFieldArrayList,labelArray)) { //if empty or not a number ,see method
            throw new Exception("Please enter Hp");
        }
        if(!attackCheck(textFieldArrayList,labelArray)) { //if empty or not a number ,see method
            throw new Exception("Please enter Attack");
        }
        if(!rcvCheck(textFieldArrayList,labelArray)) { //if empty or not a number ,see method
            throw new Exception("Please enter Recovery");
        }
        else { //if all validations go through            
            if(characterArray.isEmpty()) { //if it is empty we need to let it go through since it will not match with any existing ID
                addFlag = true;
            }
            else {
                for(int i=0;i<characterArray.size();i++) { //check each character in the array list and see if it already exists
                    if(characterArray.get(i).getId() == Integer.parseInt(textFieldArrayList.get(0).getText())) { //if matching id
                       labelArray.get(0).setText("ID already exists");
                       throw new Exception("ID already Exists");
                    }
                    else { //if it doesn't then return true
                        addFlag = true;
                    }
                }
            }
        }
        return addFlag;
    }
    /**
     * validations to see if you can modify
     * @param textFieldArrayList
     * @param characterArray
     * @param labelArray
     * @param index
     * @return
     * @throws Exception 
     */
    public boolean validateModify(ArrayList<TextField> textFieldArrayList, ArrayList<Characters> characterArray, ArrayList<Label> labelArray,int index) throws Exception {
        boolean modifyFlag = false;
        
        if(characterArray.size() == 0) { //when array list is empty
            throw new Exception("You cannot modify when there are no characters in the database! Please make a character first.");
        }
        if(!idCheck(textFieldArrayList,labelArray)) { //if empty or not a number
            throw new Exception("Please enter an ID");
        }
        if(!nameCheck(textFieldArrayList,labelArray)) {//if empty
            throw new Exception("Please enter a name");
        }
        //no need to check for class and type since something is always selected
        if(!comboCheck(textFieldArrayList,labelArray)) { //if empty or not a number
            throw new Exception("Please enter a Combo");
        }
        if(!hpCheck(textFieldArrayList,labelArray)) {//if empty or not a number
            throw new Exception("Please enter Hp");
        }
        if(!attackCheck(textFieldArrayList,labelArray)) {//if empty or not a number
            throw new Exception("Please enter Attack");
        }
        if(!rcvCheck(textFieldArrayList,labelArray)) {//if empty or not a number
            throw new Exception("Please enter Recovery");
        }
        else { //if all validations go through                        
                for(int i=0;i<characterArray.size();i++) { //check each character in the array list and see if it already exists
                    if(i == index) {//if we are on the same index then we can ignore the id checker
                        modifyFlag = true;
                    }
                    else if(characterArray.get(i).getId() == Integer.parseInt(textFieldArrayList.get(0).getText())) { //if matching ids
                       labelArray.get(0).setText("ID already exists"); //show error message
                       throw new Exception("ID already Exists");
                    }
                    else { //if it doesn't match then return true
                        modifyFlag = true;
                    }
                }

        }
        
        return modifyFlag;
    }
    /**
     * method to see if string is an int
     * @param s
     * @return 
     */
    private boolean isInt(String s){
        for(int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i))){
                return false;
            }
        }
        return true;
    }
    /**
     * checking if a textfield is empty
     * @param textFieldArrayList
     * @return 
     */
    private boolean isEmpty(ArrayList<TextField> textFieldArrayList)  {
        if(textFieldArrayList.get(0).getText() == null ||
            textFieldArrayList.get(1).getText() == null ||
            textFieldArrayList.get(2).getText() == null ||
            textFieldArrayList.get(3).getText() == null ||
            textFieldArrayList.get(4).getText() == null ||
            textFieldArrayList.get(5).getText() == null
            ) {
                return true;
                
            }

        return false;
    }
    /**
     * checking id for empty or not a number
     * @param textFieldArrayList
     * @param labelArray
     * @return
     * @throws Exception 
     */
    private boolean idCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray) throws Exception{
        if(textFieldArrayList.get(0).getText().isEmpty() || textFieldArrayList.get(0).getText() == null) { //if id textfield is empty
            labelArray.get(0).setText("Please enter an ID");
            return false; //did not pass idcheck
            
        }
        if (!isInt(textFieldArrayList.get(0).getText())) { //if id textfield is not a number
            labelArray.get(0).setText("Please Enter a number");
            throw new Exception("Please enter a number");
        }
        return true;
    }
    /**
     * checking name to see if empty
     * @param textFieldArrayList
     * @param labelArray
     * @return 
     */
    private boolean nameCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray)  {
        if(textFieldArrayList.get(1).getText().isEmpty() || textFieldArrayList.get(1).getText() == null) { //if name textfield is empty
            labelArray.get(1).setText("Please enter a Name");
            return false;
            
        }
        return true;
    }
    /**
     * checking to see if combo is not a number or empty
     * @param textFieldArrayList
     * @param labelArray
     * @return
     * @throws Exception 
     */
    private boolean comboCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray) throws Exception {
        if(textFieldArrayList.get(2).getText().isEmpty() || textFieldArrayList.get(2).getText() == null) { //if combo textfield is empty
            labelArray.get(4).setText("Please enter a Combo");
            return false;
            
        }
        if (!isInt(textFieldArrayList.get(2).getText())) { //if combo textfield is not an integer
            labelArray.get(4).setText("Please Enter a number");
            throw new Exception("Please enter a number");
        }
        return true;
    }
    /**
     * checking to see if hp is empty or not a number
     * @param textFieldArrayList
     * @param labelArray
     * @return
     * @throws Exception 
     */
    private boolean hpCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray) throws Exception  {
        if(textFieldArrayList.get(3).getText().isEmpty() || textFieldArrayList.get(3).getText() == null) { //if hp textfield is empty
            labelArray.get(5).setText("Please enter Hp");
            return false;
            
        }
        if (!isInt(textFieldArrayList.get(3).getText())) { //if hp is not an integer
            labelArray.get(5).setText("Please Enter a number");
            throw new Exception("Please enter a number");
        }
        
        return true;
    }
    /**
     * checking to see if attack is empty or not a number
     * @param textFieldArrayList
     * @param labelArray
     * @return
     * @throws Exception 
     */
    private boolean attackCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray) throws Exception {
        if(textFieldArrayList.get(4).getText().isEmpty() || textFieldArrayList.get(4).getText() == null) { //if attack textfield is empty
            labelArray.get(6).setText("Please enter Attack");
            
            return false;
            
        }
        if (!isInt(textFieldArrayList.get(4).getText())) { //if attack is not an integer
            labelArray.get(6).setText("Please Enter a number");
            throw new Exception("Please enter a number");
            
        }
        return true;
    }
    /**
     * checking to see if rcv is empty or not a number
     * @param textFieldArrayList
     * @param labelArray
     * @return
     * @throws Exception 
     */
    private boolean rcvCheck(ArrayList<TextField> textFieldArrayList, ArrayList<Label> labelArray) throws Exception  {
        if(textFieldArrayList.get(5).getText().isEmpty() || textFieldArrayList.get(5).getText() == null) { //if rcv textfield is empty
            labelArray.get(7).setText("Please enter Recovery");
            return false;
            
        }
        if (!isInt(textFieldArrayList.get(5).getText())) { //if rcv is not a number
            labelArray.get(7).setText("Please Enter a number");
            throw new Exception("Please enter a number");
        }
        return true;
    }
    
    
}
