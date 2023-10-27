package recognizing;

import java.util.ArrayList;

public class Numerics
{
    private ArrayList<Character> digits;

    public Numerics()
    {
        fillDigits();
    }

    public boolean isNum(String value)
    {
        boolean flag = true;

        int loc = 0;
        if (value.charAt(0) == '-' || value.charAt(0) == '+') loc++;

        for (int i = loc; i < value.length(); i++)
            if (!digits.contains(value.charAt(i)))
            {
                flag = false;
                break;
            }

        if (flag && loc == 1 && value.length() > 11) flag = false;
        else if (flag && loc == 0 && value.length() > 10) flag = false;
        else if ((flag && loc == 0 && value.length() == 10) || (flag && loc == 1 && value.length() == 11))
        {
            String temp = value;
            if (loc == 1) temp = temp.substring(1);

            int firstDigit = Integer.parseInt(Character.toString(temp.charAt(0)));

            if (firstDigit > 2) flag = false;
            else if (firstDigit == 2)
            {
                int rest = Integer.parseInt(temp.substring(1));
                if (rest > 147483647) flag = false;
            }
        }

        return flag;
    }

    public boolean isFnum(String value)
    {
        boolean flag = true;

        int loc = 0;

        if (!value.contains(".") || getAmount(value, '.') > 1) flag = false;

        if (flag && (value.charAt(0) == '-' || value.charAt(0) == '+'))
        {

        }

        return flag;
    }


    public void fillDigits()
    {
        digits.add('0');    digits.add('1');    digits.add('2');    digits.add('3');    digits.add('4');
        digits.add('5');    digits.add('6');    digits.add('7');    digits.add('8');    digits.add('9');
    }

    private int getAmount(String value, char item)
    {
        int amount = 0;

        for (int i = 0; i < value.length(); i++)
            if (value.charAt(i) == item)
                amount++;

        return amount;
    }

}
