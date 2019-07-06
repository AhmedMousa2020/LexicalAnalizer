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
public class expr_stmt implements node{

    expr e;
    Token semiColumn;

    public expr_stmt(expr e, Token semiColumn) {
        this.e = e;
        this.semiColumn = semiColumn;
    }
    
    
    
    @Override
    public void printNode() {
        System.out.println("------------expr_stmt------------");
        if(e!=null){
            e.printNode();
            
        }
        if(semiColumn!=null){
            System.out.println(semiColumn);
        }
    }
    
}
