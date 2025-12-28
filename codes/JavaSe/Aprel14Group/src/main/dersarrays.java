package main;
import java.util.Arrays;
import java.util.Scanner;
public class dersarrays {


		    public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);

		        int[] arr = new int[10];
		        System.out.println("10 ədəd tam ədəd daxil edin:");
		        for (int i = 0; i < arr.length; i++) {
		            arr[i] = sc.nextInt();
		        }

		        System.out.println("Daxil edilən massiv: " + Arrays.toString(arr));

		        Arrays.sort(arr);
		        System.out.println("Sort edilmiş massiv: " + Arrays.toString(arr));

		        int[] newArr = Arrays.copyOf(arr, 5);
		        System.out.println("İlk 5 elementdən ibarət massiv: " + Arrays.toString(newArr));

		        Arrays.fill(newArr, 7);
		        System.out.println("7 ilə doldurulmuş yeni massiv: " + Arrays.toString(newArr));

		        boolean equal = Arrays.equals(arr, newArr);
		        System.out.println("İki massiv bərabərdir? " + equal);
		        System.out.print("Axtarmaq istədiyiniz elementi daxil edin: ");
		        int target = sc.nextInt();

		        int index = Arrays.binarySearch(arr, target);

		        if (index >= 0) {
		            System.out.println("Bu element massivdə var");
		        } else {
		            System.out.println("Bu element massivdə yoxdur");
		        }
		    
		}



}
