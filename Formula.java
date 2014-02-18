import java.util.ArrayList;
/**
 * A Formula is a list of clauses.
 * If one clause is false, the whole formula is false.
 * @author Bill Ezekiel, Matthew Martorana, James O'Donnell 
 * @version (2/17/14)
 */
public class Formula
{
    private ArrayList<Clause> clauses;
    /**
     * Create a formula with 'n' clauses.
     * @param n the number of clauses in this formula.
     */
    public Formula(int n)
    {
        clauses = new ArrayList(n);
    }

    /**
     * Evaluate this formula using a collection of boolean values.
     * @param b An ArrayList containing boolean values.
     * @return true only if this formula evaluates to true.
     */
    public boolean satisfies(ArrayList<Boolean> b)
    {
        for(Clause c: clauses)
        {
            //since a formula is a conjuction, if one clause returns
            //false, the whole formula is false.
            if(!(c.satisfies(b)))
                return false;       
        }
        return true;
    }

    /**
     * Add a clause to this formula
     * @param c the clause to be added.
     */
    public void addClause(Clause c)
    {
        clauses.add(c);
    }
}
