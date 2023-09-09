import java.util.ArrayList;
import java.util.List;

class Lexer {
    private final List<Token> tokens = new ArrayList<>();
    private int lineNumber = 1;

    void tokenize(String input) {
        String[] lines = input.split("\n");

        for (String line : lines) {
            tokenizeLine(line);
            lineNumber++;
        }
    }

    private void tokenizeLine(String line) {
        String[] parts = line.split("\\s+");

        for (String part : parts) {
            if (isInstruction(part)) {
                tokens.add(new Token(TokenType.valueOf(part), part, lineNumber));
            } else if (isLabel(part)) {
                tokens.add(new Token(TokenType.LABEL, part, lineNumber));
            } else if (isNumber(part)) {
                tokens.add(new Token(TokenType.NUMBER, part, lineNumber));
            } else {
                System.out.println("Invalid token: " + part + " on line " + lineNumber);
            }
        }
    }

    private boolean isInstruction(String s) {
        try {
            TokenType.valueOf(s);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isLabel(String s) {
        return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private boolean isNumber(String s) {
        return s.matches("\\d+");
    }

    List<Token> getTokens() {
        return tokens;
    }
}
