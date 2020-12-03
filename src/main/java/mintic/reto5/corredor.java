/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5;

/**
 *
 * @author CARLOS
 */


import java.util.List;
import java.util.Optional;
import mintic.reto5.controlador.DirectorRepo;
import mintic.reto5.modelo.Director;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import mintic.reto5.controlador.*;




@Component
public class corredor implements CommandLineRunner {

    @Autowired
    DirectorRepo repo;

    @Override
    public void run(String... args) throws Exception {
        
        
        Director prueba = new Director();
        prueba.setId(240);
        prueba.setNombre("carlos");
        prueba.setApellido("artunduaga");
        prueba.setNacionalidad("Colombiano");
        repo.save(prueba);

        
        System.out.println("Cantidad: hasta ahora..." + repo.count());
       
    }
}


