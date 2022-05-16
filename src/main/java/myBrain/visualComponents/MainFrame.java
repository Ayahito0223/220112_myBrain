package myBrain.visualComponents;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.google.gson.Gson;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import myBrain.Main;
import myBrain.util.JsonFormats;

/**
 * MainFrameクラスの役割は
 * ・cardLayoutの保持するクラスの操作
 * ・colorModeの変更処理
 * ・データの保存、読み込み処理
 * ・他のパネルで共有するdataListの管理
 *
    * @author Ayahito0223
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * 今のカラーモード
     */
    private int nowColorMode;

    /**
     * 今cardLayoutに表示されているパネル。
     */
    private String nowPanel;

    /**
     * dataListはファイルから読み込んだデータが格納されている
     */
    private JsonFormats dataList;

    /**
     * Creates new form MainFrame
     */
    public MainFrame(int colorMode) {
        nowPanel = "resultPanel";
        dataList = new JsonFormats();
        initComponents();
        System.setProperty("flatlaf.animatedLafChange", "true");
        initColorMode(colorMode);
    }

    public void init(File file) {
        dataList.clear();
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String result = "";
            String str = null;
            while ((str = br.readLine()) != null) {
                result += str;
            }
            dataList = gson.fromJson(result, JsonFormats.class);
            dataList.updateNumber();
        } catch (Exception e) {
            dataList.clear();
            System.err.println("jsonファイルの読み込みに失敗しました。");
            if (Main.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //他コンポーネントの初期化
        resultListPanel1.initList();
    }

    public void init() {
        init(new File(Main.getDataSpace() + "\\" + Main.myBrainDataFile));
    }

    public void saveList(File file) {
        Gson gson = new Gson();
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            bw.write(gson.toJson(dataList));
            bw.flush();
        } catch (Exception e) {
            System.err.println("ファイル保存時に何か問題が起こりました。");
            if (Main.DEBUG) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void saveList() {
        saveList(new File(Main.getDataSpace() + "\\" + Main.myBrainDataFile));
    }

    public void saveList(String file) {
        saveList(new File(file));
    }

    public void changeScreen(int num) {
        java.awt.CardLayout layout = (java.awt.CardLayout) this.mainField.getLayout();
        switch (num) {
            case 0://一覧画面
                resultListPanel1.initList();
                FlatAnimatedLafChange.showSnapshot();
                layout.show(mainField, "resultPanel");
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                nowPanel = "resultPanel";
                if (Main.DEBUG) {
                    System.out.println("現在のcard： resultPanel");
                }
                break;
            case 1://詳細画面
                FlatAnimatedLafChange.showSnapshot();
                layout.show(mainField, "detailPanel");
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                nowPanel = "detailPanel";
                if (Main.DEBUG) {
                    System.out.println("現在のcard： detailPanel");
                }
                break;
            case 2://追加画面
                FlatAnimatedLafChange.showSnapshot();
                layout.show(mainField, "addPanel");
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
                nowPanel = "addPanel";
                if (Main.DEBUG) {
                    System.out.println("現在のcard： addPanel");
                }
                break;
        }

        Main.getDebugFrame().updateInfo();
    }

    public void initColorMode(int colorMode) {
        if (colorMode == Main.WHITE) {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                resultListPanel1.setBackground(new Color(220, 220, 220));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                System.err.println("LookAndFeelの変更に問題があるようです。");
                if (Main.DEBUG) {
                    e.printStackTrace();
                }
            }
        } else if (colorMode == Main.DARK) {
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                resultListPanel1.setBackground(new Color(51, 51, 51));
                SwingUtilities.updateComponentTreeUI(this);
            } catch (Exception e) {
                System.err.println("LookAndFeelの変更に問題があるようです。");
                if (Main.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
        nowColorMode = colorMode;
    }

    public void changeColorMode(int colorMode) {
        if (colorMode == Main.WHITE) {
            try {
                FlatAnimatedLafChange.showSnapshot();
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
                resultListPanel1.setBackground(new Color(220, 220, 220));
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            } catch (Exception e) {
                System.err.println("LookAndFeelの変更に問題があるようです。");
                if (Main.DEBUG) {
                    e.printStackTrace();
                }
            }
            if (Main.DEBUG) {
                System.out.println("ライトモードへ変更");
            }
        } else if (colorMode == Main.DARK) {
            try {
                FlatAnimatedLafChange.showSnapshot();
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                resultListPanel1.setBackground(new Color(51, 51, 51));
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            } catch (Exception e) {
                System.err.println("LookAndFeelの変更に問題があるようです。");
                if (Main.DEBUG) {
                    e.printStackTrace();
                }
            }
            if (Main.DEBUG) {
                System.out.println("ダークモードへ変更");
            }
        }
        nowColorMode = colorMode;
        Main.getDebugFrame().updateInfo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serchCheckBox = new javax.swing.ButtonGroup();
        mainField = new javax.swing.JPanel();
        resultListPanel1 = new myBrain.visualComponents.ResultListPanel();
        addToListPanel1 = new myBrain.visualComponents.AddToListPanel();
        detailListPanel1 = new myBrain.visualComponents.DetailListPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        exportFile = new javax.swing.JMenuItem();
        exportAs = new javax.swing.JMenuItem();
        importFile = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        dataSpace = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        layoutChangeDark = new javax.swing.JMenuItem();
        layoutChangeWhite = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        openDebugFrame = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("myBrain");

        mainField.setBackground(new java.awt.Color(220, 220, 220));
        mainField.setLayout(new java.awt.CardLayout());
        mainField.add(resultListPanel1, "resultPanel");
        mainField.add(addToListPanel1, "addPanel");
        mainField.add(detailListPanel1, "detailPanel");

        file.setText("File");

        exportFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exportFile.setText("保存する");
        exportFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportFileActionPerformed(evt);
            }
        });
        file.add(exportFile);
        exportFile.getAccessibleContext().setAccessibleDescription("");

        exportAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        exportAs.setText("別名で保存する");
        exportAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAsActionPerformed(evt);
            }
        });
        file.add(exportAs);

        importFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        importFile.setText("読み込む");
        importFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileActionPerformed(evt);
            }
        });
        file.add(importFile);
        file.add(jSeparator1);

        dataSpace.setText("dataSpaceの選択");
        dataSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSpaceActionPerformed(evt);
            }
        });
        file.add(dataSpace);

        jMenuBar1.add(file);

        edit.setText("Option");

        layoutChangeDark.setText("ダークモードへ変更");
        layoutChangeDark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layoutChangeDarkActionPerformed(evt);
            }
        });
        edit.add(layoutChangeDark);

        layoutChangeWhite.setText("ライドモードへ変更");
        layoutChangeWhite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layoutChangeWhiteActionPerformed(evt);
            }
        });
        edit.add(layoutChangeWhite);
        edit.add(jSeparator2);

        openDebugFrame.setText("DebugFrameの表示");
        openDebugFrame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDebugFrameActionPerformed(evt);
            }
        });
        edit.add(openDebugFrame);

        jMenuBar1.add(edit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainField, javax.swing.GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainField, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dataSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSpaceActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser(Main.getDataSpace());
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int selected = filechooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            Main.setDataSpace(file);
            if (Main.DEBUG) {
                System.out.println(Main.getDataSpace().toString());
            }
        } else if (selected == JFileChooser.CANCEL_OPTION) {
            System.out.println("キャンセルされました");
        } else if (selected == JFileChooser.ERROR_OPTION) {
            System.out.println("エラーです。");
        }

        Main.getDebugFrame().updateInfo();
    }//GEN-LAST:event_dataSpaceActionPerformed

    private void layoutChangeDarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layoutChangeDarkActionPerformed
        // TODO add your handling code here:
        changeColorMode(Main.DARK);
    }//GEN-LAST:event_layoutChangeDarkActionPerformed

    private void layoutChangeWhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layoutChangeWhiteActionPerformed
        // TODO add your handling code here:
        changeColorMode(Main.WHITE);
    }//GEN-LAST:event_layoutChangeWhiteActionPerformed

    private void exportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportFileActionPerformed
        // TODO add your handling code here:
        saveList();
    }//GEN-LAST:event_exportFileActionPerformed

    private void exportAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAsActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser(Main.getDataSpace());
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int selected = filechooser.showSaveDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            Object[] msg = {"デフォルトのdataSpaceも変更しますか？", " ", "変更すると、今後もこのディレクトリに内容が保存されます。", "データだけを保存したい場合は「いいえ」を押します。"};
            int ans = JOptionPane.showConfirmDialog(this, msg, "dataSpaceも変更しますか？",
                    JOptionPane.YES_NO_OPTION);

            saveList(file);
            if (ans == 0) {
                Main.setDataSpace(file.getParentFile());
                Main.setMyBrainDataFile(file.getName());
                init();
            }
            if (Main.DEBUG) {
                System.out.println(file.toString());
            }
        } else if (selected == JFileChooser.CANCEL_OPTION) {
            System.out.println("キャンセルされました");
        } else if (selected == JFileChooser.ERROR_OPTION) {
            System.out.println("エラーです。");
        }

        Main.getDebugFrame().updateInfo();
    }//GEN-LAST:event_exportAsActionPerformed

    private void importFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileActionPerformed
        // TODO add your handling code here:
        JFileChooser filechooser = new JFileChooser(Main.getDataSpace());
        filechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int selected = filechooser.showOpenDialog(this);
        if (selected == JFileChooser.APPROVE_OPTION) {
            File file = filechooser.getSelectedFile();
            Object[] msg = {"デフォルトのdataSpaceも変更しますか？", " ", "変更すると、今後もこのディレクトリに内容が保存されます。", "データだけを取り出したい場合は「いいえ」を押します。"};
            int ans = JOptionPane.showConfirmDialog(this, msg, "dataSpaceも変更しますか？",
                    JOptionPane.YES_NO_OPTION);

            if (ans == 0) {
                Main.setDataSpace(file.getParentFile());
                Main.setMyBrainDataFile(file.getName());
                init();
            } else {
                init(file);
            }
            if (Main.DEBUG) {
                System.out.println(file.toString());
            }
        } else if (selected == JFileChooser.CANCEL_OPTION) {
            System.out.println("キャンセルされました");
        } else if (selected == JFileChooser.ERROR_OPTION) {
            System.out.println("エラーです。");
        }

        Main.getDebugFrame().updateInfo();
    }//GEN-LAST:event_importFileActionPerformed

    private void openDebugFrameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDebugFrameActionPerformed
        // TODO add your handling code here:
        Main.openDebugFrame();
    }//GEN-LAST:event_openDebugFrameActionPerformed

    public DetailListPanel getDetailListPanel() {
        return this.detailListPanel1;
    }

    public JsonFormats getDataList() {
        return this.dataList;
    }

    public void setDataList(JsonFormats dataList) {
        this.dataList = dataList;
    }

    public int getNowColorMode() {
        return nowColorMode;
    }

    public String getNowPanel() {
        return nowPanel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private myBrain.visualComponents.AddToListPanel addToListPanel1;
    private javax.swing.JMenuItem dataSpace;
    private myBrain.visualComponents.DetailListPanel detailListPanel1;
    private javax.swing.JMenu edit;
    private javax.swing.JMenuItem exportAs;
    private javax.swing.JMenuItem exportFile;
    private javax.swing.JMenu file;
    private javax.swing.JMenuItem importFile;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem layoutChangeDark;
    private javax.swing.JMenuItem layoutChangeWhite;
    private javax.swing.JPanel mainField;
    private javax.swing.JMenuItem openDebugFrame;
    private myBrain.visualComponents.ResultListPanel resultListPanel1;
    private javax.swing.ButtonGroup serchCheckBox;
    // End of variables declaration//GEN-END:variables
}
