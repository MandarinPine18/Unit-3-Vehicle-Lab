class Sedan extends Vehicle {
  public Sedan(String model, int power, int weight, int speed)  {
    super(model, power, weight, speed, 100, "small");
    super.type = "Sedan";
  }

  @Override
  public String whatCondition() {
    String status;
    if (condition == 100) {
      status = "perfect";
    } else if (condition >= 50) {
      status = "good";
    } else {
      status = "bad";
    }
    return "The " + model + "'s condition is " + status;
  }
}