package String;

public class Vowels {
    public static void main(String[] args) {
        String s1 = "Bishnu";
        int v = 0, c = 0;

        for (char ch : s1.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(ch) != -1) {
                v++;
            } else if (ch >= 'a' && ch <= 'z') {
                c++;
            }
        }

        System.out.println("Vowels: " + v);
        System.out.println("Consonants: " + c);
    }
}
