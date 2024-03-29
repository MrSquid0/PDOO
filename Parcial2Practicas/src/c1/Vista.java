/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c1;

/**
 *
 * @author gonzalo0
 */
public class Vista extends javax.swing.JFrame {

    private Controlador controlador;
    public Vista(Controlador controlador) {
        initComponents();
        
        controlador.setVista(this);
        this.controlador = controlador;
        this.actualizar();
        setVisible(true);
        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        equipoEtiq = new javax.swing.JLabel();
        golesEtiq = new javax.swing.JLabel();
        equipoTex = new javax.swing.JTextField();
        golesTex = new javax.swing.JTextField();
        siguienteBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        equipoEtiq.setText("Equipo:");

        golesEtiq.setText("Goles:");

        equipoTex.setEditable(false);
        equipoTex.setText("jTextField1");
        equipoTex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipoTexActionPerformed(evt);
            }
        });

        golesTex.setEditable(false);
        golesTex.setText("jTextField1");
        golesTex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                golesTexActionPerformed(evt);
            }
        });

        siguienteBoton.setText("Siguiente");
        siguienteBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(equipoEtiq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(equipoTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(golesEtiq)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(golesTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(siguienteBoton)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipoEtiq)
                    .addComponent(golesEtiq)
                    .addComponent(equipoTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(golesTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(siguienteBoton)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void actualizar(){
        this.equipoTex.setText(this.controlador.getEquipo());
        this.golesTex.setText(Integer.toString(this.controlador.getGoles()));
        
        repaint();
        revalidate();
    }    
    
    private void equipoTexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipoTexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipoTexActionPerformed

    private void golesTexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_golesTexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_golesTexActionPerformed

    private void siguienteBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteBotonActionPerformed
        this.controlador.siguiente();
    }//GEN-LAST:event_siguienteBotonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel equipoEtiq;
    private javax.swing.JTextField equipoTex;
    private javax.swing.JLabel golesEtiq;
    private javax.swing.JTextField golesTex;
    private javax.swing.JButton siguienteBoton;
    // End of variables declaration//GEN-END:variables
}