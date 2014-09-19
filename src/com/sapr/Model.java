package com.sapr;

import javax.swing.*;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Григорий on 18.09.2014.
 */
public class Model {
    public String name;
    public int numDetails;
    public Detail [] details;

    Model(String fileName) throws IOException {
        File file = new File( fileName );

        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream( file )
                    )
            );
            String line = null;
            if((line = br.readLine()) != null) {
                this.name = line;
            }

            if((line = br.readLine()) != null) {
                this.numDetails = Integer.parseInt(line);
            }

            details = new Detail[numDetails];
            for(int i = 0; i < numDetails; i++) {
                if((line = br.readLine()) != null) {
                    this.details[i] = new Detail();
                    this.details[i].name = line;
                }
            }

            for(int i = 0; i < numDetails; i++) {
                if ((line = br.readLine()) != null) {
                    this.details[i].numPoints = Integer.parseInt(line);
                    this.details[i].x = new int[details[i].numPoints];
                    this.details[i].y = new int[details[i].numPoints];
                }
            }

            for(int i = 0; i < numDetails; i++) {
                for(int j = 0; j < details[i].numPoints; j++) {
                    if((line = br.readLine()) != null) {
                        details[i].x[j] = Integer.parseInt(line.split(" ")[0]);
                        details[i].y[j] = Integer.parseInt(line.split(" ")[1]);
                    }
                }
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*//Этот спец. объект для построения строки
        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);

       // exists(fileName);

        try {
            //Объект для чтения файла в буфер
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //В цикле построчно считываем файл
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Также не забываем закрыть файл
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }*/

       /* Scanner scanner1 = null;
        try {
            scanner1 = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner1.useLocale(Locale.US);

        String [] s;
        while (scanner1.hasNextLine()) {
            s = scanner1.nextLine().split(" ");
        }*/

        //todo: запилить перехват ошибок
        /*this.name = scanner1.nextLine();
        this.numDetails = Integer.parseInt(scanner1.nextLine());
        //this.numDetails = scanner1.nextInt();

        details = new Detail[numDetails];

        for(int i = 0; i < numDetails; i++) {
            details[i] = new Detail();
            details[i].name = scanner1.nextLine();
        }

        for(int j = 0; j < numDetails; j++) {
            details[j].numPoints = Integer.parseInt(scanner1.nextLine());
        }*/



       // scanner1.close();
    }
}
