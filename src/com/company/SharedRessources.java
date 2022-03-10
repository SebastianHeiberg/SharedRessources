package com.company;

import java.util.Scanner;

public class SharedRessources {
  public final UserInterface userInterface = new UserInterface();
  final private Scanner keyboard = new Scanner(System.in);
  final private Catalogue catalogue = new Catalogue(10);

  private String inputDescription() {
    userInterface.displayInputDescription();
    return keyboard.nextLine();
  }

  private String inputCategory() {
    userInterface.displayInputCategory();
    return keyboard.nextLine();
  }

  private String inputName() {
    userInterface.displayInputName();
    return keyboard.nextLine();
  }

  private String inputAdress() {
    userInterface.displayInputAdress();
    return keyboard.nextLine();
  }

  public void mainMenu() {
    addSomeItems();

    boolean loop = true;
    while (loop) {

      userInterface.displayOptions();

      // Read user choice
      Scanner scanner = new Scanner(System.in);
      int choice = scanner.nextInt();

      switch (choice) {
        case 1 -> { // get all items in catalogue
          Item[] allItems = catalogue.getFullList();
          System.out.println();
          for (Item allItem : allItems) {
            if (allItem != null) {
              userInterface.displayAllItems(allItem);
            }
          }
          System.out.println();
        }

        case 2 -> { // get available items in catalogue
          Item[] availableItems = catalogue.getAvailableItems();
          System.out.println();
          for (Item availableItem : availableItems) {

            if (availableItem != null && availableItem.isAvailable()) {
              userInterface.displayAllItems(availableItem);
            }
          }
        }

        case 3 -> // Add new Item to catalogue
            catalogue.addItem(new Item(inputCategory(), inputDescription(), inputName(), inputAdress()));

        case 4 -> { // make item unavailable
          Item found = catalogue.findItem(inputDescription());
          if (found != null && found.isAvailable()) { //Item findes
            catalogue.borrowItem(found);
            found.setBorrowerName(inputName());
            found.setBorrowerAdress(inputAdress());
          } else if (found != null && !found.isAvailable()) { //item er udlånt
            userInterface.displayIsNotAvailable();
          } else {
            userInterface.displayItemNotFound(); //item findes ikke
          }
        }

        case 5 -> { // make item available again
          Item found = catalogue.findItem(inputDescription());
          if (found != null && !found.isAvailable()) { // item can be returned
            catalogue.returnItem(found);
            found.setBorrowerAdress("Null");
            found.setBorrowerName("Null");
          } else if (found != null && found.isAvailable()) { //item is not yet borrowed
            userInterface.displayInvalidChoise();
          } else {
            userInterface.displayItemNotFound(); //item does not exist
          }
        }

        case 6 -> { // all info on item
          Item found = catalogue.findItem(inputDescription());
          if (found != null) { //Item findes
            userInterface.displayAllInfoOnItem(found);

          } else {
            userInterface.displayItemNotFound(); //item findes ikke
          }
        }

        case 7 -> // Ends loop menu
            loop = false;

        default -> // display invalid choice
            userInterface.displayInvalidChoise();
      }
    }
  }

  public void addSomeItems() {
    Item item1 = new Item("Sport", "Skateboard", "Patrick", "Strandvejen 15");
    catalogue.addItem(item1);
    Item item2 = new Item("Sport", "Mountainbike", "Ulrick", "Lyngbyhovedgade 10");
    catalogue.addItem(item2);
    Item item3 = new Item("Tøj", "Smoking", "Jens", "Buen 14");
    catalogue.addItem(item3);
    Item item4 = new Item("Tøj", "Pallietkjole", "Ib", "Hovedgaden 12");
    catalogue.addItem(item4);
  }

  public static void main(String[] args) {

    SharedRessources obj = new SharedRessources();
    obj.mainMenu();

  }

}
