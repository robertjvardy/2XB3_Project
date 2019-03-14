package stepsafe;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
	private static int SIZE = 150000;
	
	public static Event[] read() throws IOException {
		Event[] dbase = new Event[SIZE];
		File f = new File("Data\\MCI_2014_to_2017.csv");
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String line;
		int count = 0;
		while ((line = br.readLine()) != null) {
			if (count == 0){
				count++;
				continue;
			}
			String[] temp = line.split(",");
			dbase[count - 1] = new Event(temp[0], Integer.parseInt(temp[2]), temp[3], Integer.parseInt(temp[4]), Integer.parseInt(temp[7]), temp[8], Double.parseDouble(temp[12]), Double.parseDouble(temp[13]));
			count++;
		}
		return dbase;
	}

}
