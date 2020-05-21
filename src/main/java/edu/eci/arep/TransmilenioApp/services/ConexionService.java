/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.TransmilenioApp.services;

import edu.eci.arep.TransmilenioApp.model.Transmilenio;
import java.util.List;

/**
 *
 * @author david
 */
interface ConexionService {
    
    public List<Transmilenio> GetAllCases() ; 
}
