/*
 */
package GUI;

import civitas.CasillaCalle;

public class PropiedadPanel extends javax.swing.JPanel {
    
    CasillaCalle tituloPropiedad;
    
    void setPropiedad(CasillaCalle tituloPropiedad){
        this.tituloPropiedad = tituloPropiedad;
        tituloTex.setText(tituloPropiedad.getNombre());
        numCasasTex.setText(Integer.toString(tituloPropiedad.getNumCasas()));
        numHotelesTex.setText(Integer.toString(tituloPropiedad.getNumHoteles()));
        alquilerTex.setText(Float.toString(tituloPropiedad.getPrecioAlquilerCompleto()));
        
        repaint();
        revalidate();        
    }

    /**
     * Creates new form PropiedadPanel
     */
    public PropiedadPanel() {
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

        tituloEtiq = new javax.swing.JLabel();
        numCasasEtiq = new javax.swing.JLabel();
        numHotelesEtiq = new javax.swing.JLabel();
        tituloTex = new javax.swing.JTextField();
        numCasasTex = new javax.swing.JTextField();
        numHotelesTex = new javax.swing.JTextField();
        alquilerEtiq = new javax.swing.JLabel();
        alquilerTex = new javax.swing.JTextField();

        tituloEtiq.setText("Nombre título");

        numCasasEtiq.setText("Nº casas");

        numHotelesEtiq.setText("Nº hoteles");

        tituloTex.setEditable(false);
        tituloTex.setText("jTextField1");

        numCasasTex.setEditable(false);
        numCasasTex.setText("jTextField2");

        numHotelesTex.setEditable(false);
        numHotelesTex.setText("jTextField3");

        alquilerEtiq.setText("Alquiler");

        alquilerTex.setText("jTextField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tituloEtiq)
                    .addComponent(numCasasEtiq)
                    .addComponent(numHotelesEtiq)
                    .addComponent(alquilerEtiq))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alquilerTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numHotelesTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numCasasTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tituloEtiq)
                    .addComponent(tituloTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numCasasEtiq)
                    .addComponent(numCasasTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numHotelesEtiq)
                    .addComponent(numHotelesTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alquilerEtiq)
                    .addComponent(alquilerTex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alquilerEtiq;
    private javax.swing.JTextField alquilerTex;
    private javax.swing.JLabel numCasasEtiq;
    private javax.swing.JTextField numCasasTex;
    private javax.swing.JLabel numHotelesEtiq;
    private javax.swing.JTextField numHotelesTex;
    private javax.swing.JLabel tituloEtiq;
    private javax.swing.JTextField tituloTex;
    // End of variables declaration//GEN-END:variables
}
