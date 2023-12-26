import java.util.Random;

public class PacketSimulation {

    static final int MAX_PACKETS = 20;
    static final int QUEUE_SIZE = 10;
    static final double MAX_PROBABILITY = 0.7;
    static final double MIN_PROBABILITY = 0.3;

    public static void main(String[] args) {
        Random rand = new Random();
        int queueLength = 0;
        double dropProbability = MIN_PROBABILITY;

        for (int i = 0; i < MAX_PACKETS; i++) {
            if (queueLength == QUEUE_SIZE) {
                System.out.println("Packet dropped (QUEUE FULL)");
                dropProbability = MIN_PROBABILITY;
            } else if (rand.nextDouble() < dropProbability) {
                System.out.println("Packet dropped (RANDOM)");
                dropProbability += (MAX_PROBABILITY - MIN_PROBABILITY) / (MAX_PACKETS - 1);
            } else {
                System.out.println("Packet accepted");
                queueLength++;
                dropProbability = MIN_PROBABILITY;
            }
        }
    }
}
