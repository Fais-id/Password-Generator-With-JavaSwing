import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class passwordGeneratorGUI extends JFrame {
    private passwordGenerator passwordGenerator;

    public passwordGeneratorGUI() {
        super("Password Generator"); //judul
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fitur menutup jendela
        setSize(540, 460); //ukuran jendela
        setLocationRelativeTo(null); //posisi center
        setLayout(null);
        passwordGenerator = new passwordGenerator();
        addGuiComponents();
    }
    private void addGuiComponents() {
        JLabel title = new JLabel("Password Generator");
        title.setFont(new Font("Dialog", Font.BOLD, 32));
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 10, 540, 39);
        add(title);

        //Add area untuk menapilkan password
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Dialog", Font.BOLD, 32));

        //add scroll jika password terlalu panjang
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(25, 97, 479, 70);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(scrollPane);

        //add tulisan nama pengguna
        JLabel namaPengguna = new JLabel("Nama pengguna: ");
        namaPengguna.setFont(new Font("Dialog", Font.PLAIN, 32));
        namaPengguna.setBounds(25,200, 280, 39);
        add(namaPengguna);

        //add kolom mengisi nama pengguna
        JTextArea areaNamaPengguna = new JTextArea();
        areaNamaPengguna.setEditable(true);
        areaNamaPengguna.setFont(new Font("Dialog", Font.PLAIN, 32));
        areaNamaPengguna.setBounds(300, 202, 210, 39);
        areaNamaPengguna.setBorder(BorderFactory.createLineBorder(Color.black));
        add(areaNamaPengguna);

        //add tulisan panjang password
        JLabel passwordLengthLabel = new JLabel("Panjang password: ");
        passwordLengthLabel.setFont(new Font("Dialog", Font.PLAIN, 32));
        passwordLengthLabel.setBounds(25,247, 280, 39);
        add(passwordLengthLabel);

        //add area untuk mengisi panjang password
        JTextArea areaPassword = new JTextArea();
        areaPassword.setEditable(true);
        areaPassword.setFont(new Font("Dialog", Font.PLAIN, 32));
        areaPassword.setBounds(300, 248, 210, 39);
        areaPassword.setBorder(BorderFactory.createLineBorder(Color.black));
        add(areaPassword);

        //add teks untuk memberitahu di mana file di simpan
        JLabel path = new JLabel("Password tersimpan di folder documents :) ");
        path.setFont(new Font("Dialog", Font.PLAIN, 20));
        path.setBounds(25,290, 400, 39);
        add(path);

        //add tombol untuk menggenerate password
        JButton generateButton = new JButton("Generate Password");
        generateButton.setFont(new Font("Dialog", Font.BOLD, 32));
        generateButton.setBounds(60,350, 400, 39);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areaPassword.getText().length() <= 0) {
                    JOptionPane.showMessageDialog(null, "Masukkan panjang password!");
                    return;
                }
                if (areaNamaPengguna.getText().length() <= 0) {
                    JOptionPane.showMessageDialog(null, "Masukkan nama pengguna!");
                    return;
                }
                try {
                    int passwordLength = Integer.parseInt(areaPassword.getText());
                    String namaPengguna = areaNamaPengguna.getText();

                    // Panggil generatePassword dengan nama pengguna
                    String password = passwordGenerator.generatePassword(passwordLength, namaPengguna);
                    textArea.setText(password);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Panjang password harus angka!");
                }
            }
        });
        add(generateButton);
    }
}
