package runtime;

import exceptions.BasicExceptions;
import plangWorks.Config;

import java.io.File;
import java.util.ArrayList;

public class Macros
{

    public static Object[] run(ArrayList<String> tokens)
    {
        if (tokens.size() == 7 && Config.getMacroCommands().contains(tokens.get(1)))
        {
            if (tokens.get(1).equals("import"))
            {
                if (tokens.get(2).equals("\"") && tokens.get(4).equals("\"") && tokens.get(5).equals("as"))
                {
                    String path = tokens.get(3);

                    if (new File(path).exists() || new File("test/" + path).exists())
                        return new Object[] {tokens.get(3), tokens.get(6)};
                    else
                    {
                        System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.FILE_NON_EXIST));
                        System.exit(1);
                        return null;
                    }
                }
                else
                {
                    System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.MACRO_SYNTAX_ERROR));
                    System.exit(1);
                    return null;
                }
            }
            else if (tokens.get(1).equals("public") || tokens.get(1).equals("protected") || tokens.get(1).equals("private"))
            {
                Storage.Access access;
                if (tokens.get(1).equals("public")) access = Storage.Access.PUBLIC;
                else if (tokens.get(1).equals("protected")) access = Storage.Access.PROTECTED;
                else access = Storage.Access.PRIVATE;

                if (tokens.size() == 6 && tokens.get(4).equals("as") && Config.getDatatypes().contains(tokens.get(2)))
                    return new Object[] {access, tokens.get(2), tokens.get(3), tokens.get(5)};

                else if (tokens.size() == 8 && tokens.get(4).equals("as") && tokens.get(2).equals("text") && tokens.get(5).equals("\"") && tokens.get(7).equals("\""))
                    return new Object[] {access, tokens.get(2), tokens.get(3), tokens.get(6)};

                else if (tokens.size() == 8 && tokens.get(4).equals("as") && tokens.get(2).equals("char") && tokens.get(5).equals("'") && tokens.get(7).equals("'"))
                    return new Object[] {access, tokens.get(2), tokens.get(3), tokens.get(6)};

                else
                {
                    System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.MACRO_SYNTAX_ERROR));
                    System.exit(1);
                    return null;
                }
            }

            return null;
        }
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.INVALID_MACRO_COMMAND));
            System.exit(1);
            return null;
        }
    }

}
