
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.io.*;
import java.io.Serializable;
import java.nio.file.Path;

public class URLReader implements Serializable{
    public static void main(String[] args) throws Exception {

        //Creating URL object
        URL oracle = new URL("https://raw.githubusercontent.com/kyungsooim/TestData/master/data/SeptemberInventory.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        //Variables

        String inputLine;
        String[] cars= new String[9];
        Integer i=0;
        Vehicle[] car = new Vehicle[10];



        //Filling the string array with information
       while ((inputLine = in.readLine()) != null) {
           //Filling variables
           cars[i]=inputLine;
           String[] split = cars[0].split(",");
           String[] nameMake= split[0].split(" ");
           Integer year= Integer.valueOf(split[1]); //to get the cars year
           Integer price= Integer.valueOf(split[2]);// to get the cars price
           boolean fourW= Boolean.valueOf(split[3]);//to get if the car is four wheel drive or not
           if(!fourW){
               fourW=false;
           }
           //enter values into car object.
           car[i] = new Vehicle(nameMake[0], nameMake[1], year, price, 0, fourW);
           //increment counter
           i++;
       }
        in.close();

        //Serialization
        File file = FileUtils.getFile("./", "car.obj");
        byte [] data= SerializationUtils.serialize(car);
        try{
            FileUtils.writeByteArrayToFile(file, data);
        } catch (IOException e){
            e.printStackTrace();
        }

        //Deserialization
        File file2 = FileUtils.getFile("./", "car.obj");
        byte[] dataToDeserialize= null;
        try{
            dataToDeserialize= FileUtils.readFileToByteArray(file2);
        } catch (IOException e){
            e.printStackTrace();
        }

        Vehicle deserializedVe = SerializationUtils.deserialize(dataToDeserialize);










    }
}