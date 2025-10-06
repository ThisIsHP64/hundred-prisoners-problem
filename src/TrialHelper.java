import java.util.ArrayList;
import java.util.Collections;

public class TrialHelper {
    private static ArrayList<Integer> numbers = new ArrayList<>(); // list of numbers 1-100
    private static Prisoner[] prisoners = new Prisoner[100]; // prisoners
    private static Box[] boxes = new Box[100]; // boxes

    public static void runTrials(int numberOfTrials) {
        // total number of won trials using each strategy
        int wonRand = 0;
        int wonStrat = 0;

        // run the trials
        for(int i = 0; i < numberOfTrials; i++) {
            wonRand += runRandomTrial();
            wonStrat += runStrategizedTrial();
        }

        // calculate and display the win rate for each strategy
        double randWinRate = (double) wonRand / numberOfTrials * 100;
        double stratWinRate = (double) wonStrat / numberOfTrials * 100;
        System.out.println(numberOfTrials + " trials were performed.\n" + wonRand + " trials were won using random box selection.\n" + wonStrat + " trials were won using optimal selection.\n" + randWinRate + "% of trials were won using random box selection.\n" + stratWinRate + "% of trials were won using optimal selection.");
    }

    private static int runRandomTrial() { // runs a trial using the random strategy
        numbers.clear();
        // initialize numbers and prisoners
        for(int i = 0; i < 100; i++) {
            numbers.add(i + 1);
            prisoners[i] = new Prisoner(i + 1);
        }

        // initialize boxes
        for(int i = 0; i < 100; i++) {
            boxes[i] = new Box(i + 1);
        }
        Collections.shuffle(numbers);
        for(int i = 0; i < 100; i++) {
            boxes[i].setSlipNum(numbers.get(i));
        }

        // pick 50 random boxes per prisoner
        outer:
        for(Prisoner p : prisoners) {
            Collections.shuffle(numbers);
            for(int i = 0; i < 50; i++) {
                Box currentBox = findBox(numbers.get(i));
                if(currentBox.getSlipNum() == p.getId()) {
                    continue outer;
                }
            }
            return 0; // prisoner did not find their number
        }
        return 1; // all prisoners found their numbers
    }

    public static int runStrategizedTrial() { // runs a trial using the optimal strategy
        numbers.clear();
        // initialize numbers and prisoners
        for(int i = 0; i < 100; i++) {
            numbers.add(i + 1);
            prisoners[i] = new Prisoner(i + 1);
        }

        // initialize boxes
        for(int i = 0; i < 100; i++) {
            boxes[i] = new Box(i + 1);
        }
        Collections.shuffle(numbers);
        for(int i = 0; i < 100; i++) {
            boxes[i].setSlipNum(numbers.get(i));
        }

        // next box is always the number on the slip from the previous box
        outer:
        for(Prisoner p : prisoners) {
            Box currentBox = findBox(p.getId());
            for(int i = 0; i < 50; i++) {
                if(currentBox.getSlipNum() == p.getId()) {
                    continue outer;
                }
                currentBox = findBox(currentBox.getSlipNum());
            }
            return 0; // prisoner did not find their number
        }
        return 1; // all prisoners found their numbers
    }

    // returns the box with the given id
    private static Box findBox(int id) {
        for (Box b : boxes) {
            if(b.getLidNum() == id) {
                return b;
            }
        }

        return new Box(-1);
    }
}
