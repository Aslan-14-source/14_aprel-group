package Devsys;

import java.util.*;

public class Main {
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(12, 4, -6, 8, -9);

		List<Integer> cutEdedler = list.stream().filter(x -> x % 2 == 0).toList();

		List<Integer> ikiqatList = list.stream().map(x -> x * 2).toList();

		System.out.println("Cütlər: " + cutEdedler);
		System.out.println("2-yə vurulmuş: " + ikiqatList);
	}
}