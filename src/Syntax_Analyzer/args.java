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
public class args implements node{

    arg_list al;

    public args(arg_list al) {
        this.al = al;
    }
    
    
    @Override
    public void printNode() {
        System.out.println("------------args------------");
        if(al!=null){
            al.printNode();
        }else{
            System.out.println("null");
        }
    }
    
}
