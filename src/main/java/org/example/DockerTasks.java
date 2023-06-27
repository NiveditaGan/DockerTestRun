package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class DockerTasks {

    @Test
    public void startFile() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.command");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,30);
        long stopnow = cal.getTimeInMillis();

        String file="output.txt";

        boolean flag = false;
        while(System.currentTimeMillis()<stopnow) {
            if(flag) break;
            BufferedReader reader = new BufferedReader(new FileReader((file)));
            String currentLine = reader.readLine();
            while (currentLine != null && !flag) {
                if (currentLine.contains("Registering the node to the hub")) {
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();
        }
        Thread.sleep(3000);

        Assert.assertTrue(flag);
        runtime.exec("cmd /c start scale.command");
    }

    @Test
    public void stopFile() throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerDown.command");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND,30);
        long stopnow = cal.getTimeInMillis();

        String file="output.txt";

        boolean flag = false;
        while(System.currentTimeMillis()<stopnow) {
            if(flag) break;
            BufferedReader reader = new BufferedReader(new FileReader((file)));
            String currentLine = reader.readLine();
            while (currentLine != null && !flag) {
                if (currentLine.contains("selenium hub exited")) {
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();
        }
        Thread.sleep(3000);

        Assert.assertTrue(flag);
        File fl = new File("output.txt");
        if(fl.delete()){
            System.out.println("File deleted successfully");
        }
    }
}
