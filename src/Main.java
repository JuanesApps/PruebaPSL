import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String[] keys = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twelve", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred", "thousand"};

        //k,v
        HashMap<String, Integer> textToNumber = new HashMap();
        int[] aux1 = {30, 40, 50, 60, 70, 80, 90, 100};
        for (int i = 0; i < keys.length; i++) {
            if (i <= 20) {
                textToNumber.put(keys[i], i);
            } else if (i >= 21 && i <= 28) {
                textToNumber.put(keys[i], aux1[i - 21]);
            } else {
                textToNumber.put(keys[i], 1000);
            }
        }

        HashSet<String> hashSetComplete = new HashSet();
        for (int i = 0; i < keys.length; i++) {
            hashSetComplete.add(keys[i]);
        }

        HashSet<String> hashSetOne = new HashSet();
        for (int i = 1; i <= 9; i++) {
            hashSetOne.add(keys[i]);
        }

        HashSet<String> hashSetTwo = new HashSet();
        for (int i = 11; i <= 19; i++) {
            hashSetTwo.add(keys[i]);
        }

        HashSet<String> hashSetThree = new HashSet();
        hashSetThree.add(keys[10]);
        for (int i = 20; i <= 28; i++) {
            hashSetThree.add(keys[i]);
        }

        Scanner scanner = new Scanner(System.in);

        int answer = 0;

        System.out.print("Sick report:\n");

        String data = scanner.nextLine();

        String[] split = data.split(",");

        while (!data.equals("") && data != null) {

            for (int i = 0; i < split.length; i++) {
                boolean isNumberic = split[i].chars().allMatch(Character::isDigit);
                if (isNumberic) {
                    answer += Integer.parseInt(split[i]);
                } else {
                    StringBuilder temp = new StringBuilder();
                    int first = 0;
                    int second = 0;
                    for (int j = 0; j < split[i].length(); j++) {
                        temp.append(split[i].charAt(j));
                        if (hashSetThree.contains(temp.toString().toLowerCase())) {
                            first += textToNumber.get(temp.toString().toLowerCase());
                            temp = new StringBuilder();
                        } else if (hashSetOne.contains(temp.toString().toLowerCase())) {
                            second += textToNumber.get(temp.toString().toLowerCase());
                            temp = new StringBuilder();
                        }
                        if (first > 0 && second > 0) {
                            answer += (first + second);
                        }
                    }
                }
            }

            data = scanner.nextLine();
            split = data.split(",");
        }

        System.out.println("Hay " + answer + " enfermos en todo el país");
    }

}
