import java.util.Scanner;

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
