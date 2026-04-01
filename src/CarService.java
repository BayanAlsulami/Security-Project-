
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
// حساب أفضل سيارة بناءً على التكلفة ثم مستوى الراحة
public static Car findBestCar(Car[] cars, int passengers, int days, double mileage) {

    Car bestCar = null; // هنا ستخزن أفضل سيارة يتم العثور عليها
    double lowestCost = Double.MAX_VALUE; // نبدأ بأعلى قيمة ممكنة للمقارنة

    for (int i = 0; i < cars.length; i++) {
        Car car = cars[i]; // تعريف الكائن أولاً للوصول لبياناته

        // التحقق مما إذا كانت السيارة تستوعب عدد الركاب [cite: 3, 42, 45]
        if (car.getMaxPassengers() >= passengers) {

            // حساب التكلفة الإجمالية باستخدام الدوال الجالبة (Getters)
            double totalCost = calculateTotalCost(
                    car.getDailyCost(),
                    days,
                    mileage,
                    car.getMpg()
            );

            // 1. إذا كانت هذه السيارة أرخص من التي قبلها، تصبح هي الأفضل [cite: 2, 46]
            if (totalCost < lowestCost) {
                lowestCost = totalCost;
                bestCar = car;
            }
            // 2. إذا تساوت التكلفة، نختار السيارة ذات مستوى الراحة الأعلى [cite: 46]
            else if (totalCost == lowestCost && bestCar != null) {
                if (getComfortValue(car.getComfortLevel()) > getComfortValue(bestCar.getComfortLevel())) {
                    bestCar = car;
                }
            }
        }
    }

    return bestCar;
}
}