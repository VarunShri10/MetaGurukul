/**
 * Author : Varun Shrivastava
 * Aim : This Class will Implement Railway reservation System and interact with supporting Class 
 * Created Date : 31-01-2017
 */
package RailwayReservation;

import java.util.Scanner;

public class DrivingClass {
		
	
		/*
		 * This is a main Function . It calls show file content of Display TrainInfo 
		 */
		public static void main(String[] args)  {
			try{
				
				DisplayTrainInfo.showFileContent();		// Calls to Show File Content Function
				SortTrains.sortFunction();   			// Calls to Sort Function of Sort Trains Class
				Payment.functionPayment();				// This class will handle Payment Mode
				}
			catch(Exception o){
				
			}
		}
		
}
