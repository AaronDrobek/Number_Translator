
import java.util.Scanner;

public class Main {

    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] arg) {
        int number;
        do {
            System.out.print("Please enter a positive number between 1 - 999 ");
            while (!keyboard.hasNextInt()) {
                String input = keyboard.next();
                System.out.printf("\"%s\" is not a valid number.\n Please enter a valid number: ", input);
            }
            number = keyboard.nextInt();
        } while (number < 0);

        System.out.printf("You have entered %d\n In english your number is: \n", number);

        int length = String.valueOf(number).length();
        Double middle = Math.floor((number / 10) % 10 - 1);
        Double ceiling = Math.floor((number / 100) % 10);
        Double floor = Math.floor(number % 10);
        Double highCeiling = Math.floor((number / 1000) % 10);


        if (number >= 0) {

            switch (length) {
                case 1:
                    System.out.println(English.NUM_NAMES[floor.intValue()]);
                    break;
                case 2:

                    if (number < 20 && number >= 10) {
                        System.out.println(English.TEEN_NAMES[number - 10]);
                    } else  if (floor.intValue() == 0){
                        System.out.println(English.TENS_NAMES[middle.intValue()]);

                    }else{
                        System.out.println(English.TENS_NAMES[number / 10 - 1] + " " + English.NUM_NAMES[floor.intValue()]);
                    }
                    break;
                case 3:
                    if (middle.intValue() == -1 && floor.intValue() == 0) {
                        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred ");
                    } else if (floor.intValue() == 0) {
                        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred " + English.TENS_NAMES[middle.intValue()]);

                    } else if ((middle.intValue()) == 0) {
                        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred " +
                                 English.TEEN_NAMES[floor.intValue()]);
                    } else if ((middle.intValue()) == -1) {
                        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred " +
                                English.NUM_NAMES[floor.intValue()]);
                    } else {
                        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred " + English.TENS_NAMES[middle.intValue()] +
                                " " + English.NUM_NAMES[floor.intValue()]);

                    }
                    break;
                case 4:
                    if (middle.intValue() == -1 && floor.intValue() == 0 && ceiling.intValue() == 0) {
                        System.out.println(English.NUM_NAMES[highCeiling.intValue()] + " thousand ");
                    } else if (ceiling.intValue() == 0) {
                        System.out.println(English.NUM_NAMES[highCeiling.intValue()] + " thousand " + English.TEEN_NAMES[floor.intValue()]);

                    } else if (number > 999) {
                        System.out.println("---------number not within range, please try again-----------");
                    }
                    break;
                case 5:
                    if (number > 999) {
                        System.out.println("---------number not within range, please try again-----------");
                    }
            }
        }
    }
}


//################################################double digit numbers other than teens.
//( Double floor = Math.floor(number / 1 % 10);
//        System.out.println(English.TENS_NAMES[number/10-1]+" "+English.NUM_NAMES[floor.intValue()]);  )


//
//####################################################double digit numbers 10-19
// System.out.println(English.TEEN_NAMES[number - 10]);


//
//###################################################single digit numbers
//System.out.println(English.NUM_NAMES[number]);

//
//############################################################triple digit numbers
//Double middle = Math.floor((number /10) % 10 -1);
//    Double ceiling = Math.floor((number/100) %10);
//    Double floor = Math.floor(number % 10);
//        System.out.println(English.NUM_NAMES[ceiling.intValue()] + " hundred " + English.TENS_NAMES[middle.intValue()] + " " + English.NUM_NAMES[floor.intValue()] );