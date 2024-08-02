import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {

    private static final String ALPHABET_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHABET_LOWER = "abcdefghijklmnopqrstuvwxyz";

    //Constructor for ROT13
    ROT13() {
    }

    ROT13(Character cs, Character cf) {
        if (!Character.isLetter(cs) || !Character.isLetter(cf)) {
            throw new IllegalArgumentException("startChar and endChar must be letters");
        }
    }

//    private String cryptedShiftedAlphabet(Character cs, Character cf) {
//        //Create new string for crypted string
//        StringBuilder sb = new StringBuilder();
//        int shift = (toLowerCase(cs) - toLowerCase(cf) + 26) % 26;
//
//        for (int i = 0; i < alphabet.length(); i++) {
//            char c = alphabet.charAt(i);
//
//            //Two diff if statements for upper vs lower cases
//            if (isUpperCase(c)) {
//                char shiftedChar = (char) ('A' + (c - 'A' + shift) % 26);
//                sb.append(shiftedChar);
//            } else {
//                // if (isLowerCase(c)) {
//                char shiftedChar = (char) ('a' + (c - 'a' + shift) % 26);
//                sb.append(shiftedChar);
//            }
//        }
//        return sb.toString();
//    }

    public String crypt(String text) throws UnsupportedOperationException {

        return rotate(text, 'A');
    }

//        StringBuilder result = new StringBuilder();
//        for (char c : text.toCharArray()) {
//            int index = alphabet.indexOf(c);
//            if (index != -1) {
//                result.append(shiftedAlphabet.charAt(index));
//            } else {
//                result.append(c);
//            }
//        }
//
//        return result.toString();
//    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character startC) {

        StringBuilder result = new StringBuilder();
        int shift = ALPHABET_UPPER.indexOf(Character.toUpperCase(startC));
        if (shift == -1) {
            throw new IllegalArgumentException("Invalid character to start. Must be a letter");
        }
        shift = shift % 26; // Shift within BOUNDs

        for (char c : s.toCharArray()) {
            if (Character.isUpperCase(c)) {
                int idx = ALPHABET_UPPER.indexOf(c);
                if (idx != -1) {
                    char rotated = ALPHABET_UPPER.charAt((idx + shift) % 26);
                    result.append(c);
                } else {
                    result.append(c);
                }
            } else if (Character.isLowerCase(c)) {
                int idx = ALPHABET_LOWER.indexOf(c);
                if (idx != -1) {
                    char rotated = ALPHABET_UPPER.charAt((idx + shift) % 26);

                    result.append(rotated);
                } else {
                    result.append(c);
                }
            }

        }
        return result.toString();
    }
}

