import java.io.*;
import java.nio.file.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        try {
            //Należy wybrać sobie jakiś offset:

            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            DoIO doIO = new DoIO();

            if (input.equals("enCez")) {
                int offset = scanner.nextInt();
                doIO.enCez(offset);
            } else if (input.equals("deCez")) {
                int offset = scanner.nextInt();
                doIO.deCez(offset);
            } else if (input.equals("enHuf")) {
                doIO.enHuf();
            } else if (input.equals("deHuf")) {
                doIO.deHuf();
            } else {
                System.out.println("Wprowadzona komenda jest nieprawidłowa - spróbuj jeszcze raz");
            }
        } catch (IOException e) {
            System.out.println("Błąd wejścia - wyjścia. \n");
            e.printStackTrace();
        }
    }
}
