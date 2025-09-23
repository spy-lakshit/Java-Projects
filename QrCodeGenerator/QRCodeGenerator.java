import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class QRCodeGenerator {

    public static void generateQRCodeWithText(String data, String path, int size) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            // Generate QR code matrix
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, size, size);

            // Convert to BufferedImage
            BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            // Add text below
            int textHeight = 50; // space for text
            int width = qrImage.getWidth();
            int height = qrImage.getHeight() + textHeight;

            BufferedImage finalImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = finalImage.createGraphics();

            // White background
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);

            // Draw QR code
            g.drawImage(qrImage, 0, 0, null);

            // Draw text "SCAN ME"
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            FontMetrics fm = g.getFontMetrics();
            String text = "SCAN ME";
            int x = (width - fm.stringWidth(text)) / 2;
            int y = qrImage.getHeight() + ((textHeight - fm.getHeight()) / 2) + fm.getAscent();
            g.drawString(text, x, y);

            g.dispose();

            // Save final image
            File outputFile = new File(path);
            ImageIO.write(finalImage, "png", outputFile);

            System.out.println("✅ QR Code with text saved at: " + outputFile.getAbsolutePath());

        } catch (WriterException | IOException e) {
            System.out.println("⚠️ Error generating QR Code!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==== QR Code Generator ====");
        System.out.print("Enter text or URL: ");
        String data = sc.nextLine();

        System.out.print("Enter file name to save (e.g., qr.png): ");
        String fileName = sc.nextLine();

        // Generate with high resolution
        generateQRCodeWithText(data, fileName, 400);
        sc.close();
    }
}
