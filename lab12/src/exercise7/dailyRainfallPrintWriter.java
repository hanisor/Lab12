package exercise7;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

public class dailyRainfallPrintWriter {
	
	public static void main( String args[]) {
		
		// 1. Identify the destination eg. receipt.txt
		String fileName = "DailyRainfall.txt";
		
		
		try {
			
			//  2. Construct Writer object
			PrintWriter pwDailyRainfall = new PrintWriter(fileName);
			pwDailyRainfall.print("Reading Data from " + fileName);
			
			// Data of daily rainfall
			String divider = "_______________________________";
			
			pwDailyRainfall.write("\n" + divider );
			pwDailyRainfall.write("\n");
			pwDailyRainfall.write( "Date" + "\t\t" + "Daily Rainfall \n");
			
			String date[] = {"02/06/2023", "03/06/2023", "04/06/2023", "05/06/2023", 
					"06/06/2023", "07/06/2023"};
			int[] dailyRainfall = {0, 4, 1, 0, 6, 19};
			
			// Print the ordered items
			for (int index = 0; index < date.length; index++) {
				
				pwDailyRainfall.print(date[index] + "\t");
				pwDailyRainfall.print(dailyRainfall[index] + "\n");
			}
			
			pwDailyRainfall.write(divider + "\n");
			
			pwDailyRainfall.close();
			
		} catch (FileNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("End of execution. Refer "+ fileName);
		
	}

}
