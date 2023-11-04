package org.velezreyes.quiz.question6;

public interface Drink {
  public String getName();

  public boolean isFizzy();
}

class DrinkImp implements Drink {

  private String name;
  private Boolean isFizzy;
  private Integer price;

  public DrinkImp(String name, Boolean isFizzy, Integer price){
    this.name = name;
    this.isFizzy = isFizzy;
    this.price = price;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public boolean isFizzy() {
    return this.isFizzy;
  }

  public Integer getPrice(){
    return this.price;
  }

}