import java.util.*;

class Vehicle {
    double mileage;
    int seats;
    double price;

    public Vehicle(double mileage, int seats, double price) {
        this.mileage = mileage;
        this.seats = seats;
        this.price = price;
    }

    public double[] toArray() {
        return new double[]{mileage, seats, price};
    }
}

// -------------------------------------------------------
// K-MEANS CLUSTERING
// -------------------------------------------------------
class KMeans {
    private int k;
    private List<Vehicle> vehicles;
    private double[][] centroids;

    public KMeans(int k, List<Vehicle> vehicles) {
        this.k = k;
        this.vehicles = vehicles;
        this.centroids = new double[k][3];
    }

    public int[] cluster() {
        Random rand = new Random();

        // Step 1: Initialize centroids randomly
        for (int i = 0; i < k; i++) {
            Vehicle v = vehicles.get(rand.nextInt(vehicles.size()));
            centroids[i] = v.toArray();
        }

        int[] clusterAssignments = new int[vehicles.size()];
        boolean changed = true;

        while (changed) {
            changed = false;

            // Step 2: Assign each vehicle to nearest centroid
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle v = vehicles.get(i);
                int cluster = nearestCentroid(v.toArray());
                if (clusterAssignments[i] != cluster) {
                    clusterAssignments[i] = cluster;
                    changed = true;
                }
            }

            // Step 3: Recompute centroids
            double[][] newCentroids = new double[k][3];
            int[] counts = new int[k];

            for (int i = 0; i < vehicles.size(); i++) {
                int cluster = clusterAssignments[i];
                double[] point = vehicles.get(i).toArray();

                for (int j = 0; j < 3; j++) {
                    newCentroids[cluster][j] += point[j];
                }
                counts[cluster]++;
            }

            for (int i = 0; i < k; i++) {
                if (counts[i] > 0) {
                    for (int j = 0; j < 3; j++) {
                        centroids[i][j] = newCentroids[i][j] / counts[i];
                    }
                }
            }
        }

        return clusterAssignments;
    }

    private int nearestCentroid(double[] point) {
        double minDist = Double.MAX_VALUE;
        int bestCluster = 0;

        for (int i = 0; i < k; i++) {
            double dist = distance(point, centroids[i]);
            if (dist < minDist) {
                minDist = dist;
                bestCluster = i;
            }
        }
        return bestCluster;
    }

    private double distance(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < 3; i++) sum += Math.pow(a[i] - b[i], 2);
        return Math.sqrt(sum);
    }
}

// -------------------------------------------------------
// KNN FOR RECOMMENDATION
// -------------------------------------------------------
class KNN {

    public List<Vehicle> recommend(List<Vehicle> vehicles, Vehicle query, int k) {
        PriorityQueue<VehicleDistance> pq = new PriorityQueue<>(Comparator.comparingDouble(d -> d.distance));

        for (Vehicle v : vehicles) {
            double dist = distance(query.toArray(), v.toArray());
            pq.add(new VehicleDistance(v, dist));
        }

        List<Vehicle> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(pq.poll().vehicle);
        }
        return result;
    }

    private double distance(double[] a, double[] b) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) sum += Math.pow(a[i] - b[i], 2);
        return Math.sqrt(sum);
    }

    private static class VehicleDistance {
        Vehicle vehicle;
        double distance;

        VehicleDistance(Vehicle v, double d) {
            this.vehicle = v;
            this.distance = d;
        }
    }
}

// -------------------------------------------------------
// MAIN PROGRAM
// -------------------------------------------------------
public class KNNKMeansVehicle {

    public static void main(String[] args) {

        // Dataset
        List<Vehicle> vehicles = Arrays.asList(
            new Vehicle(18, 5, 1200),
            new Vehicle(14, 7, 1800),
            new Vehicle(20, 5, 900),
            new Vehicle(12, 7, 2200),
            new Vehicle(22, 5, 800),
            new Vehicle(16, 5, 1500),
            new Vehicle(13, 7, 2000),
            new Vehicle(19, 5, 1100),
            new Vehicle(21, 5, 950)
        );

        // ------------------ KMEANS CLUSTERING ------------------
        KMeans km = new KMeans(3, vehicles);
        int[] clusters = km.cluster();

        System.out.println("=== Vehicle Clusters (K-Means) ===");
        for (int i = 0; i < vehicles.size(); i++) {
            System.out.println("Vehicle " + i + " -> Cluster " + clusters[i]);
        }

        // ------------------ KNN RECOMMENDATION ------------------
        KNN knn = new KNN();

        Vehicle query = new Vehicle(18, 5, 1300); // input vehicle

        System.out.println("\n=== KNN Recommendations ===");
        List<Vehicle> recommendations = knn.recommend(vehicles, query, 3);

        for (Vehicle v : recommendations) {
            System.out.println("Mileage: " + v.mileage + ", Seats: " + v.seats + ", Price: " + v.price);
        }
    }
}
