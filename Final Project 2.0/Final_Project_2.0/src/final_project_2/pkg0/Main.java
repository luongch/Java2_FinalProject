/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: Main.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    private Label lblID = new Label("ID");
    private Label lblName = new Label("Name");
    private Label lblClass = new Label("Class");
    private Label lblType = new Label("Type");
    private Label lblCombo = new Label("Combo");
    private Label lblHP = new Label ("HP");
    private Label lblATK = new Label("ATK");
    private Label lblRCV = new Label("RCV");
    private Label iderror = new Label("");
    private Label nameerror = new Label("");
    private Label cclasserror = new Label("");
    private Label typeerror = new Label("");
    private Label comboerror = new Label("");
    private Label hperror = new Label ("");
    private Label atkerror = new Label("");
    private Label rcverror = new Label("");

    private TextField txtID = new TextField();
    private TextField txtName = new TextField();
    //private TextField tClass = new TextField();
    // TextField tType = new TextField();
    private TextField txtCombo = new TextField();
    private TextField txtHP = new TextField();
    private TextField txtATK = new TextField();
    private TextField txtRCV = new TextField();
    private TextField txtSearch = new TextField();
    
    private Button btnFirst = new Button("<< First");
    private Button btnLast = new Button("Last >>");
    private Button btnNext = new Button("Next >");
    private Button btnPrev = new Button("< Previous");
    private Button btnEdit = new Button("Edit Mode");
    private Button btnAdd = new Button("Add");
    private Button btnRemove = new Button("Remove");
    private Button btnModify = new Button("Modify");
    private Button btnSearch = new Button("Search");
    private Button btnListView = new Button("List View");
    
    private MediaPlayer mPlayer;
    
    private ObservableList<String> obvList = FXCollections.observableArrayList();
    private ObservableList<String> obvFullList = FXCollections.observableArrayList();
    
    private ArrayList<Image> imgList = new ArrayList();
    private ImageView imageView = new ImageView();
   
    private ComboBox<String> searchDD = new ComboBox();
    private ComboBox<String> classDD = new ComboBox();
    private ComboBox<String> typeDD = new ComboBox();
    
    private ArrayList<TextField> textFieldArrayList = new ArrayList<TextField>();
    private ArrayList<Label> errorLabelArrayList = new ArrayList<Label>();
    
    private ArrayList<Characters> characterArray = new ArrayList();
    private CharacterFileWriter characterFileWriter = new CharacterFileWriter("characters.dat");
    private CharacterWriter characterWriter = new CharacterWriter();
    private CharacterReader characterReader = new CharacterReader("characters.dat");
    private Validations validations = new Validations();
    private CharacterSearch characterSearch = new CharacterSearch();
    
    private int index = 0;
    
    @Override
    public void start(Stage primaryStage) {
        
        /**
         * attach song to media player
         */
        URL urlPath = Main.class.getResource("/One Piece OST - The Very Very Very Strongest [extended].mp3");
        Media media = new Media(urlPath.toString());
        mPlayer = new MediaPlayer(media);
        mPlayer.play();
        
        /**
         * creating images
         */
        Image whitebeardIMG = new Image("Whitebeard.png");
        Image rayleighIMG = new Image("Dark King Rayleigh.png");
        Image boaIMG = new Image("Boa Hancock Warlord of the Sea.png");
        Image sengokuIMG = new Image("Sengoku the Buddha.png");
        Image shanksIMG = new Image("Shanks Black Clad Emperor.png");
        Image aceIMG = new Image("Portgas D. Ace Black Clad Whitebeard 2nd Div. Commander.png");
        Image luffyIMG = new Image("Monkey D. Luffy Voyage Dream.png");
        Image marcoIMG = new Image("Marco the Phoenix Whitebeard 1st Div. Commander.png");
        Image saboIMG = new Image("Sabo the Revolutionary.png");
        Image mihawkIMG = new Image("Dracule Mihawk World's Strongest Swordsman.png");
        Image crocodileIMG = new Image("Sir Crocodile Logia Former Warlord of the Sea.png");
        Image lucciIMG = new Image("Rob Lucci CP9's Strongest Generation.png");
        Image doffyIMG = new Image("Heavenly Yaksha Donquixote Doflamingo.png");
        Image jimbeIMG = new Image("Knight of the Sea Jinbe Warlord of the Sea.png");
        Image naIMG = new Image("naIMG.jpg");

        searchDD.setPromptText("What would you like to search?"); //set default search dropdown message
        searchDD.getItems().addAll("ID","Name","Class","Type","Combo","HP", "ATK", "RCV"); //add selection to drop down
        searchDD.setMinWidth(250);
        txtSearch.setMinWidth(150);
        btnSearch.setMinWidth(75);
        
        classDD.getItems().addAll("Striker", "Fighter", "Shooter", "Slasher"); //add class selection to dropdown
        typeDD.getItems().addAll("DEX","STR","QCK","INT","PSY"); //add type selection to dropdown
        
        /**
         * filling textfield array list
         */
        textFieldArrayList.add(txtID);
        textFieldArrayList.add(txtName);
        //textFieldArrayList.add(tClass);
        //textFieldArrayList.add(tType);
        textFieldArrayList.add(txtCombo);
        textFieldArrayList.add(txtHP);
        textFieldArrayList.add(txtATK);
        textFieldArrayList.add(txtRCV);
        
        /**
         * filling error label textfield array list
         */
        errorLabelArrayList.add(iderror);
        errorLabelArrayList.add(nameerror);
        errorLabelArrayList.add(cclasserror);
        errorLabelArrayList.add(typeerror);
        errorLabelArrayList.add(comboerror);
        errorLabelArrayList.add(hperror);
        errorLabelArrayList.add(atkerror);
        errorLabelArrayList.add(rcverror);
        
        /**
         * filling image array list
         */
        imgList.add(whitebeardIMG);
        imgList.add(rayleighIMG);
        imgList.add(boaIMG);
        imgList.add(sengokuIMG);
        imgList.add(shanksIMG);
        imgList.add(aceIMG);
        imgList.add(luffyIMG);
        imgList.add(marcoIMG);
        imgList.add(saboIMG);
        imgList.add(mihawkIMG);
        imgList.add(crocodileIMG);
        imgList.add(lucciIMG);
        imgList.add(doffyIMG);
        imgList.add(jimbeIMG);
        imgList.add(naIMG);
        

        disableEdit(); //method to disable editing at the start

        VBox idbox = new VBox();
        VBox namebox = new VBox();
        VBox classbox = new VBox();
        VBox typebox = new VBox();
        VBox combobox = new VBox();
        VBox hpbox = new VBox();
        VBox atkbox = new VBox();
        VBox rcvbox = new VBox();
        HBox buttons = new HBox();
        VBox search = new VBox();
        search.setSpacing(10);
        idbox.getChildren().addAll(lblID, iderror,txtID);
        namebox.getChildren().addAll(lblName, nameerror,txtName);
        //classbox.getChildren().addAll(cclass, cclasserror,tClass,classDD);
        classbox.getChildren().addAll(lblClass, cclasserror,classDD);
        //typebox.getChildren().addAll(type, typeerror,tType,typeDD);
        typebox.getChildren().addAll(lblType, typeerror,typeDD);
        combobox.getChildren().addAll(lblCombo, comboerror,txtCombo);
        hpbox.getChildren().addAll(lblHP, hperror,txtHP);
        atkbox.getChildren().addAll(lblATK, atkerror,txtATK);
        rcvbox.getChildren().addAll(lblRCV, rcverror,txtRCV);
        buttons.getChildren().addAll(btnFirst, btnLast, btnNext, btnPrev);
        search.getChildren().addAll(searchDD,txtSearch,btnSearch);

        try {
            obvFullList = characterReader.fillObvList();
            characterArray = characterReader.getData(); //filling character array list
            characterFileWriter.writeCharacterFile(characterArray); //writing the file using data from the character array list
            setData(0); //displaying the first character 
        }
        catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
            showStage(e.getMessage());
        }
        catch(IOException e) {
            System.err.println(e.getMessage());
            showStage(e.getMessage());
        }
        catch(Exception exception) {
            System.err.println(exception.getMessage());
            showStage(exception.getMessage());
        }
        /**
         * when first button is pressed, brings you to first index
         */
        btnFirst.setOnAction((e)->{
            try {
                if(!validations.checkEmpty(characterArray,textFieldArrayList)) { //if not empty
                    index = 0; //set the index to 0
                    setData(index); //show the data from the first index
                }
            }
            catch(Exception exception) { //otherwise it will let user know that the arraylist is empty
                showStage(exception.getMessage());
            }
        });
        /**
         * when last btn is pressed then it will go to last indez
         */
        btnLast.setOnAction((e)->{
            try {
                if(!validations.checkEmpty(characterArray,textFieldArrayList)) { //if not empty
                    index = characterArray.size()-1; //set the index to the size of the array list -1
                    setData(index); //show the data from the last index of characterArray
                }

            }
            catch(Exception exception) { //otherwise it will let user know that the arraylist is empty
                showStage(exception.getMessage());
            }


        });
        /**
         * when next btn is pressed it will go to next index
         */
        btnNext.setOnAction((e)->{
            try {
                if(!validations.checkEmpty(characterArray,textFieldArrayList)) {
                    if(index < characterArray.size()-1) { //if it is not bigger than the ArrayList size then increase index
                        index++;

                    }
                    System.out.println("from next: " + index);
                    setData(index); //show the data in respect to the current index
                }

            }
            catch(Exception exception) {
                showStage(exception.getMessage());
            }

        });
        /**
         * when prev is pressed it will go to previous index
         */
        btnPrev.setOnAction((e)->{
            try {
                if(!validations.checkEmpty(characterArray,textFieldArrayList)) { //if not empty then it will work
                    if(index > 0) { //if the index is not the first then decrease index otherwise do nothing
                        index--;
                    }
                    setData(index); //show the data in respect to current index
                    System.out.println("from prev: " + index);
                }
            }
            catch(Exception exception) {
                showStage(exception.getMessage());
            }
        });
        /**
         * when edit is pressed enable the add,remove, and modify button
         */
        btnEdit.setOnAction((e)->{
            enableEdit();
        });
        /**
         * adds a character to the character array and goes to the newly created character
         */
        btnAdd.setOnAction((e)->{
            try {
                System.out.println(classDD.getValue());
                if(validations.validateAdd(textFieldArrayList, characterArray, errorLabelArrayList,index)) { // if validations pass
                    characterWriter.addCharacter(textFieldArrayList, characterArray, classDD, typeDD); //add the character
                    showStage("Character has been added"); //prompt that lets user know character has been added
                    disableEdit(); //disable editing
                    
                    for(int i=0; i<errorLabelArrayList.size();i++) { //remove error messages
                        errorLabelArrayList.get(i).setText("");
                    }
                    index = characterArray.size()-1; //this is to set the index to the last position since user will be sent to the most recent
                    
                    characterFileWriter.writeCharacterFile(characterArray); //rewrite the characters.dat file
                }

            }
            catch(FileNotFoundException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch(IOException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch (Exception exception) {
                showStage(exception.getMessage());
            }
        });
        /**
         * when remove button is press validate and then remove character
         */
        btnRemove.setOnAction((e)->{
            try {
                
                if(validations.validateRemove(textFieldArrayList, characterArray,index, errorLabelArrayList,classDD,typeDD)){ //if all validations go thorugh
                    
                    characterWriter.removeCharacter(characterArray, index); //remove character
                    if(validations.checkEmpty(characterArray,textFieldArrayList)) { 
                        //if it is empty an exception is thrown and sets textfields to null
                    }
                }

                if(index > 0) {
                    index--; //remove one of index since it no longer exists
                }

                setData(index); //show the data for the current index
                showStage("Character has been removed"); //prompt to let user know the character has been remove
                disableEdit(); //disable editing
                characterFileWriter.writeCharacterFile(characterArray); //rewrite the characters.dat file
            }
            
            catch(FileNotFoundException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch(IOException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch(Exception exception){
                showStage(exception.getMessage());
            }
        });
        /**
         * when modify is pressed validate and then change the data based on the current index and textfield
         */
        btnModify.setOnAction((e)->{
            try {
                if(validations.validateModify(textFieldArrayList, characterArray, errorLabelArrayList, index)) { //if validations pass
                    characterWriter.modifyCharacterV2(textFieldArrayList, characterArray, index, classDD, typeDD); //change the data 
                    setData(index); //go to current index
                    showStage("Character has been modified"); //prompt user to let them know it has been modifed
                    disableEdit(); //disable editing
                    characterFileWriter.writeCharacterFile(characterArray); //rewrite the characters.dat file
                    for(int i=0; i<errorLabelArrayList.size();i++) { //remove error messages
                        errorLabelArrayList.get(i).setText("");
                    }
                }
            }
            catch(FileNotFoundException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch(IOException x) {
                System.err.println(x.getMessage());
                showStage(x.getMessage());
            }
            catch (Exception exception) {
                System.err.println(exception.getMessage());
                showStage(exception.getMessage());
            } 
        });
        /**
         * when search button is pressed
         */
        btnSearch.setOnAction((e)->{
            try {
                
                if(searchDD.getValue() == "ID") { //id search
                    obvList = characterSearch.searchID(txtSearch, characterArray); //set obv list
                    checkObvList(obvList);
                }
                else if(searchDD.getValue() == "Name") { //name search
                    obvList = characterSearch.searchName(txtSearch, characterArray);
                    checkObvList(obvList);
                             
                }
                else if(searchDD.getValue() == "Class") { //class search
                    obvList = characterSearch.searchClass(txtSearch, characterArray);
                    checkObvList(obvList);

                }
                else if(searchDD.getValue() == "Type") { //type search
                    obvList = characterSearch.searchType(txtSearch, characterArray);
                    checkObvList(obvList);
                }
                else if(searchDD.getValue() == "Combo") { //combo search
                    obvList = characterSearch.searchCombo(txtSearch, characterArray);
                    checkObvList(obvList);
                }
                else if(searchDD.getValue() == "HP") { //hp search
                    obvList = characterSearch.searchHP(txtSearch, characterArray);
                    checkObvList(obvList);
                }
                else if(searchDD.getValue() == "ATK") { //atk search
                    obvList = characterSearch.searchATK(txtSearch, characterArray);
                    checkObvList(obvList);
                }
                else if(searchDD.getValue() == "RCV") { //rcv search
                    obvList = characterSearch.searchRCV(txtSearch, characterArray);
                    checkObvList(obvList);
                }
                else {
                    showStage("Please select from drop down!");
                }
            }
            catch(Exception exception) {
                showStage(exception.getMessage());
            }
            
        });
        /**
         * displays the full list of characters when pressed
         */
        btnListView.setOnAction((e)->{
            try {
                obvFullList = characterReader.fillObvList(); //refreshes the list
                fullListStage();
            }
            catch(FileNotFoundException x) {
                System.out.println(x.getMessage());
            }
            catch(IOException x) {
                System.out.println(x.getMessage());
            }
            catch(Exception exception) {
                System.out.println(exception.getMessage());
            }
            
        });
        
        GridPane pane = new GridPane();
        pane.add(idbox, 0, 0);
        pane.add(btnListView,1,0);
        pane.add(namebox, 0,1,4,1);
        pane.add(classbox,0,2);
        pane.add(typebox, 1, 2);
        pane.add(combobox, 0, 3);
        pane.add(hpbox, 1, 3);
        pane.add(atkbox, 2, 3);
        pane.add(rcvbox, 3, 3);
        pane.add(btnFirst, 0, 4);
        pane.add(btnPrev, 1 ,4);
        pane.add(btnNext, 2, 4);
        pane.add(btnLast, 3, 4);
        pane.add(btnEdit, 0, 5);
        pane.add(btnAdd, 1, 5);
        pane.add(btnRemove,2,5);
        pane.add(btnModify, 3, 5);
        pane.add(search, 0, 6, 4, 1);
        pane.add(imageView,5, 0, 1, 6);
        //pane.add(tSearch, 1, 6);
        //pane.add(btnSearch, 2, 6);
        //pane.add(search, 0, 5);
        pane.setHgap(10); //horizontal gap in pixels => that's what you are asking for
        pane.setVgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        Scene scene = new Scene(pane);
        //primaryStage.setFullScreen(true);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * method to display the data of the current index
     * @param index 
     */
    private void setData(int index){
        txtID.setText(Integer.toString(characterArray.get(index).getId()));
        txtName.setText(characterArray.get(index).getName());

        txtCombo.setText(Integer.toString(characterArray.get(index).getCombo()));
        txtHP.setText(Integer.toString(characterArray.get(index).getHP()));
        txtATK.setText(Integer.toString(characterArray.get(index).getAttack()));
        txtRCV.setText(Integer.toString(characterArray.get(index).getRCV()));
        
        classDD.setValue(characterArray.get(index).getcClass());
        typeDD.setValue(characterArray.get(index).getType());
        //set picture if the exact name matches
        switch(characterArray.get(index).getName()) {
            case("Whitebeard"):
                imageView.setImage(imgList.get(0));
                break;
            case("Dark King Rayleigh"):
                imageView.setImage(imgList.get(1));
                break;
            case("Boa Hancock Warlord of the Sea"):
                imageView.setImage(imgList.get(2));
                break;
            case("Sengoku the Buddha"):
                imageView.setImage(imgList.get(3));
                break;
            case("Shanks Black Clad Emperor"):
                imageView.setImage(imgList.get(4));
                break;
            case("Portgas D. Ace Black Clad Whitebeard 2nd Div. Commander"):
                imageView.setImage(imgList.get(5));
                break;
            case("Monkey D. Luffy Voyage Dream"):
                imageView.setImage(imgList.get(6));
                break;
            case("Marco the Phoenix Whitebeard 1st Div. Commander"):
                imageView.setImage(imgList.get(7));
                break;
            case("Sabo the Revolutionary"):
                imageView.setImage(imgList.get(8));
                break;
            case("Dracule Mihawk World's Strongest Swordsman"):
                imageView.setImage(imgList.get(9));
                break;
            case("Sir Crocodile Logia Former Warlord of the Sea"):
                imageView.setImage(imgList.get(10));
                break;
            case("Rob Lucci CP9's Strongest Generation"):
                imageView.setImage(imgList.get(11));
                break;
            case("Heavenly Yaksha Donquixote Doflamingo"):
                imageView.setImage(imgList.get(12));
                break;
            case("Knight of the Sea Jimbe Warlord of the Sea"):    
                imageView.setImage(imgList.get(13));
                break;
            default:
                imageView.setImage(imgList.get(14));
                break;
        }
    }
    /**
     * enable the editing
     */
    private void enableEdit() {
        //set all textfield to editable until they press the edit mode
        for(int sub = 0; sub < textFieldArrayList.size(); sub++) {
            textFieldArrayList.get(sub).setEditable(true);
        }
        //classDD.setDisable(false); //cant use because it becomes hard to read when disabled
        //typeDD.setDisable(false);
        btnAdd.setDisable(false);
        btnRemove.setDisable(false);
        btnModify.setDisable(false);
        btnEdit.setDisable(true);
        

    }
    /**
     * disables the editing
     */
    private void disableEdit() {
        //set all textfield to uneditable until they press the edit mode
        for(int sub = 0; sub < textFieldArrayList.size(); sub++) {
            textFieldArrayList.get(sub).setEditable(false);
        }
        //classDD.setDisable(true); //cant use because it becomes hard to read
        //typeDD.setDisable(true);
        btnAdd.setDisable(true);
        btnRemove.setDisable(true);
        btnModify.setDisable(true);
        btnEdit.setDisable(false);
    }
    /**
     * displays a message to the user
     * @param message 
     */
    private void showStage(String message) {
        Stage stage = new Stage();
        Button bOK = new Button("OK");
        bOK.setOnAction((e)->{
            for(int sub = 0; sub < errorLabelArrayList.size(); sub++) { //when ok is pressed all error messages get erased
                errorLabelArrayList.get(sub).setText("");
            }
            stage.close();
        });

        BorderPane pane = new BorderPane();
        pane.setCenter(new Label(message));
        pane.setBottom(bOK);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setTitle(message);
        stage.show();

    }
    /**
     * displays all the characters in the file and lets you go to that index when you click on it
     */
    private void fullListStage(){
        Stage stage = new Stage();

        ListView<String> listview = new ListView();
        listview.setItems(obvFullList); //put the content in observable list into the list view
        
        listview.setOnMouseClicked((e)->{
            
            String current = listview.getSelectionModel().getSelectedItem(); //get the string of the clicked list value
            System.out.println(current);
            if(current == null || current.isEmpty()) {
                System.err.println("Can't click there");
            }
            else {
                
                StringTokenizer tokenizer = new StringTokenizer(current, ",");
                int characterID = Integer.parseInt(tokenizer.nextToken()); //get the first token which is id
                for(int sub = 0; sub < characterArray.size(); sub++) { //loop through character array
                    if(characterID == characterArray.get(sub).getId()) { //if it finds a matching id
                        index = sub; //set the index to the index where the character that holds the ID is located
                }
            }
            setData(index); //display the data
            stage.close(); //close the screen after they click on one
            }
            
        });
        
        BorderPane pane = new BorderPane();
        pane.setCenter(listview);
        
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Search results");
        stage.show();
    }
    /**
     * displays a new stage that uses list view which displays information in the observable list
     */
    private void searchStage() {
        Stage stage = new Stage();
        Button bOK = new Button("OK");
        
        btnSearch.setDisable(true); //disable search button
        ListView<String> listview = new ListView();
        listview.setItems(obvList); //put the content in observable list into the list view
        
        listview.setOnMouseClicked((e)->{
            String current = listview.getSelectionModel().getSelectedItem();
            if(current == null || current.isEmpty()) {
                System.err.println("Can't click there");
            }
            else {
                StringTokenizer tokenizer = new StringTokenizer(current, ",");
                int characterID = Integer.parseInt(tokenizer.nextToken());
                for(int sub = 0; sub < characterArray.size(); sub++) {
                    if(characterID == characterArray.get(sub).getId()) {
                        index = sub;
                    }
                }
            setData(index);
            }
            
        });
        
        BorderPane pane = new BorderPane();
        pane.setCenter(listview);
        pane.setBottom(bOK);
        
        bOK.setOnAction((e)->{

            obvList.remove(0, obvList.size()); //removes all the previous results from the search
            btnSearch.setDisable(false); //enables search button when they press ok
            stage.close();
        });
        
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Search results");
        stage.show();

    }
    /**
     * check the obv list 
     * @param obvList 
     */
    private void checkObvList(ObservableList<String> obvList) {
        if(!obvList.isEmpty()) { //if it contains some matches
            searchStage(); //show the list view
        }
        else {
            showStage("No match"); //prompt a message saying no matches
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
