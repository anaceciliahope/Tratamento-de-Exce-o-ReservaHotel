package application;

import exceptions.DomainException;
import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {
        Scanner teclado = new Scanner(System.in);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.print("Número do quarto: ");
            int numeroQuarto = teclado.nextInt();
            System.out.print("Data do check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(teclado.next());
            System.out.print("Data do check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(teclado.next());


            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Insira os dados para atualizar a reserva: ");
            System.out.print("Data do check-in (dd/MM/yyyy): ");
            checkIn = sdf.parse(teclado.next());
            System.out.print("Data do check-out (dd/MM/yyyy): ");
            checkOut = sdf.parse(teclado.next());

            reserva.updateDates(checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

        } catch (ParseException e) {
            System.out.println("Data Invalida!!");
        } catch (DomainException e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Erro inesperado!");
        }
    }

}
