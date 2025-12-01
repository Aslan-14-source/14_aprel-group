package main;
public class ArraysDemoHome {

    public static void main(String[] args) {

        int[] numbers = {12, 5, 8, 20};

        int sum = findSum(numbers);
        System.out.println("Cəm: " + sum);

        printWithForeach(numbers);

        double average = findAverage(numbers);
        System.out.println("Orta: " + average);

        int min = findMin(numbers);
        System.out.println("Ən kiçik: " + min);

        int max = findMax(numbers);
        System.out.println("Ən böyük: " + max);

        printOdd(numbers);

        printEven(numbers);

        printSimple(numbers);

        sortDescending(numbers);
        System.out.println();
    }
    public static int findSum(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s = s + arr[i];
        }
        return s;
    }

    public static void printWithForeach(int[] arr) {
        System.out.print("Foreach ilə: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static double findAverage(int[] arr) {
        int s = findSum(arr);
        return (double)s / arr.length;
    }

    public static int findMin(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < m) {
                m = arr[i];
            }
        }
        return m;
    }

    public static int findMax(int[] arr) {
        int m = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > m) {
                m = arr[i];
            }
        }
        return m;
    }

    public static void printOdd(int[] arr) {
        System.out.print("Tək ədədlər: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static void printEven(int[] arr) {
        System.out.print("Cüt ədədlər: ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    public static void printSimple(int[] arr) {
        System.out.print("Sadə ədədlər: ");
        for (int i = 0; i < arr.length; i++) {
            if (isSimple(arr[i])) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }

    public static boolean isSimple(int n) {
        if (n <= 1) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void sortDescending(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] > arr[i]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }

        System.out.print("Azalan sıra ilə: ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}