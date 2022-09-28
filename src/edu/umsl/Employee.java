/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author pgkb78
 */

//employee, hourly, salary, commission, payroll (or runEmployee ).  Note that readWriteExample will be from payroll file 
    public class Employee implements Serializable
    {
        private char employeePosition;
        float rate = 30.0f;
        float overtime;
        float taxrate = 0.2f;
        int   hours = 45;
        float gross = 0.0f;
        float tax = 0.0f;
        float net = 0.0f;
        float net_percent = 0.0f;

        
    public void setHours(float hrs)
    {
        float setHours = hrs;
    }
    
    public int getHours(float hrs) 
    {
        return hours;
    }

    
    
    public void setRate(float sr)
    {
        float setRate = sr;
    }
    
    public int getRate(float sr)
    {
        return (int) rate;
    }
    
    
    
    public void setTaxrate(float tr)
    {
        float setTaxrate = tr;
    }

    
    
    public void setGross(float sg)
    {
        float setGross = sg;
    }

    public void setTax(float tx)
    {
        float setTax = tx;
    }

    //constructor - local variables take precedence over global variables
    public Employee(char employeePosition,int hours, int rate) 
    {
         this.employeePosition = employeePosition;
         this.hours = hours;
         this.rate = rate;
     }
    public void showAll()
    {
        System.out.println();
        System.out.println("Hours Worked: " + hours);
        System.out.println("Pay Rate: " + rate + "/hour");
        System.out.println("Tax Rate: " + taxrate );
        System.out.println("Gross Pay: " + gross);
        System.out.println("Tax Amount: " + tax);
        System.out.println("Net Pay: " + net);
        System.out.println();
    }


    public void calcGrossPay()
    {
      if (hours <= 40)
      {
       gross = (hours * rate);
      }
      else if (hours > 40)
      {
       overtime = (rate * 1.5f);
       gross = ((40 * rate) + ((hours - 40) * overtime));
      }
      System.out.println("Gross Pay: $" + gross);
    }
        
    protected void calcTax()
    {
      if(hours <= 40)
      {
            tax = (float) ((hours * rate) * 0.25);
      }
       else if (hours > 40)
       {
            tax = (float) (((40 * rate) * 0.25) + (((hours-40) * overtime) * .40));
       }
            System.out.println("Taxes deducted: $" + tax);
    }
    
   
    protected void calcNetPay()
    {
     net = (gross - tax);
     System.out.println("Net Pay: $" + net);
    }
    
    protected void calcNetPercent()
    {
     net_percent = (net / gross);
     System.out.println("Net Percent: $" + net);
    }



    public void menu() 
    {
      Scanner sc = new Scanner(System.in);

         int selection = 0;
         boolean exit = false;
         while(!exit) {
             calcGrossPay();
             calcTax();
             calcNetPay();
             calcNetPercent();
             System.out.println("");
             System.out.print("You may find information for this employee above.  Enter 6 to exit:");
             System.out.println("");
//             System.out.println("");
//             System.out.println("1) Calculate Gross Pay:");
//             System.out.println("2) Calculate Tax:");
//             System.out.println("3) Calculate Net Pay:");
//             System.out.println("4) Calculate Net Percent:");
//             System.out.println("5) Display all:");
//             System.out.println("6) Exit:");
             
             selection = sc.nextInt();
             System.out.println("");
             System.out.println("");



             if(selection < 1 || selection > 6) 
             {
                 System.out.println("???");
                 System.out.println("That selection was invalid.  Try again?:");
             }

             switch(selection) 
             {
                 case 1: 
                 {
                     calcGrossPay();
                     break;
                 }
                 case 2:
                 {
                     calcTax();                    
                     break;
                 }
                 case 3:
                 {
                     calcNetPay();
                     break;
                 }
                 case 4:
                 {
                     calcNetPercent();
                     break;
                 }
                 case 5:
                 {
                     showAll();
                     break;
                 }
                 case 6: 
                 {
                     exit = true;
                 }                                                                          
         }
     }
  }

    /**
     * @return the employeePosition
     */
    public char getEmployeePosition() {
        return employeePosition;
    }

    /**
     * @param employeePosition the employeePosition to set
     */
    public void setEmployeePosition(char employeePosition) {
        this.employeePosition = employeePosition;
    }
}

