/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5.controlador;

import mintic.reto5.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 *
 * @author CARLOS
 */

@Repository
public interface DirectorRepo extends JpaRepository <Director, Integer> {
           List<Director> findByNombre(String nombre);
    }
    
