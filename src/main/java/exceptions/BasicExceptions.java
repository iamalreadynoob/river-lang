package exceptions;

public class BasicExceptions
{

    public static String getException(Exceptions exception)
    {
        switch (exception)
        {
            case RUNTIME_NON_EXIST: return "RUNTIME DOES NOT EXIST: Please define a valid Main.rivr file.";
            case ALREADY_ASSIGNED: return "ALREADY ASSIGNED VARIABLE: This variable name has already been used.";
            case UNASSIGNED_VARIABLE: return "UNASSIGNED VARIABLE: This variable has not been assigned.";
            case INVALID_MACRO_COMMAND: return "INVALID MACRO COMMAND: This macro command is invalid.";
            case MACRO_SYNTAX_ERROR: return "MACRO SYNTAX ERROR: Something went wrong in parsing of Macro";
            case FILE_NON_EXIST: return "FILE DOES NOT EXIST: This imported file does not exist.";
            case UNEXPECTED_ARGUMENTS_PASSED: return "UNEXPECTED ARGUMENTS PASSED: There are more arguments than expected.";
            case ARGUMENTS_MISSING: return "ARGUMENTS MISSING: There are less arguments than expected";
            case INVALID_DATATYPE: return "INVALID DATATYPE: The given datatype does not exist.";
            case DUPLICATE_ERROR: return "DUPLICATE ERROR: The element duplicated";
        }

        return null;
    }


    public enum Exceptions
    {
        RUNTIME_NON_EXIST, ALREADY_ASSIGNED, UNASSIGNED_VARIABLE, INVALID_MACRO_COMMAND, MACRO_SYNTAX_ERROR, FILE_NON_EXIST,
        UNEXPECTED_ARGUMENTS_PASSED, ARGUMENTS_MISSING, INVALID_DATATYPE, DUPLICATE_ERROR
    }

}
