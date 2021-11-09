package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
		System.out.println("Room number: ");
		int number = tec.nextInt();
		System.out.println("CheckIn date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(tec.next());
		System.out.println("CheckOut date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(tec.next());

		Reservation reservation = new Reservation(checkIn, checkOut, number);
		System.out.println("Reservation: " + reservation);

		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.println("CheckIn date (dd/mm/yyyy): ");
		checkIn = sdf.parse(tec.next());
		System.out.println("CheckOut date (dd/mm/yyyy): ");
		checkOut = sdf.parse(tec.next());
		
		reservation.updateDates(checkIn, checkOut);
		System.out.println("Reservation: "+reservation);
		}
		catch (ParseException e){
			System.out.println("Invalid date format!");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation :"+e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		tec.close();
	}
}