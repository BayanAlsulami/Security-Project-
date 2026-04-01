/*import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int passengers = 0;
        int days = 0;
        double mileage = 0;

        try {
            System.out.println("Enter number of passengers: ");
            passengers = input.nextInt();

            System.out.println("Enter number of rental days: ");
            days = input.nextInt();

            System.out.println("Enter estimated mileage: ");
            mileage = input.nextDouble();

            //for wrong values like -1, 0
            if (passengers  <= 0 || days <= 0 || mileage < 0) {
                System.out.println("invalid input.");
                return;
            }
            
          //for wrong input type
        } catch (Exception e) {
            System.out.println("invalid input type.");
            return;
        }

        Car[] cars = CarData.getCars();

        System.out.println("Suitable cars: ");
        boolean found = false;

      //for each car in the cars array loop
        for (Car car : cars) {

            if (car.getMaxPassengers() >= passengers){

                double cost = CarService.calculateTotalCost(
                        car.getDailyCost(),
                        days,
                        mileage,
                        car.getMpg()
                );
                
              //display
                System.out.println("Car: " + car.getMakeModel());
                System.out.println("max passengers: " + car.getMaxPassengers());
                System.out.println("Cost: " + cost);
                System.out.println("................................");

                found = true;
            }
        }

        if (!found) {
            System.out.println("No Suitable cars found.");
        }

        input.close();
    }
}
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter number of passengers: ");
            int passengers = input.nextInt();

            System.out.print("Enter number of rental days: ");
            int days = input.nextInt();

            System.out.print("Enter estimated mileage: ");
            double mileage = input.nextDouble();

            // التحقق من المدخلات (Security Requirement)
            if (passengers <= 0 || days <= 0 || mileage < 0) {
                System.out.println("Invalid input: Values must be positive.");
                return;
            }

            Car[] cars = CarData.getCars();
            // استدعاء المنطق الصحيح لاختيار أفضل سيارة
            Car bestCar = CarService.findBestCar(cars, passengers, days, mileage);

            if (bestCar != null) {
                System.out.println("\n--- Best Suitable Car ---");
                System.out.println("Car: " + bestCar.getMakeModel());
                System.out.println("Max Passengers: " + bestCar.getMaxPassengers());

                double totalCost = CarService.calculateTotalCost(
                        bestCar.getDailyCost(), days, mileage, bestCar.getMpg());

                System.out.printf("Total Cost: $%.2f\n", totalCost);
            } else {
                System.out.println("No suitable cars found for " + passengers + " passengers.");
            }

        } catch (Exception e) {
            System.out.println("Error: Invalid input type. Please enter numeric values.");
        } finally {
            input.close();
        }
    }
}