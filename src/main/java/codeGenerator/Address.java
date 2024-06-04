package codeGenerator;

import codeGenerator.addressType.AddressType;
import codeGenerator.addressType.DirectAddress;

/**
 * Created by mohammad hosein on 6/28/2015.
 */

public class Address {
    public int num;
    public AddressType type;
    public varType varType;

    public Address(int num, varType varType, AddressType Type) {
        this.num = num;
        this.type = Type;
        this.varType = varType;
    }

    public Address(int num, varType varType) {
        this.num = num;
        this.type = new DirectAddress();
        this.varType = varType;
    }

    public String toString() {
        return type.toString();
    }
}
