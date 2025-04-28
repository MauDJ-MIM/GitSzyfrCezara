import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanCoding {
    // Helper class to represent a node in the Huffman tree.
    // Each leaf node contains a character and its frequency,
    // internal nodes contain the sum of the frequencies of their children.
    private static class Node implements Comparable<Node> {
        double frequency;
        char character;
        Node left, right;

        // Creates a new leaf node.
        Node(double frequency, char character) {
            this.frequency = frequency;
            this.character = character;
            this.left = null;
            this.right = null;
        }

        // Creates a new internal node from two child nodes.
        Node(Node left, Node right) {
            this.frequency = left.frequency + right.frequency;
            this.character = '\0';  // no character for internal nodes
            this.left = left;
            this.right = right;
        }

        // Compare nodes based on frequency for priority queue.
        @Override
        public int compareTo(Node other) {
            return Double.compare(this.frequency, other.frequency);
        }
    }

    // The frequency table maps characters to their frequencies.
    private final HashMap<Character, Double> freqTable;
    // The root of the Huffman tree.
    private final Node root;
    // The codes table maps characters to their binary Huffman codes.
    private HashMap<Character, String> codesTable;

    // Creates a new coding object given the frequencies.
    public HuffmanCoding(HashMap<Character, Double> freq) {
        this.freqTable = new HashMap<>(freq);
        this.root = buildHuffmanTree();
        this.codesTable = new HashMap<>();
        buildCodes(root, "");
    }

    // Creates a new coding object using the given text to deduce the frequencies.
    public HuffmanCoding(String text) {
        this(buildFrequencyTable(text));
    }

    // Computes the frequency table using the given text.
    private static HashMap<Character, Double> buildFrequencyTable(String text) {
        // Count the number of occurrences of each character.
        HashMap<Character, Double> freqTable = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqTable.put(c, freqTable.getOrDefault(c, 0.0) + 1.0);
        }

        // Normalize the frequencies to sum to 1 (so they represent probabilities).
        double total = text.length();
        for (var entry : freqTable.entrySet()) {
            entry.setValue(entry.getValue() / total);
        }

        return freqTable;
    }

    // Builds the Huffman tree from the frequency table.
    private Node buildHuffmanTree() {
        // Start with all leaf nodes in a priority queue.
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (var entry : freqTable.entrySet()) {
            queue.add(new Node(entry.getValue(), entry.getKey()));
        }

        // Combine two nodes with the smallest frequencies until one node remains.
        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            queue.add(new Node(left, right));
        }

        // The remaining node is the root of the Huffman tree.
        return queue.poll();
    }

    // Recursively builds the codes table from the Huffman tree.
    private void buildCodes(Node node, String code) {
        if (node.left == null && node.right == null) {
            codesTable.put(node.character, code);
            return;
        }
        if (node.left != null) {
            buildCodes(node.left, code + "0");
        }
        if (node.right != null) {
            buildCodes(node.right, code + "1");
        }
    }

    // Encodes the given text using the Huffman encoding.
    public String encode(String text) {
        String encoded = "";
        for (char c : text.toCharArray()) {
            encoded += codesTable.get(c);
        }
        return encoded;
    }

    // Decodes the given text encoded using the Huffman tree.
    public String decode(String encoded) {
        String decoded = "";
        Node current = root;
        for (char bit : encoded.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current.left == null && current.right == null) {
                decoded += current.character;
                current = root;
            }
        }
        return decoded;
    }

    // Returns the frequency table necessary for decoding.
    public HashMap<Character, Double> getFrequencies() {
        return freqTable;
    }
}
