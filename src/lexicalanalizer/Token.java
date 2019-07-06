package lexicalanalizer;

public enum Token {
    
    SINGLE_COMMENT("(//.*)"),
    MULTI_COMMENT("/\\*[\\s\\S]*?\\*/"),
    CHAR_LITERAL("('\\w')|('\\\\a')|('\\\\\\\\')"),
    STRING_LITERAL("(\".+\")"),
    AUTO("\\b(auto)\\b"),
    NEW("\\b(new)\\b"),
    TRUE("\\b(true)\\b"),
    FALSE("\\b(false)\\b"),
    BREAK("\\b(break)\\b"),
    BOOL("\\b(bool)\\b"),
    CASE("\\b(case)\\b"),
    CHAR("\\b(char)\\b"),
    CONST("\\b(const)\\b"),
    CONTINUE("\\b(continue)\\b"),
    DEFAULT("\\b(default)\\b"),
    DOUBLE("\\b(double)\\b"),
    DO("\\b(do)\\b"),
    ELSE("\\b(else)\\b"),
    ENUM("\\b(enum)\\b"),
    EXTERN("\\b(extern)\\b"),
    FLOAT("\\b(float)\\b"),
    FOR("\\b(for)\\b"),
    GOTO("\\b(goto)\\b"),
    IF("\\b(if)\\b"),
    INT("\\b(int)\\b"),
    LONG("\\b(long)\\b"),
    RIGESTER("\\b(rigester)\\b"),
    RETURN("\\b(return)\\b"),
    SHORT("\\b(short)\\b"),
    SIGNED("\\b(signed)\\b"),
    SIZEOF("\\b(sizeof)\\b"),
    STATIC("\\b(static)\\b"),
    STRUCT("\\b(struct)\\b"),
    SWITCH("\\b(switch)\\b"),
    TYPEDEF("\\b(typedef)\\b"),
    UNION("\\b(union)\\b"),
    UNSIGNED("\\b(unsigned)\\b"),
    VOID("\\b(void)\\b"),
    VOLATILE("\\b(volatile)\\b"),
    WHILE("\\b(while)\\b"),
    EOF("(\\\\0)$"),
    LEFT_CURLY_B("(\\{)"),
    RIGHT_CURLY_B("(\\})"),
    LEFT_SQUARE_B("(\\[)"),
    RIGHT_SQUARE_B("(\\])"),
    LEFT_ROUND_B("(\\()"),
    RIGHT_ROUND_B("(\\))"),
    COMMA("(,)"),
    SEMICOLON("(;)"),
    NOT("(!)"),
    EQUAL("(==)"),
    ASSIGN_OPERATOR("(=)"),
    PREPROCESSOR("(#)"),
    BACKWARD_SLASH("(\\\\)"),
    MINUS("(-)"),
    PLUS("(\\+)"),
    ASTERICK("(\\*)"),
    DIVIDE("(/)"),
    MOD("(%)"),
    LESSTHAN("(<)"),
    GREATERTHAN("(>)"),
    LESS_EQ("(<=)"),
    GREAT_EQ("(>=)"),
    NOT_EQUAL("(!=)"),
    AND("(&&)"),
    OR("(\\|\\|)"),
    BITWISE_AND("(&)"),
    BITWISE_OR("(\\|)"),
    BITWISE_XOR("(\\^)"),
    LEFT_SHIFT("(<<)"),
    RIGHT_SHIFT("(>>)"),
    BITWISE_NOT("(~)"),
    ERROR_TERM("(\\b[0-9]+[a-zA-Z]+[0-9]*)|([a-zA-Z]+[0-9]*\\.[0-9]+[a-zA-Z]*)"),
    ID("([a-zA-Z]+[0-9_\\.]*[a-zA-Z]*)"),
    FLOAT_LITERAL("(\\d*)(\\.)(\\d+)"),
    DOT("(\\.)"),
    INTEGRAL_LITERAL("(\\d+)");
    
    private final String regex;

    Token(String reg){
        regex = reg;
    }
    public String type(){
        return "<"+this+">";
    }
    public String getRegex(){
        return regex;
    }
}
