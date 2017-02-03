/**
 * Author : Varun Shrivastava
 * Aim : This Class will Implement Writing and reading trains Info in File 
 * Created Date : 31-01-2017
 */
package RailwayReservation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Trains implements Comparable<Trains>,Serializable{
	String trainNumber;
	String trainType;
	String sourceStation;
	String destinationStation;
	String sourceTime;
	String destinationTime;
	String tickets;
	String price;
	
	//This Function Display Information of file which stores information in the from of object
	static void display(String choice){
					try
					{
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream("TrainsObject.ser"));
						Trains result;
						while ((result = (Trains)ois.readObject())!=null) {
							result.trainType = result.trainType.trim();
							if(choice.equals(result.trainType)){
								System.out.println(result.trainNumber+" "+result.trainType+" "+result.sourceStation+" "+result.destinationStation+" "+result.sourceTime+" "+result.destinationTime+" "+result.tickets+" "+result.price);
							}
						}
					}
					catch(Exception obj){
						
					}
					
	}
	
	// This Function will write Object in a file and information is stored in the form of object
	public static void FileWrite() 
	{
		try
		{
			BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Varun\\workspace\\OOpsProject\\src\\RailwayReservation\\TrainInfo.txt"));
			String s="";
			Trains trainsObject=new Trains();
			String arr[]=new String[8];
			int index=0;
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("TrainsObject.ser"));
			while((s=br.readLine())!=null){
				arr[index]=s;
				index++;
				if(index==8){
					trainsObject = new Trains();
					trainsObject.trainNumber=arr[0];
					trainsObject.trainType=arr[1];
					trainsObject.sourceStation=arr[2];
					trainsObject.destinationStation=arr[3];
					trainsObject.sourceTime=arr[4];
					trainsObject.destinationTime=arr[5];
					trainsObject.tickets=arr[6];
					trainsObject.price=arr[7];
					index=0;
					oos.writeObject(trainsObject);
				}
			}
	   
		br.close();
		}
		catch(Exception object){
			
		}
	}

	@Override	// This Function Override Compare to function of Comparable Interface and Sort Array List containing Objects
	public int compareTo(Trains trainsObject) {
		if(Integer.parseInt(sourceTime.trim())==Integer.parseInt(trainsObject.sourceTime.trim()))  
			return 0;  
			else if(Integer.parseInt(sourceTime.trim())>Integer.parseInt(trainsObject.sourceTime.trim()))  
			return 1;  
			else  
			return -1;  
		
		}  
}
