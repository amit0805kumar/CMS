import javax.swing.*;
public class Common 
{
    public static void NormalMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message);
    }
    public static void ErrorMessage(String message)
    {
        JOptionPane.showMessageDialog(null, message,"Error",JOptionPane.ERROR_MESSAGE);
    }
}
