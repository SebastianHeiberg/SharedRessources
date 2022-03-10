package com.company;

public class Item {

  private String category;
  private String description;
  private boolean available;
  private String borrowerName;
  private String borrowerAdress;
  private String ownerName;
  private String ownerAdress;

  Item(String category, String description, String ownerName, String ownerAdress) {
    this.category = category;
    this.description = description;
    this.available = true;
    this.borrowerAdress = "null";
    this.borrowerName = "null";
    this.ownerName = ownerName;
    this.ownerAdress = ownerAdress;

  }

  public void setBorrowerName(String borrowerName) {
    this.borrowerName = borrowerName;
  }

  public void setBorrowerAdress(String borrowerAdress) {
    this.borrowerAdress = borrowerAdress;
  }

  public String getBorrowerName() {
    return borrowerName;
  }

  public String getBorrowerAdress() {
    return borrowerAdress;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public String getOwnerAdress() {
    return ownerAdress;
  }

  public String getCategory() {
    return category;
  }

  public boolean isAvailable() {
    return available;
  }

  public String getDescription() {
    return description;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }
}
