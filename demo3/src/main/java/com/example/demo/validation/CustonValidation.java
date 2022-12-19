package com.example.demo.validation;

import org.springframework.stereotype.Service;

@Service
public class CustonValidation {
 public boolean checNamelength(String firstName,String lastName , String emailid ){
     if(firstName.length() >3 && lastName.length() >3 && emailid.length() >3){
         return  true;
     }else {
         return false;
     }
 }
}
