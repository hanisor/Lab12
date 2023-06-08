package exercise7;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Steps to read character based data
 * 1. Identify the source
 * 2. Construct the Reader object
 * 3. Read the data
 * 4. Close the Reader
 * 
 * @author Nur Hanis Sorhana
 *
 */

public class dailyRainfallBufferedReader {
	
	public static void main(String[] args) {
		
		
		// 1. Identify the source
		String inputFile = "DailyRainfall.txt";
		
		
		try {
			
					
			// 2. Construct the Reader object
			BufferedReader brDailyRainfall = 
					new BufferedReader(new FileReader(inputFile));
			
			
			// 3. Read the data
			String line = "";
			line = brDailyRainfall.readLine();
			
			double totalDailyRainfall = 0.0;
			double dailydata = 0.0;
			int noOfRecords = 0;
			
			
			while (line != null) {
				
				String[] dailyRainfall = {"0.0", "4.0", "1.0", "0.0", "6.0", "19.0"};
				noOfRecords += dailyRainfall.length;
				
				for (int index=0; index < dailyRainfall.length; index++) {
					
					// Parse the data
					dailydata = Double.parseDouble(dailyRainfall[index]);
					
					totalDailyRainfall += dailydata;
				}
				
				
				System.out.println(line);
				// Read the next line
				line =  brDailyRainfall.readLine();
			}
			
			
			// Calculate average rainfall
			double averageRainfall = totalDailyRainfall / noOfRecords;
			System.out.println("\nAverage daily rainfall for 6 date : " + averageRainfall + "%");
			
			// 4. Close the Reader
			brDailyRainfall.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}


}
