package edd.proyectodiciembre;

/**
 *
 * @author Usuario
 */
public class EDDProyectoDiciembre {
    
    public static void main(String[] args) {
        //<editor-fold defaultstate="collapsed" desc="Look and feel setting code">
        try {
            javax.swing.UIManager.setLookAndFeel("org.jvnet.substance.SubstanceLookAndFeel");
            Login log = new Login();
            log.setVisible(true);
        } catch (Exception e) {}
        //</editor-fold>
    }
}
