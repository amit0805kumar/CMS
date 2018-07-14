import java.sql.*;
import java.util.*;
import java.io.IOException;
public class Db 
{
    public static Connection getConnection() throws SQLException
    {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cms","root","");
        return cn;
    }
    public static boolean isUserExist(String userid, String password) throws SQLException
    {
        String sql="Select * from user where userid=? and password=md5(?)";
        boolean result=false;
        try (Connection cn = getConnection()) {
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1, userid);
            ps.setString(2, password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()) result=true;
        }
        return result;
    }
     public static void saveCourse(Course c) throws SQLException
    {
        String sql="INSERT INTO course VALUES(?,?,?,?)";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1, c.getCCode());
        ps.setString(2, c.getCName());
        ps.setFloat(3, c.getFees());
        ps.setString(4, c.getDescription());
        ps.executeUpdate();
        cn.close();
    }
    public static Course getCourse(String ccode) throws SQLException
    {
        String sql="Select * from course where ccode=?";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1, ccode);
        ResultSet rs=ps.executeQuery();
        Course c=null;
        if(rs.first())
        {
            c=new Course();
            c.setCName(rs.getString("cname"));
            c.setDescription(rs.getString("description"));
            c.setFees(rs.getFloat("fees"));
        }
        cn.close();
        return c;
    }
    public static boolean updateCourse(Course c) throws SQLException
    {
        String sql="UPDATE course SET cname=?, fees=?, description=? WHERE ccode=?";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(4, c.getCCode());
        ps.setString(1, c.getCName());
        ps.setFloat(2, c.getFees());
        ps.setString(3, c.getDescription());
        int n=ps.executeUpdate();
        cn.close();
        if(n==0)
            return false;
        else
            return true;
    }
    public static boolean deleteCourse(String ccode) throws SQLException
    {
        String sql="delete from course where ccode=?";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setString(1, ccode);
        int n=ps.executeUpdate();
        cn.close();
        if(n==0)
            return false;
        else
            return true;
    }
    
    public static HashMap<String,String> getAllCourses() throws SQLException
    {
        String sql="Select cname,ccode from course order by cname";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        HashMap<String,String> h=new HashMap<>();
        while(rs.next())
        {
            h.put(rs.getString(1), rs.getString(2));
        }
        cn.close();
        return h;
    }
    
    public static ArrayList<Course> getAllCourseData() throws SQLException
    {
        String sql="Select * from course order by ccode";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        ArrayList<Course> ar=new ArrayList<>();
        while(rs.next())
        {
            Course c=new Course();
            c.setCCode(rs.getString("ccode"));
            c.setCName(rs.getString("cname"));
            c.setFees(rs.getFloat("fees"));
            c.setDescription((rs.getString("description")));
            
            ar.add(c);
        }
        cn.close();
        return ar;
    }
    
    public static void saveStudent(Student s) throws SQLException
    {
        String sql="INSERT INTO student VALUES(?,?,?,?,?,?,?)";
        Connection cn=getConnection();
        PreparedStatement ps=cn.prepareStatement(sql);
        ps.setInt(1, s.getRollNo());
        ps.setString(2, s.getName());
        ps.setString(3, s.getEmail());
        ps.setString(4, s.getMobile());
        ps.setString(5, s.getCCode());
        ps.setFloat(6, s.getDiscount());
        ps.setString(7, s.getDescription());
        ps.executeUpdate();
        cn.close();
    }
}
