import java.util.Scanner;
class Car {
  private String carName;
  private double pricePerDay;

  public Car(String carName, double pricePerDay) {
    this.carName = carName;
    this.pricePerDay = pricePerDay;
  }

  public String getCarName() {
    return carName;
  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public double calculateRentalCost(int days) {
    return days * pricePerDay;
  }
}

class RentalSystem {
  private Car[] availableCars;

 
  public RentalSystem() {
    availableCars = new Car[] {
        new Car("Toyota Camry", 50),
        new Car("Honda Accord", 45),
        new Car("Ford Mustang", 80),
        new Car("Tesla Model S", 100)
    };
  }

 
  public void displayAvailableCars() {
    System.out.println("Available Cars:");
    for (int i = 0; i < availableCars.length; i++) {
      System.out.println(
          (i + 1) + ". " + availableCars[i].getCarName() + " - $" + availableCars[i].getPricePerDay() + "/day");
    }
  }

  public Car rentCar(int choice) {
    if (choice >= 1 && choice <= availableCars.length) {
      return availableCars[choice - 1];
    } else {
      return null;
    }
  }
}


class User {
  private String name;
  private int days;

 
  public User(String name, int days) {
    this.name = name;
    this.days = days;
  }

  
  public void generateConfirmationSlip(Car car) {
    System.out.println("\nConfirmation Slip");
    System.out.println("------------------");
    System.out.println("User: " + name);
    System.out.println("Car: " + car.getCarName());
    System.out.println("Days: " + days);
    System.out.println("Total Cost: $" + car.calculateRentalCost(days));
    System.out.println("------------------\nThank you for renting with us!");
  }
}


public class CarRentalSystems {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

   
    System.out.println("Welcome to Car Rental System!");

    
    System.out.print("Enter your name: ");
    String userName = scanner.nextLine();

   
    RentalSystem rentalSystem = new RentalSystem();

    
    rentalSystem.displayAvailableCars();

   
    System.out.print("Select a car by number: ");
    int carChoice = scanner.nextInt();

   
    Car selectedCar = rentalSystem.rentCar(carChoice);

   
    if (selectedCar != null) {
      
      System.out.print("Enter number of rental days: ");
      int days = scanner.nextInt();

     
      User user = new User(userName, days);

      
      user.generateConfirmationSlip(selectedCar);
    } else {
      System.out.println("Invalid car selection.");
    }

    scanner.close();
  }
}
