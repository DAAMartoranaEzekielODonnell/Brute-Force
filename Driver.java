
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    private Solver solver = new Solver();

    public Driver()
    {
        //solver.readFile("test1.txt"); //t t t t 
        solver.readFile("u32.cnf"); 
    }

}
