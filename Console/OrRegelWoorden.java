package Console;

public class OrRegelWoorden extends Expression{
    private Expression expression1 = null;
    private Expression expression2 = null;

    public OrRegelWoorden(Expression expression1, Expression expression2) { 
        this.expression1 = expression1;
        this.expression2 = expression2; 
    }

    public String interpret(String str) {
    	if (expression1.interpret(str) != "false") {
    		return expression1.interpret(str);
    	}
    	else if(expression2.interpret(str) != "false") {
    		return expression2.interpret(str);
    	}
    	else {
    		return "false";
    	}
    }
    
}