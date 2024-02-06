public interface EmpInterface {
    //create employee
    public void createEmployee(Employee emp);
    //show all employee
    public void showAllEmployee();
    //show employee by id
    public void showEmployeeId(int id);
    //update employee
    public void updateEmployee(int id,String name,int age);
    //delete employee
    public void deleteEmployee(int id);

}
