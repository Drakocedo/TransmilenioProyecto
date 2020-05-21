/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.TransmilenioApp.services;
//import com.mashape.unirest.http.JsonNode;

//import org.json.JSONObject;
//import java.net.*;

import edu.eci.arep.TransmilenioApp.model.Transmilenio;
import java.io.IOException;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;


/**
 *
 * @author Santiago
 */

@Service("DBServices")
public class DBServices implements ConexionService  {
/*
    //public void ConnectionRequest(){
    public static void main(String[] args) throws IOException {

        URL API = new URL("https://ov579n94z2.execute-api.us-east-1.amazonaws.com/Beta");

        URLConnection con = API.openConnection();

        String result = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        System.err.println("Conectado");
        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String line;

        while ((line = in.readLine()) != null) {
            result = result + line;

        }
        List<Transmilenio> lista = new ArrayList<Transmilenio>();
        String[][] Segunda;
        result = result.substring(2, result.length() - 2);
        char c = ',';
        char d = ':';
        String[] cars = result.split(" ");

        for (int i = 0; i < cars.length ; i++) {
            if (i == cars.length - 1) {
               
                cars[i] = cars[i].substring(1, cars[i].length() - 1);
            } else {

                cars[i] = cars[i].substring(1, cars[i].length() - 2);
            }    
                String[] segunda = cars[i].split(",");
                String pri = "";
                String sec = "";
                String ter = "";

                for (int j = 0; j < segunda.length; j++) {
                    String[] tercera = segunda[j].split(":");
                    if (j == 0) {
                        pri = tercera[1];
                    } else if (j == 1) {
                        sec = tercera[1];
                    } else {
                        ter = tercera[1];
                    }

                }
                lista.add(new Transmilenio(pri, sec, ter));
            

        }
/*
        System.out.println(lista.get(7).getIDBus());
        System.out.println(lista.get(7).getLatitud());
        System.out.println(lista.get(7).getLongitud());
        System.out.println(result);
        
        

    }
*/
    @Override
    public List<Transmilenio> GetAllCases() {
        
        
         List<Transmilenio> lista = new ArrayList<Transmilenio>();   
        
        try {
            
            
            
            
            URL API = null;
           
                API = new URL("https://ov579n94z2.execute-api.us-east-1.amazonaws.com/Beta");
           
            
            URLConnection con = null;
            
                con = API.openConnection();
           
            
            String result = "";
            BufferedReader in = null;
           
            in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            
            
            System.err.println("Conectado");
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String line;
            
            while ((line = in.readLine()) != null) {
                result = result + line;
                
            }
            
            String[][] Segunda;
            result = result.substring(2, result.length() - 2);
            char c = ',';
            char d = ':';
            String[] cars = result.split(" ");
            
            for (int i = 0; i < cars.length ; i++) {
                if (i == cars.length - 1) {    
                    
                    cars[i] = cars[i].substring(1, cars[i].length() - 1);
                } else {
                    
                    cars[i] = cars[i].substring(1, cars[i].length() - 2);
                }
                String[] segunda = cars[i].split(",");
                String pri = "";
                String sec = "";
                String ter = "";

                for (int j = 0; j < segunda.length; j++) {
                    String[] tercera = segunda[j].split(":");
                    if (j == 0) {
                        pri = tercera[1];
                    } else if (j == 1) {
                        sec = tercera[1];
                    } else {
                        ter = tercera[1];
                    }

                }
                lista.add(new Transmilenio(pri, sec, ter));
                
                
            }
            
         
            
            in.close();
            
            
        } catch (IOException ex) {
            Logger.getLogger(DBServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
   
}
