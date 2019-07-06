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
public class param_list_dash implements node{
    Token comma;
    param p;
    param_list_dash pl_dash;

    public param_list_dash(Token comma, param p, param_list_dash pl_dash) {
        this.comma = comma;
        this.p = p;
        this.pl_dash = pl_dash;
    }
    
    
    
    @Override
    public void printNode() {
        System.out.println("------------param_list_dash------------");
        if(comma!=null) System.out.println(comma);
        System.out.println();
        if(p!=null) p.printNode() ;
        System.out.println();
        if(pl_dash!=null) pl_dash.printNode() ; 
        else System.out.println("ε");
    }
    
}
