package com.company;

public class UserInterface {

  public UserInterface() {
  }

  public void displayInputDescription() {
    System.out.println();
    System.out.print("input description: ");
  }

  public void displayInputCategory() {
    System.out.println();
    System.out.print("input category: ");
  }

  public void displayOptions() {
    System.out.println();
    System.out.println("What would you like to do?");
    System.out.println("1. Display all items");
    System.out.println("2. Check available items");
    System.out.println("3. Create new item");
    System.out.println("4. Borrow item");
    System.out.println("5. Return item");
    System.out.println("6. ALL info on item");
    System.out.println("7. Exit program");
    System.out.print("Input choice: ");
  }

  public void displayItemNotFound () {
    System.out.println();
    System.out.println("Item not found.");
  }

  public void displayInvalidChoise () {
    System.out.println();
    System.out.println("Invalid choice.");
  }

  public void displayIsNotAvailable () {
    System.out.println("Item is already borrowed");
  }

  public void displayInputName () {
    System.out.print("Input your name: ");
  }

  public void displayInputAdress () {
    System.out.print("Input your adress: ");
  }

 public void displayAllItems (Item item) {
   System.out.printf("""
                  Category: %-7s Description: %-15s Available: %s
                  """, item.getCategory(), item.getDescription(), item.isAvailable());
 }

 public void displayAllInfoOnItem (Item item) {
    System.out.printf("""
                  
                  Category: %-7s Description: %-10s   Available: %s
                  Owner Name: %-7s Owner adress: %-7s
                  Borrower Name: %-7s Borrower adress: %-7s
                  """, item.getCategory(), item.getDescription(), item.isAvailable(),item.getOwnerName(),item.getOwnerAdress(),item.getBorrowerName(),item.getBorrowerAdress());
  }
}

