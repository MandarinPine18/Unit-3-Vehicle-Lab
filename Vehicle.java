public class Vehicle {
  private String model;
  private int condition;
  private int power;
  private int weight;
  private int speed;
  private String size;
  protected String type = "vehicle";   // meant to be changed by subclass

  protected Vehicle(String model, int power, int weight, int speed, int condition, String size) {
    this.model = model;
    this.power = power;
    this.weight = weight;
    this.speed = speed;
    this.condition = condition;
    this.size = size;
  }

  public String toString() {
    return "You have created  a "+ model + " which is a " + inDefArtWord(type.toLowerCase()) + " with " + condition + " condition.  It is a " + size + " vehicle.  It has the following characteristics:\nPower: " + power +"\nWeight: " + weight + "\nStealth: " + speed;
  }
  
  // this is just to tack on the right indefinite article (a or an) to the word given
  // suv is a special pronunciation, so I'm just going to hard-code it
  private String inDefArtWord(String word) {
    switch (word.toLowerCase()) {
      case ("sedan"):
      case ("semi truck"): {
        return "a " + word;
      }
      case ("suv"): {
        return "an " + word;
      }
      default: {
        return word;
      }
    }
  }

  //add howMuchHealth method here.
  public String whatCondition() {
    String status;
    if (condition == 100) {
      status = "perfect";
    } else if (condition >= 50) {
      status = "good";
    } else {
      status = "bad";
    }
    return "The " + model + "'s health is " + status;
  }

  public void changeCondition(int change) {
    condition +=change;
    if (condition < 0) {
      condition = 0;
    } else if (condition > 100) {
      condition = 100;
    }
  }
}