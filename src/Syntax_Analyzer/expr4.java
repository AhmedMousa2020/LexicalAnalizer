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
public class expr4 implements node{
    
    expr e;

    public expr4(expr e) {
        this.e = e;
    }

    @Override
    public void printNode() {
        System.out.println("------------expr4------------");
        if(e!=null) e.printNode() ;
        else
            System.out.println("ε");
    }
    
}
