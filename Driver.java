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
       //solver.readFile("test1.txt"); //f f f f
        solver.readFile("s28.cnf");
        //make sure to only ready one file at a time
        //or it won't work properly.
    }

}
