import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class db {
    //? driver load
    //? Connection establish
    //? statement create
    //? execute query
    //? connection close

    public static void usedb() throws SQLException{
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/";
            String userName="root";
            String password="Tejveer@2004";
            System.out.println("Connection establish");
            conn=DriverManager.getConnection(url, userName, password);
            Statement stm=conn.createStatement();

            String query="use contacts";
            stm.execute(query);
            conn.close();
            System.out.println(conn.isClosed());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }
    public void createtable() throws SQLException{
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/contacts";
            String userName="root";
            String password="Tejveer@2004";
            System.out.println("Connection establish");
            conn=DriverManager.getConnection(url, userName, password);
            Statement stm=conn.createStatement();

            String query="create table contact (Name varchar(30),Number int)";
            stm.execute(query);
            conn.close();
            System.out.println(conn.isClosed());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
        }
    }

    public static void insertdata(String name,int number) throws SQLException{
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/contacts";
            String userName="root";
            String password="Tejveer@2004";
            conn=DriverManager.getConnection(url, userName, password);
            // System.out.println("Connection establish");


            String query="insert into  contact(name ,number) values (?,?)";
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,number);
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
            System.out.println(conn.isClosed());
        }
    }
   
   
    public static void readdata(String name) throws SQLException{
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/contacts";
            String userName="root";
            String password="Tejveer@2004";
            conn=DriverManager.getConnection(url, userName, password);
            // System.out.println("Connection establish");

            String query=String.format("Select * from contact where name='%s'",name);
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                System.out.print("name : "+rs.getString(1));
                System.out.print("   number : "+rs.getInt(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
            System.out.println(conn.isClosed());
        }
    }
   
   
    public static void updatedata(String name,int number) throws SQLException{
        Connection conn=null;
        try{
            String url="jdbc:mysql://localhost:3306/contacts";
            String userName="root";
            String password="Tejveer@2004";
            conn=DriverManager.getConnection(url, userName, password);
            // System.out.println("Connection establish");

            String query="UPDATE contact set number = ? where name = ?";
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setInt(1, number);
            pstm.setString(2, name);
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            conn.close();
            System.out.println(conn.isClosed());
        }
    }


}
