package com.sunny.enterprise.whole.global.handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sunny.enterprise.whole.global.beans.Project;
import com.sunny.enterprise.whole.global.beans.Projects;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class GradleSettingHandler {

    public boolean handle() throws IOException, URISyntaxException {
        Path path =getConfigPath("projects.json");

        Projects projects = getProjects(path);

        writeToSettings(projects);

        return true;
    }

    private void writeToSettings(Projects projects) throws IOException {
        FileWriter fw = new FileWriter(new File("./settings.gradle"));
        BufferedWriter bw = new BufferedWriter(fw);
        writeRootProject(bw,"global");
        IntStream.range(0,projects.getProjects().size()).forEach(i->System.out.println(i+")"+projects.getProjects().get(i).getName()));
        System.out.println("Select Project index");
        int index =  Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        Project project =projects.getProjects().get(index);
        System.out.println("Selected ==> "+project.getName());


                      if(null != project.getSubProjectNames() && !project.getSubProjectNames().isEmpty()) {
                          project.getSubProjectNames().stream().forEach(subModule -> {
                                  writesubModules(bw, subModule);
                          });
                      }

        bw.flush();
        bw.close();
        fw.close();
    }

    private Projects getProjects(Path path) throws IOException {
      //  String projectConfig = Files.readString(path);
        String projectConfig = String.join("",Files.readAllLines(path));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Projects projects  = gson.fromJson(projectConfig, Projects.class);
        return projects;
    }

    private Path  getConfigPath(String configFileName) throws URISyntaxException {
        URL url =this.getClass().getClassLoader().getResource(configFileName);
        return Paths.get( url.toURI());
    }
    private void writesubModules(BufferedWriter bw, String subModule)   {
          try {
              bw.write("include" + " '" + subModule + "'");
              bw.newLine();
          }catch (IOException exception)
          {
              exception.printStackTrace();
          }
    }
    private void writeRootProject(BufferedWriter bw, String root) throws IOException {
            bw.write("rootProject.name='"+root+"'");
            bw.newLine();
            bw.newLine();
            bw.newLine();
    }

}
