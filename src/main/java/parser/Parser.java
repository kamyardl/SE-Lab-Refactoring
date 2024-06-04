package parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Stack;

import Log.Log;
import codeGenerator.CodeGenerator;
import errorHandler.ErrorHandler;
import scanner.lexicalAnalyzer;
import scanner.token.Token;

public class Parser {
    private ArrayList<Rule> rules;
    private Stack<Integer> parsStack;
    private ParseTable parseTable;
    private lexicalAnalyzer lexicalAnalyzer;
    private CodeGenerator cg;

    public Parser() {
        setParsStack(new Stack<>());
        getParsStack().push(0);
        try {
            setParseTable(new ParseTable(Files.readAllLines(Paths.get("src/main/resources/parseTable")).get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setRules(new ArrayList<>());
        try {
            for (String stringRule : Files.readAllLines(Paths.get("src/main/resources/Rules"))) {
                getRules().add(new Rule(stringRule));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        setCg(new CodeGenerator());
    }

    public void startParse(java.util.Scanner sc) {
        setLexicalAnalyzer(new lexicalAnalyzer(sc));
        Token lookAhead = getLexicalAnalyzer().getNextToken();
        boolean finish = false;
        Action currentAction;
        while (!finish) {
            try {
                Log.print(/*"lookahead : "+*/ lookAhead.toString() + "\t" + getParsStack().peek());
                currentAction = getParseTable().getActionTable(getParsStack().peek(), lookAhead);
                Log.print(currentAction.toString());

                switch (currentAction.action) {
                    case shift:
                        getParsStack().push(currentAction.number);
                        lookAhead = getLexicalAnalyzer().getNextToken();

                        break;
                    case reduce:
                        Rule rule = getRules().get(currentAction.number);
                        for (int i = 0; i < rule.RHS.size(); i++) {
                            getParsStack().pop();
                        }

                        Log.print(/*"state : " +*/ getParsStack().peek() + "\t" + rule.LHS);
                        getParsStack().push(getParseTable().getGotoTable(getParsStack().peek(), rule.LHS));
                        Log.print(/*"new State : " + */getParsStack().peek() + "");
                        try {
                            getCg().semanticFunction(rule.semanticAction, lookAhead);
                        } catch (Exception e) {
                            Log.print("Code Genetator Error");
                        }
                        break;
                    case accept:
                        finish = true;
                        break;
                }
                Log.print("");
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
        if (!ErrorHandler.hasError) getCg().printMemory();
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }

    public void setRules(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public Stack<Integer> getParsStack() {
        return parsStack;
    }

    public void setParsStack(Stack<Integer> parsStack) {
        this.parsStack = parsStack;
    }

    public ParseTable getParseTable() {
        return parseTable;
    }

    public void setParseTable(ParseTable parseTable) {
        this.parseTable = parseTable;
    }

    public scanner.lexicalAnalyzer getLexicalAnalyzer() {
        return lexicalAnalyzer;
    }

    public void setLexicalAnalyzer(scanner.lexicalAnalyzer lexicalAnalyzer) {
        this.lexicalAnalyzer = lexicalAnalyzer;
    }

    public CodeGenerator getCg() {
        return cg;
    }

    public void setCg(CodeGenerator cg) {
        this.cg = cg;
    }
}
