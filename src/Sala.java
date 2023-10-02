import java.util.Arrays;

public class Sala {

    private char[][] POSTA_DA_SEDERE;
    private char seatSymbol = 'S';
    private int righe;
    private int colonne;
    private int income;
    final int price = 10;
    final int halfPrice = 8;

    Sala () {}

    public int getIncome() {

        int totalSeats = righe * colonne;
        int halfSeats = totalSeats / 2;
        int halfOddSeats;
        int halfEvenSeats;
        if (totalSeats <= 60) {
            income = price * totalSeats;
        }else if((righe % 2) == 0) {
            income = (price * halfSeats) + ((price - 2) * halfSeats);
        } else if ((righe % 2) != 0) {
            halfOddSeats = ((righe / 2) + 1) * colonne;
            halfEvenSeats = ((righe / 2)) * colonne;
            income = (price * halfEvenSeats) + ((price - 2) * halfOddSeats);
        }
        return income;
    }

    public void setRighe(int righe)  {
        this.righe = righe;
    }
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }
    public int getRighe() {
        return this.righe;
    }
    public int getColonne() {
        return this.colonne;
    }

    public void createSala() {

        POSTA_DA_SEDERE = new char[righe][colonne];

        for (char[] a: POSTA_DA_SEDERE) {
            Arrays.fill(a, seatSymbol);
        }
    }

    public int getPrice(int row) {

        int temp = righe / 2;;

        if(righe % 2 == 0) {
            if(row <= temp) {
                return 10;
            }else {
                return 8;
            }
        } else if (righe % 2 != 0) {
            if(row <= temp) {
                return 10;
            } else {
                return 8;
            }
        }

        return 0;
    }

    public boolean setSoldSeat(int colonne, int righe) {
        if (colonne < 1 || colonne > this.colonne || righe < 1 || righe > this.righe) {
            System.out.println("Wrong input!");
            return false;
        } else if(POSTA_DA_SEDERE[righe-1][colonne-1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            return false;
        } else {
            POSTA_DA_SEDERE[righe-1][colonne-1] = 'B';
            return true;
        }


    }
    public void printSala(){

        System.out.println("Cinema:");
        System.out.print("  ");

        for (int i = 0; i < colonne; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < POSTA_DA_SEDERE.length; i++) {
            System.out.print(i+1 + " ");
            for (int j = 0; j < POSTA_DA_SEDERE[i].length; j++) {
                System.out.print(POSTA_DA_SEDERE[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void getPercentage(int soldTickets) {

        int allSeats = this.righe * this.colonne;
        double purchasedTickets = (soldTickets * 100d)/ allSeats;

        System.out.printf("Percentage:  %.2f", purchasedTickets);
        System.out.print("%");
        System.out.println();

    }
}
