package interfaz;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import negocio.Palabra;
import negocio.Vocabulario;
import soporte.Persistencia;
import soporte.Validaciones;
import soporte.WorkerCargar;
import soporte.WorkerGuardar;
import soporte.WorkerHashing;

public class VocabularioFrame extends javax.swing.JFrame
{

    private Vocabulario voc;
    private LinkedList<File> colaTareas;

    /**
     * Creates new form Vocabulario
     */
    public VocabularioFrame()
    {
        voc = new Vocabulario();
        colaTareas = new LinkedList<>();
        initComponents();

    }

    public Image obtenerImagen()
    {
        try
        {
            return ImageIO.read(new File(".\\resource\\letras16.png"));
        } catch (IOException ex)
        {
            Logger.getLogger(VocabularioFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPnlPalabras = new javax.swing.JPanel();
        jScllPalabras = new javax.swing.JScrollPane();
        jTblGrillaPalabras = new javax.swing.JTable();
        jLlbCantidad = new javax.swing.JLabel();
        jPnlOpciones = new javax.swing.JPanel();
        jLblFiltro = new javax.swing.JLabel();
        jTflFiltro = new javax.swing.JTextField();
        jBtnFiltrar = new javax.swing.JButton();
        jBtnCargarDocumentos = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnLimpiar = new javax.swing.JButton();
        jlblGif = new javax.swing.JLabel();
        jPnlStatusBar = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLlbResultado = new javax.swing.JLabel();
        jPbrCargando = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vocabulario");
        setIconImage(obtenerImagen()
        );
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowOpened(java.awt.event.WindowEvent evt)
            {
                cargarBD(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                filtrado(evt);
            }
        });

        jPnlPalabras.setBorder(javax.swing.BorderFactory.createTitledBorder("Palabras"));

        jTblGrillaPalabras.setModel(new ModeloTabla()
        );
        jScllPalabras.setViewportView(jTblGrillaPalabras);

        jLlbCantidad.setText("Cantidad de Elementos:");

        javax.swing.GroupLayout jPnlPalabrasLayout = new javax.swing.GroupLayout(jPnlPalabras);
        jPnlPalabras.setLayout(jPnlPalabrasLayout);
        jPnlPalabrasLayout.setHorizontalGroup(
            jPnlPalabrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPalabrasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnlPalabrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScllPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
                    .addGroup(jPnlPalabrasLayout.createSequentialGroup()
                        .addComponent(jLlbCantidad)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnlPalabrasLayout.setVerticalGroup(
            jPnlPalabrasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlPalabrasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScllPalabras, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLlbCantidad))
        );

        jPnlOpciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciones"));

        jLblFiltro.setText("Filtro");

        jTflFiltro.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                jTflFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                jTflFiltroKeyTyped(evt);
            }
        });

        jBtnFiltrar.setIcon(new javax.swing.ImageIcon(".\\resource\\embudo24.png"));
        jBtnFiltrar.setText("Filtar");
        jBtnFiltrar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnFiltrarActionPerformed(evt);
            }
        });

        jBtnCargarDocumentos.setIcon(new javax.swing.ImageIcon(".\\resource\\agregar24.png"));
        jBtnCargarDocumentos.setText("Cargar mas Documentos");
        jBtnCargarDocumentos.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnCargarDocumentosActionPerformed(evt);
            }
        });

        jBtnGuardar.setIcon(new javax.swing.ImageIcon(".\\resource\\guardar24.png"));
        jBtnGuardar.setText("Guardar Vocabulario");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnLimpiar.setIcon(new javax.swing.ImageIcon(".\\resource\\sinfiltro24.png"));
        jBtnLimpiar.setText("Limpiar Filtro");
        jBtnLimpiar.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jBtnLimpiarActionPerformed(evt);
            }
        });

        jlblGif.setIcon(new javax.swing.ImageIcon(new javax.swing.ImageIcon(".\\resource\\loading.gif").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT)));

        javax.swing.GroupLayout jPnlOpcionesLayout = new javax.swing.GroupLayout(jPnlOpciones);
        jPnlOpciones.setLayout(jPnlOpcionesLayout);
        jPnlOpcionesLayout.setHorizontalGroup(
            jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlOpcionesLayout.createSequentialGroup()
                .addGroup(jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnlOpcionesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnlOpcionesLayout.createSequentialGroup()
                                .addComponent(jLblFiltro)
                                .addGap(18, 18, 18)
                                .addComponent(jTflFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnlOpcionesLayout.createSequentialGroup()
                                    .addComponent(jBtnFiltrar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBtnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(jBtnCargarDocumentos, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jBtnGuardar)))
                    .addGroup(jPnlOpcionesLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jlblGif, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPnlOpcionesLayout.setVerticalGroup(
            jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlOpcionesLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblFiltro)
                    .addComponent(jTflFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPnlOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnFiltrar)
                    .addComponent(jBtnLimpiar))
                .addGap(28, 28, 28)
                .addComponent(jBtnCargarDocumentos)
                .addGap(33, 33, 33)
                .addComponent(jlblGif, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jBtnGuardar)
                .addContainerGap())
        );

        jPnlStatusBar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        jLlbResultado.setText("Listo");

        javax.swing.GroupLayout jPnlStatusBarLayout = new javax.swing.GroupLayout(jPnlStatusBar);
        jPnlStatusBar.setLayout(jPnlStatusBarLayout);
        jPnlStatusBarLayout.setHorizontalGroup(
            jPnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnlStatusBarLayout.createSequentialGroup()
                .addComponent(jLlbResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPbrCargando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPnlStatusBarLayout.setVerticalGroup(
            jPnlStatusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jLlbResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
            .addComponent(jPbrCargando, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPbrCargando.setStringPainted(true);
        jPbrCargando.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPnlOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPnlPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addComponent(jPnlStatusBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPnlOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPnlPalabras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPnlStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnGuardarActionPerformed
    {//GEN-HEADEREND:event_jBtnGuardarActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Esta por guardar el vocabulario\n¿Está seguro de continuar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == JOptionPane.YES_OPTION)
        {
            if (voc.getSizeHash()>0)
            {
                jBtnGuardar.setEnabled(false);
                
                jPbrCargando.setVisible(true);
                
                WorkerGuardar worker = new WorkerGuardar(jLlbResultado, jPbrCargando, voc);
                
                worker.execute();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "El vocabulario esta vacío", "Atención", JOptionPane.INFORMATION_MESSAGE);
                
            }
                
        }


    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void cargarBD(java.awt.event.WindowEvent evt)//GEN-FIRST:event_cargarBD
    {//GEN-HEADEREND:event_cargarBD
        WorkerCargar worker = new WorkerCargar(jlblGif, jLlbResultado, voc, jLlbCantidad, jTblGrillaPalabras);
        worker.execute();
        
    }//GEN-LAST:event_cargarBD

    private void filtrado(java.awt.event.KeyEvent evt)//GEN-FIRST:event_filtrado
    {//GEN-HEADEREND:event_filtrado


    }//GEN-LAST:event_filtrado

    private void jBtnFiltrarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnFiltrarActionPerformed
    {//GEN-HEADEREND:event_jBtnFiltrarActionPerformed
        String filtro = jTflFiltro.getText();

        if (!Validaciones.estaVacio(filtro))
        {

            filtrado(filtro);

        } else
        {
            JOptionPane.showMessageDialog(this, "Ingrese criterio de filtrado", "Error", JOptionPane.OK_OPTION, null);
            jTflFiltro.requestFocus();
        }
    }//GEN-LAST:event_jBtnFiltrarActionPerformed

    public void filtrado(String filtro)
    {
        ArrayList<Palabra> byFilterPalabras = Persistencia.getByFilterPalabras(filtro);

        jTblGrillaPalabras.setModel(new ModeloFiltrado(byFilterPalabras));

        jTblGrillaPalabras.updateUI();
    }

    private void jBtnCargarDocumentosActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnCargarDocumentosActionPerformed
    {//GEN-HEADEREND:event_jBtnCargarDocumentosActionPerformed
        JFileChooser fc = new JFileChooser("../");
        fc.setMultiSelectionEnabled(true);

        FileNameExtensionFilter filtros = new FileNameExtensionFilter("Documentos de Texto (*.txt)", "txt");
        fc.setFileFilter(filtros);

        int result = fc.showOpenDialog(this);

        switch (result)
        {
            case JFileChooser.APPROVE_OPTION:

                colaTareas.addAll(Arrays.asList(fc.getSelectedFiles()));

                jPbrCargando.setVisible(true);

                WorkerHashing worker = new WorkerHashing(jLlbResultado, jLlbCantidad, jPbrCargando, jTblGrillaPalabras, colaTareas.size(), voc, colaTareas);

                worker.execute();

                jBtnGuardar.setEnabled(true);

                jTblGrillaPalabras.setModel(new ModeloTabla());

                

                break;

            case JFileChooser.CANCEL_OPTION:

                break;

        }

        //jTblGrillaPalabras.updateUI();

    }//GEN-LAST:event_jBtnCargarDocumentosActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jBtnLimpiarActionPerformed
    {//GEN-HEADEREND:event_jBtnLimpiarActionPerformed
        jTflFiltro.setText("");
        jTblGrillaPalabras.setModel(new ModeloTabla());
        jTblGrillaPalabras.updateUI();

    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jTflFiltroKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTflFiltroKeyTyped
    {//GEN-HEADEREND:event_jTflFiltroKeyTyped
        if (Validaciones.esTexto(evt.getKeyChar()))
        {

        } else
        {
            JOptionPane.showMessageDialog(this, "Ingrese solo Letras", "Error", JOptionPane.OK_OPTION, null);
            evt.consume();
        }
    }//GEN-LAST:event_jTflFiltroKeyTyped

    private void jTflFiltroKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_jTflFiltroKeyReleased
    {//GEN-HEADEREND:event_jTflFiltroKeyReleased
       String filtro = jTflFiltro.getText();

        filtrado(filtro);
    }//GEN-LAST:event_jTflFiltroKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(VocabularioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(VocabularioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(VocabularioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(VocabularioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new VocabularioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCargarDocumentos;
    private javax.swing.JButton jBtnFiltrar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JLabel jLblFiltro;
    private javax.swing.JLabel jLlbCantidad;
    private javax.swing.JLabel jLlbResultado;
    private javax.swing.JProgressBar jPbrCargando;
    private javax.swing.JPanel jPnlOpciones;
    private javax.swing.JPanel jPnlPalabras;
    private javax.swing.JPanel jPnlStatusBar;
    private javax.swing.JScrollPane jScllPalabras;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTblGrillaPalabras;
    private javax.swing.JTextField jTflFiltro;
    private javax.swing.JLabel jlblGif;
    // End of variables declaration//GEN-END:variables

    class ModeloTabla extends AbstractTableModel
    {

        @Override
        public int getRowCount()
        {
            return voc.getSizeHash();

        }

        @Override
        public int getColumnCount()
        {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            Palabra tabla[] = voc.getTabla();

            if (tabla[rowIndex] != null)
            {
                switch (columnIndex)
                {
                    case 0:

                        return tabla[rowIndex].getPalabra();

                    case 1:

                        return tabla[rowIndex].getFrecuencia();

                    case 2:

                        return tabla[rowIndex].getDocumentos().toString();

                }
            }

            return "-------";

        }

        @Override
        public String getColumnName(int column)
        {
            String nombres[] =
            {
                "Palabra", "Frecuencia", "Documentos"
            };

            return nombres[column];
        }

    }

    class ModeloFiltrado extends AbstractTableModel
    {

        ArrayList<Palabra> filtrado;

        public ModeloFiltrado(ArrayList<Palabra> filtrado)
        {
            this.filtrado = filtrado;
        }

        @Override
        public int getRowCount()
        {
            return filtrado.size();
        }

        @Override
        public int getColumnCount()
        {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex)
        {
            if (filtrado.get(rowIndex) != null)
            {
                switch (columnIndex)
                {
                    case 0:

                        return filtrado.get(rowIndex).getPalabra();

                    case 1:

                        return filtrado.get(rowIndex).getFrecuencia();

                    case 2:

                        return filtrado.get(rowIndex).getDocumentos().toString();

                }
            }

            return "-------";
        }

        @Override
        public String getColumnName(int column)
        {
            String nombres[] =
            {
                "Palabra", "Frecuencia", "Documentos"
            };

            return nombres[column];
        }

    }

}
