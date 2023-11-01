package recognizing;

import runtime.Macros;

import java.util.ArrayList;

public class TypeArith
{

    private final String resultType;

    public TypeArith(String resultType)
    {
        this.resultType = resultType;
    }

    public String calculate(String first, String second, char calculation)
    {
        String result = null;

        switch (calculation)
        {
            case '+': result = add(first, second); break;
            case '-': result = sub(first, second); break;
            case '*': result = multiply(first, second); break;
            case '/': result = divide(first, second); break;
            case '^': result = times(first, second); break;
        }

        return result;
    }

    public ArrayList<String> reArrangeArr(ArrayList<String> pieces, String value, int at)
    {
        ArrayList<String> temp = new ArrayList<>();

        if (at >= 0 && at < pieces.size())
        {
            for (int i = 0; i < at; i++) temp.add(pieces.get(i));
            temp.add(value);
            for (int i = at+1; i < pieces.size(); i++) temp.add(pieces.get(i));
        }

        return temp;
    }

    private String add(String first, String second)
    {
        String result = null;

        TypeCast cast = new TypeCast();

        if (resultType.equals("num"))
        {
            first = cast.convert(TypeCheck.getType(first), "num", first);
            second = cast.convert(TypeCheck.getType(second), "num", second);

            Integer temp = Integer.parseInt(first) + Integer.parseInt(second);
            result = temp.toString();
        }
        else if (resultType.equals("fnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "fnum", first);
            second = cast.convert(TypeCheck.getType(second), "fnum", second);

            Double temp = Double.parseDouble(first) + Double.parseDouble(second);
            result = temp.toString();
        }
        else if (resultType.equals("lnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "lnum", first);
            second = cast.convert(TypeCheck.getType(second), "lnum", second);

            Long temp = Long.parseLong(first) + Long.parseLong(second);
            result = temp.toString();
        }
        else if (resultType.equals("byte"))
        {
            first = cast.convert(TypeCheck.getType(first), "byte", first);
            second = cast.convert(TypeCheck.getType(second), "byte", second);

            Byte temp = (byte) (Byte.parseByte(first) + Byte.parseByte(second));
            result = temp.toString();
        }

        return result;
    }

    private String sub(String first, String second)
    {
        String result = null;

        TypeCast cast = new TypeCast();

        if (resultType.equals("num"))
        {
            first = cast.convert(TypeCheck.getType(first), "num", first);
            second = cast.convert(TypeCheck.getType(second), "num", second);

            Integer temp = Integer.parseInt(first) - Integer.parseInt(second);
            result = temp.toString();
        }
        else if (resultType.equals("fnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "fnum", first);
            second = cast.convert(TypeCheck.getType(second), "fnum", second);

            Double temp = Double.parseDouble(first) - Double.parseDouble(second);
            result = temp.toString();
        }
        else if (resultType.equals("lnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "lnum", first);
            second = cast.convert(TypeCheck.getType(second), "lnum", second);

            Long temp = Long.parseLong(first) - Long.parseLong(second);
            result = temp.toString();
        }
        else if (resultType.equals("byte"))
        {
            first = cast.convert(TypeCheck.getType(first), "byte", first);
            second = cast.convert(TypeCheck.getType(second), "byte", second);

            Byte temp = (byte) (Byte.parseByte(first) - Byte.parseByte(second));
            result = temp.toString();
        }

        return result;
    }

    private String multiply(String first, String second)
    {
        String result = null;

        TypeCast cast = new TypeCast();

        if (resultType.equals("num"))
        {
            first = cast.convert(TypeCheck.getType(first), "num", first);
            second = cast.convert(TypeCheck.getType(second), "num", second);

            Integer temp = Integer.parseInt(first) * Integer.parseInt(second);
            result = temp.toString();
        }
        else if (resultType.equals("fnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "fnum", first);
            second = cast.convert(TypeCheck.getType(second), "fnum", second);

            Double temp = Double.parseDouble(first) * Double.parseDouble(second);
            result = temp.toString();
        }
        else if (resultType.equals("lnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "lnum", first);
            second = cast.convert(TypeCheck.getType(second), "lnum", second);

            Long temp = Long.parseLong(first) * Long.parseLong(second);
            result = temp.toString();
        }
        else if (resultType.equals("byte"))
        {
            first = cast.convert(TypeCheck.getType(first), "byte", first);
            second = cast.convert(TypeCheck.getType(second), "byte", second);

            Byte temp = (byte) (Byte.parseByte(first) * Byte.parseByte(second));
            result = temp.toString();
        }

        return result;
    }

    private String divide(String first, String second)
    {
        String result = null;

        TypeCast cast = new TypeCast();

        if (resultType.equals("num"))
        {
            first = cast.convert(TypeCheck.getType(first), "num", first);
            second = cast.convert(TypeCheck.getType(second), "num", second);

            Integer temp = Integer.parseInt(first) / Integer.parseInt(second);
            result = temp.toString();
        }
        else if (resultType.equals("fnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "fnum", first);
            second = cast.convert(TypeCheck.getType(second), "fnum", second);

            Double temp = Double.parseDouble(first) / Double.parseDouble(second);
            result = temp.toString();
        }
        else if (resultType.equals("lnum"))
        {
            first = cast.convert(TypeCheck.getType(first), "lnum", first);
            second = cast.convert(TypeCheck.getType(second), "lnum", second);

            Long temp = Long.parseLong(first) / Long.parseLong(second);
            result = temp.toString();
        }
        else if (resultType.equals("byte"))
        {
            first = cast.convert(TypeCheck.getType(first), "byte", first);
            second = cast.convert(TypeCheck.getType(second), "byte", second);

            Byte temp = (byte) (Byte.parseByte(first) / Byte.parseByte(second));
            result = temp.toString();
        }

        return result;
    }

    private String times(String first, String second)
    {
        String result = null;

        TypeCast cast = new TypeCast();

        Double firstD = Double.parseDouble(cast.convert(TypeCheck.getType(first), "fnum", first));
        Double secondD = Double.parseDouble(cast.convert(TypeCheck.getType(second), "fnum", second));
        Double subResult = Math.pow(firstD, secondD);

        String raw = subResult.toString();
        result = cast.convert("fnum", resultType, raw);

        return result;
    }

}
