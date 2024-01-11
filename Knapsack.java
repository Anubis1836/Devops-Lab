import java.util.*;

class Item implements Comparable<Item> {
    int value;
    int weight;
    double ratio;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double) value / weight;
    }

    @Override
    public int compareTo(Item other) {
        return Double.compare(other.ratio, this.ratio);
    }
}

public class Knapsack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum capacity of the knapsack: ");
        int capacity = scanner.nextInt();

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value and weight for item " + (i + 1) + ": ");
            int value = scanner.nextInt();
            int weight = scanner.nextInt();
            items[i] = new Item(value, weight);
        }

        
        Arrays.sort(items);

        double totalValue = 0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
            }
        }

        System.out.println("Maximum value that can be obtained: " + totalValue);

        scanner.close();
    }
}
