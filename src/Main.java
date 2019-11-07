
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main {

//    - Install MySQL Server, create database, create user and initialise the server
//    - Install MySQL Connector by adding the jar file as a library in project structure and move all the files to global libraries
//    - In the class MySQLAccess, set the correct driver in Class.forName() and the localhost address in DriverManager.getConnection()

//root - test1234

    public static void main (String[]args){

        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        MySQLAccess mySQLAccess = new MySQLAccess();

        int action = Integer.parseInt(JOptionPane.showInputDialog("\n Select the number corresponding to the desired option: " + " \n 1. Add product \n 2. List products \n 3. Update product \n 4. Delete product"));

        switch (action){
            case 1:
                mySQLAccess.create();
                break;
            case 2:
                mySQLAccess.read();
                break;
            case 3:
                mySQLAccess.update();
                break;
            case 4:
                mySQLAccess.delete();
                break;
            default:
                System.out.println("Invalid number");
                break;
        }

    }

}
