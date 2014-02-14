import java.util.ArrayList;
/**
 * A Clause is a disjunction of boolean variables.
 * 
 * @author //Names here 
 * @version //date here
 */
public class Clause
{
    private ArrayList<Variable> variables = new ArrayList();   
    /**
     * Evaluate this clause.
     * @return true only if this clause is true.
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        for(int i = 0; i<variables.size();i++)
        {
            Variable v = variables.get(i);
            v.setValue(b.get(Math.abs(v.getNumber())-1));
        }
        for(Variable v: variables)
        {
            if(v.getValue())
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
