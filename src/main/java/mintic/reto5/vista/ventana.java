/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mintic.reto5.vista;

/**
 *
 * @author CARLOS
 */

import javax.swing.JFrame;
import mintic.reto5.DemoApplication;
import mintic.reto5.controlador.DirectorRepo;
import java.util.Optional;
import mintic.reto5.Extractor;
import mintic.reto5.modelo.Director;

/**
 *
 * @author clases
 */
public class ventana extends JFrame {
    DirectorRepo repo;
    
    public ventana(){
        initComponents();
        String[] args = {};
        DemoApplication.runSpringServer(args);
        
        repo = Extractor.getBean(DirectorRepo.class);
    }


  private void initComponents() {       
     
        jButton1 = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        
        
        jTextField1 = new javax.swing.JTextField("Introduzca el ID");
        jTextField1.setBounds(100, 0, 200, 60);
          
        DirectorNombre = new javax.swing.JTextField("Nombre del director");
        DirectorNombre.setBounds(100, 0, 350, 300);
       
        
        jButton1.setBounds(100, 0, 100, 60);
        jButton1.setLocation(250, 150);
        
        guardar.setBounds(100, 0, 150, 60);
        guardar.setLocation(200, 500);
        jLabel1 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Buscar");
        
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLabel1.setText("Buscar cliente");
        this.setSize(500, 500);
        this.setLocation(100, 150);
        this.add(jButton1);
        this.add(jTextField1);
        this.add(DirectorNombre);
        
        
        }
  
  private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }  
  
  
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) { 
        
        Integer id = Integer.parseInt(jTextField1.getText());
        Optional<Director> result = repo.findById(id);
        Director uno;
        if(result.isPresent()){
            uno = result.get();
            System.out.println("Funciona por !!" + uno.getNombre());
           DirectorNombre.setText(uno.getNombre());
        }
        
    }     
  
  
    private javax.swing.JButton jButton1;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField DirectorNombre;
  
   
    }
 