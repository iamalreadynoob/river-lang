package runtime;

import exceptions.BasicExceptions;
import recognizing.TypeArith;
import recognizing.TypeCast;
import recognizing.TypeCheck;

import java.util.ArrayList;
import java.util.Map;

public class ArithOperators
{

    public static String calculate(ArrayList<String> pieces, Map<String, String> variables, Map<String, String> varTypes, String resultType)
    {
        String result = null;
        ArrayList<String> simplified = simplify(pieces, resultType, variables, varTypes);
        ArrayList<String> cleared = handleBrackets(simplified, resultType);
        result = exec(cleared, resultType);
        return result;
    }

    private static ArrayList<String> simplify(ArrayList<String> pieces, String resultType, Map<String, String> variables, Map<String, String> varTypes)
    {
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
                if (type != null && !type.equals("truth"))
                {
                    TypeCast cast = new TypeCast();
                    simplified.add(cast.convert(type, resultType, pieces.get(loc)));
                }
            }
        }

        return simplified;
    }

    private static ArrayList<String> handleBrackets(ArrayList<String> pieces, String type)
    {
        String result = null;

        int openBrackets = 0;
        int closeBrackets = 0;

        int loc = 0;
        while (loc < pieces.size())
        {
            if (pieces.get(loc).equals("(")) openBrackets = loc;
            else if (pieces.get(loc).equals(")") && openBrackets < loc)
            {
                closeBrackets = loc;

                if (closeBrackets - openBrackets > 1)
                {
                    ArrayList<String> subProcess = new ArrayList<>();

                    for (int i = openBrackets+1; i < closeBrackets; i++)
                        subProcess.add(pieces.get(i));

                    String subResult = exec(subProcess, type);

                    ArrayList<String> temp = new ArrayList<>();
                    for (int i = 0; i < openBrackets; i++) temp.add(pieces.get(i));
                    temp.add(subResult);
                    for (int i = closeBrackets+1; i < pieces.size(); i++) temp.add(pieces.get(i));

                    pieces = temp;
                    loc = openBrackets;
                }
            }

            loc++;
        }


        return pieces;
    }

    public static String exec(ArrayList<String> pieces, String type)
    {
        String result = null;

        int loc = 0;

        boolean flag = true;

        while (!pieces.isEmpty() && flag)
        {
            flag = false;

            if (pieces.get(0).equals("*") || pieces.get(0).equals("/") || pieces.get(0).equals("^"))
            {
                pieces.remove(0);
                flag = true;
            }

            if (pieces.get(pieces.size() - 1).equals("*") || pieces.get(pieces.size() - 1).equals("/") || pieces.get(pieces.size() - 1).equals("^"))
            {
                pieces.remove(pieces.size()-1);
                flag = true;
            }
        }


        TypeArith arith = new TypeArith(type);

        loc = 0;

        while (loc < pieces.size())
        {
            if (pieces.get(loc).equals("*"))
            {
                String subResult = arith.calculate(pieces.get(loc-1), pieces.get(loc+1), '*');
                pieces = arith.reArrangeArr(pieces, subResult, loc-1);
            }
            else if (pieces.get(loc).equals("/"))
            {
                String subResult = arith.calculate(pieces.get(loc-1), pieces.get(loc+1), '/');
                pieces = arith.reArrangeArr(pieces, subResult, loc-1);
            }
            else if (pieces.get(loc).equals("^"))
            {
                String subResult = arith.calculate(pieces.get(loc-1), pieces.get(loc+1), '^');
                pieces = arith.reArrangeArr(pieces, subResult, loc-1);
            }
            else loc++;
        }

        //TODO: ADD & SUBTRACT

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
