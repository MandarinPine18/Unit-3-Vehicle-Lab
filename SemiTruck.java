class SemiTruck extends Vehicle {
  public SemiTruck(String model, int power, int weight, int speed) {
    super(model, power, weight, speed, 100, "large");
    super.type = "Semi Truck";
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