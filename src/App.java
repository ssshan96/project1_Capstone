import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import org.junit.Test; //Must import to run JUnit 5

public class App {

    static int count = 0;

     /**
     * @method parseCSV parses a CSV file
     * @param path
     * @param arrVal
     */
    public static void parseCSV(String path, String[] arrVal){
        String[] values;
        String line = "";
        int i = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(path));
            //Reads in each value into an array
            //arrVal is populated with all the values read in
            while((line = br.readLine()) != null){
                values = line.split(",");
                arrVal[i] = values [0];
                count++;
                i++;
                arrVal[i] = values [1];
                count++;
                i++;
            }
            br.close();
        } catch (FileNotFoundException e){ //Handles exceptions/errors
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

    }
    
    /**
    * Driver method
    */
    public static void main(String[] args) throws Exception {
        String path = "lib/LangInput.csv";
        String[] arrVal = new String[114];
        parseCSV(path, arrVal);
        int j = 0;
        while(j < 114){
            System.out.print(arrVal[j] + ", ");
            j++;
        }
        System.out.println(count);
    }
    
    /**
    * Test method
    * Tests to see if the CSV file had been parsed successfully
    */
    @Test 
    public void testParseCSV(){
        String[] testVal = {"English", "Spanish", "a", "a", "b", "b", "c", "c", "d", "d", "e", "e", "f", "f", "g", "g", "h", "h", "i", "i", "j", "j", "k", "k", "l", "l", "m", 
        "m", "n", "n", "o", "?±", "p", "o", "q", "p", "r", "q", "s", "r", "t", "rr", "u", "s", "v", "t", "w", "u", "x", "v", "y", "w", "z", "x", "A", "y", "B", "z", "C", "A",
        "D", "B", "E", "C", "F", "D", "G", "E", "H", "F", "I", "G", "J", "H", "K", "I", "L", "J", "M", "K", "N", "L", "O", "M", "P", "N", "Q", "??", "R", "O", "S", "P", "T",
        "Q", "U", "R", "V", "RR", "W", "S", "X", "T", "Y", "U", "Z", "V", "", "W", "", "X", "", "Y", "", "Z", ""};

        String path = "C:/Users/fbite/Desktop/Classes_Spring2022/Capstone/project1_Capstone/lib/LangInput.csv";
        String[] actVal = new String[114];
        parseCSV(path, actVal);
        int k = 0;
        while (k < 114)
        {
            assertEquals(testVal[k], actVal[k]); //Tests to see each value is properly parsed and stored
            k++;
        }
        
        assertEquals(114, count); //Tests to see that there are accurate number of data
    }
}
