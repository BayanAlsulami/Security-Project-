
class CarService {
	
// حساب الايجار
	//simplicity of design
    public static double calculateRentalCost(double dailyRate, int days) {
        return dailyRate * days;
    }
//حساب البنزين
    public static double calculateFuelCost(double mileage, double mpg) {
        double gasPrice = 2.25;
        return (mileage / mpg) * gasPrice;
    }
//حساب توتال التكلفه
  //component integration
    public static double calculateTotalCost(double dailyRate, int days, double mileage, double mpg) {
        return calculateRentalCost(dailyRate, days) + calculateFuelCost(mileage, mpg);//نجمعهم
    }

    // نحول مستوى الراحة إلى رقم عشان نقارن
    // abstraction
    public static int getComfortValue(String comfort) {
        if (comfort.equalsIgnoreCase("Poor")) return 1;
        if (comfort.equalsIgnoreCase("Medium")) return 2;
        if (comfort.equalsIgnoreCase("Good")) return 3;
        return 0;
    }
    //least privilege
    
//نحسب افضل سيارة
    public static Car findBestCar(Car[] cars, int passengers, int days, double mileage) {

        Car bestCar = null;// هنا تتخزن افضل سيارة
        double lowestCost = Double.MAX_VALUE;//simplicity of design

        for (هnt i=0 ; i<cars.length ; i++) {
//اذا السياره تتحمل عدد الركاب
        	//least privilege
            if (car.maxPassengers >= passengers) {
            	Car car = cars[i];
//توتال التكلفه لهالسياره
                double totalCost = calculateTotalCost(
                        car.dailyRate,
                        days,
                        mileage,
                        car.mpg
                );

                //اذا هذي ارخص من اللي قبلها تصير هي الافضل
                if (totalCost < lowestCost) {
                    lowestCost = totalCost;
                    bestCar = car;
                }

                // هذي الاضافه حقت اذا سيارتين نفس السعر يصير ناخذ الcomfort 
                else if (totalCost == lowestCost && bestCar != null) {

                    // نقارن الراحة
                    if (getComfortValue(car.comfortLevel) > getComfortValue(bestCar.comfortLevel)) {
                        bestCar = car;
                    }
                }
            }
        }

        return bestCar;
    }
}