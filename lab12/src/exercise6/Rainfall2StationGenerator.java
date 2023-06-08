package exercise6;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate writing byte-based data using DataOuputStream.
 * The data is written in its original type into the stream.  
 * 
 * 
 */

public class Rainfall2StationGenerator {
	
	public static void main(String[] args) {
		
		
		// 1. Declare output file 
		String rainfallFile = "DailyRainfallByte-Based.txt";
			
		// Data declaration
		
		// station id
		int stationId[] = {2225044, 2125002, 2321006, 2222002, 2222006, 2223023};
		
		// station name
		String stationName[] = {"Chohong", "Teluk Rimba", "Ladang Lendu", "Durian Tunggal", "Cheng (Taman Merdeka)", "Sg. Duyong"};
		
		// name of district
		String district[] = {"Jasin", "Jasin", "Alor Gajah", "Alor Gajah", "Melaka Tengah", "Melaka Tengah"};
	
		
		// reading of daily rainfall
		double dailyRainfall0206[] = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		double dailyRainfall0306[] = {0.0, 0.0, 2.0, 0.0, 0.0, 0.0};
		double dailyRainfall0406[] = {21.5, 1.0, 0.0, 0.0, 3.5, 3.0};
		double dailyRainfall0506[] = {0.0, 1.0, 0.0, 0.0, 0.0, 0.0};
		double dailyRainfall0606[] = {39.0, 69.0, 3.0, 37.0, 42.5, 43.0};
		double dailyRainfall0706[] = {14.5, 53.0, 4.0, 6.0, 10.0, 26.0};
			
		try {
				
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(rainfallFile));
			
			// Process data
			for (int index = 0; index < district.length; index++) {
					
				// 3. Write data into data stream
				dos.writeInt(stationId[index]);
				dos.writeUTF(stationName[index]);
				dos.writeUTF(district[index]);
				dos.writeDouble(dailyRainfall0206[index]);
				dos.writeDouble(dailyRainfall0306[index]);
				dos.writeDouble(dailyRainfall0406[index]);
				dos.writeDouble(dailyRainfall0506[index]);
				dos.writeDouble(dailyRainfall0606[index]);
				dos.writeDouble(dailyRainfall0706[index]);
				
				// 4. Flush for each writing
				dos.flush();
			}
			
			// 5. Close stream
			dos.close();
			
		} catch (Exception ex) {
				
			ex.printStackTrace();
		}
			
		// Indicate end of program - Could be successful
		System.out.println("End of program. Check out " + rainfallFile); 
	}

}
