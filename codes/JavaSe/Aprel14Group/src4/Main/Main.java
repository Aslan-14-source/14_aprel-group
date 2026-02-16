package Main;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();

		map.put("Ad", "Fidan");
		map.put("Şəhər", "Bolnis");
		map.put("Dövlət", "Gurcustan");

		String enUzunAcar = "";

		for (String acar : map.keySet()) {
			if (acar.length() > enUzunAcar.length()) {
				enUzunAcar = acar;
			}
		}

		System.out.println("Ən uzun açar: " + enUzunAcar);
	}
}
