import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Scanner;

public class DoIO {

    public void enCez(int offset) {
        try {
            String input = Files.readString(Path.of("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\input.txt"));
            File encodeCezar = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\encodeCezar.txt");
            SzyfrCezara cezara = new SzyfrCezara();
            Files.writeString(encodeCezar.toPath(), cezara.encode(input, offset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deCez(int offset) {
        try {
            String input = Files.readString(Path.of("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\input.txt"));
            File decodeCezar = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\decodeCezar.txt");
            SzyfrCezara cezara = new SzyfrCezara();
            Files.writeString(decodeCezar.toPath(), cezara.decode(input, offset));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enHuf() throws IOException {
        String input = Files.readString(Path.of("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\input.txt"));
        File encodeHuffman = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\encodeHuffman.txt");
        HuffmanCoding huffman = new HuffmanCoding(input);
        Files.writeString(encodeHuffman.toPath(), huffman.encode(input));

        HashMap<Character, Double> hashSzyfru = huffman.getFrequencies();
        String doSzyfru = "";

        for (Character key : hashSzyfru.keySet()) {
            doSzyfru += "\n";
            doSzyfru += key;
            doSzyfru += "\n";
            doSzyfru += hashSzyfru.get(key);
        }

        File doSzyfruHuffman = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\doSzyfruHuffman.txt");
        Files.writeString(doSzyfruHuffman.toPath(), doSzyfru);
    }

    public void deHuf() throws IOException{
        String input = Files.readString(Path.of("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\input.txt"));
        File decodeHuffman = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\decodeHuffman.txt");

        HashMap<Character, Double> freq = new HashMap<>();
        File file = new File("C:\\Users\\maury\\IdeaProjects\\GitSzyfrCezara\\src\\doSzyfruHuffman.txt");
        Scanner scanner = new Scanner(file);
        String key = scanner.nextLine();
        String valueTemp;
        Double value;

        while (scanner.hasNextLine()) {
            key = scanner.nextLine();
            valueTemp = scanner.nextLine();
            value = Double.parseDouble(valueTemp);
            freq.put(key.charAt(0), value);
        }

        System.out.println(freq);

        HuffmanCoding huffman = new HuffmanCoding(freq);
        Files.writeString(decodeHuffman.toPath(), huffman.encode(input));
    }
}
