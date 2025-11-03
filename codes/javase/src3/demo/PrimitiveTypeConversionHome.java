package demo;
public class PrimitiveTypeConversionHome {
    public static void main(String[] args) {

        int intValue = 55;
        byte byteValue1 = (byte) intValue;
        System.out.println("int → byte: " + byteValue1);

        short shortValue = 636;
        byte byteValue2 = (byte) shortValue;
        System.out.println("short → byte: " + byteValue2);

        long longValue1 = 458L;
        short shortValue2 = (short) longValue1;
        System.out.println("long → short: " + shortValue2);

        long longValue2 = 92523635483L;
        int intValue2 = (int) longValue2;
        System.out.println("long → int: " + intValue2);

        double doubleValue = 65787.3;
        int intValue3 = (int) doubleValue;
        System.out.println("double → int: " + intValue3);

        char charValue1 = 'q';
        int intValue4 = (int) charValue1;
        System.out.println("char → int: " + intValue4);

        int intValue5 = 266;
        char charValue2 = (char) intValue5;
        System.out.println("int → char: " + charValue2);
    }
}
