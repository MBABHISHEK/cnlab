import java.util.Scanner;

public class LeakyBucket {
    public static void main(String[] args) {
        int noOfQueries;
        int bucketSize;
        int inputPacketSize;
        int outputPacketSize;
        int storedBufferSize = 0;
        int sizeLeft;

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER THE BUCKET SIZE");
        bucketSize = scanner.nextInt();
        System.out.println("ENTER THE NUMBER OF PACKETS");
        noOfQueries = scanner.nextInt();
        System.out.println("ENTER THE OUTPUT RATE");
        outputPacketSize = scanner.nextInt();

        for (int i = 0; i < noOfQueries; i++) {
            System.out.print("ENTER THE SIZE OF THE PACKET :");
            inputPacketSize = scanner.nextInt();

            sizeLeft = bucketSize - storedBufferSize;

            if (inputPacketSize <= sizeLeft) {
                storedBufferSize += inputPacketSize;
                System.out.println("Number of Packets added into Bucket" + inputPacketSize);
            } else {
                System.out.println("Number of Packets Dropped " + (storedBufferSize + inputPacketSize - bucketSize));
                storedBufferSize = bucketSize;
            }
            /* System.out.println("Stored Buffer Size: " + storedBufferSize); */
            storedBufferSize -= outputPacketSize;
        }

        scanner.close();
    }
}
