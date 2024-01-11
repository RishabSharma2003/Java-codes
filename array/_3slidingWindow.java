public class _3slidingWindow {
    public static void main(String[] args) {
        int arr[] = { 2, 2, -3, 2, 3, 1, -2, 10, 2, -4 };
        int k = 3, sum = 0;

        for (int i = 0; i < k; i++)
            sum += arr[i];
        int max = sum;

        for (int i = k; i < arr.length; i++) {
            sum += arr[i];
            sum -= arr[i - k];
            max = Math.max(max, sum);
        }
        System.out.println(max);

    }
}
