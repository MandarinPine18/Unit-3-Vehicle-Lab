class Sedan extends Vehicle {
  public Sedan(String model, int power, int weight, int speed)  {
    super(model, power, weight, speed, 100, "small");
    super.type = "Sedan";
  }
}