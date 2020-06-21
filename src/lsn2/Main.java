package lsn2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] stringArray = reader.readLine().split("\\s");
			int[] array = new int[stringArray.length];

			for (int i = 0; i < stringArray.length; i++) {
				array[i] = Integer.parseInt(stringArray[i]);
			}

			Arrays.sort(array);

			int p1 = 0;
			int p2 = array.length - 1;
			int current1 = 0;
			int current2 = 0;
			int x = 0;
			int y = 0;

			while (p1 < p2) {
				if (array[p1] + array[p2] == 13) {

					current1 = array[p1];
					current2 = array[p2];
					x = p1;
					y = p2;

					while (array[x] == current1) {
						x++;
					}
					while (array[y] == current2) {
						y--;
					}
					for (int k = 0; k < (x - p1) * (p2 - y); k++) {
						System.out.printf("%d %d%n", array[p1], array[p2]);
					}

					p1 = x;
					p2 = y;

				} else if (array[p1] + array[p2] < 13) {
					p1++;
				} else if (array[p1] + array[p2] > 13) {
					p2--;
				}
			}
		} catch (IOException e) {
			System.err.print("I/O error");
			System.exit(0);
		} catch (NumberFormatException e) {
			System.err.print("Input format error");
			System.exit(0);
		}
	}
}
