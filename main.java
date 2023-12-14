import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение: ");
        String message = scanner.nextLine();

        System.out.println("Введите ключ: ");
        String key = scanner.nextLine();

        String encryptedMessage = encrypt(message, key);
        System.out.println("зашифрованное сообщение: " + encryptedMessage);
    }

    private static String encrypt(String message, String key) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0, j = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(j);

            if (Character.isUpperCase(messageChar)) {
                int encryptedCharIndex = (messageChar - 'А' + keyChar - 'А') % 32;
                encryptedMessage.append((char) ('А' + encryptedCharIndex));
            } else if (Character.isLowerCase(messageChar)) {
                int encryptedCharIndex = (messageChar - 'а' + keyChar - 'а') % 32;
                encryptedMessage.append((char) ('а' + encryptedCharIndex));
            } else {
                encryptedMessage.append(messageChar);
            }

            j = (j + 1) % key.length();
        }

        return encryptedMessage.toString();
    }
}
