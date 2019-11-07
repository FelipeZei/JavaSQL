import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Date;

public class MySQLAccess {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pre;
    private long d = System.currentTimeMillis();
    private Date date = new Date(d);

    public MySQLAccess(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb" , "sqluser", "test1234!");
            st = con.createStatement();
        }catch(Exception e){
            System.out.println("ConnectionError | MySQLAcess constructor: " + e);
        }
    }

    /////////////verify insert id
    public void create(){
        try{
            String query = "INSERT INTO product (name, price, datum) VALUES (?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "Soap");
            statement.setString(2, "1");
            statement.setString(3, date.toString());

            int rowInserted = statement.executeUpdate();
            if(rowInserted > 0){
                System.out.println("Product successfully added");
            }
        } catch(Exception e){
            System.out.println("ErrorWhileInsertingData | create method: " + e);
        }
    }

    public void read(){
        try{
            String query = "SELECT * FROM product";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String name = rs.getString("name");
                String price = rs.getString("price");
                String date = rs.getString("datum");
                System.out.println("Name: " + name + " " + "- price: " + price + " " + "- date: " + date);
            }
        } catch(Exception e){
            System.out.println("ErrorWhileGettingData | read method: " + e );
        }
    }

    public void update(){
        try{
            String query = "UPDATE product SET name=?, price=?, datum=? WHERE id=?";
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, "Shampoo");
            statement.setString(2, "2");
            statement.setString(3, date.toString());
            statement.setString(4, "1");

            int rowsUpdated = statement.executeUpdate();
            if(rowsUpdated > 0) {
                System.out.println("Product successfully updated");
            }
        } catch(Exception e){
            System.out.println("ErrorWhileUpdatingData | update method" + e);
        }
    }

    public void delete(){
        try{
            String sql = "DELETE FROM product WHERE name=?";

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, "Shampoo");
            int rowsDeleted = statement.executeUpdate();
            if(rowsDeleted > 0){
                System.out.println("Product successfully deleted");
            }
        } catch(Exception e){
            System.out.println("ErrorWhileDeletingData | delete method: " + e);
        }
    }

}
