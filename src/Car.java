public class Car {
    private String makeModel;
    private int maxPassengers;
    private String comfortLevel; // Poor, Medium, Good
    private double dailyCost;
    private double mpg; // Miles Per Gallon (استهلاك الوقود)
    private String category; // SUV, Sedan, etc.

    public Car(String makeModel, int maxPassengers, String comfortLevel, double dailyCost, double mpg, String category) {
        this.makeModel = makeModel;
        this.maxPassengers = maxPassengers;
        this.comfortLevel = comfortLevel;
        this.dailyCost = dailyCost;
        this.mpg = mpg;
        this.category = category;
    }

    // Getters
    public String getMakeModel() { return makeModel; }
    public int getMaxPassengers() { return maxPassengers; }
    public String getComfortLevel() { return comfortLevel; }
    public double getDailyCost() { return dailyCost; }
    public double getMpg() { return mpg; }
}