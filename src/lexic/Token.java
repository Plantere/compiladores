package lexic;

public class Token {
    private int line;
    private int column;
    private Class classe;
    private Value value;

    public Token(int line, int column, Class classe, Value value) {
        this.line = line;
        this.column = column;
        this.classe = classe;
        this.value = value;
    }

    public Token(int line, int column, Class classe) {
        this.line = line;
        this.column = column;
        this.classe = classe;
    }

    public Token(int line, int column) {
        this.line = line;
        this.column = column;

    }

    public int getLine() {
        return line;
    }

    public void setline(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setcolumn(int column) {
        this.column = column;
    }

    public Class getClasse() {
        return classe;
    }

    public void setClasse(Class classe) {
        this.classe = classe;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String toString() {
        return "Token [line=" + line + ", column=" + column + ", classe=" + classe + ", valor=" + value + "]";
    }

}
