class SUV extends Vehicle {
  public SUV(String model, int power, int weight, int speed) {
    super(model, power, weight, speed, 100, "medium");
    super.type = "SUV";
  }
}