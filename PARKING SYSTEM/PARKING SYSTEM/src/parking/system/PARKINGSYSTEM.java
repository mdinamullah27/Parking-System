package parking.system;

import java.util.Scanner;

public class PARKINGSYSTEM extends TimePin {

    int cpin;
    String name;
    String license;
    int ihour, imin, ohour, omin;
 
    public static void option(PARKINGSYSTEM pm[][]) {
        System.out.println("\n\n******************************WELCOME TO OUR PARKING SYSTEM******************************\n\n\n");
        System.out.println("\tWhat do you want?\n\n\t1.Vehicle In\n\t2.Vehicle Out\n\t3.Exit\n\t ");
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        // system("cls");Inam
        switch (n) {
            case 1: {
                
                PARKINGSYSTEM.Vehicle_in(pm);

                break;
            }
            case 2:
                PARKINGSYSTEM.Vehicle_out(pm);
                break;
            case 3:
                System.exit(n);

            default:
                PARKINGSYSTEM.option(pm);

        }
    }

    public static void Vehicle_out(PARKINGSYSTEM pm[][]) {
        Scanner s = new Scanner(System.in);

        int pin, i, j, n, t;
        double pay;

        int flag = 0, check = 0;

        System.out.println("Vehicle type:\n\n\t1.Motor Cycle\n\t2. Car\n\t3. Mini truck\n\t4.Go back\n\t:");
        n = s.nextInt();

        if (n >= 1 && n <= 3) {
            System.out.print("Enter your pin: ");
            pin = s.nextInt();
            // system("cls");

            //Pin matching
            for (i = n - 1, j = 0; j < 30; j++) {
                if (pm[i][j].cpin == pin) {
                    flag = 1;
                    check = j;
                    break;
                }
            }
            if (flag == 1) {
                System.out.printf("\n\nPin Matched!!!\n\nDear %s\nYour -\n\n", pm[i][j].name);
                System.out.printf("\tLicense is = %s\n", pm[i][j].license);
                System.out.printf("\tCar position is : %d,%d\n", i + 1, j + 1);

                pm[n - 1][check].ohour = PARKINGSYSTEM.Time();
                pm[n - 1][check].omin = PARKINGSYSTEM.Time2();
              //  System.out.println(pm[n - 1][check].ihour);
               // System.out.println(pm[n - 1][check].ohour);

                //payment();
                if (pm[n - 1][check].ohour < pm[n - 1][check].ihour) {

                    pm[n - 1][check].ohour += 12;
                }
                t = (pm[n - 1][check].omin + (pm[n - 1][check].ohour * 60)) - (pm[n - 1][check].imin + (pm[n - 1][check].ihour * 60));

                switch (n) {
                    case 1:
                        pay = t * 0.67 + 50;
                        break;
                    case 2:
                        pay = t * 1.34 + 50;
                        break;
                    default:
                        pay = t = 50;
                        break;
                }

                int t1 = (int) t % 60;
                int t2 = (int) t / 60;
                System.out.printf("\tYou parked your vehicle at" + pm[n - 1][check].ihour + " " + pm[n - 1][check].imin + " \n\tTotal time spent = " + t2 + " hour " + t1 + " minute " + "\n\nPlease pay " + pay + "Taka to cash counter...Thank you.....\n");
                pm[n - 1][check].cpin = 0;
                System.out.println("\nPress any key to exit.");

                // system("cls");
                PARKINGSYSTEM.option(pm);
            } else {
                System.out.println("Pin not matched!!! \n Press any key to enter Again:");
                //  getch();
                //system("cls");
                PARKINGSYSTEM.Vehicle_out(pm);
            }
        } else if (n == 4) {
            //system("cls");
            PARKINGSYSTEM.option(pm);
        } //Wrong input.
        else {
            System.out.println("Invalid vehicle type! \n Press any key to enter again:");
            //getch();
            //system("cls");
            PARKINGSYSTEM.Vehicle_out(pm);
        }

        PARKINGSYSTEM.option(pm);

    }

    public static void Vehicle_in(PARKINGSYSTEM pm[][]) {
        Scanner s = new Scanner(System.in);
        int flag = 0, pin1, l, check = 0;
        System.out.println("Vehicle type:\n\n\t1.Motor Cycle\n\t2. Car\n\t3. Mini truck\n\t4.Go back\n\t:");
        l = s.nextInt();
        //system("cls");
        int i, j;
        if (l >= 1 && l <= 3) {
            //Space finding.

            for (i = l - 1, j = 0; j < 50; j++) {
                if (pm[i][j].cpin == 0) {
                    System.out.printf("***%d,%d is ready for you***\n", i + 1, j + 1);
                    flag = 1;

                    check = j;
                    break;
                }
            }
            if (flag == 1) {

                System.out.print("Enter your name: ");

               // pm[i][check].name = s.nextLine();
                s.nextLine();
                pm[i][check].name = s.nextLine();
               
                // fflush(stdin);
                System.out.print("Enter your license:");
                pm[i][check].license = s.nextLine();
               

                pin1 = PARKINGSYSTEM.pin();
                System.out.printf("Your pin number is %d\n", pin1);
                pm[i][check].cpin = pin1;

                //clock function.
                String time = PARKINGSYSTEM.Time3();

                pm[i][check].ihour = PARKINGSYSTEM.Time();
                pm[i][check].imin = PARKINGSYSTEM.Time2();

                System.out.println("Time=" + time);
                System.out.println("Thank You. Go in....\n\n");
                System.out.println("Press any key +to clear screen_");

                // system("cls");
            } else {
                System.out.println("We are sorry,sir! There is no space for your vehicle!");
                System.out.println("\nPress any key to exit.");

                //system("cls");
                PARKINGSYSTEM.option(pm);
            }
        } //Back to main menu.
        else if (l == 4) {
            PARKINGSYSTEM.option(pm);
        } else {
            System.out.println("Invalid vehicle type! Press any key to enter again:");

            // system("cls");
            PARKINGSYSTEM.Vehicle_in(pm);
        }

        PARKINGSYSTEM.option(pm);
    }
}
