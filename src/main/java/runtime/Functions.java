package runtime;


import exceptions.BasicExceptions;
import plangWorks.Config;

import java.util.ArrayList;

public class Functions
{

    public static void run(ArrayList<ArrayList<String>> fun, ArrayList<Object> passedArgs, ArrayList<CodeFile> codeFiles)
    {
        int loc = 0;
        Storage block = new Storage();

        while (loc < fun.size())
        {
            if (loc == 0 && fun.get(loc).size() >= 4 && fun.get(loc).get(0).equals("(") && fun.get(loc).get(1).equals("fun") && fun.get(loc).get(fun.get(loc).size() - 1).equals(")"))
            {
                if (fun.get(loc).size() > 4 && fun.get(loc).get(3).equals(":"))
                {
                    int subLoc = 4;

                    ArrayList<String> names = new ArrayList<>();
                    ArrayList<String> types = new ArrayList<>();

                    while (subLoc + 1 < fun.get(loc).size())
                    {
                        String name = fun.get(loc).get(subLoc);
                        String type = fun.get(loc).get(subLoc+1);

                        if (Config.getDatatypes().contains(type) && !names.contains(name))
                        {
                            names.add(name);
                            types.add(type);
                        }
                        else if (!Config.getDatatypes().contains(type))
                        {
                            System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.INVALID_DATATYPE));
                            System.exit(1);
                        }
                        else
                        {
                            System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.DUPLICATE_ERROR));
                            System.exit(1);
                        }
                    }

                    if (passedArgs.size() == names.size())
                    {
                        for (int i = 0; i < names.size(); i++)
                            block.addVariable(names.get(i), types.get(i), Storage.Access.BLOCK, passedArgs.get(i));
                    }
                    else if (passedArgs.size() > names.size())
                    {
                        System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNEXPECTED_ARGUMENTS_PASSED));
                        System.exit(1);
                    }
                    else
                    {
                        System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.ARGUMENTS_MISSING));
                        System.exit(1);
                    }
                }

                loc++;
            }
            else if (loc == 0) loc++;

            //conditional statements
            else if (fun.get(loc).get(0).equals("situ"))
            {

            }

            //loops
            else if (fun.get(loc).get(0).equals("loop"))
            {

            }

            else if (fun.get(loc).contains("="))
            {

            }
            
        }
    }

}
