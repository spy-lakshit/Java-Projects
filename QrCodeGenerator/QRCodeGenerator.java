import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class QRCodeGenerator {

    public static void generateQRCode(String data, String path, int width, int height) {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
            Path filePath = FileSystems.getDefault().getPath(path);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", filePath);
            System.out.println("✅ QR Code generated at: " + path);
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

        generateQRCode(data, fileName, 300, 300);
        sc.close();
    }
}
