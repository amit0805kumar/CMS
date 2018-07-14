public class Course 
{
    private String ccode,cname,description;
    private float fees;
    public void setCCode(String ccode)
    {
        this.ccode=ccode;
    }
    public void setCName(String cname)
    {
        this.cname=cname;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public void setFees(float fees)
    {
        this.fees=fees;
    }
    public String getCCode()
    {
        return ccode;
    }
    public String getCName()
    {
        return cname;
    }
    public String getDescription()
    {
        return description;
    }
    public float getFees()
    {
        return fees;
    }
}
