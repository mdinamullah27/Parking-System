
package parking.system;

import java.util.Scanner;


public class LoginSystem  {
    private String  password,Username;
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    
    public int Login(String a,String b,int count)
    {
       Scanner s =new Scanner(System.in);
       String p,u;
       System.out.print("Enter Your UserName:");
       u=s.nextLine();
       System.out.printf("\nEnter Your Password:");
       p=s.nextLine();
       
        for (int i = 0; i < 5; i++) {
            if(u.equals(a)&&p.equals(b))
            {
                System.out.println("Login Successfully");
                break;
            }
            else
            {
                System.out.println("Wrong Password or Username");
                
                System.out.print("\nEnter Right UserName:");
                u=s.nextLine();
                System.out.printf("\nEnter Right Password:");
                p=s.nextLine();
                count++;
                
            }
        }
        return count;
    }
}
