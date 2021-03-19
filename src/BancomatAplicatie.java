import java.util.Scanner;
public class BancomatAplicatie {
    public static void main(String[] args) {

        ContBancar contBancar=new ContBancar("Cosmin", "20KB58");
        contBancar.Meniu();
    }
}

class ContBancar {
    int sold;
    int tranzactieAnterioara;
    String NumeClient;
    String ClientID;

    ContBancar(String NumeClient, String ClientID) {
        this.NumeClient = NumeClient;
        this.ClientID = ClientID;
    }


    void deposit(int valoare) {
        if (valoare != 0) {
            sold = sold + valoare;
            tranzactieAnterioara = valoare;
        }
    }

    void retragere(int valoare) {
        if (valoare != 0) {
            sold = sold - valoare;
            tranzactieAnterioara = -valoare;
        }

    }

    void aflaTranzactiaAnterioara() {
        if (tranzactieAnterioara > 0) {
            System.out.println("Depozitat: " + tranzactieAnterioara);
        } else if (tranzactieAnterioara < 0) {
            System.out.println("Retrasi: " + Math.abs(tranzactieAnterioara));
        } else {
            System.out.println("Nu s-a produs nicio tranzactie");
        }
    }

    void Meniu() {
        char optiune = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bine ai venit " + NumeClient);
        System.out.println("ID-ul tau este " + ClientID);
        System.out.println("\n");
        System.out.println("A. Afiseaza Sold");
        System.out.println("B. Depoziteaza");
        System.out.println("C. Retrage");
        System.out.println("D. Vezi tranzactia anterioara");
        System.out.println("E. Exit");

        do {

            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("Alege o optiune");
            System.out.println("---------------------------------------------------------------------------------------------");
            optiune = scanner.next().charAt(0);
            System.out.println();

            switch (optiune) {
                case 'A':
                    System.out.println("-------------------------------------------");
                    System.out.println("Sold = " + sold);
                    System.out.println("-------------------------------------------");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("-------------------------------------------");
                    System.out.println("Alege suma dorita pentru depozitare: ");
                    System.out.println("-------------------------------------------");
                    int valoare = scanner.nextInt();
                    deposit(valoare);
                   System.out.println();
                    break;

                case 'C':
                    System.out.println("--------------------------------------------");
                    System.out.println("Alege valoarea pe care doresti sa o retragi ");
                    System.out.println("--------------------------------------------");
                    int valoare2 = scanner.nextInt();
                    retragere(valoare2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("---------------------------------------------");
                    aflaTranzactiaAnterioara();
                    System.out.println("---------------------------------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("---------------------------------------------");
                    break;

                default:
                    System.out.println("Operatie nereusita! Incercati din nou");
                    break;
            }

        } while (optiune != 'E');
        System.out.println("Va multumim ca ne folositi serviciile");
    }

}
