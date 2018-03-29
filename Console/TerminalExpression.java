package Console;

import java.util.StringTokenizer;

public class TerminalExpression extends Expression {
	
    private String literal = null;
    
    private String englishStr = null;

    public TerminalExpression(String str, String englishStr) { 
        literal = str;
        this.englishStr = englishStr;
    }

    public String interpret(String str) { 
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) { 
            String test = st.nextToken();
            if (test.equals(literal)) {
                return englishStr;
            }
        }
        return "false";
    }
}
