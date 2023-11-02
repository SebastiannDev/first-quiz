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
        return null;
  }
}
