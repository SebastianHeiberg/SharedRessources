package com.company;

public class Catalogue {

  final private Item[] stock;
  private int count;

  public Catalogue(int size) {
    this.stock = new Item[size];
  }

  public void addItem(Item item) {
    stock[count] = item;
    setCount();
  }

  public Item findItem(String description) {

    for (Item item : stock) {
      if (item != null && item.getDescription().equalsIgnoreCase(description)) {
        return item;
      }
    }
    return null;
  }

  public void borrowItem(Item item) {
    item.setAvailable(false);
  }

  public void returnItem(Item item) {
    item.setAvailable(true);
  }

  public Item[] getFullList() {
    return stock;
  }

  public Item[] getAvailableItems() {
    return stock;
  }

  private void setCount() {
    count++;
  }



}
