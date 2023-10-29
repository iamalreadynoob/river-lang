package runtime;

import exceptions.BasicExceptions;

import java.util.HashMap;
import java.util.Map;

public class Storage
{

    private Map<String, String> storage;
    private Map<String, String> types;
    private Map<String, Access> accessTypes;
    private double referencePoint;
    private boolean referencePointBehavior;

    public Storage()
    {
        storage = new HashMap<>();
        types = new HashMap<>();
        accessTypes = new HashMap<>();

        referencePoint = 0.5;
        referencePointBehavior = true;
    }

    //CREATE
    public void addVariable(String name, String type, Access access, String object)
    {
        if (!storage.containsKey(name))
        {
            storage.put(name, object);
            types.put(name, type);
            accessTypes.put(name, access);
        }
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.ALREADY_ASSIGNED));
            System.exit(1);
        }
    }

    public void addNestedVariable()
    {

    }


    //READ
    public String getObject(String name)
    {
        if (storage.containsKey(name)) return storage.get(name);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
            return null;
        }
    }

    public String getType(String name)
    {
        if (types.containsKey(name)) return types.get(name);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
            return null;
        }
    }

    public Access getAccess(String name)
    {
        if (accessTypes.containsKey(name)) return accessTypes.get(name);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
            return null;
        }
    }

    public double getReferencePoint() {return referencePoint;}
    public boolean getReferencePointBehavior() {return referencePointBehavior;}

    //UPDATE
    public void setValue(String name, String value)
    {
        if (storage.containsKey(name)) storage.put(name, value);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
        }
    }

    public void setNestedValue()
    {

    }

    public void setVarAccess(String name, String type)
    {
        if (storage.containsKey(name)) types.put(name, type);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
        }
    }

    public void setVarType(String name, Access access)
    {
        if (storage.containsKey(name)) accessTypes.put(name, access);
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
        }
    }

    public void setReferencePoint(double referencePoint)
    {
        if (referencePoint >= 0 && referencePoint <= 1) this.referencePoint = referencePoint;
        else
        {
            System.err.println(BasicExceptions.getException(BasicExceptions.Exceptions.INVALID_REFERENCE_POINT));
            System.exit(1);
        }
    }

    public void setReferencePointBehavior(boolean referencePointBehavior) {this.referencePointBehavior = referencePointBehavior;}

    //DELETE
    public void killVariable(String name)
    {
        if (storage.containsKey(name))
        {
            storage.remove(name);
            types.remove(name);
            accessTypes.remove(name);
        }
        else
        {
            System.out.println(BasicExceptions.getException(BasicExceptions.Exceptions.UNASSIGNED_VARIABLE));
            System.exit(1);
        }
    }

    public enum Access
    {
        PUBLIC, PROTECTED, PRIVATE, BLOCK
    }
}
