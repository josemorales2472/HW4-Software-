import java.io.*;

public class Vehicle implements Serializable {
    String Make, Model, fw;
    Integer Year, Price, Mpg;
    Boolean FourW;

    //Default Constructor
    public Vehicle(){
        this.Make = "";
        this.Model = "";
        this.Price = 0;
        this.Mpg = 0;
        this.FourW = false;
    }





    //Constructor with Parameters
    public Vehicle(String Make, String Model, Integer Year, Integer Price, Integer Mpg, Boolean FourW){
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.Price = Price;
        this.Mpg = Mpg;
        this.FourW = FourW;
        if(FourW)
        {
            fw="Yes";
        }else{
            fw="No";
        }
    }

    //Getters
    public String getMake(){
        return Make;
    }
    public String getModel(){
        return Model;
    }
    public Integer getYear(){
        return Year;
    }
    public Integer getPrice(){
        return Price;
    }
    public Integer getMpg(){
        return Mpg;
    }
    public Boolean getFourW(){
        return FourW;
    }

    //Setter
    public void setVariables(String Mak, String Mod, Integer Ye, Integer Pric, Integer Mp, Boolean FW){
        Make = Mak;
        Model = Mod;
        Year = Ye;
        Price = Pric;
        Mpg = Mp;
        FourW = FW;
        if(FourW)
        {
            fw="Yes";
        }else{
            fw="No";
        }
    }

    //Printing function
    public String toString(){
        String newLine = System.getProperty("line.separator");
        return "Year of car: " + Year+ newLine+ "Make: "+ Make + newLine+ "Model: " + Model  + newLine + "Price: "+ Price + newLine +"MPG: " + Mpg+ newLine+"Four Wheel Drive?:  "+fw;
    }

}
