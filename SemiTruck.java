class SemiTruck extends Vehicle {
  public SemiTruck(String model, int power, int weight, int speed) {
    super(model, power, weight, speed, 100, "large");
    super.type = "Semi Truck";
  }
}