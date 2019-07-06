/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import lexicalanalizer.LexicalAnalizer;
import lexicalanalizer.Token;

/**
 *
 * @author AbuElsaud
 */
public class Parser {
    	public static Queue<Token> tokens;
	public static  Queue<Token>getTokens() throws IOException{
		LexicalAnalizer la = new LexicalAnalizer();
		return la.getTokens();
	}
        
        public Parser() throws IOException{
            tokens = getTokens();
        }
        
        private decl_list parse(){
            return program_f();
        }
        
        private decl_list program_f(){
        decl rule3 = decl_f();
        if (rule3==null){
            System.out.println("There is nothing to parse!");
            return null;
        }
        decl_list_dash rule2 = decl_list_dash_f();
        return new decl_list(rule3,rule2);
    }

    private decl_list_dash decl_list_dash_f(){
        decl rule3 = decl_f();
        if (rule3 == null){
            return null;
        }
        decl_list_dash rule2 = decl_list_dash_f();
        return new decl_list_dash(rule3,rule2);
    }

    private decl decl_f(){
       Token type = rule27Fun();
        if (type == null){
            return null;
        }
        Token identifier = IDENT();
        if (identifier == null){
            return null;
        }
        var_decl rule4 = var_decl_f( type, identifier);
        if(rule4 == null){
            fun_decl rule5 = fun_decl_f( type, identifier);
            return new decl(rule5);
        }
        return new decl(rule4);
    }

    private var_decl var_decl_f(Token type, Token identifier){
        var_decl rule28 = rule28Fun();
        if (rule28 == null){
            return null;
        }
        return new var_decl(type, identifier, rule28);
    }

    private fun_decl fun_decl_f(Token type, Token identifier){
        Token leftRoundBracket = leftRoundBracket();
        if(leftRoundBracket == null){
            return null;
        }
        params rule6 = params_f();
        
        Token rightRoundBracket = rightRoundBracket();
        if(rightRoundBracket == null){
            return null;
        }
        compound_stmt rule14 = compound_stmt_f();
        return new fun_decl(type, identifier, leftRoundBracket, rule6, rightRoundBracket, rule14);
    }

    private params params_f(){
        param_list rule7 = pram_list_f();
        if(rule7 == null){
            return null;
        }
        return new params(rule7);
    }

    private param_list pram_list_f(){
        param rule9 = param_f();
        if(rule9 == null){
            return null;
        }
        param_list_dash rule8 = param_list_dash_f();
        return new param_list(rule9, rule8);
    }

    private param_list_dash param_list_dash_f(){
        Token comma = tokens.peek();
        if(comma == null || !comma.type().equals("<COMMA>")){
            return null;
        }
        tokens.poll();
        param rule9 = param_f();
        if (rule9 == null){
            return null;
        }
        param_list_dash rule8 = param_list_dash_f();
        return new param_list_dash(comma, rule9, rule8);
    }

    private param param_f(){
        Token type = rule27Fun();
        
        Token identifier = IDENT();
        if (identifier == null){
            return null;
        }
        param rule29 = rule29Fun();
        
        if(rule29 != null){
            return new param(type, identifier, rule29.rightSquareBracket, rule29.leftSquareBracket);
        }
        return new param(type, identifier);
    }

    private stmt_list stmt_list_f(){
        stmt rule11 = stmt_f();
        if (rule11 == null){
            return null;
        }
        stmt_list rule10 = stmt_list_f();
        
        return new stmt_list(rule11, rule10);
    }

    private stmt stmt_f(){
        expr_stmt rule12 = expr_stmt_f();
        if(rule12 != null){
            return new stmt(rule12);
        }
        
        compound_stmt rule14 = compound_stmt_f();
        
        if(rule14 != null){
            return new stmt(rule14);
        }
        
        if_stmt rule16 = if_stmt_f();
        if(rule16 != null){
            return new stmt(rule16);
        }
        
        while_stmt rule13 = while_stmt_f();
        if(rule13 != null){
            return new stmt(rule13);
        }
        
        return_stmt rule18 = return_stmt_f();
        if(rule18 != null){
            return new stmt(rule18);
        }
        
        return rule30Fun();
    }

