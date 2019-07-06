package lexicalanalizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexicalAnalizer {
    
    public static ArrayList<String> splitter(String Source){
        ArrayList<String> Tokens = new ArrayList();
//        String Regex = "";
        String Regex = "(([0-9]*[a-zA-Z]+[0-9_\\.]*[a-zA-Z]*)|(\\d*)\\.(\\d+)|(//.*)|(/\\*[\\s\\S]*?\\*/)|(\\d+)|(\".+\")|('.+')|(==|>=|<=|!=|>>|<<|&&|\\|\\|)|([{}()=+\\-/*<>~#|&!;,\\[\\]]))";
        //Compile the Regex
        Pattern pattern = Pattern.compile(Regex);
        Matcher matcher = pattern.matcher(Source);
        
        while (matcher.find()){
            Tokens.add(matcher.group());
        }
        return Tokens;
    }
    
    public static Queue<Token> getTokens() throws FileNotFoundException, IOException{
        BufferedReader in = new BufferedReader(new FileReader("InputFile.txt"));
        String str;

        List<String> list = new ArrayList<String>();
        while((str = in.readLine()) != null){
            list.add(str);
        }
        String input="";
        String[] stringArr = list.toArray(new String[0]);
        for (int i=0;i<stringArr.length;i++){
            input+=stringArr[i];
            if(i!=stringArr.length-1){
                input+="\n";
            }
        }

        ArrayList Tokens = splitter(input);
//        for(int i=0;i<Tokens.size();i++)
//            System.out.println(Tokens.get(i));
        Pattern pattern ;
        Matcher matcher ;
        Queue<Token>Q = new LinkedList<>();
//        PrintWriter writer = new PrintWriter("OutputFile.txt", "UTF-8");
        for(int i=0;i<Tokens.size();i++){
            for(Token t : Token.values()){
                pattern = Pattern.compile(t.getRegex());
                matcher = pattern.matcher((String)Tokens.get(i));
                if(matcher.find()){
                        Q.add(t);
//                    System.out.println("<" + t +"> : "+matcher.group());
//                    writer.println("<" + t +"> : "+matcher.group()+"\n");
                    break;
                }
            }
        }
        
//        writer.close();
        return Q;
    }
    
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
//        Queue<Token>Q = new LinkedList<Token>();
//        Q = getTokens();
//        while(Q.size()>0){
//        System.out.println(Q.poll());
//        }
        
        
    }
}

