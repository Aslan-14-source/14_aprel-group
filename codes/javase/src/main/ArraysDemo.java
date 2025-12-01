package main;

public class ArraysDemo {

    public static void main(String[] args) {
        int[] numbers = {3, 9, 12, 15, 21};

        int sum = findSum(numbers);
        System.out.println("Cəm: " + sum);

        double average = findAverage(numbers);
        System.out.println("Orta: " + average);

        int min = findMin(numbers);
        System.out.println("Ən kiçik: " + min);

        printOdd(numbers);
    }

    public static int findSum(int[] arr) {
        int s = 0;
        for(int i = 0; i < arr.length; i++){
            s = s + arr[i];
        }
        return s;
    }

    public static double findAverage(int[] arr) {
        int s = findSum(arr);
        return (double)s / arr.length;
    }

    public static int findMin(int[] arr) {
        int m = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < m){
                m = arr[i];
            }
        }
        return m;
    }

    public static void printOdd(int[] arr) {
        System.out.print("Tək ədədlər: ");
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
}
