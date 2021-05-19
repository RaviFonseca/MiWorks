package Program;


import Entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc= new Scanner(System.in);
        List<Employee> list= new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int n=sc.nextInt();

        for (int i=0;i<n;i++){
            System.out.println("Employee #"+(i+1)+":");
            System.out.print("Id: ");
            int id=sc.nextInt();

            while(hasId(list,id)){
                System.out.print("ID already exists!! Try again: ");
                id=sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name=sc.nextLine();
            System.out.print("Salary: ");
            double salary=sc.nextDouble();

            Employee employee=new Employee(id,name,salary);
            list.add(employee);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int idIncrease=sc.nextInt();

        Employee emp=list.stream().filter(x->x.getId()==idIncrease).findFirst().orElse(null);
        if(emp==null){
            System.out.println("This id does not exist!!");
        }else{
            System.out.println("Enter the percentage: ");
            double percent=sc.nextDouble();
            emp.salaryIncrease(percent);
        }

        System.out.println("List of Employee: ");
        for(Employee x: list){
            System.out.println(x);
        }


        sc.close();
    }

    public static Boolean hasId(List<Employee> list,int id){
        Employee emp= list.stream().filter(x->x.getId()==id).findFirst().orElse(null);
        return emp!=null;
    }

    public static Integer position(List<Employee> list, int id){
        for(int i=0;i< list.size();i++){
            if (list.get(i).getId()==id){
                return i;
            }
        }
        return null;
    }


}
