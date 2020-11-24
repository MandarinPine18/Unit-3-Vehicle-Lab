public class Vehicle {
  protected String model;
  protected int condition;
  protected int power;
  protected int weight;
  protected int speed;
  protected String size;
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

  // based on the specific wording of the directions, I left it to the subclasses to implement this method
  public String whatCondition() {
    return "";
  }

  // a getter which deals with overflow from range [0, 100] by overriding the value given
  public void changeCondition(int change) {
    condition +=change;
    if (condition < 0) {
      condition = 0;
    } else if (condition > 100) {
      condition = 100;
    }
  }
}