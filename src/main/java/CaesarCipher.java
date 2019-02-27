import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CaesarCipher {

    private enum Type {
        RIGHT,
        LEFT
    }

    private List<Alphabet> alphabets;

    private final int key;

    public CaesarCipher(int key) {
        this.key = key;
        alphabets = new ArrayList<>();
    }

    public void addAlphabet(Alphabet alphabet) {
        alphabets.add(alphabet);
    }

    public String right(String string) {
        return crypt(string, Type.RIGHT);
    }

    public String left(String string) {
        return crypt(string, Type.LEFT);
    }

    private String crypt(String string, Type type) {
        int sign = 1;
        if (type == Type.LEFT) {
            sign = -1;
        }

        if (string.length() == 0) {
            return string;
        }

        StringBuilder result = new StringBuilder();

        Alphabet alphabet = null;
        char current;
        char foundChar;
        for (int i = 0; i < string.length(); i++) {
            current = string.charAt(i);

            if (!Character.isLetter(current)) {
                result.append(current);
                continue;
            }

            if (Objects.isNull(alphabet) || !alphabet.contain(current)) {
                alphabet = getAlphabet(current);
            }

            foundChar = alphabet.getChar(alphabet.getIndex(current) + key * sign);
            if (Character.isUpperCase(current)) {
                foundChar = Character.toUpperCase(foundChar);
            }

            result.append(foundChar);
        }

        return result.toString();
    }


    private Alphabet getAlphabet(char c) {
        for (Alphabet alphabet : alphabets) {
            if (alphabet.contain(c)) {
                return alphabet;
            }
        }
        throw new AlphabetNotFoundException("Alphabet not found for char: " + c + ".");
    }
}
