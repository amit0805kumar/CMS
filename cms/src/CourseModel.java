import java.util.*;
import javax.swing.table.AbstractTableModel;
public class CourseModel extends AbstractTableModel
{

    Object data[][];
    String columns[]={"Course Code","Coure Name","Course Fees"};
    public CourseModel() throws Exception
    {
        ArrayList<Course> ar=Db.getAllCourseData();
        data=new Object[ar.size()][columns.length];
        for(int i=0;i<ar.size();i++)
        {
            data[i][0]=ar.get(i).getCCode();
            data[i][1]=ar.get(i).getCName();
            data[i][2]=ar.get(i).getFees();
        }
    }
    @Override
    public int getRowCount() 
    {
        return data.length;
    }

    @Override
    public int getColumnCount() 
    {
        return columns.length;
    }

    @Override
    public Object getValueAt(int r, int c) 
    {
        return data[r][c];
    }
    
    public String getColumnName(int i)
    {
        return columns[i];
    }
}
