//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(system.in);

        int passengers = 0;
        int days = 0;
        double mileage = 0;

        try {
            System.out.println("Enter number of passingers: ");
            passengers = input.nextInt();
            System.out.println("Enter number of rental days: ");
            days = input.nextInt();
            System.out.println("Enter estimated mileage: ");
            mileage = input.nextDouble();

            //for wrong values like -1, 0//
            if (passengers <= 0 || days<=0 || mileage<0 ) {
                System.out.println("invalid input.");
                return;
            }

            //for wrong input type//
        } catch (exception e) {
            System.out.println("invalid input type. ");
            return;
        }

        //
        //
        car[] cars = CarData.getCars();
        //
        //

        System.out.println("Suitable cars: ");
        boolean found = false;


        //for each car in the cars array loop//
        for (Car car : cars) {

            if (car.getMaxPassengers() >= passengers){
                double cost = calculateCost(car, days, mileage);

                //display//
                System.out.println("Car; "+ car.getMakeModel());
                System.out.println("max passengers: "+ car.getMaxPassengers());
                System.out.println("Cost: "+ cost);
                System.out.println("................................");

                found = true;

            }
        }

        if (!found) {
            System.out.println("No Suitable cars found.");
        }

        input.close();

    }

    private static double calculateCost (car car, int days, double mileage) {

        double cost = car.getDailyCost() * days;
        double gasCost = (mileage / car.getMpg()) * 2.25;
        double finalCost = cost + gasCost;

        return finalCost;
    }
}