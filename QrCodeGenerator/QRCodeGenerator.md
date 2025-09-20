# QR Code Generator (Java)

This is a simple **console-based QR Code Generator** implemented in **Java** using the **ZXing library**.  
It allows you to generate a QR code for any text or URL and save it as a PNG image.

---

## Features
- Generate QR codes for text or URLs.
- Save QR codes as PNG files.
- Simple console-based menu.

---

## Technologies Used
- Java (Core Java)
- ZXing (`core-3.5.2.jar` and `javase-3.5.2.jar`)

---

## Project Structure
QRCodeProject/
├── QRCodeGenerator.java # Main Java file
├── core-3.5.2.jar # ZXing core library
├── javase-3.5.2.jar # ZXing Java SE library
├── README.md # Project documentation


---

## How to Run

1. Make sure you have **Java installed** on your system.  
2. Download both ZXing libraries and place them in the same folder as your Java file:
   - [core-3.5.2.jar](https://repo1.maven.org/maven2/com/google/zxing/core/3.5.2/core-3.5.2.jar)  
   - [javase-3.5.2.jar](https://repo1.maven.org/maven2/com/google/zxing/javase/3.5.2/javase-3.5.2.jar)  
3. Open terminal or PowerShell in the project folder.
4. Compile the Java file:
   ```bash
   javac -cp ".;core-3.5.2.jar;javase-3.5.2.jar" QRCodeGenerator.java


==== QR Code Generator ====
Enter text or URL: https://example.com
Enter file name to save (e.g., qr.png): myqr.png
