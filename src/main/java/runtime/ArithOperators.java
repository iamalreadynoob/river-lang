package runtime;

import exceptions.BasicExceptions;
import recognizing.TypeCast;
import recognizing.TypeCheck;

import java.util.ArrayList;
import java.util.Map;

public class ArithOperators
{

    public static String calculate(ArrayList<String> pieces, Map<String, String> variables, Map<String, String> varTypes, String resultType)
    {
        String result = null;

        ArrayList<String> simplified = new ArrayList<>();

        int loc = 0;
        while (loc < pieces.size())
        {
            if (pieces.get(loc).equals("'") || pieces.get(loc).equals("\""))
            {
                loc++;
                if (isWordToNumeric(resultType, pieces.get(loc))) simplified.add(resultType);
                loc += 2;
            }
            else if (pieces.get(loc).equals("+") || pieces.get(loc).equals("-") || pieces.get(loc).equals("*") || pieces.get(loc).equals("/") || pieces.get(loc).equals("(") || pieces.get(loc).equals(")") || pieces.get(loc).equals("^"))
            {
                simplified.add(pieces.get(loc));
                loc++;
            }

            else if (variables.containsKey(pieces.get(loc)))
            {
                TypeCast cast = new TypeCast();
                simplified.add(cast.convert(varTypes.get(pieces.get(loc)), resultType, variables.get(pieces.get(loc))));
                loc++;
            }
            else
            {
                String type = TypeCheck.getType(pieces.get(loc));
            }
        }

        return result;
    }

    private static boolean isWordToNumeric(String type, String words)
    {
        if (type.equals("num"))
        {
            if (TypeCheck.isNum(words)) return true;
            else
            {
                System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.TYPE_CAST_ERROR));
                System.exit(1);
            }
        }
        else if (type.equals("fnum"))
        {
            if (TypeCheck.isFnum(words)) return true;
            else
            {
                System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.TYPE_CAST_ERROR));
                System.exit(1);
            }
        }
        else if (type.equals("lnum"))
        {
            if (TypeCheck.isLnum(words)) return true;
            else
            {
                System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.TYPE_CAST_ERROR));
                System.exit(1);
            }
        }
        else if (type.equals("byte"))
        {
            if (TypeCheck.isByte(words)) return true;
            else
            {
                System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.TYPE_CAST_ERROR));
                System.exit(1);
            }
        }

        return false;
    }

}
