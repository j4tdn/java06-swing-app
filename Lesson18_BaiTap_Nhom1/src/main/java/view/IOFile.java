/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phanv
 */
public class IOFile {

    public static boolean updateFile(String directory, String... data) {
        List<String> lines = new ArrayList<>();
        File file = new File(directory);
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        String line = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for (String str : lines) {
                bw.write(str);
                bw.newLine();
            }
            bw.write("Tran dau " + lines.size() + ":" + data[0] + " vs " + data[1] + " vs " + data[2]);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        {
            try {
                bw.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
