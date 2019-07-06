/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Syntax_Analyzer;

/**
 *
 * @author AbuElsaud
 */
public class decl_list implements node{
    decl_list_dash dl;
    decl d;
    public decl_list(decl d,decl_list_dash dl) {
        this.dl=dl;
        this.d=d;
    }

    
    
     
    @Override
    public void printNode() {
        System.out.println("-------decl_list-------------");
        if(d!=null) { ; 
            d.printNode();
        }
        if(dl!=null){
            dl.printNode();
        }
    }
                
    
    
}
