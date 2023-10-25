import runtime.CodeFile;
import plangWorks.ScanProject;
import runtime.Functions;

import java.util.ArrayList;

public class Main
{

    public static void main(String[] args)
    {
        //TODO: for now, file selection is for testing, it will be redesigned for jar format by using args.

        ArrayList<CodeFile> srcCode = ScanProject.scan("test");

        for (CodeFile src: srcCode)
            if (src.isMain())
            {
                Functions.run(src.getMainFun());
                System.exit(0);
            }
    }

}
