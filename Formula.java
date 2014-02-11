import java.util.ArrayList;
/**
 * A Clause is a disjunction of boolean variables.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Formula
{
    private ArrayList<Clause> clauses = new ArrayList();
    private boolean value;

    public Formula()
    {
    }

    /**
     * Evaluate this clause
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        value = true;
        for(int i = 0; i<clauses.size()&&value;i++)
        {
            if(clauses.get(i).satisfies(b) == false)
            {
                value = false;            
            }
        }
        return value;
    }
    
    public void addClause(Clause c)
    {
        clauses.add(c);
    }

    public int size()
    {
        return clauses.size();
    }
}
