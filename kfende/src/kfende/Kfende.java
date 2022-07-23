/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kfende;

/**
 *
 * @author ardakc
 */
public class Kfende {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
             if(args[0].equals("-e")) {
            System.out.println(args[1]);
            java.io.File file = new java.io.File(args[1]);
            java.io.File file2 = new java.io.File(args[2]);
            if(file.exists()) {
               byte[] sap = java.nio.file.Files.readAllBytes(file.toPath());
               java.nio.file.Files.writeString(file2.toPath(), java.util.Base64.getEncoder().encodeToString(sap), java.nio.file.StandardOpenOption.CREATE);
               System.out.println(file2.toString());
               System.out.println("is done!");
             }
            else {
                System.out.println(file + " not exists!");
            }
        }
             else {
                 if(args[0].equals("-d")) {
                     java.io.File encodingfile = new java.io.File(args[1]);
                     if(encodingfile.exists()) {
                           String s = java.nio.file.Files.readString(encodingfile.toPath());
                           byte[] sap = java.util.Base64.getDecoder().decode(s);
                           java.io.File file = new java.io.File(args[2]);
                           java.nio.file.Files.write(file.toPath(), sap);
                           System.out.println(file);    
                           System.out.println("is done!");
                     }
                     else {
                          System.out.println(encodingfile + " not exists!");
                     }
                   
                 }
                 else {
                     System.out.println("KCS File Encoder Decoder CLI v1.0");
                     System.out.println("-e fileinput fileoutput");
                     System.out.println("-d fileinput fileoutput");
                     System.out.println("-e this command reads the file and base64 encodes the byte of the file and then prints the base64 code to the specified output file.");
                     System.out.println("-d Reads the text file containing the base64 code and decoding base64 code to the byte array and writing to the specified output path.");
                     System.out.println("-e command example: -e /home/user/file.jar /home/user/base64code.txt");
                     System.out.println("-d command example: -d /home/user/base64code.txt /home/user/filename.jar");
                }
             }
        } catch (Exception e) {
            System.out.println(e);
        }
       
    }
    
}
