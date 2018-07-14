public class Student 
{
    private int rollno;
    private String name, email, mobile, ccode, description;
    private float discount;
    public void setRollNo(int rollno)
    {
        this.rollno=rollno;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setMobile(String mobile)
    {
        this.mobile=mobile;
    }
    public void setCCode(String ccode)
    {
        this.ccode=ccode;
    }
    public void setDescription(String description)
    {
        this.description=description;
    }
    public void setDiscount(float discount)
    {
        this.discount=discount;
    }
    public int getRollNo()
    {
        return rollno;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getMobile()
    {
        return mobile;
    }
    public String getCCode()
    {
        return ccode;
    }
    public String getDescription()
    {
        return description;
    }
    public float getDiscount()
    {
        return discount;
    }
}
