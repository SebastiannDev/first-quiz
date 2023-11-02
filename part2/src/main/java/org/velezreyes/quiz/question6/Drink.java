package org.velezreyes.quiz.question6;

public interface Drink {
  public String getName();

  public boolean isFizzy();
}

class DrinkImp implements Drink {

  private String name = "";
  private Boolean isFizzy = true;

  public DrinkImp(String name, Boolean isFizzy){
    this.name = name;
    this.isFizzy = isFizzy;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean isFizzy() {
    return this.isFizzy;
  }

}