public class Alphabet {

    private final String ALPHABET_CHARS;

    public Alphabet(String alphabetChars) {
        ALPHABET_CHARS = alphabetChars;
    }

    public boolean contain(char c) {
        return ALPHABET_CHARS.contains(String.valueOf(Character.toLowerCase(c)));
    }

    public int getIndex(char c) {
        int index = ALPHABET_CHARS.indexOf(String.valueOf(Character.toLowerCase(c)));
        if (index < 0)
            throw new CharNotFoundException("Char: " + c + " not found.");

        return index;
    }

    public char getChar(int index) {
        index = index % ALPHABET_CHARS.length();

        if (index < 0) {
            index = ALPHABET_CHARS.length() + index;
        }

        return ALPHABET_CHARS.charAt(index);
    }
}
