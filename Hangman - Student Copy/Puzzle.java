import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Puzzle
{
    //Guests
    private ArrayList<String> gl = new ArrayList<String>();
    private ArrayList<String> word;
    String ans ="SHIIIT";
    
    Scanner scanner = new Scanner(System.in);
    Random R;
    int num = 0;
    String[] s;
    public Puzzle(){
        
        
         word = new ArrayList<String>();

        try {
            File file = new File("words.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String tempWord = scanner.next().toUpperCase();
                word.add(tempWord);
            }
            scanner.close();
			
			//ONCE THIS LINE OF CODE IS REACHED, YOUR words ArrayList
			//CONTAINS ALL THE WORDS IN words.txt
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.print("Shiit");
        }
        R = new Random();
        num =R.nextInt(word.size());
        ans = word.get(num);
        s = new String[ans.length()];
        for(int i = 0; i < s.length; i++){
            s[i] = "_";
            
            
        }
        
    }
    
    public void show(){
        
        for(int i = 0; i < s.length; i++){
            
            System.out.print(s[i]);
            System.out.print(" ");
            
        }
        System.out.println();
        System.out.print("Your Guesses: ");
        for(int i = 0; i < gl.size(); i++){
            System.out.print(gl.get(i));
            System.out.print(",");
            
            
        }
        
        
    }
    
    
    
    public boolean isUnsolved(){
        int c = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == "_"){
                return true;
                
            }
            
            
        }
        
        return false;
    }
    
    public boolean makeGuess(String g){
        boolean found = false;
        while(gl.contains(g) == true){
                System.out.println("U already asked for that Letter!!!! \n Try again");
                //System.out.println(ans);
                g = scanner.nextLine();
                
                
                
            }
        if(gl.contains(g) == false){
            for(int i =0; i < ans.length(); i++){
                if(ans.toLowerCase().charAt(i) == g.charAt(0)){
                    s[i] = ans.toLowerCase().substring(i,i+1);
                    
                    found = true;
                    
                }
                
                
                
            }
            gl.add(g);
            if(found == true){
                return true;
                
                
            }
            return false;
           
        }else{
            
            
            return false;
            
        }
        
        
        
        
    }
    
    public String getWord(){
        
        return ans;
        
        
    }
   
}
