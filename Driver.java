
/**
 * A Driver to test the solver. 
 * 
 * @author Bill Ezekiel, Matthew Martorana, James O'Donnell 
 * @version (2/17/14)
 */
public class Driver
{
    private static Solver solver = new Solver();

    public static void main()
    {
        String filename = "u32.cnf";
        if(solver.readFile(filename)) 
        {
            //double start = System.currentTimeMillis();    
            solver.solve();
            //System.out.println(System.currentTimeMillis()- start);
        }
    }

}
