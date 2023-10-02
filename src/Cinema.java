import java.util.InputMismatchException;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args){

        int row = 0;
        int column = 0;
        int input = 0;
        boolean firstInput = false;
        int soldTickets = 0;
        int rowTemp;
        int columnTemp;
        int currentIncome = 0;

        Scanner scanner = new Scanner(System.in);
        Sala sala = new Sala();


        while (!firstInput) {

            try {


                System.out.println("Enter the number of rows:");
                row = scanner.nextInt();

                if (row > 9 || row <= 0) {
                    System.out.println("The row should not be higher than 9 or lesser than 0");
                    continue;
                } else {
                    sala.setRighe(row);
                }

                System.out.println("Enter the number of seats in each row:");
                column = scanner.nextInt();

                if (column > 9 || column <= 0) {
                    System.out.println("The column should not be higher than 9 or lesser than 0");
                    continue;
                } else {
                    sala.setColonne(column);
                }
            } catch (InputMismatchException a) {
                System.out.println("Error");
            }

            System.out.println();
            sala.createSala();
            firstInput = true;
        }

        do {

            try {

                System.out.println("1. Show the seats\n" +
                        "2. Buy a ticket\n" +
                        "3. Statistics\n" +
                        "0. Exit");
                input = scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Error");
                input = 10;
            }

            switch (input) {

                case 1-> {
                    sala.printSala();
                    System.out.println();
                }
                case 2-> {

                    boolean ticketAlreadySold = false;

                    try {

                        while (!ticketAlreadySold) {

                            System.out.println("Enter a row number:");
                            rowTemp = scanner.nextInt();

                            System.out.println("Enter a seat number in that row:");
                            columnTemp = scanner.nextInt();


                            if (!sala.setSoldSeat(columnTemp, rowTemp)) {
                                System.out.println();
                            } else {

                                System.out.println("Ticket price: $" + sala.getPrice(rowTemp));
                                sala.printSala();
                                soldTickets++;
                                ticketAlreadySold = true;
                                currentIncome = currentIncome + sala.getPrice(rowTemp);
                            }

                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Error");
                        scanner.nextLine();

                    }

                }
                case 3-> {

                    System.out.println("Number of purchased tickets: " + soldTickets);
                    sala.getPercentage(soldTickets);
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + sala.getIncome());

                }
                case 0-> {
                    input = 0;
                }
            }
        } while (input != 0);

    }
}
