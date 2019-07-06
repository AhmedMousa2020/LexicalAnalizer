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
public class while_stmt implements node{

    Token While,LB,RB;
    expr e;
    stmt s;

    public while_stmt(Token While, Token LB, expr e,Token RB, stmt s) {
        this.While = While;
        this.LB = LB;
        this.RB = RB;
        this.e = e;
        this.s = s;
    }
    
    
    @Override
    public void printNode() {
        System.out.println("------------while_stmt------------");
        if(While!=null) System.out.println(While);
        if(RB!=null) System.out.println(RB);
        System.out.println();
        if(e!=null) e.printNode() ;
        System.out.println();
        if(LB!=null) System.out.println(LB);
        System.out.println();
        if(s!=null) s.printNode() ;
    }
    
}
