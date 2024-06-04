package semantic.symbol;

import codeGenerator.Address;
import codeGenerator.addressType.ImmediateAddress;
import codeGenerator.varType;

public class CodeGeneratorFacade {
    public static Address createAddress(int num, String varType_str) {
        return new Address(num, varType.valueOf(varType_str), new ImmediateAddress());
    }
}
