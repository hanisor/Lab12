package exercise5;

import java.io.DataOutputStream;
import java.io.FileOutputStream;

/**
 * This program demonstrate writing byte-based data using DataOuputStream.
 * The data is written in its original type into the stream.  
 * 
 * The data represents a 6 days reading of daily rainfall from station 
 * Simpang Ampat in Alor Gajah district
 * 
 * @author Nur Hanis Sorhana
 *
 */
 
public class DailyRainfallDataGenerator {
	
	
	public static void main(String[] args) {
		
	
		// 1. Declare output file 
		String rainfallFile = "DailyRainfallSimpangAmpat.txt";
			
		// Data declaration
		String date[] = {"02/06/2023", "03/06/2023", "04/06/2023", "05/06/2023", 
				"06/06/2023", "07/06/2023"};
		int dailyRainfall[] = {0, 4, 1, 0, 6, 19};
			
		try {
				
			// 2. Create stream to read data
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(rainfallFile));
			
			// Process data
			for (int index = 0; index < date.length; index++) {
					
				// 3. Write data into data stream
				dos.writeUTF(date[index]);
				dos.writeInt(dailyRainfall[index]);
				
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
