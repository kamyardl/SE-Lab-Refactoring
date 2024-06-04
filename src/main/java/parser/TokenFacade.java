package parser;

import scanner.token.Token;

public class TokenFacade {
    public static Token createToken(String s) {
        return new Token(Token.getTypeFormString(s), s);
    }
}
