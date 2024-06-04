package codeGenerator.addressType;

public class IndirectAddress implements AddressType {
    @Override
    public String toString(int number) {
        return "@" + number;
    }
}
