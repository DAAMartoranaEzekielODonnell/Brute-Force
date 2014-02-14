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

    /**
     * Evaluate this clause
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        for(Clause c: clauses)
        {
            if(!(c.satisfies(b)))
                return false;       
        }
        return true;
    }

    public void addClause(Clause c)
    {
        clauses.add(c);
    }
}
