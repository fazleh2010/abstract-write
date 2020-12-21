package citec.wikipedia.writer.main;

import citec.wikipedia.writer.analyzer.TextAnalyzer;
import citec.wikipedia.writer.table.DbpediaClass;
import citec.wikipedia.writer.constants.PropertyNotation;
import citec.wikipedia.writer.table.Tables;
import citec.wikipedia.writer.utils.FileFolderUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author elahi
 */
public class Main {

    private static String dbpediaDir = "src/main/resources/dbpedia/";
    private static String inputDir = dbpediaDir + "class-entity-files/input/";
    private static String[] classDirectoryStructure = new String[]{"rawFiles", "pattern", "tables/" + "result", "tables/" + "selectedWords"};

    public static void main(String[] args) throws Exception {
        String fileType = DbpediaClass.ALL;
        List<String> classFileNames = new ArrayList<String>();

        List<File> inputFiles = FileFolderUtils.getFiles(inputDir, ".txt");
        for (File inputFile : inputFiles) {
            String dbo_ClassName =PropertyNotation.dbo_Person+"_"+inputFile.getName().replace(".txt", "");
            String inputFileName = inputDir + inputFile.getName();
            System.out.println(inputFileName);
            String rawFiles = dbpediaDir + dbo_ClassName + "/" + "rawFiles/";
            makeClassDir(dbpediaDir + dbo_ClassName + "/");
            DbpediaClass dbpediaClass = new DbpediaClass(dbo_ClassName, inputFileName, rawFiles, TextAnalyzer.POS_TAGGER_WORDS, fileType);
        }
    }

    public static Boolean makeClassDir(String classDir) {
        try {
            Path path = Paths.get(classDir);
            Files.createDirectories(path);
            path = Paths.get(classDir + classDirectoryStructure[0]);
            Files.createDirectories(path);
            path = Paths.get(classDir + classDirectoryStructure[1]);
            Files.createDirectories(path);
            path = Paths.get(classDir + classDirectoryStructure[2]);
            Files.createDirectories(path);
            path = Paths.get(classDir + classDirectoryStructure[3]);
            Files.createDirectories(path);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
            return false;

        }
    }

}
