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
public class expr3 implements node{

    Token token;
    expr e;

    public expr3(Token token, expr e) {
        this.token = token;
        this.e = e;
    }
    
    @Override
    public void printNode() {
        System.out.println("------------expr3------------");
        if(token!=null) System.out.println(token);
        System.out.println();
        if(e!=null) e.printNode() ;
    }
    
}
