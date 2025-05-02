import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) extends IOException {
        try {
            File input = new File("input.txt");
            Scanner inputScanner = new Scanner(input);

            //Deklarujemy nowe pliki
            File encodeCezar = new File("encodeCezar.txt");
            File decodeCezar = new File("decodeCezar.txt");
            File encodeHuffman = new File("encodeHuffman.txt");
            File decodeHuffman = new File("decodeHuffman.txt");

            //Tworzymy nowe pliki.
            //Jeśli są już pliki o danych nazwach, to je usuwamy i stwarzamy na nowo puste pliki.
            if(!(encodeCezar.createNewFile())) {encodeCezar.delete(); encodeCezar.createNewFile();}
            if(!(decodeCezar.createNewFile())) {decodeCezar.delete(); decodeCezar.createNewFile();}
            if(!(encodeHuffman.createNewFile())) {encodeHuffman.delete(); encodeHuffman.createNewFile();}
            if(!(encodeHuffman.createNewFile())) {encodeHuffman.delete(); encodeHuffman.createNewFile();}


        } catch (IOException e) {
            System.out.println("Błąd wejścia - wyjścia. \n");
            e.printStackTrace();
        }
    }
}
