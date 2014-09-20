package com.javacodegeeks.examples.messagedigest;

//~--- JDK imports ------------------------------------------------------------

import java.math.BigInteger;

import java.net.URI;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.security.MessageDigest;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger("App");

    // ========================================================================
    // = Text files to exemplify MessageDigest functionality ==================
    // ========================================================================
    private static final String FILE1 = "file1ToHash.txt";
    private static final String FILE2 = "file2ToHash.txt";
    private static final String FILE3 = "file3ToHash.txt";

    // ========================================================================
    // = Some of the Cryptographic Hash Functions supported by MessageDigest ==
    // = You can choose any of them for this example                         ==
    // ========================================================================
    private static final String MD5    = "MD5";
    private static final String SHA1   = "SHA-1";
    private static final String SHA256 = "SHA-256";

    // ========================================================================
    // = Utility function to get a file located in the classpath ==============
    // ========================================================================
    public URI getFileURI(String fileName) throws Exception {
        URI result = this.getClass().getClassLoader().getResource(fileName).toURI();

        return result;
    }

    public static void main(String[] args) {
        try {
            App app = new App();

            // Instance a MessageDigest
            MessageDigest messageDigest = MessageDigest.getInstance(App.MD5);

            // Files to be cryptographically hashed and compared
            Path   path1      = Paths.get(app.getFileURI(App.FILE1));
            byte[] file1Bytes = Files.readAllBytes(path1);
            Path   path2      = Paths.get(app.getFileURI(App.FILE2));
            byte[] file2Bytes = Files.readAllBytes(path2);
            Path   path3      = Paths.get(app.getFileURI(App.FILE3));
            byte[] file3Bytes = Files.readAllBytes(path3);

            // Digest files content
            byte[] digestedFile1Bytes = messageDigest.digest(file1Bytes);

            messageDigest.reset();

            byte[] digestedFile2Bytes = messageDigest.digest(file2Bytes);

            // The content of both files is EXACTLY the same
            // We can see that the generated hash, is IDENTICAL for both files
            logger.info("Byte representation of File1 content: "
                        + (new BigInteger(1, digestedFile1Bytes)).toString(32));
            logger.info("Byte representation of File2 content: "
                        + (new BigInteger(1, digestedFile2Bytes)).toString(32));
            logger.info(MessageDigest.isEqual(digestedFile1Bytes, digestedFile2Bytes)
                        ? "Identical hashes"
                        : "Different hashes");

            // The content of FILE3 is EXACTLY the same as in FILE1 and FILE2
            // with just and extra 'A' appended at the very end
            // We can see that this is enough to have a total different hash
            messageDigest.reset();

            byte[] digestedFile3Bytes = messageDigest.digest(file3Bytes);

            logger.info("Byte representation of File3 content: "
                        + (new BigInteger(1, digestedFile3Bytes)).toString(32));
            logger.info(MessageDigest.isEqual(digestedFile1Bytes, digestedFile3Bytes)
                        ? "Identical hashes"
                        : "Different hashes");
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
