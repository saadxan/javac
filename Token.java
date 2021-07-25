public class Token {

	public String lexeme;
	public Grammar.Unit code;
	public Integer value;

	public Token(String tokenName){
		lexeme = tokenName;
		setAttributes();
	}

	private void setAttributes(){
		try{
			code = Grammar.traceElement(lexeme).lexCode;
			value = Grammar.traceElement(lexeme).lexValue;
		} catch (NullPointerException ne){ matchKey(lexeme); }
	}

	private void matchKey(String lex){
		if(lex.matches("[0-9]+")){
			code = Grammar.traceElement("INT_LIT").lexCode;
			value = Grammar.traceElement("INT_LIT").lexValue;
		}else if(lex.matches("[a-zA-Z]+") && !lex.matches("EOF")){
			code = Grammar.traceElement("IDENT").lexCode;
			value = Grammar.traceElement("IDENT").lexValue;
		}
	}

	public String toString(){
		return String.format("Next token is: %-10d Next lexeme is: %-10s Next code is %-10s", value, lexeme, code);
	}
}