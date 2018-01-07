package ProyectoDic2017;

import Interfaz.Login;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Main {
    
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Look and feel setting code">
        try {
            javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
            Login log = new Login();
            log.setVisible(true);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {}
        //</editor-fold>
    }
}
