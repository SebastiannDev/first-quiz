package org.velezreyes.quiz.question6;

import java.util.HashMap;

public class VendingMachineImpl implements VendingMachine {

  // === variables and instances ===
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

  @Override
  public Drink pressButton(String name)
      throws NotEnoughMoneyException, UnknownDrinkException {

    if (coins_bag < 3) {
      throw new NotEnoughMoneyException();
    }

    // Dictionary
    HashMap<Integer, String> drinks = new HashMap<>();
    drinks.put(3, "ScottCola");
    drinks.put(4, "KarenTea");

    if (drinks.containsValue(name)) {
      return buy_drink(coins_bag, name);
    }
    
    throw new UnknownDrinkException();
  }
  
  private Drink buy_drink(int coins, String name) throws NotEnoughMoneyException {
    System.out.println(coins_bag + " " + name);
    if (coins >= 3 && name.equals("ScottCola")) {
      coins_bag = 0;
      return new DrinkImp("ScottCola", true);
    }

    if (coins >= 4 && name.equals("KarenTea")) {
      coins_bag = 0;
      return new DrinkImp("KarenTea", false);
    }

    throw new NotEnoughMoneyException();
  }

}
