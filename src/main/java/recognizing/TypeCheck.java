package recognizing;


public class TypeCheck
{
    public static boolean isNum(String value)
    {
        boolean flag = true;

        try {Integer temp = Integer.parseInt(value);}
        catch (Exception e) {flag = false;}

        return flag;
    }

    public static boolean isFnum(String value)
    {
        boolean flag = true;

        try {Float temp = Float.parseFloat(value);}
        catch (Exception e) {flag = false;}

        return flag;
    }

    public static boolean isLnum(String value)
    {
        boolean flag = true;

        try {Long temp = Long.parseLong(value);}
        catch (Exception e) {flag = false;}

        return flag;
    }

    public static boolean isChar(String value)
    {
        boolean flag = true;
        if (value.length() != 1) flag = false;
        return flag;
    }

    public static boolean isByte(String value)
    {
        boolean flag = true;

        try {Byte temp = Byte.parseByte(value);}
        catch (Exception e) {flag = false;}

        return flag;
    }

    public static boolean isBool(String value)
    {
        boolean flag = true;

        try {Boolean temp = Boolean.parseBoolean(value);}
        catch (Exception e) {flag = false;}

        return flag;
    }

    public static boolean isTruth(String value)
    {
        boolean flag = false;

        if (value.equals("true") || value.equals("atrue") || value.equals("tiresias") || value.equals("afalse") || value.equals("false"))
            flag = true;

        return flag;
    }

    public static String getType(String value)
    {
        String type = null;

        boolean flag = true;

        return type;
    }

}
