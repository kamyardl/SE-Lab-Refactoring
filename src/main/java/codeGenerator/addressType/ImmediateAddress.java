package codeGenerator.addressType;

public class ImmediateAddress implements AddressType {
    @Override
    public String toString(int number) {
        return "#" + number;
    }
}
