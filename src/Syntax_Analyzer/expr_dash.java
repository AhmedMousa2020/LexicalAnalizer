/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

/**
 *
 * @author Ahmed
 */
public class expr_dash implements node{
    
    expr3 e3;
    expr_dash e_dash;

    public expr_dash(expr3 e3, expr_dash e_dash) {
        this.e3 = e3;
        this.e_dash = e_dash;
    }

    @Override
    public void printNode() {
        System.out.println("------------expr_dash------------");
        if(e3!=null) e3.printNode() ;
        System.out.println();
        if(e_dash!=null) e_dash.printNode() ; 
        else System.out.println("ε");
    
    }
    
}
