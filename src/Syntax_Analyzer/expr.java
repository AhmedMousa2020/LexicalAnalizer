/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

import lexicalanalizer.Token;

/**
 *
 * @author Ahmed
 */
public class expr implements node{
    Token token;
    expr2 e2;
    expr_dash e_dash;
    expr e;
    Token type;
    Token rightSquareBracket;
    Token leftSquareBracket;
    
    public expr(Token token, expr2 e2, expr_dash e_dash) {
        this.token = token;
        this.e2 = e2;
        this.e_dash = e_dash;
        this.e = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public expr(Token token, expr e, expr_dash e_dash) {
        this.e_dash = e_dash;
        this.token = token;
        this.e = e;
        this.e2 = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public expr(Token token, expr_dash e_dash) {
        this.e_dash = e_dash;
        this.token = token;
        this.e2 = null;
        this.e = null;
        this.type = null;
        this.leftSquareBracket = null;
        this.rightSquareBracket = null;
    }

    public expr(Token token, Token type, Token rightSquareBracket, expr e, Token leftSquareBracket, expr_dash e_dash) {
        this.e_dash = e_dash;
        this.e = e;
        this.token = token;
        this.type = type;
        this.leftSquareBracket = leftSquareBracket;
        this.rightSquareBracket = rightSquareBracket;
        this.e2 = null;
    }

    @Override
    public void printNode() {
        System.out.println("------------expr------------");
        if(token!=null) System.out.println(token);
        if(type!=null) System.out.println(type);
        if(e2!=null) e2.printNode() ;
        if(rightSquareBracket!=null) System.out.println(rightSquareBracket);
        System.out.println();
        if(e!=null) e.printNode() ;
        System.out.println();
        if(leftSquareBracket!=null) System.out.println(leftSquareBracket);
        System.out.println();
        if(e_dash!=null) e_dash.printNode() ; 
        
    }

   
    
    
    
}
