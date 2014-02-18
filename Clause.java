import java.util.ArrayList;
/**
 * A Clause is a disjunction of boolean Variables.
 * If one variable is true, the whole clause is true.
 * 
 * @author Bill Ezekiel, Matthew Martorana, James O'Donnell 
 * @version (2/17/14)
 */
public class Clause
{
    private ArrayList<Variable> variables;

    /**
     * Create a clause with 'n' variables.
     * @param n the number of variables in this clause.
     */
    public Clause(int n)
    {
        variables = new ArrayList(n); 
    }

    /**
     * Evaluate this clause.
     * @param b An ArrayList containing boolean values.
     * @return true only if this clause evaluates to true.
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        //since a clause is a disjunction, if one variable is
        //true, the whole clause is true.
        for(Variable v: variables)
        {  
            boolean varBoo = b.get(v.getNumber()-1); //get boolean 
            //for corresponding variable.
            if(v.getValue(varBoo))
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
