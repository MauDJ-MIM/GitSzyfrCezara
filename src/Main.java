import java.io.*;
import java.nio.file.*;



public class Main {
    public static void main(String[] args) throws IOException {
        try {
            //Należy wybrać sobie jakiś offset:
            int offset = 5;

            //Wczytujemy z pliku informacje
            String input = Files.readString(Path.of("input.txt"));

            //Deklarujemy nowe pliki
            File encodeCezar = new File("encodeCezar.txt");
            File decodeCezar = new File("decodeCezar.txt");
            File encodeHuffman = new File("encodeHuffman.txt");
            File decodeHuffman = new File("decodeHuffman.txt");

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
