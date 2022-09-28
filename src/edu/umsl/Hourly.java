/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.util.Scanner;

public class Hourly extends Employee
{

    public Hourly(char argep)
    {
    //from the constructor in Employee.java --> (hours, rate) ; figure out how to add in char selection: Salary, exec, commission
        super(argep,40,30);
    }
    
    
    public void calcGrossPay() 
    {
        Scanner sc = new Scanner(System.in);
        float overtime;
        
        System.out.print("How many hours did this employee work for? ");
        hours = sc.nextInt();
        
        System.out.print("What is this employees earnings per hour? $");
        rate = sc.nextInt();
        
        if (hours > 40) {
            overtime = (hours - 40);
            overtime = (float) ((40 * rate) + (hours - 40) * (rate * 1.5));
            gross = overtime * rate * 1.5f;
        }
        else {
            overtime = 0;
            gross = rate * hours;
        }
    }
}
