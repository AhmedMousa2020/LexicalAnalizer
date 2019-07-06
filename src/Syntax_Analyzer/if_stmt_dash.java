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
public class if_stmt_dash  implements node{
    Token elseWord;
    stmt st;

    public if_stmt_dash(Token elseWord, stmt st) {
        this.elseWord = elseWord;
        this.st = st;
    }
    
    @Override
    public void printNode() {
        System.out.println("------------if_stmt_dash------------");
     if(elseWord!=null) System.out.println(elseWord);
     if(st!=null) st.printNode();
    }
    
}
