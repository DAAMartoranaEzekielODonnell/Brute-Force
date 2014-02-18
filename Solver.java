import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * Reads files and attempts to solve boolean formulas.
 * 
 * @author Bill Ezekiel, Matthew Martorana, James O'Donnell 
 * @version (2/17/14)
 */
public class Solver
{
    private Formula formula;
    private Scanner scanner;
    private int varCount;  
    private int clauseCount;   

    /**
     * Reads a file and sets up a formula based on it's contents.
     * @param filename The name of the file to be read.
     * @return true if the file was successfully read. 
     */
    public boolean readFile(String filename)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine = reader.readLine();
            while(currentLine!=null)
            {
                switch(currentLine.charAt(0))
                {
                    case 99: //99 = c comment line.
                    currentLine = reader.readLine();
                    break;

                    case 112: //112 = p "p cnf" line
                    getCounts(currentLine.substring(6));
                    currentLine = reader.readLine();
                    formula = new Formula(clauseCount);  //we will have clause count by this time.
                    break;

                    default: //remaining lines
                    makeClause(currentLine);
                    currentLine = reader.readLine();
                    break;
                }
            }
            return true; //file successfully read
        }
        catch(IOException ioe)
        {
            System.out.println("Invalid filename '"+filename+"'");
            return false;
        }
    }

    /**
     * Solve the formula. 
     * @return an ArrayList of boolean values corresponding to values assigned to variables.
     * Example: [true,false,true,true] means
     * x1 = true
     * x2 = false
     * x3 = true
     * x4 = true
     */
    public ArrayList<Boolean> solve()
    {
        double iterations = Math.pow(2,varCount);  //2^varCount
        double start = System.currentTimeMillis();    
        int tenth = (int) iterations/10;

        for(int i = 0; i<(iterations);i++)
        {
            if(i%tenth == 0)
            {
                System.out.println(System.currentTimeMillis()- start);
            }
            ArrayList<Boolean> currentList = intToBooList(i);
            if(formula.satisfies(currentList))
            {
                System.out.println(currentList);
                return currentList;
            }
        }
        System.out.println("No Match");
        return null;  
    }

    /**
     * Gets the variable count and clause count
     * @param line the line from which data is read.
     */
    private void getCounts(String line)
    {
        scanner = new Scanner(line);
        varCount = scanner.nextInt();
        clauseCount = scanner.nextInt();
    }

    /**
     * Converts an integer to a list of boolean values by first
     * converting it to a string representation of its 
     * binary form. The string is then converted to the list. 
     * 16 -> [1,0,0,0,0]
     * @param num The integer to convert
     * @return An ArrayList of boolean values corresponding to num in binary. 
     */
    public ArrayList<Boolean> intToBooList(int num)
    {
        ArrayList<Boolean> result = new ArrayList(varCount);
        String binary = Integer.toBinaryString(num);
        while(binary.length()<varCount)
        {
            binary = "0".concat(binary); //add 0's to make size of list the amount of variables.
        }
        for(int i = 0;i<binary.length();i++)
        {
            if(binary.charAt(i) == '0')  //0 -> false
            {
                result.add(false);
            }
            else                        
            {
                result.add(true); //1 -> true
            }
        }
        return result;
    }

    /**
     * Create a clause
     * @param s A string where information about the clause is acquired.
     */
    private void makeClause(String s)
    {
        Clause c = new Clause(varCount);
        scanner = new Scanner(s);
        while(scanner.hasNextInt())
        {
            int next = scanner.nextInt();
            if(next!=0)  //0 signifies the end of clause
            {c.addVariable(new Variable(next));}
        }
        formula.addClause(c); //add clause to the formula
    }
}
