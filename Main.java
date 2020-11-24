//Name: Ethan Parab
//Class Period: 5

// quick note in the readme

import java.util.Scanner;

class Main {
  // create scanner object
  private static final Scanner input = new Scanner(System.in);

  public static void main(String[] args) {
    // ask for the users name
    String username;
    while (true) {
      try {
        username = input("Name: ");
        if (username.equals("")) {
          throw new IllegalArgumentException();
        }
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("You must enter your name. Try again.");
      }
    }

    System.out.println("\nHello, " + username + ". Welcome to the vehicle creator. Here, you can create any vehicle you want! Let's go!");
    // ask which car they would like to create
    System.out.print("\nWhat vehicle would you like to create? Options are:\n1. Sedan\n2. SUV\n3. Semi truck\n(Enter 1, 2, or 3): ");

    int carChoice;

    // a try loop was the simplest way I could think of to deal with bad input here
    // the basic idea here is to get a value in the set {1, 2, 3}
    // if the user does not do this, they will get as many tries as it takes for them to get it right
    while (true) {
      try {
        carChoice = Integer.parseInt(input.nextLine());

        // Integer.valueOf() does not account for the fact [1,3] is the only interval I can take, so I raise this exception to do that
        if (carChoice < 1 || carChoice > 3) {
          throw new IllegalArgumentException();
        }

        break;
      } catch (RuntimeException e) {
        System.out.print("You didn't enter a valid input. It's okay, just try again and make sure you type in 1, 2, or 3: ");
      }
    }

    // the Vehicle class contains a template for all behaviors and attributes for a character. Sedan, SUV, and SemiTruck are all subclasses of it
    Vehicle vehicle;

    //ask user for the name of the vehicle and its attributes
    //make sure to call the correct constructor and apply the variables
    // in the proper order.
    System.out.println("\nWhat is the model and attributes of your vehicle?");

    String model;
    int power;
    int weight;
    int speed;

    // model input checking
    while (true) {
      try {
        model = input("Model: ");
        if (model.equals("")) {
          throw new IllegalArgumentException();
        }
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("You must enter a model. Try again.");
      }
    }

    System.out.println("\nFor the following attributes, please input an integer in range [0,100].");

    // power input checking
    while (true) {
      try {
        power = checkNum(Integer.parseInt(input("Power: ")));
        break;
      } catch (IllegalArgumentException e) {
        System.out.print("You didn't enter a valid input. It's okay, just try again and make sure you type in an integer in range [0, 100]. \n");
      }
    }

    // weight input checking
    while (true) {
      try {
        weight = checkNum(Integer.parseInt(input("Weight: ")));
        break;
      } catch (IllegalArgumentException e) {
        System.out.print("You didn't enter a valid input. It's okay, just try again and make sure you type in an integer in range [0, 100]. \n");
      }
    }

    // speed input checking
    while (true) {
      try {
        speed = checkNum(Integer.parseInt(input("Speed: ")));
        break;
      } catch (IllegalArgumentException e) {
        System.out.print("You didn't enter a valid input. It's okay, just try again and make sure you type in an integer in range [0, 100]. \n");
      }
    }

    // initialize the object based on prior input
    if (carChoice == 1) {
      vehicle = new Sedan(model, power, weight, speed);
    } else if (carChoice == 2) {
      vehicle = new SUV(model, power, weight, speed);
    } else if (carChoice == 3) {
      vehicle = new SemiTruck(model, power, weight, speed);
    } else {
      // theoretically, this is impossible, but it's better to have a failsafe
      vehicle = new Vehicle("", 0, 0, 0, 0, "");
      System.exit(1);
    }

    // print out the details of the new vehicle
    System.out.println("\n" + vehicle);
    System.out.println(vehicle.whatCondition() + "\n");


    // enter quasi-CLI interface
    System.out.println("Now you can control your vehicle. Acceptable commands are as follows:\n" +
            "\"drive {num}\" - reduces the condition of your car, {num} must be an integer in range [0, 100]\n" +
            "\"service\" - brings car condition to max value\n" +
            "\"output\" - prints the details of the character\n" +
            "\"exit\" - exits the program\n");
    while (true) {
      command(vehicle);
    }
  }

  // this makes it easier for me to accept input
  // if I want to dig into the specifics of input (i.e. character choice loop) will just do use the input object instead
  private static String input(String prompt) {
    System.out.print(prompt);
    return input.nextLine();
  }

  private static void command(Vehicle vehicle) {
    try {
      String command = input("> ");
      int numValue;
      if (command.startsWith("drive ")) {
        numValue = Integer.parseInt(command.substring(6));
        checkNum(numValue);
        vehicle.changeCondition(numValue * -1);
        System.out.println(vehicle.whatCondition());
      } else if (command.startsWith("service")) {
        vehicle.changeCondition(100);
        System.out.println(vehicle.whatCondition());
      } else if (command.startsWith("output")) {
        System.out.println(vehicle);
        System.out.println(vehicle.whatCondition());
      } else if (command.startsWith("exit")) {
        System.out.println("Goodbye!");
        System.exit(0);
      } else {
        throw new IllegalArgumentException();
      }
    } catch (NumberFormatException e) {
      System.out.println("Try again, make sure if you drive the vehicle, you type an integer in range [0, 100].");
    } catch (IllegalArgumentException e) {
      System.out.println("Try again, make sure you use \"drive\", \"service\", \"output\", or \"exit\" and follow the first one with in integer in range [0, 100] after a space.");
    }
  }

  // makes sure the number is in range [0, 100]
  // it returns the int just for convenience
  private static int checkNum(int num) {
    if (num > 100 || num < 0) {
      throw new NumberFormatException();
    }
    return num;
  }
}