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


public class param_list implements node{
   param_list_dash pl;
   param p;

    public param_list( param p,param_list_dash pl) {
        this.pl = pl;
        this.p = p;
    }
    

    
    
    
    @Override
    public void printNode() {
        System.out.println("------------param_list------------");
    if(p!=null){
        p.printNode();
    }
    if(pl!=null){
        pl.printNode();
    }   
    }
    
}
