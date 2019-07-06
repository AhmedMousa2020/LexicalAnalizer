/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

/**
 *
 * @author AbuElsaud
 */

import lexicalanalizer.Token;
public class fun_decl implements node{
    Token type;
    Token identifier;
    Token rightRoundBracket;
    params p;
    Token leftRoundBracket;
    compound_stmt com;


    public fun_decl(Token type, Token identifier, Token rightRoundBracket, params p, Token leftRoundBracket, compound_stmt com) {
        this.type = type;
        this.identifier = identifier;
        this.leftRoundBracket = leftRoundBracket;
        this.p = p;
        this.rightRoundBracket = rightRoundBracket;
        this.com = com;
    }

    @Override
    public void printNode() {
        System.out.println("------------fun_decl------------");
        if(type!=null) System.out.println(type);
        if(identifier!=null) System.out.println(identifier);
        if(rightRoundBracket!=null) System.out.println(rightRoundBracket);
        System.out.println();
        if(p!=null) p.printNode() ; else System.out.println("ε");
        System.out.println();
        if(leftRoundBracket!=null) System.out.println(leftRoundBracket);
        System.out.println();
        if(com!=null) com.printNode() ;
            
    }
    
}
