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
public class decl_list_dash implements node{
    decl d;
    decl_list_dash dl;

    public decl_list_dash(decl d, decl_list_dash dl) {
        this.d = d;
        this.dl = dl;
    }

    @Override
    public void printNode() {
        System.out.println("----------decl_list_dash----------");
         if(d!=null){
           d.printNode();
         
         }
         if(dl!=null){
         dl.printNode();
         }
    }
    
}
