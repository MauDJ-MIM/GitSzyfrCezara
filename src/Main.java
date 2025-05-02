import java.io.*;
import java.nio.file.*;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) throws IOException {
        try {
            //Należy wybrać sobie jakiś offset:
            Scanner scanner = new Scanner(System.in);
            int offset = scanner.nextInt();


            //Wczytujemy z pliku informacje
            String input = Files.readString(Path.of("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\input.txt"));

            //Deklarujemy nowe pliki
            File encodeCezar = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\encodeCezar.txt");
            File decodeCezar = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\decodeCezar.txt");
            File encodeHuffman = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\encodeHuffman.txt");
            File decodeHuffman = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\decodeHuffman.txt");

            //Teraz tworzymy obiekty, by móc zastosować metody
            SzyfrCezara cezara = new SzyfrCezara();
            HuffmanCoding huffman = new HuffmanCoding(input);

            //Wpisujemy wynik do plików:
            Files.writeString(encodeCezar.toPath(), cezara.encode(input, offset));
            Files.writeString(decodeCezar.toPath(), cezara.decode(input, offset));
            Files.writeString(encodeHuffman.toPath(), huffman.encode(input));
            Files.writeString(decodeHuffman.toPath(), huffman.decode(input));

        } catch (IOException e) {
            System.out.println("Błąd wejścia - wyjścia. \n");
            e.printStackTrace();
        }
    }
}
