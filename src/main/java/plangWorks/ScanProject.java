package plangWorks;

import fileWorks.TextCommunication;
import runtime.CodeFile;
import runtime.Macros;
import runtime.Storage;

import java.io.File;
import java.util.ArrayList;

public class ScanProject
{

    public static ArrayList<CodeFile> scan(String dir)
    {
        ArrayList<CodeFile> codeFiles = new ArrayList<>();

        //Project Files
        ArrayList<String> paths = new ArrayList<>();
        ArrayList<String> dirs = new ArrayList<>();
        dirs.add(dir);

        while (dirs.size() > 0)
        {
            File d = new File(dirs.get(0));
            File[] files = d.listFiles();

            for (File f: files)
            {
                if (f.isDirectory()) dirs.add(f.getAbsolutePath());
                else if (f.isFile() && f.getAbsolutePath().endsWith(".rivr")) paths.add(f.getAbsolutePath());
            }

            dirs.remove(0);
        }

        for (String path: paths) codeFiles.add(create(path));

        return codeFiles;
    }

    private static CodeFile create(String path)
    {
        CodeFile codeFile = new CodeFile();

        ArrayList<ArrayList<String>> tokenLines = tokenizeFile(path);

        int loc = 0;

        while (loc < tokenLines.size())
        {
            if (tokenLines.get(loc).get(0).equals("#"))
            {
                if (tokenLines.get(loc).get(1).equals("import"))
                {
                    Object[] objects = Macros.run(tokenLines.get(loc));
                    codeFile.getImports().put(objects[0].toString(), objects[1].toString());
                }
                else if (tokenLines.get(loc).get(1).equals("public") || tokenLines.get(loc).get(1).equals("protected") || tokenLines.get(loc).get(1).equals("private"))
                {
                    Object[] objects = Macros.run(tokenLines.get(loc));
                    codeFile.getStorage().addVariable(objects[2].toString(), objects[1].toString(), (Storage.Access) objects[0], objects[3]);
                }

                loc++;
            }
            else if (tokenLines.get(loc).get(0).equals("MAIN"))
            {
                ArrayList<ArrayList<String>> tokens = new ArrayList<>();

                while (loc < tokenLines.size())
                {
                    tokens.add(tokenLines.get(loc));
                    loc++;
                }

                codeFile.setMainFun(tokens);
            }
            else if (tokenLines.get(loc).get(0).equals("fun"))
            {
                String name = tokenLines.get(loc).get(1);

                ArrayList<ArrayList<String>> tokens = new ArrayList<>();
                while (loc < tokenLines.size() && !tokenLines.get(loc).get(0).equals("done"))
                {
                    tokens.add(tokenLines.get(loc));
                    loc++;
                }

                codeFile.addFun(name, tokens);
            }
        }

        return codeFile;
    }

    private static ArrayList<ArrayList<String>> tokenizeFile(String path)
    {
        ArrayList<String> rawLines = TextCommunication.read(path);
        ArrayList<String> editedLines = new ArrayList<>();
        for (String l: rawLines) if (!l.trim().isEmpty() && !l.trim().isBlank()) editedLines.add(l.trim());

        ArrayList<ArrayList<String>> tokenized = new ArrayList<>();

        Parser parser = new Parser(Config.getStringPointers(), Config.getSeparativeSymbols(), Config.getEscapeChar());
        for (String l: editedLines) tokenized.add(parser.parse(l));

        return tokenized;
    }

}
