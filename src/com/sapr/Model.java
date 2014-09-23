package com.sapr;

import java.io.*;

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
    }
}
