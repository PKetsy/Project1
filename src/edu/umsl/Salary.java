package edu.umsl;

import java.util.Scanner;

public class Salary extends Employee
{
    public Salary(char argep)
    {
    //from the constructor in Employee.java --> (hours, rate) ; figure out how to add in char selection: Salary, exec, commission
        super(argep,40,30);
        //try to overload employee constructor to give me more ways to call parent classes constructor
    }
    
    
    public void CalcGrossPay() {
        Scanner sc = new Scanner(System.in);
        int selection;
        
        System.out.print("Hi there.  Are you Staff (S) or Executive (E)? ");
        
        selection = sc.next().charAt(0);
        
        if (selection == 'S' || selection == 's') {
            gross = 50000;
        }
        else if (selection == 'E' || selection =='e') {
            gross = 100000;
        }
    }
}
