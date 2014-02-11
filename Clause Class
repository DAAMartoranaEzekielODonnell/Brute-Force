import java.util.ArrayList;
/**
 * A Clause is a disjunction of boolean variables.
 * 
 * @author //Names here 
 * @version //date here
 */
public class Clause
{
    private ArrayList<Integer> varValues = new ArrayList();
    private boolean value;

    /**
     * Constructor for Clause
     */
    public Clause()
    {  
    }

    /**
     * Evaluate this clause given specific values for variables.
     */
    public boolean satisfies(ArrayList<Boolean> booValues)
    {
        booValues = negate(booValues);
        for(int i = 0; i<varValues.size()&&!value;i++)
        {
            if(booValues.get(Math.abs(varValues.get(i))-1) == true)
            {
                return true;
            }
        }
        return false;
    }
    
    public void setVarValues(ArrayList<Integer> values)
    {
        varValues = values;
    }
    
    public void addVariable(int var)
    {
        varValues.add(var);
    }
    
    /**
     * Negates any values that should be negated. 
     */
    public ArrayList<Boolean> negate(ArrayList<Boolean> booValues)
    {
        ArrayList<Boolean> b = new ArrayList(booValues);
        for(int i = 0; i<varValues.size();i++)
        {
            int var = varValues.get(i);
            if(var<0)
            {
                var*=-1; //make negative value positive to a void Index Out of Bounds
                b.set(var-1,!b.get(var-1));
            }
        }
        return b;
    }
    
}
