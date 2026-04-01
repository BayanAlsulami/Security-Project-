public class CarData {
    public static Car[] getCars() {
        return new Car[] {
                // 1. Economy Group ($45) - Category: Coupe [cite: 20, 21, 24]
                new Car("2024 Toyota GR86", 4, "Poor", 45.0, 25.0, "Coupe"),
                new Car("2024 Subaru BRZ", 4, "Poor", 45.0, 24.0, "Coupe"),

                // 2. Intermediate Group ($50) - Categories: Sedan, Hybrid [cite: 25, 26, 29]
                new Car("2024 Honda Accord", 4, "Medium", 50.0, 32.0, "Sedan"),
                new Car("2024 Toyota Prius", 4, "Medium", 50.0, 52.0, "Hybrid"),
                new Car("2024 Hyundai Elantra", 4, "Medium", 50.0, 36.0, "Sedan"),

                // 3. Standard Group ($55) - Categories: Truck, Crossover, SUV [cite: 30, 31, 34]
                new Car("2024 Ford F-150", 5, "Good", 55.0, 20.0, "Truck"),
                new Car("2024 Mazda CX-5", 5, "Good", 55.0, 28.0, "Crossover"),
                new Car("2024 Chevrolet Tahoe", 5, "Good", 55.0, 18.0, "SUV"),
                new Car("2024 Jeep Wrangler", 5, "Good", 55.0, 21.0, "SUV"),

                // 4. Van Group ($70) - Category: Van/Minivan [cite: 35, 36, 39]
                new Car("2024 Chrysler Pacifica", 7, "Medium", 70.0, 22.0, "Van/Minivan")
        };
    }
}