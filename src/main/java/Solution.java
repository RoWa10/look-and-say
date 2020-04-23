import java.util.*;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // read values with in.next...() methods
        int iterations = in.nextInt();
        // code your solution here
        String sequence = getSequence(iterations, new StringBuilder("1"));

        // Write result with System.out.println()
        System.out.println(sequence);
    }

    private static String getSequence(int input, StringBuilder previousSequence) {
        if (input == 0) {
            return previousSequence.toString();
        }

        int counter = 0;
        StringBuilder sequence = new StringBuilder();
        char currentCharacter = previousSequence.charAt(0);

        for (int i = 0; i < previousSequence.length(); i++) {
            char character = previousSequence.charAt(i);
            if (character != currentCharacter) {
                sequence.append(counter) ; //first add the count
                sequence.append(currentCharacter); //count follwed by the actual number
                counter = 0;

                currentCharacter = character;

            }
            counter++;
        }
        sequence.append(counter) ; //first add the count
        sequence.append(currentCharacter); //count follwed by the actual number
        return getSequence(input - 1, sequence);
    }
}
