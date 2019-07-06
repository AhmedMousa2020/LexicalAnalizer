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
public class expr2 implements node{

    Token token;
    Token token2;
    expr e;
    expr4 e4;
    args ag;

    public expr2(Token token, expr e) {
        this.token = token;
        this.e = e;
        this.token2 = null;
        this.e4 = null;
        this.ag = null;
    }

    public expr2(Token token, expr e, Token token2, expr4 e4) {
        this.token = token;
        this.e = e;
        this.token2 = token2;
        this.e4 = e4;
        this.ag = null;
    }

    public expr2(Token token, args ag, Token token2) {
        this.token = token;
        this.e = null;
        this.token2 = token2;
        this.e4 = null;
        this.ag = ag;
    }

    public expr2(Token token, Token token2) {
        this.token = token;
        this.e = null;
        this.token2 = token2;
        this.e4 = null;
        this.ag = null;
    }
    
    @Override
    public void printNode() {
        System.out.println("------------expr2------------");
        if(token!=null) System.out.println(token);
        System.out.println();
        if(e!=null) e.printNode();
        System.out.println();
        if(ag!=null) ag.printNode() ;
        System.out.println();
        if(token2!=null) System.out.println(token2);
        System.out.println();
        if(e4!=null) e4.printNode() ;
    }
    
}
