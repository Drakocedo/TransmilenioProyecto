/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arep.TransmilenioApp.controllers;

import edu.eci.arep.TransmilenioApp.model.Transmilenio;
import edu.eci.arep.TransmilenioApp.services.DBServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author david
 */
@RestController
@RequestMapping(value = "/TransmilenioBuses")
public class TransmiAPIController {

    @Autowired
    DBServices Services;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> manejadorGetRecursoBlueprint() {
        List<Transmilenio> data = null;
        try{
            data = Services.GetAllCases();
        }catch (Exception ex){
            return new ResponseEntity<>("ERROR 500",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
    }
    
}