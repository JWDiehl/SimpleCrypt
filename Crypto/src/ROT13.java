import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    private String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private String shiftedAlphabet;

    ROT13(Character cs, Character cf) {
        this.shiftedAlphabet = cryptedShiftedAlphabet(cs, cf);
    }

    private String cryptedShiftedAlphabet(Character cs, Character cf) {
        //Create new string for crypted string
        StringBuilder sb = new StringBuilder();
        int shift = (toLowerCase(cs) - toLowerCase(cf) + 26) % 26;

        for (int i = 0; i < alphabet.length(); i++) {
            char c = alphabet.charAt(i);

            //Two diff if statements for upper vs lower cases
            if (isUpperCase(c)) {
                char shiftedChar = (char) ('A' + (c - 'A' + shift) % 26);
                sb.append(shiftedChar);
            } else {
                // if (isLowerCase(c)) {
                char shiftedChar = (char) ('a' + (c - 'a' + shift) % 26);
                sb.append(shiftedChar);
            }
        }
        return sb.toString();
    }

    //Constructor for ROT13
    ROT13() {
        this('a', 'n');
    }


    public String crypt(String text) throws UnsupportedOperationException {

        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(c);
            if (index != -1) {
                result.append(shiftedAlphabet.charAt(index));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return decrypt(text);
    }

    public static String rotate(String s, Character c) {

        throw new UnsupportedOperationException("rotate method is not implemented");
    }

}
