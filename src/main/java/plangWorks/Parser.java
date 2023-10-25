package plangWorks;

import java.util.ArrayList;

public class Parser
{
    private ArrayList<Character> stringPointers, separativeSymbols;
    private char escapeChar;

    public Parser(ArrayList<Character> stringPointers, ArrayList<Character> separativeSymbols, char escapeChar)
    {
        this.stringPointers = stringPointers;
        this.separativeSymbols = separativeSymbols;
        this.escapeChar = escapeChar;
    }

    public ArrayList<String> parse(String line)
    {
        if (line.isEmpty()) return null;
        else
        {
            ArrayList<String> pieces = new ArrayList<>();

            int loc = 0;
            boolean isInsideString = false;
            char strPointer = '\0';

            while (loc < line.length())
            {
                if (line.charAt(loc) != ' ')
                {
                    if (!isInsideString && stringPointers.contains(line.charAt(loc)))
                    {
                        pieces.add(Character.toString(line.charAt(loc)));
                        strPointer = line.charAt(loc);

                        loc++;
                        isInsideString = true;
                    }
                    else if (isInsideString && isStringPointer(line, loc, strPointer))
                    {
                        pieces.add(Character.toString(line.charAt(loc)));
                        loc++;

                        strPointer = '\0';
                        isInsideString = false;
                    }
                    else if (isInsideString)
                    {
                        String piece = null;

                        while (loc < line.length() && !isStringPointer(line, loc, strPointer))
                        {
                            if (piece == null) piece = Character.toString(line.charAt(loc));
                            else piece += Character.toString(line.charAt(loc));

                            loc++;
                        }

                        pieces.add(piece);
                    }
                    else
                    {
                        if (separativeSymbols.contains(line.charAt(loc)))
                        {
                            pieces.add(Character.toString(line.charAt(loc)));
                            loc++;
                        }
                        else
                        {
                            String piece = null;

                            while (loc < line.length() && line.charAt(loc) != ' ' && !separativeSymbols.contains(line.charAt(loc)))
                            {
                                if (piece == null) piece = Character.toString(line.charAt(loc));
                                else piece += line.charAt(loc);

                                loc++;
                            }

                            pieces.add(piece);
                        }
                    }
                }
                else loc++;
            }

            return pieces;
        }
    }

    private boolean isStringPointer(String line, int at, char strPointer)
    {
        if (at > 0 && at < line.length() && strPointer == line.charAt(at) && at - 1 > 0)
        {
            int amount = 0;

            for (int i = at-1; i >= 0; i--)
            {
                if (line.charAt(i) == escapeChar) amount++;
                else break;
            }

            if (amount % 2 == 0) return true;
            else return false;
        }
        else return false;
    }
}
