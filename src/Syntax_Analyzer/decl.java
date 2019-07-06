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
public class decl implements node{
     var_decl vd;
     fun_decl fd;
    public decl(var_decl vd ) {
        this.vd=vd;
    }
    public decl(fun_decl fd) {
        this.fd=fd;
    }

    
    
    
    @Override
    public void printNode() {
        System.out.println("------------decl------------");
        if(vd!=null) vd.printNode() ;
        else if(fd!=null) fd.printNode() ;
        else System.out.println("ε");
        }
    }
    

