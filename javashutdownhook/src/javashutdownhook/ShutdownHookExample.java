package javashutdownhook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ShutdownHookExample {

    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("data.txt")) {
            fos.write("Data ini akan disimpan ke disk sebelum aplikasi ditutup.".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Runnable() {
            @Override
            public void run() {
                System.out.println("Koneksi database ditutup.");
                try {
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password").close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
