package Console;

public class Main {

	/**
	 * this method builds the interpreter tree
	 * It defines the rule "Owen and (John or (Henry or Mary))"
	 * @return
	 */
    static Expression buildInterpreterTree() 
    {
        // Lid woorden
        Expression terminal1 = new TerminalExpression("De", "The ");
        Expression terminal2 = new TerminalExpression("Het", "The ");
        Expression terminal3 = new TerminalExpression("Een", "a ");
        
        // Zelfstandige naamwoorden
        Expression terminal4 = new TerminalExpression("brood", "Bread ");
        Expression terminal5 = new TerminalExpression("man", "man ");
        Expression terminal6 = new TerminalExpression("boer", "farmer ");
        
        //Werkwoordelijk deel
        Expression terminal7 = new TerminalExpression("laat", "lets ");
        Expression terminal8 = new TerminalExpression("eet", "eats ");
        Expression terminal9 = new TerminalExpression("koopt", "buys ");
        Expression terminal10 = new TerminalExpression("snijdt", "cuts ");

        // De of Het
        Expression alternation1 = new OrRegelWoorden(terminal1, terminal2); 

        // Een of (Het of De)
        Expression alternation2 = new OrRegelWoorden(terminal3, alternation1);
        
        //Man of Boer
        Expression alternation3 = new OrRegelWoorden(terminal5, terminal6); 
        
        //Brood of (Man of Boer)
        Expression alternation4 = new OrRegelWoorden(terminal4, alternation3);
        
        //eet of koopt
        Expression alternation5 = new OrRegelWoorden(terminal8, terminal9);
        
        //laat of (eet of koopt)
        Expression alternation6 = new OrRegelWoorden(terminal7, alternation5);
        
        //snijdt of (laat of (eet of koopt))
        Expression WerkwoordelijkDeel = new OrRegelWoorden(terminal10, alternation6);
        
        //(Een of (Het of De)) en (Brood of (Man of Boer))
        Expression NaamWoordelijkDeel = new AndRegelWoorden(alternation2, alternation4);
        
        //(Een of (Het of De)) en (Brood of (Man of Boer)) en (laat of eet of koopt of snijdt)
        Expression alternation7 = new AndRegelWoorden(NaamWoordelijkDeel, WerkwoordelijkDeel);
        
        // ((Een of (Het of De)) en (Brood of (Man of Boer)) en (laat of eet of koopt of snijdt)) en (Een of (Het of De)) en (Brood of (Man of Boer)
        return new AndRegelWoorden(alternation7, NaamWoordelijkDeel);
    }

	
	/**
	 * main method - build the interpreter
	 *  and then interpret a specific sequence 
	 * @param args
	 */
	public static void main(String[] args) {
		
        String context = "De man eet brood";

        Expression define = buildInterpreterTree();

        System.out.println(context + " is " + define.interpret(context));
	}
}