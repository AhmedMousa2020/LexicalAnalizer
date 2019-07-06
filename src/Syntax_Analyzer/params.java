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


public class params implements node{
    param_list pl;
    public params(param_list pl) {
    this.pl=pl;
    }

    @Override
    public void printNode() {
     System.out.println("------------params------------");
     if(pl!=null){
     pl.printNode();
     }
     
    }
    
}
