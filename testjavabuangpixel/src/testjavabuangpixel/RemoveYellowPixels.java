package testjavabuangpixel;

public class RemoveYellowPixels {

    public static void main(String[] args) {
        // Mendefinisikan nilai warna RGB untuk pixel kuning
        int yellowRed = 255;
        int yellowGreen = 255;
        int yellowBlue = 0;

        // Mendefinisikan nilai warna RGB untuk pixel lain
        int otherRed = 0;
        int otherGreen = 0;
        int otherBlue = 0;

        // Membaca nilai warna dari gambar
        int[][] image = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                image[i][j] = readRGBColor(i, j);
            }
        }

        // Memproses image
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Memeriksa apakah pixel kuning
                if (isYellowPixel(image[i][j], yellowRed, yellowGreen, yellowBlue)) {
                    // Mengubah pixel kuning menjadi hitam
                    image[i][j] = setRGBColor(otherRed, otherGreen, otherBlue);
                }
            }
        }

        // Menampilkan image yang telah diproses
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                printRGBColor(image[i][j]);
            }
            System.out.println();
        }
    }

    // Membaca nilai warna RGB dari pixel
    private static int readRGBColor(int row, int col) {
        // Implementasi untuk membaca nilai warna RGB dari pixel
        // (Gunakan metode yang sesuai dengan format gambar)
        return 0;
    }

    // Memeriksa apakah pixel kuning
    private static boolean isYellowPixel(int rgbColor, int yellowRed, int yellowGreen, int yellowBlue) {
        int red = (rgbColor >> 16) & 0xFF;
        int green = (rgbColor >> 8) & 0xFF;
        int blue = rgbColor & 0xFF;

        return red == yellowRed && green == yellowGreen && blue == yellowBlue;
    }

    // Mengubah nilai RGB menjadi warna
    private static int setRGBColor(int red, int green, int blue) {
        return (red << 16) | (green << 8) | blue;
    }

    // Menampilkan nilai warna RGB
    private static void printRGBColor(int rgbColor) {
        int red = (rgbColor >> 16) & 0xFF;
        int green = (rgbColor >> 8) & 0xFF;
        int blue = rgbColor & 0xFF;

        System.out.printf("%3d, %3d, %3d ", red, green, blue);
    }
}
