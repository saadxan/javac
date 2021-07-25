import java.io.File;
import java.io.IOException;
import java.util.*;

public class Scanner {

    static java.util.Scanner sc;
    static String lexeme, nonOperator;
    static int index;
    static List<Token> tokens = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        if(args.length == 0) {
            System.out.println("Incorrect number of arguments.");
            System.exit(0);
        }

        File file = new File(args[0]);
        if(!file.exists()){
            System.out.printf("The file %s does not exist. Please use correct name in the code.%n", file);
            System.exit(0);
        }
        sc = new java.util.Scanner(file);

        for(String arg: args){
            switch(arg){
                case "-quiet":
                    checkGrammar();
                    break;
                case "-verbose":
                    printStatements();
                    break;
                default:
                    printTokens();
            }
        }
    }

    public static Token analyze(){
        String thisChar = Character.toString(lexeme.charAt(index));

        if(lex(thisChar)){
            if(index < lexeme.length()-1){
                String nextChar = Character.toString(lexeme.charAt(index+1));
                if(lex(nextChar) && Grammar.traceElement(nextChar).lexValue == 20){
                    index++;
                    return new Token(thisChar+nextChar);
                }
            }
            return new Token(thisChar);
        }else{
            if(nonOperator.length() == 0)
                nonOperator += thisChar;
            if(index < lexeme.length()-1){
                String nextChar = Character.toString(lexeme.charAt(index+1));
                if(!lex(nextChar))
                    nonOperator += nextChar;
                else
                    return new Token(nonOperator);
            }else
                return new Token(nonOperator);
        }
        index++;
        return analyze();
    }

    public static void checkGrammar(){
        Collection<Object> tokenBag = new ArrayList<>();
        Queue<Object> enclosureSnippets = new LinkedList<>();

        for(Token currentToken : tokens){
            tokenBag.add(currentToken.code);

            if(currentToken.code == Grammar.Unit.SEMICOLON){
                System.out.println(Grammar.obtainRules(tokenBag));
                tokenBag.clear();
            }else if(getConnectableType(currentToken.code) == 0){
                enclosureSnippets.addAll(tokenBag);
                tokenBag.clear();
            }else if(getConnectableType(currentToken.code) == 1){
                Collection<Object> block = new ArrayList<>();
                while(!enclosureSnippets.isEmpty()){
                    Grammar.Unit blockTypeCode = (Grammar.Unit)enclosureSnippets.poll();
                    block.add(blockTypeCode);
                    if(getConnectableType(blockTypeCode) == 1)
                        break;
                }
                block.add(currentToken.code);
                System.out.println(Grammar.obtainRules(block));
            }
        }
    }


    public static int getConnectableType(Grammar.Unit tokenCode){
        switch(tokenCode){
            case LEFT_BRACKET:
            case LEFT_PAREN:
                return 0;
            case RIGHT_BRACKET:
            case RIGHT_PAREN:
                return 1;
            default:
                return -1;
        }
    }

    public static void getNonBlank(){
        while(sc.hasNext()){
            lexeme = sc.next();
            for(index = 0; index < lexeme.length(); index++){
                nonOperator = "";
                Token caughtToken = analyze();
                tokens.add(caughtToken);
            }
        }
    }

    public static boolean lex(String lexeme){
        return !lexeme.matches("[a-zA-Z0-9]+");
    }

    public static void printStatements(){
        getNonBlank();
        checkGrammar();
        List<Token> statementTokens = new ArrayList<>();
        Iterator<Token> statementIterator;

        for(Token currentToken : tokens){
            statementTokens.add(currentToken);
            System.out.print(!currentToken.lexeme.matches(";") ? " " + currentToken.lexeme : currentToken.lexeme);

            statementIterator = statementTokens.iterator();
            if(currentToken.value >= 53){
                System.out.print("\n");
                while(statementIterator.hasNext())
                    System.out.println(statementIterator.next());
                System.out.print("\n");
                statementTokens.clear();
            }
        }
    }

    public static void printTokens(){
        getNonBlank();
        for(Token caughtToken : tokens)
            System.out.println(caughtToken);
    }
}