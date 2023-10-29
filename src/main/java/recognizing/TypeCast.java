package recognizing;

import plangWorks.Config;

import java.util.ArrayList;

public class TypeCast
{

    private ArrayList<String> types;

    public TypeCast()
    {
        types = Config.getDatatypes();
    }

    public String convert(String from, String to, String value)
    {
        String converted = null;

        if (from.equals(to)) converted = value;
        else if (types.contains(from) && types.contains(to))
        {
            if (from.equals("num")) converted = fromNum(to, value);
            else if (from.equals("fnum")) converted = fromFnum(to, value);
            else if (from.equals("lnum")) converted = fromLnum(to, value);
            else if (from.equals("byte")) converted = fromByte(to, value);
        }

        return converted;
    }

    private String fromNum(String to, String value)
    {
        String converted = null;

        Integer raw = Integer.parseInt(value);

        if (to.equals("fnum"))
        {
            Double temp = raw.doubleValue();
            converted = Double.toString(temp);
        }
        else if (to.equals("lnum"))
        {
            Long temp = raw.longValue();
            converted = Long.toString(temp);
        }
        else if (to.equals("byte"))
        {
            Byte temp = raw.byteValue();
            converted = Byte.toString(temp);
        }

        return converted;
    }

    private String fromLnum(String to, String value)
    {
        String converted = null;

        Long raw = Long.parseLong(value);

        if (to.equals("num"))
        {
            Integer temp = raw.intValue();
            converted = Integer.toString(temp);
        }
        else if (to.equals("fnum"))
        {
            Double temp = raw.doubleValue();
            converted = Double.toString(temp);
        }
        else if (to.equals("byte"))
        {
            Byte temp = raw.byteValue();
            converted = Byte.toString(temp);
        }

        return converted;
    }

    private String fromFnum(String to, String value)
    {
        String converted = null;

        Double raw = Double.parseDouble(value);

        if (to.equals("num"))
        {
            Integer temp = raw.intValue();
            converted = Integer.toString(temp);
        }
        else if (to.equals("lnum"))
        {
            Long temp = raw.longValue();
            converted = Long.toString(temp);
        }
        else if (to.equals("byte"))
        {
            Byte temp = raw.byteValue();
            converted = Byte.toString(temp);
        }

        return converted;
    }

    private String fromByte(String to, String value)
    {
        String converted = null;

        Byte raw = Byte.parseByte(value);

        if (to.equals("num"))
        {
            Integer temp = raw.intValue();
            converted = Integer.toString(temp);
        }
        else if (to.equals("fnum"))
        {
            Double temp = raw.doubleValue();
            converted = Double.toString(temp);
        }
        else if (to.equals("lnum"))
        {
            Long temp = raw.longValue();
            converted = Long.toString(temp);
        }

        return converted;
    }

}
