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
public class compound_stmt implements node{

    Token rightCurlyBracket;
    local_decls ld;
    stmt_list stl;
    Token leftCurlyBracket;

    public compound_stmt(Token rightCurlyBracket, local_decls ld, stmt_list stl, Token leftCurlyBracket) {
        this.leftCurlyBracket = leftCurlyBracket;
        this.ld = ld;
        this.stl = stl;
        this.rightCurlyBracket = rightCurlyBracket;
    }
    
    
    
    @Override
    public void printNode() {
        System.out.println("------------compound_stmt------------");
        if(rightCurlyBracket!=null) System.out.println(rightCurlyBracket);
        System.out.println();
        if(ld!=null) ld.printNode() ; else System.out.println("ε");
                
        System.out.println();
        if(stl!=null) stl.printNode() ; else System.out.println("ε");
        System.out.println();
        if(leftCurlyBracket!=null) System.out.println(leftCurlyBracket);
    }
    
    
}
