import java.util.*;

public class Main {

    public static void main(String[] args) {

        PersonalCollection personalCollection = new PersonalCollection();

        Scanner input = new Scanner(System.in);
        int choice;

        while (true) {

            try{

                System.out.println("Welcome to the Card Collection Program!");
                System.out.println("Please choose from the following options below!");
                System.out.println("1. Create a card");
                System.out.println("2. Update a card");
                System.out.println("3. Delete a card");
                System.out.println("4. Create a collection");
                System.out.println("5. View collections");
                System.out.println("6. Add a card to a collection");
                System.out.println("0. Exit program");

                choice = input.nextInt();

                switch (choice) {

                    case 0 -> {
                        System.out.println("Exiting the program...");
                        System.exit(0);
                    }
                    // Create a card
                    case 1 -> {
                        if (PersonalCollection.collections.isEmpty()){

                            System.out.println("You must create a new collection first! (Option 4)");

                        } else {

                            int id = 0;
                            String name = "";
                            String game = "";
                            float price = 0;
                            String attr1 = "";
                            String attr2 = "";
                            String answer = "";

                            try{
                                System.out.println("What is the ID for your card?");
                                id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Card ID must be an integer.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("What is the name for your card?");
                                name = input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Name must be a string.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("What game is this card for?");
                                game = input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Game must be a string.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("What is the price for your card?");
                                price = input.nextFloat();
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Price must be a floating point number.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("What is the first attribute for your card?");
                                attr1 = input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("First attribute must be a string.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("What is the second attribute for your card?");
                                attr2 = input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Second attribute must be a string.");
                                input.nextLine();
                                break;
                            }

                            System.out.println("Is this a unique card? (Y/N) or (y/n)");
                            try{
                                answer = input.nextLine();
                                if (answer.equalsIgnoreCase("y")) {
                                    boolean unique = true;
                                    personalCollection.createCard(id, name, game, price, attr1, attr2, unique);

                                } else {
                                    boolean unique = false;
                                    personalCollection.createCard(id, name, game, price, attr1, attr2, unique);
                                }
                            } catch (InputMismatchException e){
                                System.out.println("Must not contain numbers and must be either Y, N or y, n");
                            }

                        }

                    }
                    // Update a card
                    case 2 -> {

                        int card_id = 0;
                        String name = "";
                        String game = "";
                        float price = 0;
                        String attr1 = "";
                        String attr2 = "";
                        int col_id = 0;
                        String answer = "";

                        if (PersonalCollection.collections.isEmpty()){
                            System.out.println("You must create a new collection first! (Option 4)");
                        } else {
                            try{
                                personalCollection.printCollectionIds();
                                System.out.println("Which collection ID is the card in?");
                                col_id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Collection ID must be an integer.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("Is the card a unique? (Y/N) or (y/n)");
                                answer = input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Must not contain numbers and must be either Y, N or y, n");
                                input.nextLine();
                                break;
                            }

                            if (answer.equalsIgnoreCase("y")){
                                System.out.println("========================================================================");
                                System.out.println("You CANNOT update a unique card. You must delete that unique card first!");
                                System.out.println("========================================================================");
                            } else {
                                personalCollection.printCollections();
                                try{
                                    System.out.println("What is the Card ID?");
                                    card_id = input.nextInt();
                                    input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("ID must be an integer.");
                                    input.nextLine();
                                    break;
                                }

                                try{
                                    System.out.println("What would you like your updated name to be?");
                                    name = input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("Name must be a string.");
                                    input.nextLine();
                                    break;
                                }

                                try{
                                    System.out.println("What would you like your updated game to be?");
                                    game = input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("Game must be a string.");
                                    input.nextLine();
                                    break;
                                }

                                try{
                                    System.out.println("What would you like your updated price to be");
                                    price = input.nextFloat();
                                    input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("Price must be a floating point number.");
                                    input.nextLine();
                                    break;
                                }

                                try{
                                    System.out.println("What would you like your updated attribute 1 to be?");
                                    attr1 = input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("Attribute 1 must be a string.");
                                    input.nextLine();
                                    break;
                                }

                                try{
                                    System.out.println("What would you like your updated attribute 2 to be?");
                                    attr2 = input.nextLine();
                                } catch (InputMismatchException e){
                                    System.out.println("Attribute 2 must be a string.");
                                    input.nextLine();
                                    break;
                                }

                                personalCollection.updateCard(name, game, price, attr1, attr2, col_id, answer, card_id);
                                System.out.println("Card updated successfully.");
                            }
                        }
                    }
                    // Delete a card
                    case 3 -> {

                        int id = 0;
                        int card_id = 0;

                        if (PersonalCollection.collections.isEmpty()){
                            System.out.println("You must create a new collection first! (Option 4)");
                        } else {
                            personalCollection.printCollections();

                            try{
                                System.out.println("Which collection ID would you like to delete a card from?");
                                id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Collection ID must be a number.");
                                input.nextLine();
                                break;
                            }

                            try{
                                System.out.println("Which card ID would you like to delete from this collection?");
                                card_id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Card ID must be a number.");
                                input.nextLine();
                                break;
                            }

                            personalCollection.deleteCard(id, card_id);
                        }
                    }
                    // Create a collection
                    case 4 -> {
                        // create a new collection via user input
                        int col_id = 0;
                        String name = "";

                        try{
                            System.out.println("What ID would you like to give this collection?");
                            col_id = input.nextInt();
                            input.nextLine();
                        } catch (InputMismatchException e){
                            System.out.println("Collection ID must be an integer.");
                            input.nextLine();
                            break;
                        }

                        boolean exists = false;
                        for (PersonalCollection collection : PersonalCollection.collections){
                            if (collection.getCol_id() == col_id){
                                exists = true;
                                break;
                            }
                        }

                        if (!exists){
                            try{
                                System.out.println("What name would you like to give this collection?");
                                name = input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Collection name must be a string.");
                                input.nextLine();
                                break;
                            }
                            personalCollection.addNewCollection(col_id, name);
                        } else {
                            System.out.println("You cannot make a collection with an ID of " + col_id + " as it already exists!");
                        }
                    }
                    // View collections
                    case 5 -> {

                        int col_id = 0;
                        personalCollection.printCollectionIds();

                        if (!personalCollection.getCollections().isEmpty()){
                            try{
                                System.out.println("Which collection ID are you trying to view?");
                                col_id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Collection ID must be a number.");
                                input.nextLine();
                                break;
                            }
                            if (!(col_id == personalCollection.getCol_id())) System.out.println("Personal collection not found.");
                            personalCollection.viewPersonalCollections(col_id);
                        } else {
                            System.out.println("You must create a new collection first! (Option 4).");
                        }
                    }
                    // Add a card to a collection
                    case 6 -> {

                        int collection_id = 0;
                        int card_id = 0;

                        if (PersonalCollection.collections.isEmpty()){
                            System.out.println("You must create a new collection first! (Option 4).");
                        } else {
                            personalCollection.printCollections();

                            try{
                                System.out.println("Which collection ID would you like to add this card to?");
                                collection_id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Collection ID must be a number.");
                                input.nextLine();
                                break;
                            }

                            try{
                                personalCollection.printCardBinder();
                                System.out.println("Which card ID would you like to add to this collection?");
                                card_id = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e){
                                System.out.println("Card ID must be a number.");
                                input.nextLine();
                                break;
                            }
                            personalCollection.addToCollection(card_id, collection_id);
                        }
                    } default -> {
                        System.out.println("Please enter a number between 0-6.");
                    }
                }
            } catch (Exception e){
                System.out.println("Choice must be an integer number between 0-6.");
                input.nextLine();
            }
        }
    }
}