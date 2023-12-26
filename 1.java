import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

class Frame {

    int seqNo;
    String data;

    public Frame(int seqNo) {
        this.seqNo = seqNo;
    }

}

public class Framesort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE TOTAL SIZE OF THE MESSAGE");
        int total = sc.nextInt();

        System.out.println("ENTER THE SIZE OF EACH DATA PACKET");
        int size = sc.nextInt();

        int n = total / size;
        List<Frame> frames = new ArrayList<Frame>();
        for (int i = 0; i < n; i++) {
            frames.add(new Frame(i));
        }

        for (Frame f : frames) {
            System.out.println("ENTER THE DATA FOR EACH FRAME " + f.seqNo);
            f.data = sc.next();
        }
        Collections.shuffle(frames);
        System.out.println("Before sorting the frames");
        for (Frame f : frames) {
            System.out.println("THE SEQNO " + f.seqNo + " MESSAGE " + f.data);
        }
        Collections.sort(frames, (f1, f2) -> Integer.compare(f1.seqNo, f2.seqNo));

        System.out.println("AFTER sorting the frames");
        for (Frame f : frames) {
            System.out.println("THE SEQNO " + f.seqNo + " MESSAGE " + f.data);
        }

        sc.close();

    }
}
