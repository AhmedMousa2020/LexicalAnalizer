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
public class return_stmt implements node{
    
    Token returnWord;
    expr_stmt es;

    public return_stmt(Token returnWord, expr_stmt es) {
        this.returnWord = returnWord;
        this.es = es;
    }
    

    

    @Override
    public void printNode() {
        System.out.println("------------return_stmt------------");
        if(returnWord!=null) System.out.println(returnWord);
        System.out.println();
        if(es!=null) es.printNode() ;
    }
    
}
