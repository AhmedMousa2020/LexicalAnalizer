
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
public class var_decl implements node{
    Token type;
    Token identifier;
    Token semiColon;
    Token rightSquareBracket;
    Token leftSquareBracket;


    public var_decl(Token type, Token identifier, var_decl vd) {
        this.type = type;
        this.identifier = identifier;
        if(vd != null){
            this.semiColon = vd.semiColon;
            this.rightSquareBracket = vd.rightSquareBracket;
            this.leftSquareBracket = vd.leftSquareBracket;
        }
    }

    public var_decl(Token rightSquareBracket, Token leftSquareBracket, Token semiColon) {
        this.type = null;
        this.identifier = null;
        this.rightSquareBracket = rightSquareBracket;
        this.leftSquareBracket = leftSquareBracket;
        this.semiColon = semiColon;
    }
    
    
    @Override
    public void printNode() {
        System.out.println("------------var_decl------------");
        if(type!=null) System.out.println(type);
        if(identifier!=null) System.out.println(identifier);
        if(rightSquareBracket!=null) System.out.println(rightSquareBracket);
        if(leftSquareBracket!=null) System.out.println(leftSquareBracket);
        if(semiColon!=null) System.out.println(semiColon);
    }
}
    

