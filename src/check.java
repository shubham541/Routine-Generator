
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



/**
 *
 * @author shubham
 */
public class check {
    public static void main(String[] args) throws IOException{
        
        String st,st1="";
 
        File file = new File("/home/kunal/workplace/netbeans-project/Scheduler/src/res/path.txt");
        FileWriter wr=new FileWriter("/home/kunal/workplace/netbeans-project/Scheduler/src/res/path.txt");

        
        BufferedReader br = new BufferedReader(new FileReader(file));

        
        while ((st = br.readLine()) != null){
                  
                st1=st1+st;}
        
        
        System.out.println(st1);
        String st2="kunal";
        wr.write(st2);
        
    }
    
}
