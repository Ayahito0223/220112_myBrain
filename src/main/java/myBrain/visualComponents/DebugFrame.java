package myBrain.visualComponents;

import myBrain.Main;

/**
 *
 * @author Ayahito0223
 */
public class DebugFrame extends javax.swing.JFrame {

    private int searchListNum;
    private int selectedListNum;
    
    /**
     * Creates new form DebugFrame
     */
    public DebugFrame(boolean debug) {
        initComponents();
        if (debug) {
            toggleDebug.setText("debugModeをオフにする");
        } else {
            toggleDebug.setText("debugModeをオンにする");
        }
    }

    public void updateInfo() {
        dataSpaceValue.setText(Main.getDataSpace().toString());
        myBrainDataFileValue.setText(Main.getMyBrainDataFile());

        int color = Main.getMainFrame().getNowColorMode();
        if (color == Main.WHITE) {
            colorModeValue.setText("ライトモード");
        } else if (color == Main.DARK) {
            colorModeValue.setText("ダークモード");
        }

        nowPanelValue.setText(Main.getMainFrame().getNowPanel());

        searchListValue.setText(Integer.toString(searchListNum));
                
        selectedListValue.setText(Integer.toString(selectedListNum));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        wrap = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dataSpaceValue = new javax.swing.JTextArea();
        dataSpaceTxt = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        myBrainDataFileValue = new javax.swing.JTextArea();
        myBrainDataFileTxt = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        colorModeValue = new javax.swing.JTextArea();
        colorModeTxt = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        nowPanelValue = new javax.swing.JTextArea();
        nowPanelTxt = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        searchListValue = new javax.swing.JTextArea();
        searchListTxt = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        selectedListValue = new javax.swing.JTextArea();
        selectedListTxt = new javax.swing.JLabel();
        toggleDebug = new javax.swing.JButton();

        setTitle("debugFrame");

        wrap.setLayout(new java.awt.GridBagLayout());

        dataSpaceValue.setEditable(false);
        dataSpaceValue.setColumns(20);
        dataSpaceValue.setLineWrap(true);
        dataSpaceValue.setRows(2);
        jScrollPane1.setViewportView(dataSpaceValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane1, gridBagConstraints);

        dataSpaceTxt.setText("dataSpace");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(dataSpaceTxt, gridBagConstraints);

        myBrainDataFileValue.setEditable(false);
        myBrainDataFileValue.setColumns(20);
        myBrainDataFileValue.setLineWrap(true);
        myBrainDataFileValue.setRows(1);
        jScrollPane2.setViewportView(myBrainDataFileValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane2, gridBagConstraints);

        myBrainDataFileTxt.setText("myBrainDataFile");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(myBrainDataFileTxt, gridBagConstraints);

        colorModeValue.setEditable(false);
        colorModeValue.setColumns(20);
        colorModeValue.setLineWrap(true);
        colorModeValue.setRows(1);
        jScrollPane3.setViewportView(colorModeValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane3, gridBagConstraints);

        colorModeTxt.setText("colorMode");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(colorModeTxt, gridBagConstraints);

        nowPanelValue.setEditable(false);
        nowPanelValue.setColumns(20);
        nowPanelValue.setLineWrap(true);
        nowPanelValue.setRows(1);
        jScrollPane4.setViewportView(nowPanelValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane4, gridBagConstraints);

        nowPanelTxt.setText("nowPanel");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(nowPanelTxt, gridBagConstraints);

        searchListValue.setEditable(false);
        searchListValue.setColumns(20);
        searchListValue.setLineWrap(true);
        searchListValue.setRows(1);
        jScrollPane5.setViewportView(searchListValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane5, gridBagConstraints);

        searchListTxt.setText("searchListNum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(searchListTxt, gridBagConstraints);

        selectedListValue.setEditable(false);
        selectedListValue.setColumns(20);
        selectedListValue.setLineWrap(true);
        selectedListValue.setRows(1);
        jScrollPane6.setViewportView(selectedListValue);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 5);
        wrap.add(jScrollPane6, gridBagConstraints);

        selectedListTxt.setText("selectedListNum");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 0, 0);
        wrap.add(selectedListTxt, gridBagConstraints);

        toggleDebug.setText("debugModeをオンにする");
        toggleDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleDebugActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 10, 5);
        wrap.add(toggleDebug, gridBagConstraints);

        getContentPane().add(wrap, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toggleDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggleDebugActionPerformed
        // TODO add your handling code here:
        if (Main.DEBUG) {
            Main.DEBUG = false;
            toggleDebug.setText("debugModeをオンにする");
        } else {
            Main.DEBUG = true;
            toggleDebug.setText("debugModeをオフにする");
        }
    }//GEN-LAST:event_toggleDebugActionPerformed

    public void setColorModeValue(String txt) {
        colorModeValue.setText(txt);
    }

    public void setSearchListNum(int searchListNum) {
        this.searchListNum = searchListNum;
    }

    public void setSelectedListNum(int selectedListNum) {
        this.selectedListNum = selectedListNum;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel colorModeTxt;
    private javax.swing.JTextArea colorModeValue;
    private javax.swing.JLabel dataSpaceTxt;
    private javax.swing.JTextArea dataSpaceValue;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel myBrainDataFileTxt;
    private javax.swing.JTextArea myBrainDataFileValue;
    private javax.swing.JLabel nowPanelTxt;
    private javax.swing.JTextArea nowPanelValue;
    private javax.swing.JLabel searchListTxt;
    private javax.swing.JTextArea searchListValue;
    private javax.swing.JLabel selectedListTxt;
    private javax.swing.JTextArea selectedListValue;
    private javax.swing.JButton toggleDebug;
    private javax.swing.JPanel wrap;
    // End of variables declaration//GEN-END:variables
}
