import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class passwordGenerator {
    public static final String HURUFBESAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String HURUFKECIL = "abcdefghijklmnopqrstuvwxyz";
    public static final String SIMBOL = "~!@#$%^&*()_-=+{}[]?,<.>;:'";
    public static final String ANGKA = "0123456789";
    public static final String CAMPURAN = HURUFBESAR + HURUFKECIL + SIMBOL + ANGKA;
    private static SecureRandom random = new SecureRandom();

    public static String generatePassword(int length, String namaPengguna) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(CAMPURAN.length());
            sb.append(CAMPURAN.charAt(number));
        }
        fileWriter(sb.toString(), namaPengguna);
        return sb.toString();
    }

    public static void fileWriter(String password, String namaPengguna) {
        String path = System.getProperty("user.home") + "\\Documents\\password.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
            writer.write("Nama: " + namaPengguna);
            writer.newLine();
            writer.write("Password: " + password);
            writer.newLine();
            writer.write("-----------------------");
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing file");
            e.printStackTrace();
        }
    }
}
