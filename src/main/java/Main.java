import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Alphabet engAlphabet = new Alphabet("abcdefghijklmnopqrstuvwxyz");
        Alphabet rusAlphabet = new Alphabet("абвгдеёжзийклмнопрстуфхцчшщъыьэюя");

        CaesarCipher caesarCipher = new CaesarCipher(3);
        caesarCipher.addAlphabet(engAlphabet);
        caesarCipher.addAlphabet(rusAlphabet);

        Scanner scanner = new Scanner(System.in);
        String command;
        int mode = 1;
        System.out.println("Сдвиг вправо");
        while(true) {
            command = scanner.nextLine();
            switch (command) {
                case "1":
                    mode = 1;
                    System.out.println("Сдвиг вправо");
                    break;
                case "2":
                    mode = 2;
                    System.out.println("Сдвиег влево");
                    break;
                case "exit": {
                    return;
                }
                default:
                    if (mode == 1) {
                        System.out.println(caesarCipher.right(command));
                    } else {
                        System.out.println(caesarCipher.left(command));
                    }
                    break;
            }

        }
    }
}
