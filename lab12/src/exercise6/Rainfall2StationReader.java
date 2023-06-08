package exercise6;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;

/**
 * This program demonstrate writing byte-based data using DataOuputStream.
 * The data is written in its original type into the stream.  
 * 
 * 
 */

public class Rainfall2StationReader {
	
	public static void main(String[] args) {

		// 1. Declare output file 
		String sourceFile = "DailyRainfallByte-Based.txt";
		System.out.println("Reading data from " + sourceFile + "\n");
		

		try {

			// 2. Create stream to read data
			DataInputStream dis = new DataInputStream(new FileInputStream(sourceFile));

			// Variables for processing byte-based data
			int stationId = 0;
			String stationName = "";
			String district = "";
			double dailyRainfall0206 = 0.0;
			double dailyRainfall0306 = 0.0;
			double dailyRainfall0406 = 0.0;
			double dailyRainfall0506 = 0.0;
			double dailyRainfall0606 = 0.0;
			double dailyRainfall0706 = 0.0;
			
			// Total daily rainfall readings for each station
			double sum = 0.0;
			
			// Declaration of Arraylist to store the each total daily rainfall readings
			ArrayList <Double> totalDailyRainfall = new ArrayList<Double>();
						
			// ArrayList to store stations for calculation purpose
			ArrayList<String> stations = new ArrayList<String>();
									
			// HashSet to store distinct district for calculation purpose
			ArrayList<String> districts = new ArrayList<String>();
			
			int noOfRecords = 0;
		
			// 3. Process data until end-of-file
			System.out.println( "_________________________________________________________");
			while(dis.available() > 0) {
				
				// Read data
				stationId = dis.readInt();
				stationName = dis.readUTF();
				district = dis.readUTF();
				dailyRainfall0206 = dis.readDouble();
				dailyRainfall0306 = dis.readDouble();
				dailyRainfall0406 = dis.readDouble();
				dailyRainfall0506 = dis.readDouble();
				dailyRainfall0606 = dis.readDouble();
				dailyRainfall0706 = dis.readDouble();
				
				System.out.println( stationId + "\t" + stationName + "\t\t" + district + 
						"\t" + dailyRainfall0206 + "\t" +  dailyRainfall0306 +
						"\t" + dailyRainfall0406 + "\t" +  dailyRainfall0506 +
						"\t" + dailyRainfall0606 + "\t" +  dailyRainfall0706);
				
				// Calculate total rainfall
				sum = dailyRainfall0206 + dailyRainfall0306 +dailyRainfall0406 
						+ dailyRainfall0506 + dailyRainfall0606 +dailyRainfall0706;
				
				totalDailyRainfall.add(sum);
				
				// save the station names into the arraylist, stations
				stations.add(stationName);
				
				// save the distinct district into arraylist, districtCount
				districts.add(district);
				
				noOfRecords ++;
			}
			System.out.println( "_________________________________________________________");
			
			// 4. Close stream
			dis.close();
			
			// Calculation for average daily rainfall readings in each station
			for(int index = 0; index < stations.size(); index++)
			{
				// Calculation for average daily rainfall readings in each station
				double average = totalDailyRainfall.get(index) / noOfRecords;
							
				// format the average in one decimal places
				String formattedAverage = String.format("%.4f", average);
					
				// display the total daily rainfall readings in each station and its correspond average
				System.out.println("The total daily rainfall for " + stations.get(index) + " : " 
						+ totalDailyRainfall.get(index) );
				System.out.println("The average daily rainfall for " + stations.get(index) + " : " 
						+ formattedAverage + "\n");
			}
			
		} catch (Exception ex) {
			
			ex.printStackTrace();
		}

		// Indicate end of program - Could be successful
		System.out.println("\nEnd of program.");
		

	}

}
