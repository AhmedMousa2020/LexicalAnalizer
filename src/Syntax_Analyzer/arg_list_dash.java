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
public class arg_list_dash implements node{
      Token comma;
      expr e;
      arg_list_dash a;

    public arg_list_dash(Token comma, expr e, arg_list_dash a) {
        this.comma = comma;
        this.e = e;
        this.a = a;
    }
      
    @Override
    public void printNode() {
        System.out.println("------------arg_list_dash------------");
       if(comma==Token.COMMA&&e!=null&&a!=null){
           System.out.println(comma);
           e.printNode();
           a.printNode();
       
       }
       else{
           System.out.println("ε");
       }
    }
    
}
