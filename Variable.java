
/**
 * A Variable that has a number
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Variable
{
    private int number;
    /**
     * Constructor for a Variable
     */
    public Variable(int i)
    {
        number = i;
    }

    /**
     * @param b  A boolean 
     */
    public boolean getValue(boolean b)
    {
        if(number>0)
        {return b;}
        return !b;
    }

    /**
     * @return this variable's number
     */
    public int getNumber()
    {return number;}
}
