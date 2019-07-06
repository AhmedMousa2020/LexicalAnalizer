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
public class stmt implements node{
    expr_stmt exp;
    compound_stmt com;
    if_stmt if_s;
    while_stmt wh;
    return_stmt ret;
    Token breakWord;
    Token semicolon;
    
    public stmt(expr_stmt exp) {
        this.exp = exp;
        this.com = null;
        this.if_s = null;
        this.wh = null;
        this.ret = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public stmt(compound_stmt com) {
        this.com = com;
        this.exp = null;
        this.if_s = null;
        this.wh = null;
        this.ret = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public stmt(if_stmt if_s) {
        this.if_s = if_s;
        this.exp = null;
        this.com = null;
        this.wh = null;
        this.ret = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public stmt(while_stmt wh) {
        this.wh = wh;
        this.exp = null;
        this.com = null;
        this.if_s = null;
        this.ret = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public stmt(return_stmt ret) {
        this.ret = ret;
        this.exp = null;
        this.com = null;
        this.if_s = null;
        this.wh = null;
        this.breakWord = null;
        this.semicolon = null;
    }

    public stmt(Token breakWord, Token semicolon) {
        this.breakWord = breakWord;
        this.semicolon = semicolon;
        this.exp = null;
        this.com = null;
        this.if_s = null;
        this.wh = null;
        this.ret = null;
    }
    
    
    
    
    
    
    @Override
    public void printNode() {
        System.out.println("------------stmt------------");
        if(exp!=null) exp.printNode() ;
        if(com!=null) com.printNode() ;
        if(if_s!=null) if_s.printNode() ;
        if(wh!=null) wh.printNode() ;
        if(ret!=null) ret.printNode() ;
        if(breakWord!=null) System.out.println(breakWord);
        if(semicolon!=null) System.out.println(semicolon);
    }
    
}
