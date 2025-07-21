import java.security.SecureRandom;

public class passwordGenerator {
    public static final String HURUFBESAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String HURUFKECIL = "abcdefghijklmnopqrstuvwxyz";
    public static final String SIMBOL = "~!@#$%^&*()_-=+{}[]?,<.>;:'";
    public static final String ANGKA = "0123456789";

    public static final String CAMPURAN = HURUFBESAR + HURUFKECIL + SIMBOL + ANGKA;

    private static SecureRandom random = new SecureRandom();

    public static String generatePassword(int length) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(CAMPURAN.length());
            sb.append(CAMPURAN.charAt(number));
        }
        return sb.toString();
    }
}
