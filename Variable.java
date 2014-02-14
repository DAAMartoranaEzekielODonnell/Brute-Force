
/**
 * A Variable that has a number
 * and a boolean value
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Variable
{
    private boolean value;
    private int number;

    /**
     * Constructor for a Variable
     */
    public Variable(boolean b, int i)
    {
        value = b;
        number = i;
    }

    public boolean getValue()
    {
        if(number>0)
        {return value;}
        return !value;
    }

    public int getNumber()
    {return number;}

    public void setValue(boolean value)
    {this.value = value;}
}
