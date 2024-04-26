package samplejavathread_filedownload;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JProgressBar;

public class DownloadThread extends Thread {

    private String url;
    private String fileName;
    private JProgressBar progressBar; // Menambahkan progress bar

    public DownloadThread(String url, String fileName, JProgressBar progressBar) {
        this.url = url;
        this.fileName = fileName;
        this.progressBar = progressBar; // Inisialisasi progress bar
    }

    @Override
    public void run() {
        try {
            URL downloadURL = new URL(url);
            URLConnection connection = downloadURL.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0"); // Menambahkan user agent

            int contentLength = connection.getContentLength(); // Mendapatkan ukuran file
            if (contentLength > 0) {
                progressBar.setMaximum(contentLength); // Set nilai maksimum progress bar
            }

            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
                progressBar.setValue((int) totalBytesRead); // Update nilai progress bar
            }

            inputStream.close();
            outputStream.close();

            System.out.println("File " + fileName + " downloaded successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
