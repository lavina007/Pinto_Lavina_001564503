/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Person;

/**
 *
 * @author Lavina
 */
public class PersonValidation {
    static boolean isError = false;
    
    public static StringBuilder personFieldValidation(Person p){

      StringBuilder message = new StringBuilder();
      
      
      
      if(checkIfFieldNotPresent(p.getName())){
          System.out.println(p.getName());
          message.append("Please Enter Name\n");
          isError = true;
      }
      
      if(checkIfFieldNotPresent(p.getAddr())){
          message.append("Please Enter Address\n");
          isError = true;
      }
      
      if(checkIfFieldNotPresent(p.getDateOfBirth())){
          message.append("Please Enter Date Of Birth\n");
          isError = true;
      }else{
          validateDateOfBirth(p.getDateOfBirth());
      }
      
      if(checkIfFieldNotPresent(p.getPhone1())){
          message.append("Please enter Phone number\n");
          isError = true;
      }else{
          message.append(validatePhoneNo(p.getPhone1(),10));
      }
      if(checkIfFieldNotPresent(p.getFaxNo())){
          message.append("Please Enter Fax Number\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getEmailId1())){
          message.append("Please Enter EmailId\n");
          isError = true;
      }else{
          message.append(validateEmailID(p.getEmailId1()));
      }
      if(checkIfFieldNotPresent(p.getSsnNo())){
          message.append("Please Enter SSN No\n");
          isError = true;
      }else{
          //message.append(validateSSN(p.getSsnNo()));
      }
      if(checkIfFieldNotPresent(p.getMedicalRecordNo())){
          message.append("Please Enter Medical Record Number\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getHealthBenNo())){
          message.append("Please Enter Health Plan Beneficiary Number\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getBankAccNo1())){
          message.append("Please Enter Bank Account Number\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getLicenseNo())){
          message.append("Please Enter Driving License Number\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getLinkedIn())){
          message.append("Please Enter LinkedIn Profile\n");
          isError = true;
      }
      if(checkIfFieldNotPresent(p.getIpAddr())){
          message.append("Please Enter IP Address\n");
          isError = true;
      }else{
          message.append(validateIpAddress(p.getIpAddr()));
      }
      if(isError){
        return message;  
      }else{
         return new StringBuilder("Details for " +p.getName()+ " have been added successfully ");
      }
    }

    private static boolean checkIfFieldNotPresent(String field){
        return field.isEmpty();         
    }
    
    private static String validatePhoneNo(String phoneNo, int length){
    String regex = "^([0-9]{"+length+"})$";
        Pattern p = Pattern.compile(regex);
   
        Matcher m = p.matcher(phoneNo);
        boolean result = m.matches();
        if(result){
            return "";
        }else
        {
            isError = true;
            return "Please enter a valid phone number\n";
        }
}
    
    private static String validateDateOfBirth(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        try{
            formatter.parse(date);
            return "";
        }catch(Exception e){
            isError = true;
           return "Please enter a valid date in the dd/mm/yyyy format\n";
        }
    }
    
    private static String validateEmailID(String email){
        final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        boolean result = EMAIL_REGEX.matcher(email).matches();
        if(result){
            return "";
        }else{
            isError = true;
            return "Please enter a valid email ID\n";
        }

    }
    
    private static String validateIpAddress(String ip){
        String regex = "\\b((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)(\\.|$)){4}\\b";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(ip);
        boolean result = m.matches();
        if(result){
            return "";
        }else{
            isError = true;
            return "Please enter a valid IP Address\n";
        }
    }
    
    private static String validateSSN(String ssn){
       String regex = "^(?!666|000|9\\d{2})\\d{3}"
                       + "-(?!00)\\d{2}-"
                       +"(?!0{4})\\d{4}$";
       Pattern p = Pattern.compile(regex);
       Matcher m = p.matcher(ssn);
        boolean result = m.matches();
        if(result){
            return "";
        }else{
            isError = true;
            return "Please enter a valid SSN number\n";
        }

    }

}
    
