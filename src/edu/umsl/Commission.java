
package edu.umsl;
import java.util.Scanner;

/**
 *
 * @author pgkb78
 */
public class Commission extends Employee 
{
//    @Override
    
    public Commission(char argep)
    {
    //from the constructor in Employee.java --> (hours, rate) ; figure out how to add in char selection: Salary, exec, commission
        super(argep, 40, 30);
    }
    
    
    @Override
    public void calcGrossPay()
    {
        int items;
        float itemPrice;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("How many items were sold by this commissioned employee? ");
        items = sc.nextInt();
        
        System.out.print("Excellent.  What was the price per unit? $");
        itemPrice = sc.nextInt();
        
        gross = (float)((items * itemPrice)*.50);
    }
    
}
