// Ramatheledza Adzisani 4484298
// Practical prep 1
// Algorithm analysis

import java.util.Scanner;
public class ContractTracing {
    public static void main(String[] args){

        //Ask the user to input the number of patients in the hospital
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of patients: ");
        int numberPatient = scan.nextInt();

        // Followed by arrival and departure times (separated by “,”) for each patient
        // create an array to store data
        int[] arrivalTime = new int[numberPatient];
        int[] departureTime= new int[numberPatient];

        // ask the user to input arrival time and depature time
        for ( int i = 0; i < numberPatient ; i++) {
            System.out.print("Enter the arrival time of patient" + (i + 1) + " : ");
            arrivalTime[i] = scan.nextInt();
            System.out.print("Enter the departure time of patient" + (i + 1) + " : ");
            departureTime[i] = scan.nextInt();

        }


        for (int i = 0; i < numberPatient; i++){
            for (int j = i + 1; j < numberPatient; j++){

                if (arrivalTime[i] <= departureTime[j] && arrivalTime[j] <= departureTime[i]) {

                    System.out.println("(" + (i+1) + ", " + (j+1) + ")");
                }
            }
        }

        scan.close();






    }
}
