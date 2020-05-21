/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.TransmilenioApp.model;

/**
 *
 * @author david
 */
 public class Transmilenio {

    public Transmilenio(String IDBus, String Longitud, String Latitud) {
        this.IDBus = IDBus;
        this.Longitud = Longitud;
        this.Latitud = Latitud;
    }

    private String IDBus;
    private String Longitud;
    private String Latitud;

    public Transmilenio() {
    }
    
    

    public String getIDBus() {
        return IDBus;
    }

    public void setIDBus(String IDBus) {
        this.IDBus = IDBus;
    }

    public String getLongitud() {
        return Longitud;
    }

    public void setLongitud(String Longitud) {
        this.Longitud = Longitud;
    }

    public String getLatitud() {
        return Latitud;
    }

    public void setLatitud(String Latitud) {
        this.Latitud = Latitud;
    }
    

}
