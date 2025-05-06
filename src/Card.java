import java.util.*;

public class Card {

    int id;
    float price;
    String name = "", game = "", attr1 = "", attr2 = "";

    public Card(){

    }

    public Card(int id, String name, String game, float price, String attr1, String attr2){
        this.id = id;
        this.name = name;
        this.game = game;
        this.price = price;
        this.attr1 = attr1;
        this.attr2 = attr2;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(String game) {
        this.game = game;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getAttr1() {
        return attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getGame() {
        return game;
    }

    @Override
    public String toString(){
        return ("ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Game: " + this.getGame() +
                ", Price: " + this.getPrice() +
                ", Attribute 1: " + this.getAttr1() +
                ", Attribute 2: " + this.getAttr2());
    }
}
