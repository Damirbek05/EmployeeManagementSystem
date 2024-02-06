import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class EmpImpl implements EmpInterface {
    Connection con;
    private String query;
    @Override
    public void createEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        query = "insert into employee values(?,?,?,?)";
        try {
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setInt(3,emp.getAge());
            pstm.setDouble(4,emp.getSalary());

            int count = pstm.executeUpdate();
            if(count != 0){
                System.out.println("Employee Inserted Successfully !");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void showAllEmployee() {
        con = DBConnection.createDBConnection();
        query = "select * from employee";
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            System.out.println("Employee Details");
            System.out.println("------------------------------");
            System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Age","Salary");
            System.out.println("------------------------------");

            while(result.next()){
                System.out.format("%d\t%s\t%d\t%f\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getInt(3),
                        result.getDouble(4));
                System.out.println("------------------------------");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void showEmployeeId(int id) {
        con = DBConnection.createDBConnection();
        query = "SELECT * FROM employee WHERE id="+id;
        try{
            Statement stmt = con.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

            System.out.println("Employee Details");
            System.out.println("------------------------------");
            System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Age","Salary");
            System.out.println("------------------------------");

            while(resultSet.next()){
                System.out.format("%d\t%s\t%d\t%f\n",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getDouble(4));
                System.out.println("------------------------------");
            }

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateEmployee(int id, String name,int age) {
        con = DBConnection.createDBConnection();
        query = "UPDATE employee SET employee_name = ? , employee_age = ? WHERE id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,age);
            pstm.setInt(3,id);

            int count = pstm.executeUpdate();
            if(count != 0){
                System.out.println("Employee Details updated successfully !");
            }



        } catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con = DBConnection.createDBConnection();
        query = "DELETE from employee where id=?";
        try{
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setInt(1,id);

            int count = pstm.executeUpdate();
            if(count != 0){
                System.out.println("Employee Deleted successfully !");
            }

        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
