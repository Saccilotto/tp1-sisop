class Token {
    TokenType type;
    String lexeme;
    int lineNumber;

    Token(TokenType type, String lexeme, int lineNumber) {
        this.type = type;
        this.lexeme = lexeme;
        this.lineNumber = lineNumber;
    }

    @Override
    public String toString() {
        return "[" + type + ", " + lexeme + ", Line " + lineNumber + "]";
    }
}
