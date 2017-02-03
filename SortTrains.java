/**
 * Author : Varun Shrivastava
 * Aim : This Class will Implement Sorting of trains on the basis of arrival time 
 * Created Date : 31-01-2017
 */
package RailwayReservation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortTrains {

	//This Function will takes source and destination station from user 
	public static void sortFunction() throws FileNotFoundException, ClassNotFoundException, IOException{
		Scanner scannerObject= new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String source="";
		String destination="";
		System.out.println("Enter Source Station : ");
		source = reader.readLine();
		System.out.println("Enter Destination Station : ");
		destination=reader.readLine();
		SortTrains.function(source,destination);
		
		
	}
	
	// This Function Will Display Trains List on the basis of Source And Destination Station and will be in Sorted Form on the basis of arrival Time
	static public void function(String source,String destination) {
		ArrayList<Trains> al=new ArrayList<Trains>();  
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
			Trains result;
			while ((result = ((Trains)ois.readObject()))!=null) {
				result.trainType = result.trainType.trim();
				result.sourceStation = result.sourceStation.trim();
				result.destinationStation = result.destinationStation.trim();
				if(source.equalsIgnoreCase(result.sourceStation)&&destination.equalsIgnoreCase(result.destinationStation)){
					al.add(result);
				}
			}
		}
		catch(Exception object){
			
		}
		Collections.sort(al);		// This Call will Sort Trains On the basis of arrival Time
		for(Trains object :al)
			System.out.println(object.trainNumber+" "+object.trainType+" "+object.sourceStation+" "+object.destinationStation+" "+object.sourceTime+" "+object.destinationTime+" "+object.tickets+" "+object.price);  
		
	}
}
