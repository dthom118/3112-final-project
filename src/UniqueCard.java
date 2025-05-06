import java.util.*;

public class UniqueCard extends Card{

    boolean unique;

    public UniqueCard(){

    }

    public UniqueCard(int id, String name, String game, float price, String attr1, String attr2, boolean unique){
        this.id = id;
        this.name = name;
        this.game = game;
        this.price = price;
        this.attr1 = attr1;
        this.attr2 = attr2;
        this.unique = unique;
    }

    // Getter
    public boolean isUnique() {
        return unique;
    }

    // Setter
    public void setUnique(boolean unique) {
        this.unique = unique;
    }

    @Override
    public String toString(){
        return ("ID: " + this.getId() +
                ", Name: " + this.getName() +
                ", Game: " + this.getGame() +
                ", Price: " + this.getPrice() +
                ", Attribute 1: " + this.getAttr1() +
                ", Attribute 2: " + this.getAttr2() +
                ", Unique: " + this.isUnique());
    }

}
