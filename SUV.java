class SUV extends Vehicle {
  public SUV(String model, int power, int weight, int speed) {
    super(model, power, weight, speed, 100, "medium");
    super.type = "SUV";
  }

  // implemented separately due to direction specifics
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
    return "The " + model + "'s condition is " + condition + ", which is " + status + ".";
  }
}