    private expr_stmt expr_stmt_f(){
        expr rule19 = expr_f();
        
        Token token = tokens.peek();
        if(token != null && token.type().equals("<SEMICOLON>")){
            tokens.poll();
        }
        else if (rule19 != null) {                          // must return an error if rule19 exists
//            System.out.println("Syntax Error: Expected ; ");
        }
        else {                                              // won't return an error to explore other paths
            return null;
        }
        return new expr_stmt(rule19, token);
    }

    private while_stmt while_stmt_f(){
        Token whileWord = tokens.peek();
        if(whileWord == null || !whileWord.type().equals("<WHILE>")){
            return null;
        }
        tokens.poll();
        Token leftRoundB = leftRoundBracket();
        if(leftRoundB == null){
            return null;
        }
        expr rule19 = expr_f();
        if(rule19 == null){
            return null;
        }
        Token rightRoundB = rightRoundBracket();
        if(rightRoundB == null){
            return null;
        }
        stmt rule11 = stmt_f();
        if(rule11 == null){
            return null;
        }
        return new while_stmt(whileWord, leftRoundB, rule19, rightRoundB, rule11);
    }

    private compound_stmt compound_stmt_f(){
        Token leftCurlyBracket = tokens.peek();
        if(leftCurlyBracket == null || !leftCurlyBracket.type().equals("<LEFT_CURLY_B>")){
//            System.out.println("Syntax Error: Expected { ");
            return null;
        }
        tokens.poll();
        local_decls rule15 = local_decls_f();
        
        stmt_list rule10 = stmt_list_f();
        
        Token rightCurlyBracket = tokens.peek();
        if(rightCurlyBracket == null || !rightCurlyBracket.type().equals("<RIGHT_CURLY_B>")){
//            System.out.println("Syntax Error: Expected } ");
            return null;
        }
        tokens.poll();
        return new compound_stmt(leftCurlyBracket, rule15, rule10, rightCurlyBracket);
    }

    private local_decls local_decls_f(){
        Token type = rule27Fun();
        if (type == null){
            return null;
        }
        Token identifier = IDENT();
        if (identifier == null){
            return null;
        }
        var_decl rule4 = var_decl_f(type, identifier);
        if(rule4 ==  null){
            return null;
        }
        local_decls rule15 = local_decls_f();
        
        return new local_decls(rule4, rule15);
    }

    private if_stmt if_stmt_f(){
        Token ifWord = tokens.peek();
        if(ifWord == null || !ifWord.type().equals("<IF>")){
            return null;
        }
        tokens.poll();
        Token leftRoundB = leftRoundBracket();
        if(leftRoundB == null){
            return null;
        }
        expr rule19 = expr_f();
        if(rule19 == null){
            return null;
        }
        Token rightRoundB = rightRoundBracket();
        if(rightRoundB == null){
            return null;
        }
        stmt rule11 = stmt_f();
        if(rule11 == null){
            
            return null;
        }
        if_stmt_dash rule17 = rule17un();
        
        return new if_stmt(ifWord, leftRoundB, rule19, rightRoundB, rule11, rule17);
    }

    private if_stmt_dash rule17un(){
        Token elseWord = tokens.peek();
        if(elseWord ==  null || !elseWord.type().equals("<ELSE>")){
            return null;
        }
        tokens.poll();
        stmt rule11 = stmt_f();
        if(rule11 == null){
           
            return null;
        }
        return new if_stmt_dash(elseWord, rule11);
    }

    private return_stmt return_stmt_f(){
        Token returnWord = tokens.peek();
        if(returnWord == null || !returnWord.type().equals("<RETURN>")){
            return null;
        }
        tokens.poll();
        expr_stmt rule12 = expr_stmt_f();
        if(rule12 ==  null){
            return null;
        }
        return new return_stmt(returnWord, rule12);
    }

