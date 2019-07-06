/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

import lexicalanalizer.Token;

/**
 *
 * @author AbuElsaud
 */
public class if_stmt implements node{

    Token ifWord;
    Token rightRoundBracket;
    expr e;
    Token leftRoundBracket;
    stmt st;
    if_stmt_dash if_dash;

    public if_stmt(Token ifWord, Token rightRoundBracket, expr e, Token leftRoundBracket, stmt st, if_stmt_dash if_dash) {
        this.ifWord = ifWord;
        this.leftRoundBracket = leftRoundBracket;
        this.e = e;
        this.rightRoundBracket = rightRoundBracket;
        this.st = st;
        this.if_dash = if_dash;
    }
    
    
    
    @Override
    public void printNode() {
        System.out.println("------------if_stmt------------");
        if(ifWord!=null) System.out.println(ifWord);
        if(rightRoundBracket!=null) System.out.println(rightRoundBracket);
        System.out.println();
        if(e!=null) e.printNode() ;
        System.out.println();
        if(leftRoundBracket!=null) System.out.println(leftRoundBracket);
        System.out.println();
        if(st!=null) st.printNode() ;
        System.out.println();
        if(if_dash!=null) if_dash.printNode() ;
    }
    
}
