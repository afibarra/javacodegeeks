package com.javacodegeeks.examples;

//~--- JDK imports ------------------------------------------------------------

import java.net.URI;

import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger logger = Logger.getLogger("App");

    // ===========================================================
    // = Text files to exemplify MappedByteBuffer functionality ==
    // ===========================================================
    private static final String FILE = "raf.txt";

    // ========================================================================
    // = Utility function to get a file located in the classpath ==============
    // ========================================================================
    public URI getFileURI(String fileName) throws Exception {
        URI result = this.getClass().getClassLoader().getResource(fileName).toURI();

        return result;
    }

    public static void main(String[] args) {
        App app = new App();

        try {
            Path             path             = Paths.get(app.getFileURI(App.FILE));
            MappedByteBuffer mappedByteBuffer = null;

            // Gets a new channel for the file "raf.txt"
            // and maps its entire content into a byte buffer in READ_ONLY mode.
            try (FileChannel fileChannel = (FileChannel.open(path, EnumSet.of(StandardOpenOption.READ)))) {
                mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

                if (mappedByteBuffer != null) {
                    mappedByteBuffer = mappedByteBuffer.load();

                    if (mappedByteBuffer.isLoaded()) {
                        Charset        charset     = Charset.defaultCharset();
                        CharsetDecoder decoder     = charset.newDecoder();
                        CharBuffer     charBuffer  = decoder.decode(mappedByteBuffer);
                        String         fileContent = charBuffer.toString();

                        logger.info(fileContent);
                        mappedByteBuffer.clear();
                    }
                }
            } catch (CharacterCodingException cce) {
                logger.log(Level.SEVERE, cce.getMessage());
                cce.printStackTrace(System.err);
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
