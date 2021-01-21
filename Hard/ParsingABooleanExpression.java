package Hard;

public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        String exp = expression;
        while (exp.length() != 1) {
            int opIndex = findOpIndex(exp);
            int rp = opIndex + 2;
            for (; rp < exp.length(); rp++)
                if (exp.charAt(rp) == ')')
                    break;
            String res = getBool(exp.substring(opIndex, rp));
            exp = exp.substring(0, opIndex) + res + exp.substring(rp + 1);
        }

        return exp.equals("t");
    }

    private String getBool(String exp) {
        switch (exp.charAt(0)) {
            case '!':
                return (exp.charAt(2)) == 't' ? "f" : "t";
            case '&':
                for (int i = 2; i < exp.length(); i++)
                    if (exp.charAt(i) == 'f')
                        return "f";
                return "t";
            case '|':
                for (int i = 2; i < exp.length(); i++)
                    if (exp.charAt(i) == 't')
                        return "t";
                return "f";
        }
        return "-1";
    }

    private int findOpIndex(String exp) {
        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);
            if (c == '|' || c == '&' || c == '!')
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String expression = "|(|(&(t,f,t),!(t)),&(!(f),t))";
        System.out.println(new ParsingABooleanExpression().parseBoolExpr(expression));
    }
}
