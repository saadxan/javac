import java.util.*;

public class Grammar {

    enum Terminal{PROGRAM, PROCEDURE, DECLARATIONS, DECLARATION, TYPE, STATEMENTS, STATEMENT, BLOCK, IF_BLOCK,
        WHILE_BLOCK, BOOL_EXPRESS, RELATION_OP, ASSIGNMENT, EXPRESSION, TERM, FACTOR, ASSIGN_OR_FUNC, FUNCALL};

    enum Unit{INT_LIT, IDENT, ASSIGN_OP, ADD_OP, SUB_OP, MULT_OP, DIV_OP, MOD, EQUAL, NOTEQUAL,
        LESS, MORE, LESS_EQUAL, MORE_EQUAL, INT, MAIN, IF, WHILE, READ, WRITE, PROC,
        LEFT_PAREN, RIGHT_PAREN, COMMA, SEMICOLON, LEFT_BRACKET, RIGHT_BRACKET, EOF, UNKNOWN}; // AKA Non-Terminal

    public static <E> Object obtainRules(Collection<E> rules){
        return rules;
    }

    static element traceElement(String lex){
        return lexicaldictionary.get(lex);
    }

    static class element{
        Unit lexCode;
        Integer lexValue;

        element(Unit lexCode, Integer lexValue){
            this.lexCode = lexCode;
            this.lexValue = lexValue;
        }
    }

    private static final Map<String, element> lexicaldictionary;
    static{
            lexicaldictionary = new HashMap<>();
            lexicaldictionary.put("INT_LIT", new element(Unit.INT_LIT, 10));
            lexicaldictionary.put("IDENT", new element(Unit.IDENT, 11));
            lexicaldictionary.put("=", new element(Unit.ASSIGN_OP, 20));
            lexicaldictionary.put("+", new element(Unit.ADD_OP, 21));
            lexicaldictionary.put("-", new element(Unit.SUB_OP, 22));
            lexicaldictionary.put("*", new element(Unit.MULT_OP, 23));
            lexicaldictionary.put("/", new element(Unit.DIV_OP, 24));
            lexicaldictionary.put("%", new element(Unit.MOD, 25));
            lexicaldictionary.put("==", new element(Unit.EQUAL, 30));
            lexicaldictionary.put("!=", new element(Unit.NOTEQUAL, 31));
            lexicaldictionary.put("<", new element(Unit.LESS, 32));
            lexicaldictionary.put(">", new element(Unit.MORE, 33));
            lexicaldictionary.put("<=", new element(Unit.LESS_EQUAL, 34));
            lexicaldictionary.put(">=", new element(Unit.MORE_EQUAL, 35));
            lexicaldictionary.put("int", new element(Unit.INT, 40));
            lexicaldictionary.put("main", new element(Unit.MAIN, 41));
            lexicaldictionary.put("if", new element(Unit.IF, 42));
            lexicaldictionary.put("while", new element(Unit.WHILE, 43));
            lexicaldictionary.put("read", new element(Unit.READ, 44));
            lexicaldictionary.put("write", new element(Unit.WRITE, 45));
            lexicaldictionary.put("procedure", new element(Unit.PROC, 46));
            lexicaldictionary.put("(", new element(Unit.LEFT_PAREN, 50));
            lexicaldictionary.put(")", new element(Unit.RIGHT_PAREN, 51));
            lexicaldictionary.put(",", new element(Unit.COMMA, 52));
            lexicaldictionary.put(";", new element(Unit.SEMICOLON, 53));
            lexicaldictionary.put("{", new element(Unit.LEFT_BRACKET, 54));
            lexicaldictionary.put("}", new element(Unit.RIGHT_BRACKET, 55));
            lexicaldictionary.put("EOF", new element(Unit.EOF, 60));
            lexicaldictionary.put("UNKNOWN", new element(Unit.UNKNOWN, 61));
    }
}