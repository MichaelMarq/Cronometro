
package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Michael
 */
public class Ventana extends javax.swing.JFrame {

    //Atributos
    private Timer tiempo;
    private int segundos = 0, minutos=0,horas=0;
    
    
    //Constructor
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    //Etiqueta del tiempo
    private void actualizarEtiquetaTiempo(){
        String texto = (horas<10? "0":"")+horas+" : "+(minutos<10? "0":"")+minutos+" : "+(segundos<10? "0":"")+segundos;
        lbTiempo.setText(texto);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        lbReloj = new javax.swing.JLabel();
        btnPausar = new javax.swing.JButton();
        btnIniciar = new javax.swing.JButton();
        btnDetener = new javax.swing.JButton();
        lbTiempo = new javax.swing.JLabel();
        lbTitulo = new javax.swing.JLabel();
        lbFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cronómetro");
        setResizable(false);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbReloj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cronometro1.png"))); // NOI18N
        panel.add(lbReloj, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 140, 130));

        btnPausar.setBackground(new java.awt.Color(153, 204, 255));
        btnPausar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnPausar.setText("Pausar");
        btnPausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausarActionPerformed(evt);
            }
        });
        panel.add(btnPausar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        btnIniciar.setBackground(new java.awt.Color(153, 204, 255));
        btnIniciar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });
        panel.add(btnIniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        btnDetener.setBackground(new java.awt.Color(153, 204, 255));
        btnDetener.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        btnDetener.setText("Detener");
        btnDetener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetenerActionPerformed(evt);
            }
        });
        panel.add(btnDetener, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));

        lbTiempo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        lbTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(lbTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 300, 50));

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 26)); // NOI18N
        lbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitulo.setText("Cronómetro");
        lbTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panel.add(lbTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 300, 50));

        lbFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo_pista.jpg"))); // NOI18N
        panel.add(lbFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        //Inicializar el rvento del tiempo
        ActionListener oyente = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                if(segundos>59){
                    segundos = 0;
                    minutos++;
                    if(minutos>59){
                        minutos =0;
                        horas++;
                    }
                }
                actualizarEtiquetaTiempo();
            }
        };
        
        tiempo = new Timer(1000,oyente);
        tiempo.start();
        btnIniciar.setEnabled(false);
        btnIniciar.setText("Reanudar");
        btnPausar.setEnabled(true);
        
        
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnPausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausarActionPerformed
        ///Pausar el tiempo
        tiempo.stop();
        btnIniciar.setEnabled(true);
        btnPausar.setEnabled(false);
    }//GEN-LAST:event_btnPausarActionPerformed

    private void btnDetenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetenerActionPerformed

        //Reiniciar el tiempo de 0
        
        tiempo.restart();
        tiempo.stop();
        btnIniciar.setText("Iniciar");
        btnIniciar.setEnabled(true);
        btnPausar.setEnabled(false);
        segundos =0;
        minutos = 0;
        horas = 0;
        actualizarEtiquetaTiempo();
        
    }//GEN-LAST:event_btnDetenerActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetener;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnPausar;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JLabel lbReloj;
    private javax.swing.JLabel lbTiempo;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
