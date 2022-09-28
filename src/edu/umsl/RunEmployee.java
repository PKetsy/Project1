/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umsl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author pgkb78
 */

public class RunEmployee
{
    //encapsulating myEmployees (has-a-relationship) (is-a-relationship would be INHERITANCE
    Employee[] myEmployees = new Employee[3];
    Employee emp;
    static Scanner sc = new Scanner(System.in);
    
    
    public static void main(String[] args) throws IOException
    {
       RunEmployee re = new RunEmployee();
       re.menu();
    }
    
    public void menu() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int selection;
        
        do
        {
            System.out.println("1. Populate Employee");
            System.out.println("2. Select Employee");
            System.out.println("3. Save Employee Data");
            System.out.println("4. Load Employee Data");
            System.out.println("5. Exit");
            System.out.println(" ");
            
            
            System.out.println("Hello there.  Please make a selection");
            selection = Integer.parseInt(sc.next());
            
            switch (selection) {
                case 1: 
                    populateEmployee();
                    break;
                    
                case 2: 
                    selectEmployee();
                    break;
                    
                case 3: 
                    writeEmployee();
                    break;
                    
                case 4:
                    loadEmployee();
                    break;
                default:
                    break;
            }
        } while (selection !=5);
    }
    
    
    public void populateEmployee()
    {
        char employeePosition;
          //employeePosition is acting as user input
          //let it note: this might need to be a temp variable.  'tempemployeePosition'
        
        int temphrs;
        int temppr;
        int selectedIndex = 0;
        
        
        for (int i = 0; i < myEmployees.length; i++)
        {
            if(myEmployees[i] == null)
            {
                System.out.println("Please enter the type of position for this employee: 'H' for hourly, 'S' for salary, or 'C' for commissioned ");
                employeePosition = sc.next().charAt(0);
                
                switch (employeePosition)
                {
                    case 'H':
                    case 'h':
                        myEmployees[selectedIndex] = new Hourly(employeePosition);
                        myEmployees[selectedIndex].calcGrossPay();
                        break;
                        
                    case 'S':
                    case 's':
                        myEmployees[selectedIndex] = new Salary(employeePosition);
                        myEmployees[selectedIndex].calcGrossPay();
                        break;
                    case 'C':
                    case 'c':
                        myEmployees[selectedIndex] = new Commission(employeePosition);
                        myEmployees[selectedIndex].calcGrossPay();
                        break;
                    default:
                        break;
                }
            }
            
            else if(myEmployees[i] != null)
            {
                System.out.println("Sorry, Employee array is full.  Nice try.");
                break;
            }
        }
    }
    
    public void selectEmployee() throws IOException
    {
       try
       {
           System.out.print("Please select one of the three employees in the array.  0, 1, or 2: ");
           int selection = sc.nextInt();
           myEmployees[selection].menu();
       }
       catch(Exception ioe)
       {
           System.out.println("Nope.  Please try another employee");
           System.out.println(" ");
           selectEmployee();
       }
    }
    
    
    
    public void writeEmployee()
    {
        try
        {
            //EmployeeList.txt is a relative path for the file in question.  We can also use absolute but we must know exact file location
            FileOutputStream fos = new FileOutputStream("EmployeeList.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(myEmployees);
            oos.flush();
            fos.close();
            //closing the connection to the file - NOT the output stream
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println(fnfe);
        }
        catch (IOException ioe)
        {
            System.err.println(ioe);
        }
    }
    
    public void loadEmployee()
    {
        try
        {
            FileInputStream fis = new FileInputStream("EmployeeList.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            myEmployees = (Employee[])ois.readObject();
            fis.close();
            
            for (int i = 0; i < 3; i++)
            {
                System.out.println(myEmployees[i].getEmployeePosition()
                        + " " + myEmployees[i].getHours(i) + " Hours worked "
                        + " $ " + myEmployees[i].getRate(i) + " per hour");
            }
        }
        
        catch (Throwable e)
        {
            System.err.println(e);
        }
    }
}
