package samplejavathread_filedownload;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;



public class Main {

    public static void main(String[] args) throws IOException {
        String[] urls = {
            "https://example.com/file1.zip",
            "https://example.com/file2.zip",
            "https://example.com/file3.zip"
        };

        // Buat panel untuk menampung progress bar
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(urls.length, 1));

        for (String url : urls) {
            String fileName = url.substring(url.lastIndexOf('/') + 1);
            JProgressBar progressBar = new JProgressBar(0, 100);

            DownloadThread thread = new DownloadThread(url, fileName, progressBar);
            thread.start();

            // Tambahkan progress bar ke panel
            panel.add(progressBar);
        }

        // Tampilkan panel progress bar
        JFrame frame = new JFrame("Downloading Files");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
