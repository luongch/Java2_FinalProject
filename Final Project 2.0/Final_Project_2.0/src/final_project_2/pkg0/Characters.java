/**
 *
 * Programmer: Christopher Luong, Gurkamal Hans<BR>
 * Program: Characters.java<BR>
 * Date: April 2016<BR>
 * @version 2.0 
 */

package final_project_2.pkg0;

import javafx.scene.image.Image;

public class Characters {
    
    int id;
    String name;
    String cclass;
    String type;
    int combo;
    int hp;
    int attack;
    int rcv;
    /**
     * blank constructor, so you can get it one at a time
     */
    public Characters() {
        
    }
    /**
     * constructor that takes all information at once
     * @param id
     * @param name
     * @param cclass
     * @param type
     * @param combo
     * @param hp
     * @param attack
     * @param rcv 
     */
    public Characters(int id, String name, String cclass, String type, int combo, int hp,int attack, int rcv) {
        this.id = id;
        this.name = name;
        this.cclass = cclass;
        this.type = type;
        this.combo = combo;
        this.hp = hp;
        this.attack = attack;
        this.rcv = rcv;
    }

    public void setID(int id){
        this.id =  id;
    }
    
    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setClass (String cclass) {
        this.cclass = cclass;
    }

    public String getcClass () {
        return this.cclass;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public void setCombo(int combo){
        this.combo = combo;
    }

    public int getCombo() {
        return this.combo;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }
    public int getHP() {
        return this.hp;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getAttack() {
        return this.attack;
    }
    public void setRCV(int rcv) {
        this.rcv = rcv;
    }
    public int getRCV() {
        return this.rcv;
    }

        
}
