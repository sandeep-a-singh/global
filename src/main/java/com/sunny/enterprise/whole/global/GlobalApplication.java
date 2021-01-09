package com.sunny.enterprise.whole.global;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunny.enterprise.whole.global.handler.GradleSettingHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {


        //testSettings();

        GradleSettingHandler handler =new GradleSettingHandler();
        handler.handle();

    }

    private static void testSettings() throws IOException {
        File file =    getRootFile("settings.gradle");

        System.out.println(file.getAbsolutePath());

        List<String> data = Files.readAllLines(Paths.get( file.getAbsolutePath()));
        List<String> projectList = data.stream().filter(line->line.startsWith("def currProj =")).collect(Collectors.toList());


      /*  try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("dadad");
            bw.newLine();
        }
        projectList.stream().forEach(System.out::println);
        */
        new GlobalApplication().printPath();
    }

    public static File  getRootFile(String fileName)
   {
     File currentDirFile = new File("./"+fileName);
     return new File(fileName);
   }

   public  void printPath()
   {
       URL url = this.getClass().getClassLoader().getResource("projects.json");
   }

}
