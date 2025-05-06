import java.util.*;

public class PersonalCollection extends Card{

    static Main main = new Main();

    Scanner input = new Scanner(System.in);

    String name = "";
    int col_id;
    ArrayList<Card> cards = new ArrayList<>();
    public static ArrayList<PersonalCollection> collections = new ArrayList<>();

    public PersonalCollection(){

    }

    public PersonalCollection(int col_id, String name, ArrayList<Card> cards){
        this.col_id = col_id;
        this.name = name;
        this.cards = cards;
    }

    public PersonalCollection(int col_id, String name){
        this.col_id = col_id;
        this.name = name;
    }

    // Setters
    public void setColName(String name) {
        this.name = name;
    }

    public void setCol_id(int col_id) {
        this.col_id = col_id;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void setCollections(ArrayList<PersonalCollection> collections) {
        PersonalCollection.collections = collections;
    }

    // Getters
    public String getColName() {
        return name;
    }

    public int getCol_id() {
        return col_id;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<PersonalCollection> getCollections() {
        return collections;
    }

    @Override
    public String toString(){
        return ("Collection ID: " + this.getCol_id() +
                ", Collection Name: " + this.getColName() +
                ", Cards: " + this.getCards());
    }

    // Methods
    public void createCard(int id, String name, String game, float price, String attr1, String attr2, boolean unique){

        if (unique == true){
            UniqueCard uniqueCard = new UniqueCard(id, name, game, price, attr1, attr2, true);

            cards.add(uniqueCard);

            System.out.println("Card successfully created with ID: " + id + ".");

        } else {

            Card card = new Card(id, name, game, price, attr1, attr2);

            cards.add(card);

            System.out.println("Card successfully created with ID: " + id + ".");

        }

    }

    public void deleteCard(int id, int card_id){

        Card toBeDeleted = null;

        for (PersonalCollection collection : collections){
            if (collection.getCol_id() == id){
                // collection ID found
                if (collection.getCards().isEmpty()){
                    System.out.println("There are no cards in this collection!");
                }
                for (Card card : collection.getCards()){
                    if (card.getId() == card_id){
                        toBeDeleted = card;
                    } else {
                        System.out.println("Card ID not found!");
                    }
                }
                collection.getCards().remove(toBeDeleted);
            } else {
                System.out.println("Collection ID not found!");
            }
        }

        System.out.println("Deleted card ID " + card_id + " for collection ID " + id);
    }

    public void updateCard(String name, String game, float price, String attr1, String attr2, int col_id, String answer, int card_id){

        for (PersonalCollection collection : collections){
            if (collection.getCol_id() == col_id){
                if (!collection.getCards().isEmpty()){
                    for (Card card : collection.getCards()){
                        if (card.getId() == card_id){
                            card.setName(name);
                            card.setGame(game);
                            card.setPrice(price);
                            card.setAttr1(attr1);
                            card.setAttr2(attr2);
                        }
                    }
                } else {
                    System.out.println("The collection has no cards in it! Consider adding some cards!");
                }
            } else {
                System.out.println("Cannot find the collection with ID of " + collection.getCol_id());
            }
        }
    }

    public void addToCollection(int card_id, int collection_id){

        Card toBeRemoved = null;

        for (Card card : cards){
            if (card.getId() == card_id){
                for (PersonalCollection collection : collections){
                    if (collection.getCol_id() == collection_id){
                        if (collection.getCards().isEmpty()){
                            collection.setCards(new ArrayList<>());
                        }
                        collection.getCards().add(card);
                        toBeRemoved = card;
                        System.out.println("Card added to collection with the ID of " + collection.getCol_id());
                    } else {
                        System.out.println("Card couldn't be added to the ID of " + collection_id);
                    }
                }
            } else {
                System.out.println("Card couldn't be added to the collection with the ID of " + card_id);
            }
        }
        cards.remove(toBeRemoved);

    }

    public void viewPersonalCollections(int col_id){
        if (!collections.isEmpty()){
            for (PersonalCollection collection : collections){
                if (collection.getCol_id() == col_id){
                    System.out.println(collection);
                } else {
                    System.out.println("You must create a collection first! (Option 4)");
                }
            }
        }

    }

    public void addNewCollection(int col_id, String name){

        ArrayList<Card> cards = new ArrayList<>();

        PersonalCollection collection = new PersonalCollection(col_id, name, cards);

        collections.add(collection);

        printCollections();

    }

    public void printCollections(){
        for (PersonalCollection collection : collections){
            System.out.println(collection);
        }
    }

    public void printCardBinder(){
        for (Card card : cards){
            System.out.println("Card ID: " + card.getId());
        }
    }

    public void printCollectionIds(){
        for (PersonalCollection collection : collections){
            System.out.println("Collection ID: " + collection.getCol_id());
        }
    }


}
