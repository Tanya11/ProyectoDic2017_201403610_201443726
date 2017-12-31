/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edd.proyectodiciembre;



/**
 *
 * @author Usuario
 */
public class EDDProyectoDiciembre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       //Tag raiz = JespXML.leerXML(new File("prueba.xml"));
        
        
        Login log = new Login();
        log.setVisible(true);
        Principal prin = new Principal();
        prin.setVisible(true);
    }
    
}
