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
public class arg_list implements node{

    arg_list_dash al;
   
    expr e;

    public arg_list( expr e,arg_list_dash al) {
        this.al = al;
        this.e = e;
    }

    
    
    
    @Override
    public void printNode() {
        System.out.println("------------arg_list------------");
        if(al!=null&&e!=null){
                e.printNode();
              al.printNode();
        }}
    
    
}
