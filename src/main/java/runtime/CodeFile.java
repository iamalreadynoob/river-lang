package runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CodeFile
{

    private Storage storage;

    //path, name
    private Map<String, String> imports;
    private String path;
    private boolean isMain;

    private ArrayList<ArrayList<String>> mainFun;
    private Map<String, ArrayList<ArrayList<String>>> functions;

    public CodeFile()
    {
        storage = new Storage();
        imports = new HashMap<>();
        mainFun = new ArrayList<>();
        functions = new HashMap<>();
        isMain = false;
    }

    public Storage getStorage() {return storage;}
    public Map<String, String> getImports() {return imports;}

    public void setMainFun(ArrayList<ArrayList<String>> mainFun)
    {
        this.mainFun = mainFun;
        isMain = true;
    }

    public boolean isMain() {return isMain;}
    public void addFun(String name, ArrayList<ArrayList<String>> tokens) {functions.put(name, tokens);}

    public ArrayList<ArrayList<String>> getMainFun() {return mainFun;}

    public ArrayList<ArrayList<String>> getFun(String name)
    {
        if (functions.containsKey(name)) return functions.get(name);
        else return null;
    }

}
