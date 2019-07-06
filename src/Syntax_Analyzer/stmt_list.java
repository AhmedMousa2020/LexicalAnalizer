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
public class stmt_list implements node{
    stmt_list sl;
    stmt s;
    public stmt_list(stmt s,stmt_list sl) {
        this.sl=sl;
        this.s=s;
    }

    
    
    
    @Override
    public void printNode() {
        System.out.println("------------stmt_list------------");
      if(s!=null){
       s.printNode();
        }
      if(sl!=null){
      sl.printNode();
      }
      else{
      System.out.print('ε');
      }
    }
    
}
