public class DoomedDiceChallenge {

    public static void main(String[] args) {
        int[] dieA = {1, 2, 3, 4, 5, 6};
        int[] dieB = {1, 2, 3, 4, 5, 6};

        // Part 1: Total combinations
        int totalCombinations = dieA.length * dieB.length;
        System.out.println("Total combinations: " + totalCombinations);

        // Part 2: Distribution of all possible combinations
        int[][] combinationsDistribution = new int[7][7];
        for (int faceA : dieA) {
            for (int faceB : dieB) {
                combinationsDistribution[faceA][faceB]++;
            }
        }

        // Displaying the distribution matrix
        System.out.println("Combinations Distribution:");
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                System.out.print(combinationsDistribution[i][j] + "\t");
            }
            System.out.println();
        }

        // Part 3: Probability of all Possible Sums
        System.out.println("Probability of Sums:");
        for (int sum = 2; sum <= 12; sum++) {
            int count = 0;
            for (int i = 1; i <= 6; i++) {
                int j = sum - i;
                if (j >= 1 && j <= 6) {
                    count += combinationsDistribution[i][j];
                }
            }
            double probability = (double) count / totalCombinations;
            System.out.println("P(Sum = " + sum + ") = " + count + "/" + totalCombinations + " = " + probability);
        }
    }
}
