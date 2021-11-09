package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	public static void main(String[] args) throws ParseException {
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = tec.nextInt();
		System.out.println("CheckIn date (dd/mm/yyyy): ");
		Date checkIn = sdf.parse(tec.next());
		System.out.println("CheckOut date (dd/mm/yyyy): ");
		Date checkOut = sdf.parse(tec.next());

		if (!checkOut.after(checkIn)) { // compara se a data de checkout é antes da data de checkin pelo metodo sfter da
										// classe Data
			System.out.println("Error in reservation: checkout date must be after checkin date");
		} else {
			Reservation reservation = new Reservation(checkIn, checkOut, number);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("CheckIn date (dd/mm/yyyy): ");
			checkIn = sdf.parse(tec.next());
			System.out.println("CheckOut date (dd/mm/yyyy): ");
			checkOut = sdf.parse(tec.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}
		}

		tec.close();
	}
}
