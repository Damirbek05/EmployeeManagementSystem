import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        String name;
        int id;
        int age;
        Scanner scan = new Scanner(System.in);
        EmpImpl empImpl = new EmpImpl();
        System.out.println("Welcome to Employee Management application");

        do {
            System.out.println("1. Add employee\n" +
                    "2. Show all employee\n" +
                    "3. Show employee by ID\n" +
                    "4. Update employee\n" +
                    "5. Delete employee\n" +
                    "6. Exit the application\n");
            System.out.print("Enter choice: ");
            int ch = scan.nextInt();
            switch (ch){
                case 1:
                    Employee emp = new Employee();
                    System.out.println("Enter ID: ");
                    id = scan.nextInt();
                    System.out.println("Enter name: ");
                    name = scan.next();
                    System.out.println("Enter age: ");
                    age = scan.nextInt();
                    System.out.println("Enter salary: ");
                    double salary = scan.nextDouble();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setAge(age);
                    emp.setSalary(salary);
                    empImpl.createEmployee(emp);
                    break;
                case 2 :
                    empImpl.showAllEmployee();
                    break;
                case 3 :
                    System.out.println("Enter employee ID: ");
                    id = scan.nextInt();
                    empImpl.showEmployeeId(id);
                    break;
                case 4:
                    System.out.println("Enter employee ID to update : ");
                    id = scan.nextInt();
                    System.out.println("Enter employee new name: ");
                    name = scan.next();
                    System.out.println("Enter employee new age:");
                    age = scan.nextInt();
                    empImpl.updateEmployee(id,name,age);
                    break;
                case 5:
                    System.out.println("Enter employee ID to delete:");
                    id = scan.nextInt();
                    empImpl.deleteEmployee(id);
                    break;
                case 6 :
                    System.out.println("Thank you for using my application");
                    System.exit(0);
                default:
                    System.out.println("Enter valid choice !\n");
                    break;

            }
        } while(true);
    }
}