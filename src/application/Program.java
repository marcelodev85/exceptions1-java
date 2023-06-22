package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


        System.out.print("Room number: ");
        int roomNumber = sc.nextInt();
        System.out.print("Check-in: ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out: ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: checkout date must be after checkin date.");
        } else {
            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println("Enter data to update the reservation: ");
            roomNumber = sc.nextInt();
            System.out.print("Check-in: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out: ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: reservation dates for update must be future");
            } else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation: checkout date must be after checkin date.");
            } else {
                reservation.updateDates();
                System.out.println(reservation);
            }
        }


        sc.close();
    }
}
