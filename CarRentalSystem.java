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
        availableCars = new Car[]{
            new Car("🚗 Toyota Camry", 50),
            new Car("🚙 Honda Accord", 45),
            new Car("🏎️ Ford Mustang", 80),
            new Car("🚘 Tesla Model S", 100)
        };
    }

    
    public void displayAvailableCars() {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║             🌟 AVAILABLE CARS FOR RENT 🌟     ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        for (int i = 0; i < availableCars.length; i++) {
            System.out.printf("║ %d. %-20s | Price: $%-6.2f/day ║\n", (i + 1), availableCars[i].getCarName(), availableCars[i].getPricePerDay());
        }
        System.out.println("╚════════════════════════════════════════════════╝\n");
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
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║              🔖 CONFIRMATION SLIP 🔖            ║");
        System.out.println("╠════════════════════════════════════════════════╣");
        System.out.printf("║ 👤 User: %-38s ║\n", name);
        System.out.printf("║ 🚗 Car: %-39s ║\n", car.getCarName());
        System.out.printf("║ 📅 Rental Days: %-30d ║\n", days);
        System.out.printf("║ 💲 Total Cost: $%-32.2f ║\n", car.calculateRentalCost(days));
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("✨ We hope you enjoy your ride! Thank you for choosing us! ✨\n");
    }
}


public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("║           🚗  WELCOME TO CAR RENTAL SYSTEM  🚗  ║");
        System.out.println("║        Your journey to a smooth ride starts here!║");
        System.out.println("╚══════════════════════════════════════════════════╝\n");
        
        
        System.out.print("👤 Enter your name: ");
        String userName = scanner.nextLine();
        
      
        RentalSystem rentalSystem = new RentalSystem();
        
     
        rentalSystem.displayAvailableCars();
        
        
        System.out.print("🚘 Please select a car by number: ");
        int carChoice = scanner.nextInt();
        
        
        Car selectedCar = rentalSystem.rentCar(carChoice);
        
       
        if (selectedCar != null) {
           
            System.out.print("📅 Enter number of rental days: ");
            int days = scanner.nextInt();
            
          
            User user = new User(userName, days);
            
            user.generateConfirmationSlip(selectedCar);
        } else {
            System.out.println("❌ Invalid car selection! Please try again.");
        }
        
        scanner.close();
    }
}
