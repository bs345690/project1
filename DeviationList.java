import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

class DeviationList {

	private DeviationList() {
	}

	private static ArrayList<Integer> readAndStoreData(String fileName, ArrayList<Integer> numberList) 
			throws IOException {
		try {
			Scanner fileInput = new Scanner(new File(fileName));
			while (fileInput.hasNextInt()) {
				numberList.add(fileInput.nextInt());
			}
			fileInput.close();
		} catch (IOException e) {
			System.out.print("Error: " + e);
		}
		return numberList;
	}

	private static ArrayList<Double> computeDeviations(double average, ArrayList<Integer> numberList) {
		ArrayList<Double> deviations = new ArrayList<Double>();
		for (int x : numberList) {
			deviations.add(Math.abs(x - average));
		}
		return deviations;
	}
	
	private static double computeAverage(ArrayList<Integer> numberList) {
		double sum = 0;
		double average;
		for (int x : numberList) {
			sum = sum + x;
		}
		average = sum / numberList.size();
		return average;
	}

	private static void prettyPrint(ArrayList<Integer> numberList, ArrayList<Double> deviations, double average) {
		System.out.format("Average: %.4f%n", average);
		System.out.println("Line | Number|  Deviation |");
		for (int x = 0; x < numberList.size(); x++) {
			System.out.format("%-5d|%6d | %10.4f |%n", x + 1,
					numberList.get(x), deviations.get(x));
		}
	}

	public static void execute(String fileName) throws IOException {
		
		double average;
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		ArrayList<Double> deviations = new ArrayList<Double>();

		numberList = readAndStoreData(fileName, numberList);
		average = computeAverage(numberList);
		deviations = computeDeviations(average, numberList);
		prettyPrint(numberList, deviations, average);
		
	}
}
