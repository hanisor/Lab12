package exercise5;

import java.io.DataInputStream;
import java.io.FileInputStream;

/**
 * This program demonstrate writing byte-based data using DataOuputStream.
 * The data is written in its original type into the stream.  
 * 
 * The data represents a 6 days reading of daily rainfall from station 
 * Simpang Ampat in Alor Gajah district
 * 
 * The program  display the 6-days rainfall data , compute and 
 * display the average of the rainfall
 * 
 * @author Nur Hanis Sorhana
 * 
 */

public class DailyRainfallDataReader {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "DailyRainfallSimpangAmpat.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int dailyRainfall = 0;
			int totalDailyRainfall = 0;
			int noOfRecords = 0;
			String date = "";
			
			
			// 3. Process data until end-of-file
			System.out.println( "_______________________________");
			System.out.println( "Date" + "\t\t" + "Daily Rainfall");
			while(dis.available() > 0) {
				
				// Read data
				date = dis.readUTF();
				dailyRainfall = dis.readInt();
				
				System.out.println( date + "\t" + dailyRainfall );
				
				// Calculate total rainfall
				totalDailyRainfall += dailyRainfall;
				noOfRecords ++;
			}
			System.out.println( "_______________________________");
			
			// 4. Close stream
			dis.close();
			
			// Calculate average rainfall
			double averageRainfall = totalDailyRainfall / noOfRecords;
			System.out.println("\nAverage daily rainfall for " + noOfRecords 
					+ " date : " + averageRainfall + "%");
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}
