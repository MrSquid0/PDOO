/*
 */
package GUI;

import civitas.CasillaCalle;
import civitas.Jugador;
import java.util.ArrayList;

/**
 *
 * @author gonzalo
 */
public class JugadorPanel extends javax.swing.JPanel {
    
    Jugador jugador;
    
    
    void setJugador(Jugador jugador){
        this.jugador = jugador;
        nombreTexto.setText(jugador.getNombre());
        saldoTexto.setText(Float.toString(jugador.getSaldo()));
        boolean esEspec = jugador.esEspeculador();
        especTexto.setText(Boolean.toString(esEspec));
        
        rellenaPropiedades(jugador.getPropiedades());
        
        repaint();
        revalidate();
    }
    
    private void rellenaPropiedades (ArrayList<CasillaCalle> lista) {
        // Se elimina la información antigua
        propiedadesPanel.removeAll();
        
        // Se recorre la lista de propiedades para ir creando sus vistas
        //individuales y añadirlas al panel
        for (CasillaCalle t : lista) {
            PropiedadPanel vistaPropiedad = new PropiedadPanel();
            vistaPropiedad.setPropiedad(t);
            propiedadesPanel.add(vistaPropiedad);
            vistaPropiedad.setVisible(true);
        } 
        
        // Se fuerza la actualización visual del panel propiedades y del
        //panel del jugador
        repaint();
        revalidate();
    }

    /**
     * Creates new form JugadorPanel
     */
    public JugadorPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombreEt = new javax.swing.JLabel();
        saldoEt = new javax.swing.JLabel();
        especuladorEt = new javax.swing.JLabel();
        nombreTexto = new javax.swing.JTextField();
        saldoTexto = new javax.swing.JTextField();
        especTexto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        propiedadesPanel = new javax.swing.JPanel();

        nombreEt.setText("Nombre");

        saldoEt.setText("Saldo");

        especuladorEt.setText("Especulador");

        nombreTexto.setEditable(false);
        nombreTexto.setText("jTextField1");
        nombreTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        nombreTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextoActionPerformed(evt);
            }
        });

        saldoTexto.setEditable(false);
        saldoTexto.setText("jTextField2");
        saldoTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        especTexto.setEditable(false);
        especTexto.setText("jTextField3");
        especTexto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 20)); // NOI18N
        jLabel1.setText("Propiedades");

        jScrollPane1.setViewportView(propiedadesPanel);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(132, 132, 132))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saldoEt)
                            .addComponent(nombreEt)
                            .addComponent(especuladorEt))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(especTexto)
                            .addComponent(saldoTexto)
                            .addComponent(nombreTexto)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEt)
                    .addComponent(nombreTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saldoEt)
                    .addComponent(saldoTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(especuladorEt)
                    .addComponent(especTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nombreTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreTextoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField especTexto;
    private javax.swing.JLabel especuladorEt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel nombreEt;
    private javax.swing.JTextField nombreTexto;
    private javax.swing.JPanel propiedadesPanel;
    private javax.swing.JLabel saldoEt;
    private javax.swing.JTextField saldoTexto;
    // End of variables declaration//GEN-END:variables
}
