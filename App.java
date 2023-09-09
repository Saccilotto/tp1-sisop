import java.util.List;

public class App {
    public static void main(String[] args) {
        String code = """
            ADD op1
            SUB op2
            BRANY label1
            SYSCALL 42
            """;

        Lexer lexer = new Lexer();
        lexer.tokenize(code);

        List<Token> tokens = lexer.getTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

}
