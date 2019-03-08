package utils;

public class TString {
    public static boolean isEqual(String v1, String v2) {
        return v1.toLowerCase().equals(v2.toLowerCase());
    }
    public static boolean contains(String v1, String v2) {
        return v1.toLowerCase().contains(v2.toLowerCase());
    }
}
