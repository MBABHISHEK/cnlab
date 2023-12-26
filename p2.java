import java.util.Scanner;

public class CRC {
    public static String crc(String data, String poly, boolean errChk) {
        String rem = data;
        if (!errChk) {
            for (int i = 0; i < poly.length() - 1; i++)
                rem += "0";
        }
        for (int i = 0; i < rem.length() - poly.length() + 1; i++) {
            if (rem.charAt(i) == '1') {
                for (int j = 0; j < poly.length(); j++) {
                    rem = rem.substring(0, i + j) + (rem.charAt(i + j) == poly.charAt(j) ? '0' : '1') + rem.substring(i + j + 1);
                }
            }
        }
        return rem.substring(rem.length() - poly.length() + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String poly = "10000100010001010";

        System.out.print("Enter Data to be sent: ");
        String data = scanner.nextLine();

        String rem = crc(data, poly, false);
        String codeword = data + rem;

        System.out.println("Remainder: " + rem);
        System.out.println("Codeword: " + codeword);

        // Checking error
        System.out.print("Enter received codeword: ");
        String recvCodeword = scanner.nextLine();

        String recvRem = crc(recvCodeword, poly, true);

        if (Integer.parseInt(recvRem) == 0) {
            System.out.println("No Error");
        } else {
            System.out.println("Error Detected");
        }

        scanner.close();
    }
}
