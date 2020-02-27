#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<time.h>
time_t rawtime;
struct tm * timeinfo;

struct in
{
    int cpin;
    char name[20];
    char license[20];
    int ihour,imin,ohour,omin;
} car[3][30];

void Vehicle_in();
void Vehicle_out();
void option();
int pin();
int Timefunc();
int one=0;
int *ptr = &one;

//main function is here.70395582

int main()
{
    int i,j;

    for(i=0; i<3; i++)
    {
        for(j=0; j<30; j++)
        {
            car[i][j].cpin=0;
        }

    }

    option();

    return 0;
}

//Choose an option:
//done
void option()
{
    int n,i,j;

    printf("\n\n******************************WELCOME TO OUR PARKING SYSTEM******************************\n\n\n");

    printf("\tWhat do you want?\n\n\t1.Vehicle In\n\t2.Vehicle Out\n\t ");
    scanf("%d",&n);
    system("cls");

    if(n==1)
    {
        Vehicle_in() ;

    }
    else if(n==2)
    {
        Vehicle_out();
    }
    else
        option();


}
void Vehicle_in()
{

    int flag=0,pin1,n,check;
    printf("Vehicle type:\n\n\t1.Motor Cycle\n\t2. Car\n\t3. Mini truck\n\t4.Go back\n\t:");
    scanf("%d",&n);
    system("cls");

    if(n>=1 && n<=3)
    {
        //Space finding.
        for(int i=n-1,int j=0; j<30; j++)
        {
            if(car[i][j].cpin==0)
            {
                printf("***%d,%d is ready for you***\n",i+1,j+1);
                flag = 1;
                check = j;
                break;
            }
        }


        //If space available.
        if(flag==1)
        {
            fflush(stdin);
            printf("Enter your name:");
            gets(car[i][check].name);

            fflush(stdin);
            printf("Enter your license:");
            gets(car[i][check].license);

            pin1=pin();
            printf("Your pin number is %d\n",pin1);
            car[i][check].cpin = pin1;


            //clock function.
            Timefunc(&car[i][check].ihour,&car[i][check].imin);
            printf("time: %d : %d\n",car[i][check].ihour,car[i][check].imin);
            printf("Thank You. Go in....\n\n");
            printf("Press any key +to clear screen_");
            getch();
            system("cls");
        }
        else
        {
            printf("We are sorry,sir! There is no space for your vehicle!");
            printf("\nPress any key to exit.");
            getch();
            system("cls");
            option();
        }
    }
    //Back to main menu.
    else if(n==4)
        option();
    //Wrong input.
    else
    {
        printf("Invalid vehicle type! Press any key to enter again:");
        getch();
        system("cls");
        Vehicle_in();
    }

    option();
}
//pin generate:
int pin()
{
    long long int pin2;
    pin2 = rand()+rand()+rand()*11111;
    return (pin2);
}

//time machine
int Timefunc(int *x,int *y)
{


    time ( &rawtime );
    timeinfo = localtime ( &rawtime );

    *x=timeinfo->tm_hour;
    *y=timeinfo->tm_min;

}

//Vehicle out:

void Vehicle_out()
{
    int pin,n,i,j,t=0;
    double pay=0.0;
    int flag=0,check=0;

    printf("Vehicle type:\n\n\t1.Motor Cycle\n\t2. Car\n\t3. Mini truck\n\t4.Go back\n\t:");
    scanf("%d",&n);

    if(n>=1 && n<=3)
    {
        printf("Enter your pin: ");
        scanf("%d",&pin);
        system("cls");

        //Pin matching

        for(i=n-1,j=0; j<30; j++)
        {
            if(car[i][j].cpin==pin)
            {
                flag=1;
                check = j;
                break;
            }
        }
        if(flag==1)
        {
            printf("\n\nPin Matched!!!\n\nDear %s\nYour -\n\n",car[i][j].name);
            printf("\tLicense is = %s\n",car[i][j].license);
            printf("\tCar position is : %d,%d\n",i+1,j+1);
            Timefunc(&car[n-1][check].ohour,&car[n-1][check].omin);
            //payment();
            if(car[n-1][check].ohour<car[n-1][check].ihour)
            {
                car[n-1][check].ohour+=24;
            }
            t = (car[n-1][check].omin + (car[n-1][check].ohour * 60)) - (car[n-1][check].imin + (car[n-1][check].ihour * 60));
            if(n==1)
            {
                pay = t * 0.67;
            }
            else if(n==2)
            {
                pay = t * 1.34;
            }
            else
                pay = t;

            printf("\tYou parked your vehicle at %d:%d \n\tTotal time spent = %d hour %d minute\n\nPlease pay %.2lf Taka to cash counter...Thank you.....\n",car[n-1][check].ihour,car[n-1][check].imin,((int)t/60),((int)t%60),pay);
            car[n-1][check].cpin=0;
            printf("\nPress any key to exit.");
            getch();
            system("cls");
            option();
        }
        else
        {
            printf("Pin not matched!!! \n Press any key to enter Again:");
            getch();
            system("cls");
            Vehicle_out();
        }
    }
    else if(n==4)
    {
        system("cls");
        option();
    }
    //Wrong input.
    else
    {
        printf("Invalid vehicle type! \n Press any key to enter again:");
        getch();
        system("cls");
        Vehicle_out();
    }

    option();

}
