package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {

	private Date checkIn;
	private Date checkOut;
	int roomNumber;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Date checkIn, Date checkOut, int roomNumber)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("checkout date must be after checkin date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long duration() {
		long diff = getCheckOut().getTime() - getCheckIn().getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);// converte os milisegundos obtidos atraves do calculo
		// da diferença entre as datas em dias.

	}

	public void updateDates(Date checkIn, Date checkOut)  {
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be futures dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("checkout date must be after checkin date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String toString() {
		return "Room " + roomNumber + ", CheckIn " + sdf.format(checkIn) + ", CheckOut " + sdf.format(checkOut)
				+ ", Duration: " + duration() + " nights";

	}
}
