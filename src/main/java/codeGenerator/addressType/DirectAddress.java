package codeGenerator.addressType;

public class DirectAddress implements AddressType {
    @Override
    public String toString(int number) {
        return number + "";
    }
}
