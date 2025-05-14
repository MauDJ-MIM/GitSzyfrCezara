public class SzyfrCezara {

    public static String encode(String s, int offset) {
        String coded = "";
        char codedChar;
        for (int i = 0; i < s.length(); ++i) {
            codedChar = s.charAt(i);
            if (Character.isLowerCase(codedChar)) 
                coded += shiftChar(codedChar, offset, false);
            else if (Character.isUpperCase(codedChar))
                coded += shiftChar(codedChar, offset, true);
            else
                coded += codedChar;
        }
        return coded;
    }

    public static String decode(String s, int offset) {
        return encode(s, -1*offset);
    }

    private static char shiftChar(char c, int offset, boolean upper) {
        int cNum = (char) c;
        final int letters = (int) 'z' - (int) 'a' + 1;
        final int upperOffset = (int) 'A';
        final int lowerOffset = (int) 'a';
        if (upper)
            return (char) ((cNum+offset+letters-upperOffset) % letters + upperOffset);
        else
            return (char) ((cNum+offset+letters-lowerOffset) % letters + lowerOffset);
    }
}