    private expr expr_f(){
        Token token = tokens.peek();
        if(token == null){
            return null;
        }
        switch (token.type()){
            case "<ID>":
                tokens.poll();
                return caseID( token);
            case "<not>":
            case "<MINUS>":
            case "<PLUS>":
                tokens.poll();
                return caseNotPlusMinus( token);
            case "<BOOL_LIT>":
            case "<INTEGRAL_LITERAL>":
            case "<FLOAT_LITERAL>":
                tokens.poll();
                expr_dash rule20 = expr_dash_f();
                
                return new expr(token, rule20);
            case "<NEW>":
                tokens.poll();
                return caseNew(token);
        }
        return null;
    }

    private expr_dash expr_dash_f(){
        expr3 rule22 = expr3_f();
        if(rule22 == null){
            return null;
        }
        expr_dash rule20 = expr_dash_f();
        return new expr_dash(rule22, rule20);
    }

    private expr2 expr2_f(){
        Token token = tokens.peek();
        if(token == null){
            return null;
        }
        switch (token.type()){
            case "<ASSIGN_OPERATOR>":
                tokens.poll();
                return caseAssignOperator( token);
            case "<LEFT_SQUARE_B>":
                tokens.poll();
                return caseLeftSquareB( token);
            case "<LEFT_ROUND_B>":
                tokens.poll();
                return caseLeftRoundB( token);
            case "<dot>":
                tokens.poll();
                Token sizeWord = tokens.peek();
                if(sizeWord == null || !sizeWord.type().equals("<SIZE>")){
                    System.out.println("Syntax Error: Expected Token");
                    return null;
                }
                tokens.poll();
                return new expr2(token,sizeWord);
        }
        return null;
    }

