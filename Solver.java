import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * Reads files and determines a satisfying assignment for a given
 * formula (specified in the file).
 * 
 * @author Bill Ezekiel
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
/**
 * Reads files and determines a satisfying assignment for a given
 * formula (specified in the file).
 * 
 * @author Bill Ezekiel
 * @version //Date Here
 */
public class Solver
{
    private Formula formula = new Formula();
    private Scanner scanner;
    private int varCount;  
    private int clauseCount;   

    /**
     * Reads a file and sets up a formula based on it's contents.
     * @param filename The name of the file to be read.
     */
    public ArrayList<Boolean> readFile(String filename)
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine = reader.readLine();
            while(currentLine!=null)
            {
                switch(currentLine.charAt(0))
                {
                    case 99:
                    currentLine = reader.readLine();
                    break;

                    case 112:
                    getCounts(currentLine.substring(6));
                    currentLine = reader.readLine();
                    break;

                    default:
                    makeClause(currentLine);
                    currentLine = reader.readLine();
                    break;
                }
            }

            double start = System.currentTimeMillis(); 
            double iterations = Math.pow(2,varCount);
            for(int i = 0; i<iterations;i++)
            {
                ArrayList<Boolean> currentList = intToBooList(i);
                if(formula.satisfies(currentList))
                {
                    System.out.println(System.currentTimeMillis()- start);
                    System.out.println(currentList);
                    return currentList;
                }
            }
            System.out.println(System.currentTimeMillis()- start);
        }
        catch(IOException ioe)
        {System.out.println("Invalid filename '"+filename+"'");}
        System.out.println("No Match");
        return null;  
    }

    /**
     * Gets the variable count and clause count
     * @param line the line 
     */
    private void getCounts(String line)
    {
        scanner = new Scanner(line);
        varCount = scanner.nextInt();
        clauseCount = scanner.nextInt();
    }

    /**
     * Converts an integer to a list of boolean values.
     */
    public ArrayList<Boolean> intToBooList(int num)
    {
        ArrayList<Boolean> result = new ArrayList();
        String binary = Integer.toBinaryString(num);
        while(binary.length()<varCount)
        {
            binary = "0".concat(binary);
        }
        for(int i = 0;i<binary.length();i++)
        {
            if(binary.charAt(i) == '0')
            {
                result.add(false);
            }
            else
            {
                result.add(true);
            }
        }
        return result;
    }

    /**
     * Create a clause
     */
    private void makeClause(String s)
    {
        Clause c = new Clause();
        scanner = new Scanner(s);
        while(scanner.hasNextInt())
        {
            int next = scanner.nextInt();
            if(next!=0)
            {c.addVariable(new Variable(true,next));}
        }
        formula.addClause(c);
    }
}
