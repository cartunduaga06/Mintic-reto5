package mintic.reto5;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import mintic.reto5.vista.ventana;

@SpringBootApplication

@ComponentScan("mintic.reto5")
public class DemoApplication {

    
    
    public static void main(String[] args) {     
        ventana interfaz = new ventana();
        interfaz.setVisible(true);
    }
	public static void runSpringServer(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
