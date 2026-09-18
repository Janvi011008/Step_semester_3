import java.text.DecimalFormat;
import java.util.Random;

public class TeamBmiCalculator {

    // Threshold constants for BMI classification
    private static final double UNDERWEIGHT_LIMIT = 18.5;
    private static final double NORMAL_LIMIT = 24.9;
    private static final double OVERWEIGHT_LIMIT = 29.9;

    // Decimal formatter for 2-decimal display    
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    // Computes single BMI value with unchecked exception validation
    public static double computeBmi(double weightKg, double heightM) {
        if (heightM <= 0) {
            throw new IllegalArgumentException("Height must be greater than zero. Received: " + heightM);
        }
        if (weightKg <= 0) {
            throw new IllegalArgumentException("Weight must be greater than zero. Received: " + weightKg);
        }
        return weightKg / (heightM * heightM);
    }

    // Classifies health status based on standard ranges
    public static String getBmiStatus(double bmi) {
        if (bmi < UNDERWEIGHT_LIMIT) {
            return "Underweight";
        } else if (bmi <= NORMAL_LIMIT) {
            return "Normal";
        } else if (bmi <= OVERWEIGHT_LIMIT) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Generates formatted table output for parallel arrays
    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null) {
            throw new NullPointerException("Input arrays cannot be null.");
        }
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Mismatched data: heights and weights must have equal lengths.");
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n", 
                          "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            try {
                double currentBmi = computeBmi(weights[i], heights[i]);
                String currentStatus = getBmiStatus(currentBmi);

                System.out.printf("%-10s | %-12s | %-12s | %-8s | %-12s%n",
                        "Person " + (i + 1),
                        DECIMAL_FORMAT.format(heights[i]),
                        DECIMAL_FORMAT.format(weights[i]),
                        DECIMAL_FORMAT.format(currentBmi),
                        currentStatus);
            } catch (IllegalArgumentException ex) {
                System.out.printf("%-10s | Error processing record: %s%n", "Person " + (i + 1), ex.getMessage());
            }
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        try {
            int teamSize = 10;
            double[] heights = new double[teamSize];
            double[] weights = new double[teamSize];

            // Generating sample wellness data: Height 1.50-1.95m, Weight 50-105kg
            Random randomGenerator = new Random(42); // Fixed seed for reproducible demo run
            for (int i = 0; i < teamSize; i++) {
                heights[i] = 1.50 + (0.45 * randomGenerator.nextDouble());
                weights[i] = 50.0 + (55.0 * randomGenerator.nextDouble());
            }

            printWellnessReport(heights, weights);

        } catch (Exception e) {
            System.err.println("Fatal execution error in report processing: " + e.getMessage());
        }
    }
}
