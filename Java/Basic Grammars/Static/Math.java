package Static;

public class Math {

    public static int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        return sum;
    }

    public static int average(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum = sum + value;
        }
        return (sum / values.length);
    }

    public static int min(int[] values) {
        int min = values[0];
        for (int value : values) {
            if (min > value) {
                min = value;
            }
        }
        return min;
    }

    public static int max(int[] values) {
        int max = values[0];
        for (int value : values) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }
}
