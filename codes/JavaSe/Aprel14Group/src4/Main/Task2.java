package Main;

import java.util.HashMap;
import java.util.Map;

public class Task2 {
	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();

		map.put("Riyaziyyat", 90);
		map.put("Fizika", 80);
		map.put("Kimya", 70);

		int cem = 0;

		for (int deyer : map.values()) {
			cem += deyer;
		}

		double orta = (double) cem / map.size();

		System.out.println("Ortalama: " + orta);
	}
}