    private expr3 expr3_f(){
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("<OR>", "<EQUAL>", "<NOT_EQUAL>", "<LESS_EQ>", "<LESSTHAN>",
                "<GREAT_EQ>", "<GREATERTHAN>", "<AND>", "<PLUS>", "<MINUS>", "<ASTERISK>", "<DIVIDE>", "<MOD>"));
        Token token = tokens.peek();
        if(token != null && temp.contains(token.type())){
            tokens.poll();
            expr rule19 = expr_f();
            if(rule19 == null){
                return null;
            }
            return new expr3(token, rule19);
        }
        return null;
    }

    private expr4 expr4_f(){
        expr rule19 = expr_f();
        if(rule19 ==  null){
            return null;
        }
        return new expr4(rule19);
    }

    private arg_list arg_list_f(){
        expr rule19 = expr_f();
        if(rule19== null){
            return null;
        }
        arg_list_dash rule25 = arg_list_dash_f();
        
        return new arg_list(rule19, rule25);
    }

    private arg_list_dash arg_list_dash_f(){
        Token comma = tokens.peek();
        if(comma == null || !comma.type().equals("<COMMA>")){
            return null;
        }
        tokens.poll();
        expr rule19 = expr_f();
        if(rule19 == null){
            return null;
        }
        arg_list_dash rule25 = arg_list_dash_f();
        
        return new arg_list_dash(comma, rule19, rule25);
    }

    private args args_f(){
        arg_list rule24 = arg_list_f();
        if (rule24 == null){
            return null;
        }
        return new args(rule24);
    }

    private Token rule27Fun(){
        Token type = tokens.peek();
        if (type != null){
            if(type.type().equals("<VOID>") || type.type().equals("<BOOL>") || type.type().equals("<INT>") || type.type().equals("<FLOAT>")){
                return tokens.poll();
            }
//            System.out.println("Syntax Error: Expected Identifier Type");
        }
        return null;
    }

    private var_decl rule28Fun(){
        Token token = leftSquareBracket();
        Token token2= null , token3;
        
        if (token != null) {
            token2 = rightSquareBracket();
            if (token2 == null) {
                return null;
            }
        }
        token3 = tokens.peek();
        if(token3 != null && token3.type().equals("<SEMICOLON>")){
            tokens.poll();
        }
        else {
//            System.out.println("Syntax Error: Expected ; ");
            return null;
        }
        return new var_decl(token, token2, token3);
    }

    private param rule29Fun(){
        Token token = leftSquareBracket();
        Token token2;
        if (token != null) {
            token2 = rightSquareBracket();
            if (token2 == null) {
                return null;
            }
        }
        else {
            return null;
        }
        return new param(null, null, token, token2);
    }

    private stmt rule30Fun(){
        Token breakWord = tokens.peek();
        if(breakWord != null && breakWord.type().equals("<BREAK>")){
            tokens.poll();
            Token semicolon = tokens.peek();
            if(semicolon != null && semicolon.type().equals("<SEMICOLON>")){
                tokens.poll();
                return  new stmt(breakWord, semicolon);
            }
            else {
//                System.out.println("Syntax Error: Expected ;");
            }
        }
        return null;
    }

    private Token IDENT(){
        Token identifier = tokens.peek();
        if (identifier != null &&identifier.type().equals("<ID>")) {
            return tokens.poll();
        }
//        System.out.println("Syntax Error: Expected Identifier");
        return null;
    }

    private Token rightRoundBracket(){
        Token rightRoundBracket = tokens.peek();
        if(rightRoundBracket != null && rightRoundBracket.type().equals("<RIGHT_ROUND_B>")){
            return tokens.poll();
        }
//        System.out.println("Syntax Error: Expected ) ");
        return null;
    }

    private Token leftRoundBracket(){
        Token leftRoundBracket = tokens.peek();
        if(leftRoundBracket != null && leftRoundBracket.type().equals("<LEFT_ROUND_B>")){
            return tokens.poll();
        }
//        System.out.println("Syntax Error: Expected ( ");
        return null;
    }

    private Token rightSquareBracket(){
        Token rightSquareBracket = tokens.peek();
        
        if(rightSquareBracket != null && rightSquareBracket.type().equals("<RIGHT_SQUARE_B>")){
            return tokens.poll();
        }
//        System.out.println("Syntax Error: Expected ] ");
        return null;
    }

    private Token leftSquareBracket(){
        Token leftSquareBracket = tokens.peek();
        if(leftSquareBracket != null && leftSquareBracket.type().equals("<LEFT_SQUARE_B>")){
            return tokens.poll();
        }
//        System.out.println("Syntax Error: Expected [ ");
        return null;
    }

    private expr caseID( Token token){
        expr2 rule21 = expr2_f();
        expr_dash rule20 = expr_dash_f();
        return new expr(token, rule21, rule20);
    }

    private expr caseNotPlusMinus(Token token){
        expr rule19 = expr_f();
        if(rule19 == null){
            
            return null;
        }
        expr_dash rule20 = expr_dash_f();
        
        return new expr(token, rule19, rule20);
    }

    private expr caseNew( Token token){
        Token type = rule27Fun();
        
        Token leftSquareB = leftSquareBracket();
        if(leftSquareB == null){
            return null;
        }
        expr rule19 = expr_f();
        if(rule19 == null){
            
            return null;
        }
        Token rightSquareB = rightSquareBracket();
        if(rightSquareB == null){
            return null;
        }
        expr_dash rule20 = expr_dash_f();
        
        return new expr(token, type, leftSquareB, rule19, rightSquareB, rule20);
    }

    private expr2 caseAssignOperator(Token token){
        expr rule19 = expr_f();
        if(rule19 == null){
            return null;
        }
        return new expr2(token, rule19);
    }

    private expr2 caseLeftSquareB(Token token){
        expr rule19 = expr_f();
        if(rule19 == null){
            return null;
        }
        Token rightSquareB = rightSquareBracket();
        if(rightSquareB == null){
            return null;
        }
        expr4 rule23 = expr4_f();
        
        return new expr2(token, rule19, rightSquareB, rule23);
    }

    private expr2 caseLeftRoundB(Token token){
        args rule26 = args_f();
       
        Token rightRoundB = rightRoundBracket();
        if(rightRoundB == null){
            return null;
        }
        return new expr2(token, rule26, rightRoundB);
    }
	
	public static void main(String[] args) throws IOException {
		Parser p = new Parser();
                
//                    while(tokens.size()>0){
//                    System.out.println(tokens.poll().type());
//                   }
                 
                      
                decl_list root = p.parse();
                
                if(root != null){
                    System.out.println("------------Program------------");
                    root.printNode();
                    System.out.println("------------End------------");
                }
                
                
	}
}
