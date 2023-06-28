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
            System.out.print("Check-in date: ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out: ");
            checkOut = sdf.parse(sc.next());


            String error = reservation.updateDates(checkIn, checkOut);
            Date now = new Date();
            if (error != null) {
                System.out.println("Error in reservation: " + error);

            } else {
                System.out.println("Reservation: " + reservation);
            }
        }


        sc.close();
    }
}
