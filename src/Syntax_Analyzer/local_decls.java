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
public class local_decls implements node{

    var_decl vd;
    local_decls ld;

    public local_decls(var_decl vd, local_decls ld) {
        this.vd = vd;
        this.ld = ld;
    }
    
    @Override
    public void printNode() {
        System.out.println("------------local_decls------------");
        if(vd!=null) vd.printNode() ;
        System.out.println();
        if(ld!=null) ld.printNode() ; 
        else System.out.println("");
    }
    
}
