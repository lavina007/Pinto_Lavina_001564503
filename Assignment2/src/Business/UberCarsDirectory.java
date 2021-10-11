/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author Lavina
 */
public class UberCarsDirectory {
    private ArrayList <UberCars> uberCarsDirectory;
    private ArrayList <UberCars> tempCarsDirectory; 
    private ArrayList <UberCars> temp1CarsDirectory; 

    public UberCarsDirectory() {
        this.uberCarsDirectory = new ArrayList<>();
        populateArrayList();
    }

    public ArrayList<UberCars> getUberCarsDirectory() {
        return uberCarsDirectory;
    }
    
    public ArrayList<UberCars> getUberCarsDirectory( ArrayList<UberCars> tempCarsDirectory) {
        return tempCarsDirectory;
    }

    public void setUberCarsDirectory(ArrayList<UberCars> uberCarsDirectory) {
        this.uberCarsDirectory = uberCarsDirectory;
    }
    
    private void populateArrayList(){
        Year yr = Year.of(2010);
        Year yr1 = Year.of(2012);
        LocalDateTime dt = LocalDateTime.now();
        UberCars ub1 = new UberCars("Cayenne","SX12","1234","Porsche",true,"Boston",yr,4,true,dt,dt);
        UberCars ub2 = new UberCars("P","SX1","12345","Porsche",false,"California",yr1,5,true,dt,dt);
        UberCars ub3 = new UberCars("Accord","X12","14","Honda",true,"Boston",yr,7,false,dt,dt);
        UberCars ub4 = new UberCars("Def","S2","122","Abc",false,"New York",yr1,2,false,dt,dt);
        UberCars ub5 = new UberCars("Turbo","KJ12","34","Lambo",true,"Boston",yr1,6,true,dt,dt);
        UberCars ub6 = new UberCars("Pac","FG12","1334","GMC",false,"Seatle",yr1,3,true,dt,dt);
        UberCars ub7 = new UberCars("City","AS12","354","Honda",true,"Texas",yr,4,false,dt,dt);
        UberCars ub8 = new UberCars("Suzuki","qw12","9734","SDC",false,"California",yr,6,false,dt,dt);
        uberCarsDirectory.add(ub1);
        uberCarsDirectory.add(ub2); 
        uberCarsDirectory.add(ub3);
        uberCarsDirectory.add(ub4);
        uberCarsDirectory.add(ub5);
        uberCarsDirectory.add(ub6); 
        uberCarsDirectory.add(ub7);
        uberCarsDirectory.add(ub8);
         
    }
    public UberCars addCars(){
        UberCars uberCars = new UberCars();
        uberCarsDirectory.add(uberCars);
        return uberCars;
    }
    
    public void deleteCars(UberCars uberCars){
         uberCarsDirectory.remove(uberCars);
    }
    
    public UberCars searchbySerial (String serialNumber){
        for(UberCars uberCars: uberCarsDirectory){
            if(uberCars.getSerialNumber().equals(serialNumber)){
                return uberCars;
            }
        }
        return null;
    }
    
    public UberCars searchByModel (String modelNumber){
        for(UberCars uberCars: uberCarsDirectory){
            if(uberCars.getModelNumber().equals(modelNumber)){
                return uberCars;
            }
        }
        return null;
    }
    
    public ArrayList<UberCars> searchCars(String manu1, String year, String minSeats, String maxSeats, String modelName, String city){
        tempCarsDirectory = new ArrayList<UberCars>(uberCarsDirectory);
        temp1CarsDirectory = new ArrayList<UberCars>();
        
        if (!manu1.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (! (uberCars.getManufacturer().equals(manu1))){
                temp1CarsDirectory.add(uberCars);
                }    
            }
        }
       
        if (!minSeats.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (uberCars.getSeats() < Integer.parseInt(String.valueOf(minSeats))){
                temp1CarsDirectory.add(uberCars);
                }    
            }
        }
        if (!maxSeats.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (uberCars.getSeats() > Integer.parseInt(String.valueOf(maxSeats))){
                temp1CarsDirectory.add(uberCars);
                }    
            }
        }
        if (!year.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (! (uberCars.getManufacturingYear().equals(Year.parse(year)))){
                temp1CarsDirectory.add(uberCars);
                }    
            }
        }
        if (!modelName.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (! (uberCars.getModelName().equals(modelName))){
                temp1CarsDirectory.add(uberCars);
                }
            }
        }
        if (!city.isEmpty()){
            for (UberCars uberCars: tempCarsDirectory){
                if (! (uberCars.getCity().equals(city))){
                temp1CarsDirectory.add(uberCars);
                }
            }
        }
        tempCarsDirectory.removeAll(temp1CarsDirectory);
        return tempCarsDirectory;
    }
     
}
