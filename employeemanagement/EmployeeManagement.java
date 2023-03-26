package employeemanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@SupperessWarnings("serial")
class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	float salary;
	long contact_no;
	String email_id;
	
	//create a constructor
	public Employee(int id, String name, float salary, long contact_no, String email_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.email_id = email_id;
	}
	public String toString() {
		return "\nEmployee Details :"+"\nID : "+this.id +"\nName : "+this.name+"\nSalary : "+this.salary+
				"\nContact No : "+this.contact_no+"\nEmail Id : "+this.email_id;
		}
}

public class EmployeeManagement {
	//create display function 
	static void display(ArrayList<Employee>al) {
		System.out.println("\n    -----------------------------Employee List--------------------------------\n");
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","Salary","Contact-no","Email Id"));
		
		for(Employee e : al) {
			System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s", e.id, e.name, e.salary, e.contact_no, e.email_id));
		}
	}
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int id;
		String name;
		float salary;
		long contact_no ;
		String email_id;
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> arraylist = new ArrayList <Employee>();
		
		File file = null;
		FileInputStream fileinput = null;
		ObjectInputStream objectinput =null;
		FileOutputStream fileoutput = null;
		ObjectOutputStream objectoutput = null;
		
	    try {
			file=new File("D:/projects/java_practice/employeemanagement/src/EmployeeDataList1.txt");
			if (file.exists()) {
				fileinput = new FileInputStream(file);
				objectinput = new ObjectInputStream(fileinput);
				arraylist = (ArrayList<Employee>)objectinput.readObject();
			}
		}
		catch(Exception exp) {
			System.out.println(exp);
		}
	    do {
	    	System.out.println("\n***********Welcome To Employee Management System*************\n");
	    	System.out.println("1) Add Employee to Data Base\n"+
	    	                   "2) Search for Employee\n"+
	    			           "3) Edit Employee Details\n"+
	    	                   "4) Delete Employee Details\n"+
	    			           "5) Display all Employee Working in this company\n"+
	    	                   "6) EXIT\n");
	    	System.out.println("Enter your Choice : ");
	    	int ch = sc.nextInt();
	    	
	    	switch(ch) {
	    	case 1 :System.out.println("\nEnter the following details to Add list:\n ");
	    	        System.out.println("Enter ID : ");
	    	        id = sc.nextInt();
	    	        System.out.println("Enter Name : ");
	    	        name = sc.next();
	    	        System.out.println("Enter Salary : ");
	    	        salary = sc.nextFloat();
	    	        System.out.println("Enter contact no : ");
	    	        contact_no =sc.nextLong();
	    	        System.out.println("Enter Email ID : ");
	    	        email_id=sc.next();
	    	        arraylist.add(new Employee(id,name,salary,contact_no,email_id));
	    	        display(arraylist);
	    	        break;
	    	case 2 : System.out.println("Enter the Employee ID to Search : ");
	    	         id = sc.nextInt();
	    	         int i=0;
	    	         for(Employee e: arraylist) {
	    	        	 if(id ==e.id) {
	    	        		 System.out.println(e+"\n");
	    	        		 i++;
	    	        	 }
	    	         }
	    	         if(i ==0) {
	    	        	 System.out.println("\nEmployee details are not available. please enter valid ID !!!");
	    	         }
	    	         break;
	    	case 3 : System.out.println("\nEnter the Employee ID to EDIT the details");
	    	         id = sc.nextInt();
	    	         int j= 0;
	    	         for(Employee e:arraylist) {
	    	        	 if(id == e.id) {
	    	        		 j++;
	    	        	 }
	    	        	 do {
	    	        		 int ch1 = 0;
	    	        		 System.out.println("\nEDIT Employee Details : \n"+
	    	        		                    "1) Employee ID\n"+
	    	        				            "2) Name\n"+
	    	        		                    "3) Salary\n"+
	    	        				            "4) Contact no \n"+
	    	        		                    "5) Email ID\n"+
	    	        				            "6) Go Back\n");
	    	        		 System.err.println("Enter your choise : ");
	    	        		 ch1 = sc.nextInt();
	    	        		 switch (ch1) {
	    	        		 case 1: System.out.println("\n Enter new Employee ID : ");
	    	        		         e.id =sc.nextInt();
	    	        		         System.out.println(e+"\n");
	    	        		         break;
	    	        		 case 2: System.out.println("\n Enter new Employee Name : ");
	        		                 sc.nextLine();
	        		                 e.name = sc.nextLine();
	        		                 System.out.println(e+"\n");
	        		                 break;
	    	        		         
	    	        		 case 3: System.out.println("\n Enter new Employee Salary : ");
	        		                 e.salary =sc.nextFloat();
	        		                 System.out.println(e+"\n");
	        		                 break;
	        		          
	    	        		 case 4: System.out.println("\n Enter new Employee Contact No. : ");
	        		                 e.contact_no =sc.nextLong();
	        		                 System.out.println(e+"\n");
	        		                 break;     
	        		                 
	    	        		 case 5: System.out.println("\n Enter new Employee Email ID : ");
	        		                 e.email_id =sc.next();
	        		                 System.out.println(e+"\n");
	        		                 break;
	        		         
	        		         case 6 :j++;
	        		                break;
	        		                
	        		         default : System.out.println("\nEnter a correct choice from the list : ");
	        		                  break;
	    	        		 }
	    	        	 } 
	    	        	 while(j==1);
	    	         }
	    	        if(j==0) {
	    	        	System.out.println("\nEmployee Detail are not available. Please enter a valid ID !!!");
	    	        }
	    	        break;
	    	case 4: System.out.println("\nEnter Employee ID to Delete form the Database : ");
	    	       id = sc.nextInt();
	    	       int k=0;
	    	       try {
	    	    	   for(Employee e:arraylist) {
	    	    		   if(id ==e.id) {
	    	    			   arraylist.remove(e);
	    	    			   display(arraylist);
	    	    			   k++;
	    	    		   }
	    	    	   }
	    	    	   if(k ==0) {
	    	    		   System.out.println("\nEmployee Details are not available, please enter a valid ID!!!");
	    	    		   
	    	    	   }
	    	    	   }

    	    	   catch(Exception ex) {
    	    		   System.out.println(ex);
    	    	   }
	    	       break;
	    	    	
	    	 case 5: try {
	    		 arraylist = (ArrayList<Employee>)objectinput.readObject();
	    	    	   
	    	       }
	    	      catch(ClassNotFoundException e2) {
	    	    	  System.out.println(e2);
	    	      }
	    	      catch(Exception e2) {
	    	    	  System.out.println(e2);
	    	      }
	    	      display(arraylist);
	    	      break;
	    	 case 6:try {
	    		 fileoutput = new FileOutputStream(file);
	    		 objectoutput = new ObjectOutputStream(fileoutput);
	    		 objectoutput.writeObject(arraylist);
	    	   }     
	    	 catch(IOException e1) {
	    		 e1.printStackTrace();
	    	 }
	    	 catch(Exception e2) {
	    		 e2.printStackTrace();
	    	 }
	    	 finally {
	    		 try {
	    			 fileinput.close();
	    			 objectinput.close();
	    			 fileoutput.close();
	    			 objectoutput.close();
	    		 }
	    		 catch(Exception e1) {
	    			 e1.printStackTrace();
	    		 }
	    	 }
	    	 System.out.println("\nYou have chose Exit  !! Saving Files and closing the tool.Thank You.....");
	    	 sc.close();
	    	 System.exit(0);
	    	 break;
	    
	    default : System.out.println("\nEnter correct choice from the list : ");	 
	    	}	
		}
	    while(true);
	    	
	}
	
}

