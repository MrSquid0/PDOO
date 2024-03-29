/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package b3;

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

        archivoEtiq = new javax.swing.JLabel();
        archivoTex = new javax.swing.JTextField();
        esEtiq = new javax.swing.JLabel();
        esTex = new javax.swing.JTextField();
        cambiarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        archivoEtiq.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        archivoEtiq.setText("Archivo:");

        archivoTex.setEditable(false);
        archivoTex.setText("archivo");
        archivoTex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoTexActionPerformed(evt);
            }
        });

        esEtiq.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        esEtiq.setText("Es:");

        esTex.setEditable(false);
        esTex.setText("es");

        cambiarBoton.setText("Cambiar");
        cambiarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(archivoEtiq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(archivoTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(esEtiq)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(esTex, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cambiarBoton)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(archivoEtiq)
                    .addComponent(archivoTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(esEtiq)
                    .addComponent(esTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(cambiarBoton)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoTexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoTexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_archivoTexActionPerformed

    private void cambiarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarBotonActionPerformed
        this.controlador.cambiar();
    }//GEN-LAST:event_cambiarBotonActionPerformed

    public void actualizar(){
        this.archivoTex.setText(this.controlador.getArchivo());
        this.esTex.setText(this.controlador.getTipo());
        
        repaint();
        revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel archivoEtiq;
    private javax.swing.JTextField archivoTex;
    private javax.swing.JButton cambiarBoton;
    private javax.swing.JLabel esEtiq;
    private javax.swing.JTextField esTex;
    // End of variables declaration//GEN-END:variables
}
