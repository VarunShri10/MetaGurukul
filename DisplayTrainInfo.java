/**
 * Author : Varun Shrivastava
 * Aim : This Class will Display Train Information 
 * Created Date : 31-01-2017
 */
package RailwayReservation;

import java.util.Scanner;

public class DisplayTrainInfo {
	
	/*	This Function Ask User about his choice and Display Train Information on the basis of whether it 
	 * 	is Goods Train or Passenger Train+ 
	 */
	public static void showFileContent() throws Exception {
		String name="";
		System.out.println("Enter Name : ");
		Scanner scannerObject=new  Scanner(System.in);
		name=scannerObject.nextLine();
		System.out.println("P : Passenger\nG : Goods");
		String choice;
		choice=scannerObject.next();
		Trains.display(choice);				// This Function Display Trains List
		
	}

}
