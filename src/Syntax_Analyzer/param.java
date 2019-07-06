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
public class param implements node{
   
    Token type;
    Token identifier;
    Token rightSquareBracket;
    Token leftSquareBracket;

    public param(Token type, Token identifier) {
        this.type = type;
        this.identifier = identifier;
        this.rightSquareBracket = null;
        this.leftSquareBracket = null;
    }

    public param(Token type, Token identifier, Token rightSquareBracket, Token leftSquareBracket) {
        this.type = type;
        this.identifier = identifier;
        this.rightSquareBracket = rightSquareBracket;
        this.leftSquareBracket = leftSquareBracket;
    }
    

    @Override
    public void printNode() {
        System.out.println("------------param------------");
         if(type!=null) System.out.println(type);
        if(identifier!=null) System.out.println(identifier);
        if(rightSquareBracket!=null) System.out.println(rightSquareBracket);
        if(leftSquareBracket!=null) System.out.println(leftSquareBracket);
    }
    
}
