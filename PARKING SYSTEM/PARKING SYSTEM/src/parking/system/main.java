
package parking.system;

import java.util.Scanner;


public class main {
       public static void main(String[] args) {
        System.out.println("\n\n******************************WELCOME TO OUR PARKING SYSTEM******************************\n\n\n");
        LoginSystem ss=new LoginSystem();
        
        ss.setPassword("InamKhan");
        ss.setUsername("InamKhan");
        String a=ss.getUsername();
        String b=ss.getUsername();
        int count=1;
        int c=ss.Login(a, b,count);
        
        if(5>=c)
        {
            Scanner s = new Scanner(System.in);
            PARKINGSYSTEM[][] pm = new PARKINGSYSTEM[3][50];
            int i, j;
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 50; j++) {
                    pm[i][j] = new PARKINGSYSTEM();
                    pm[i][j].cpin = 0;
                }
            }
            
            
            PARKINGSYSTEM.option(pm);
        }
        else
        {
            System.out.println("you are Blocked");
        }

    }
}
