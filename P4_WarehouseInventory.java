public class P4_WarehouseInventory {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int sumA = 0;
        int sumB = 0;

        int highestQty = Integer.MIN_VALUE;
        String highestSection = "";
        int highestIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            sumA += sectionA[i];
            sumB += sectionB[i];

            if (sectionA[i] > highestQty) {
                highestQty = sectionA[i];
                highestSection = "Section A";
                highestIndex = i + 1;
            }

            if (sectionB[i] > highestQty) {
                highestQty = sectionB[i];
                highestSection = "Section B";
                highestIndex = i + 1;
            }
        }

        String status = (sumA == sumB) ? "Balanced" : "Not Balanced";

        System.out.println(String.format(
                "Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)",
                sumA, sumB, status, highestQty, highestSection, highestIndex));
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
