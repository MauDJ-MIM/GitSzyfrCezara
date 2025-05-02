public class Main {
    public static void main(String[] args) {
        String wstęp = "Alfabet to ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String wstepmałe = "A małe to abcdefghijklmnopqrstuvwxyz";
        SzyfrCezara cezara = new SzyfrCezara();
        String zakodowanyWstęp = cezara.encode(wstęp, 1);
        System.out.println(zakodowanyWstęp);
    }
}
