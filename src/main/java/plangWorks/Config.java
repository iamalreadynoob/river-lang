package plangWorks;

import java.util.ArrayList;

public class Config
{

    public static ArrayList<Character> getStringPointers()
    {
        ArrayList<Character> temp = new ArrayList<>();
        temp.add('"'); temp.add('\'');
        return temp;
    }

    public static ArrayList<Character> getSeparativeSymbols()
    {
        ArrayList<Character> temp = new ArrayList<>();
        temp.add('"');  temp.add('\''); temp.add('!');   temp.add('^');   temp.add('#');   temp.add('+');
        temp.add('$');  temp.add('%'); temp.add('&');   temp.add('/');   temp.add('{');   temp.add('}');
        temp.add('(');  temp.add(')'); temp.add('[');   temp.add(']');   temp.add('=');   temp.add('?');
        temp.add('*');  temp.add('-'); temp.add('_');   temp.add('@');   temp.add(',');   temp.add('.');
        temp.add(';');  temp.add(':'); temp.add('<');   temp.add('>');   temp.add('|');
        return temp;
    }

    public static char getEscapeChar() {return '\\';}

    public static ArrayList<String> getDatatypes()
    {
        ArrayList<String> datatypes = new ArrayList<>();
        datatypes.add("num");
        datatypes.add("fnum");
        datatypes.add("lnum");
        datatypes.add("text");
        datatypes.add("char");
        datatypes.add("truth");
        datatypes.add("byte");
        //datatypes.add("arr");
        //datatypes.add("coll");

        return datatypes;
    }

    public static ArrayList<String> getMacroCommands()
    {
        ArrayList<String> commands = new ArrayList<>();

        commands.add("import");
        commands.add("public");
        commands.add("protected");
        commands.add("private");

        return commands;
    }

}
