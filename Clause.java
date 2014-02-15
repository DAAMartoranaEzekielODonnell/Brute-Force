import java.util.ArrayList;
/**
 * A Clause is a disjunction of boolean variables.
 * 
 * @author //Names here 
 * @version //date here
 */
public class Clause
{
    private ArrayList<Variable> variables;
    
    public Clause(int n)
    {
        variables = new ArrayList(n); 
    }
    
    /**
     * Evaluate this clause.
     * @return true only if this clause is true.
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        for(Variable v: variables)
        {  
            if(v.getValue(b.get(Math.abs(v.getNumber())-1)))
                return true;
        }
        return false;
    }

    /**
     * Add a variable to this clause.
     * @param v The variable to be added.
     */
    public void addVariable(Variable v)
    {variables.add(v);}
}
