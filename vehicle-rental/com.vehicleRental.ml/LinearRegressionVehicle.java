import java.util.*;

class Vehicle {
    double mileage;
    double seat;
    double age;
    double price; // rental price (target)

    public Vehicle(double mileage, double seat, double age, double price) {
        this.mileage = mileage;
        this.seat = seat;
        this.age = age;
        this.price = price;
    }
}

class LinearRegression {

    private double[] weights; // w0 (bias), w1, w2, w3
    private double learningRate = 0.0001;

    public LinearRegression(int featureCount) {
        weights = new double[featureCount + 1]; // +1 for bias term
    }

    // Predict y = w0 + w1*x1 + w2*x2 + w3*x3
    public double predict(double[] features) {
        double result = weights[0]; // bias term

        for (int i = 0; i < features.length; i++) {
            result += weights[i + 1] * features[i];
        }

        return result;
    }

    // Train model using Gradient Descent
    public void train(List<Vehicle> data, int epochs) {
        int m = data.size();

        for (int e = 0; e < epochs; e++) {
            double[] gradients = new double[weights.length];

            for (Vehicle v : data) {
                double[] features = {v.mileage, v.seat, v.age};
                double prediction = predict(features);
                double error = prediction - v.price;

                gradients[0] += error; // bias update

                for (int i = 0; i < features.length; i++) {
                    gradients[i + 1] += error * features[i];
                }
            }

            // Update weights
            for (int i = 0; i < weights.length; i++) {
                weights[i] -= (learningRate * gradients[i]) / m;
            }

            // Optional: Print training progress
            if (e % 1000 == 0) {
                System.out.println("Epoch " + e + " - Sample Prediction: " +
                        predict(new double[]{15, 5, 3}));
            }
        }
    }
}

public class LinearRegressionVehicle {

    public static void main(String[] args) {

        // Training Data (Mileage, Seat Count, Age, Rental Price)
        List<Vehicle> dataset = Arrays.asList(
            new Vehicle(18, 5, 2, 1200),
            new Vehicle(17, 5, 3, 1100),
            new Vehicle(12, 7, 5, 2000),
            new Vehicle(22, 5, 1, 800),
            new Vehicle(16, 5, 4, 1500),
            new Vehicle(17, 5, 2, 1400),
            new Vehicle(20, 5, 2, 1300),
            new Vehicle(15, 5, 3, 1250),
            new Vehicle(13, 7, 4, 1800),
            new Vehicle(21, 5, 2, 900)
        );

        LinearRegression lr = new LinearRegression(3);

        System.out.println("Training model...");
        lr.train(dataset, 20000);

        // Predict rental price for new vehicle
        double[] input = {15, 5, 3}; // mileage, seat, age
        double predictedPrice = lr.predict(input);

        System.out.println("\n------------------------------");
        System.out.println("Predicted Rental Price: " + predictedPrice);
        System.out.println("------------------------------");
    }
}
