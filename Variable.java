
/**
 * A Variable that has a number
 * 
 * @author Bill Ezekiel, Matthew Martorana, James O'Donnell  
 * @version (2/17/14)
 */
public class Variable
{
    private int number; //variable number (x#)
    private boolean not = false;
    /**
     * Constructor for a Variable
     * @param i The variable number
     */
    public Variable(int i)
    {
        if(i<0)
        {
            not = true;  //not
            number= -i; //make positive
        }
        else{
            number = i;
        }
    }

    /**
     * Evaluate a boolean value for this variable.
     * @param b a boolean value (true or false)
     * @return a boolean value
     */
    public boolean getValue(boolean b)
    {
        if(not)  
        {return !b;}
        return b;
    }

    /**
     * @return this variable's number
     */
    public int getNumber()
    {return number;}
}
