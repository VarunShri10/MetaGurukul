/**
 * Author : Varun Shrivastava
 * Aim : This Class will Update Trains File and Do Payment Implementation
 * Created Date : 31-01-2017
 */
package RailwayReservation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Payment {
	//This Function Implement Payment Mode. It ask user about First Mode of Payment  and Display Fare and Ticket Information About Train
	public static void modeInfo(int trainNumber,int seats) throws Exception{
		int choice;
		int creditCardNumber;
		int fare;
		String Bank;
		String username;
		String Password;
		System.out.println("1:Creadit Card\n2:Wallet\n3:Net Banking");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		choice=Integer.parseInt(reader.readLine());
		if(choice==1){
			System.out.println("Enter Credit Card Number : ");
			creditCardNumber=Integer.parseInt(reader.readLine());
		}
		else if(choice==2){
			// Do Nothing
		}
		else{
			System.out.println("Enter Bank : ");
			Bank=(reader.readLine());
			System.out.println("Enter user name : ");
			username=reader.readLine();
			System.out.println("Enter password : ");
			Password=(reader.readLine());
		}
		System.out.println("Ticket Information ");
		if(choice==1)
		System.out.println("Payment Mode : CC");
		else
			if(choice==2)
				System.out.println("Payment Mode : Wallet");
			else
				System.out.println("Payment Mode : NetBanking ");
			
		try{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
			Trains result;
			while ((result = ((Trains)ois.readObject()))!=null) {
				if(Integer.parseInt(result.trainNumber.trim())==trainNumber){
					fare=Integer.parseInt(result.price.trim())*seats;
					System.out.println("Train Number : "+result.trainNumber+"Source :  "+result.sourceStation+" Destination "+result.destinationStation+" Arrival : "+result.sourceTime+" Destination : "+result.destinationTime+" Tickets : "+seats+" Fare : "+fare);
				}
			}
		}

		catch(Exception object){
			
		}
		
	}
			
	// This Function ask train number and seats and calls update Function and passes train number and seats
	static public void functionPayment() {
			int trainNumber=0;
			int seats=0;
			try{
					BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
					System.out.println("Enter Train Number : ");
					trainNumber=Integer.parseInt(reader.readLine());
					System.out.println("Enter Seats : ");
					seats=Integer.parseInt(reader.readLine());
					ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
					Trains result;
					while ((result = ((Trains)ois.readObject()))!=null) {
						if(Integer.parseInt(result.trainNumber.trim())==trainNumber){
							if(Integer.parseInt(result.tickets.trim())>=seats){
								Payment.update(trainNumber,seats);
							}
						}
					}
				}
			catch(Exception ob){
				
			}
			try {
					Payment.modeInfo(trainNumber,seats);	//
				} 
			catch (Exception e) {
		
				}
	}
			
	
	// This Function will Update Tickets in File
	static public void update(int trainNumber,int seats){
			ArrayList<Trains> al=new ArrayList<Trains>();
			Trains result;
			try{
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
				Integer difference;
				while ((result = ((Trains)ois.readObject()))!=null) {
						if(Integer.parseInt(result.trainNumber.trim())==trainNumber){
							difference=Integer.parseInt(result.tickets.trim())-seats;
							result.tickets=(difference.toString()).trim();
							al.add(result);
						}
						else
							al.add(result);
				}
			}
			catch(Exception object){
					
			}
			try{
					ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("TrainsObject.ser"));
					for(Trains ob:al)
						out.writeObject(ob);
				}
			catch(Exception o){
						
			}
			try{
					ObjectInputStream oio = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
					while ((result = ((Trains)oio.readObject()))!=null) {
						 System.out.println(result.trainNumber+" "+result.trainType+" "+result.sourceStation+" "+result.destinationStation+" "+result.sourceTime+" "+result.destinationTime+" "+result.tickets+" "+result.price);
					}
			}
			catch(Exception o){
						
			}
	}
	
}
