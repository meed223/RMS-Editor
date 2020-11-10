package com.meed223.rms_editor.utils;

import java.io.FileWriter;
import java.io.IOException;

public class RmsWriter {

    public static void write(RMS map) {
        // Write out rms to a file
        try {
            FileWriter rmsWriter = new FileWriter("maps\\" + map.mapName + ".rms");
            rmsWriter.write(map.toString());
            rmsWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
