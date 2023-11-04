package org.velezreyes.quiz.question6;

import java.util.HashMap;
import java.util.Map;

public class VendingMachineImpl implements VendingMachine {

  // === variables & instances ===
  private static VendingMachine vm;
  private static int coins_bag = 0;

  private VendingMachineImpl() {
    // Constructor protected for singleton...
  }

  public static VendingMachine getInstance() {
    if (vm == null) {
      return new VendingMachineImpl();
    }
    return vm;
  }

  @Override
  public void insertQuarter() {
    coins_bag++;
  }

  /**
   * Can add more items to HashMap to validate if can buy, the key is the name of
   * the drink and the Value is used for return the drink
   * 
   * @param name accept name of drink wish get.
   */
  @Override
  public Drink pressButton(String name) throws NotEnoughMoneyException, UnknownDrinkException {

    if (coins_bag < 3) {
      throw new NotEnoughMoneyException();
    }

    HashMap<String, DrinkImp> drinks = new HashMap<>();

    drinks.put("ScottCola", new DrinkImp("ScottCola", true, 3));
    drinks.put("KarenTea", new DrinkImp("KarenTea", false, 4));

    if (!drinks.containsKey(name)) {
      throw new UnknownDrinkException();
    }

    for (Map.Entry<String, DrinkImp> drink_item : drinks.entrySet()) {

      Integer price_item = drink_item.getValue().getPrice();
      String name_item = drink_item.getKey();

      if (coins_bag >= price_item && name_item.equals(name)) {
        coins_bag = 0;
        return drink_item.getValue();
      }
    }

    throw new NotEnoughMoneyException();
  }
}
