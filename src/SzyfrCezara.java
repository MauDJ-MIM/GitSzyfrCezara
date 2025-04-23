public class SzyfrCezara {
    private int letters() {
        return (int) 'z' - (int) 'a';
    }
    
    private int upperOffset() {
        return (int) 'A';
    }

    private int lowerOffset() {
        return (int) 'a';
    }

    private char shiftChar(char c, char offset, boolean upper) {
        int cNum = (char) c;
        int offsetNum = (char) offset;
        int letters = letters();
        if (upper)
            return (char) ((cNum+offsetNum+letters-upperOffset()) % letters + upperOffset());
        else
            return (char) ((cNum+offsetNum+letters-lowerOffset()) % letters + lowerOffset());
    }
}
