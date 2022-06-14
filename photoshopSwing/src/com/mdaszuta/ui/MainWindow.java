package com.mdaszuta.ui;

import com.mdaszuta.algoritms.AlgorithmParams;
import com.mdaszuta.core.FileReader;
import com.mdaszuta.core.Processor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;

public class MainWindow extends JFrame implements ActionListener {

    private final Processor imageProcessor = new Processor();
    private final JFrame window;
    private final MenuPanel menuPanel;
    private final ImagesPanel imagesPanel = new ImagesPanel();

    private JMenuItem openFile;

    private JMenuItem openSecondFile;

    private final AlgorithmParams params = new AlgorithmParams();

    private BufferedImage image;

    private BufferedImage secondImage;

    public MainWindow() {
        window = new JFrame();
        menuPanel = new MenuPanel();
        menuPanel.create();

       // window.setSize(1500, 900);
        window.setLayout(new BorderLayout(1, 1));

        window.add(createMenuPanel(), BorderLayout.NORTH);
        //window.add(g1Panel, BorderLayout.WEST);
        //window.add(g2Panel, BorderLayout.EAST);

        window.add(menuPanel.getJPanel(), BorderLayout.CENTER);
        window.add(imagesPanel.create(), BorderLayout.SOUTH);
        window.setSize(new Dimension(1280, 720));
        window.setVisible(true);
        menuPanel.getProcessButton().addActionListener(
                e -> {
                    menuPanel.readParams(params);
                    final var newImage = deepCopy(image);
                    final var newSecondImage = deepCopy(secondImage);
                    imageProcessor.process(newImage, newSecondImage, params);
                    imagesPanel.setResultImage(newImage);
                }
        );
    }

    private JPanel createMenuPanel() {
        final var panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        openFile = new JMenuItem("Open File");
        openSecondFile = new JMenuItem("Open Secound File");
        final var close = new JMenuItem("Exit");
        panel.add(openFile);
        panel.add(openSecondFile);
        panel.add(close);
        close.addChangeListener(e -> System.exit(1));
        openFile.addActionListener(this);
        openSecondFile.addActionListener(this);
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            System.out.println(e.getSource());
            JFileChooser fc=new JFileChooser();
            int i=fc.showOpenDialog(this);
            if(i==JFileChooser.APPROVE_OPTION){
                File f=fc.getSelectedFile();
                String filepath=f.getPath();
                System.out.println(filepath);
                try {
                    if (e.getSource() == openFile) {
                        image = new FileReader().readImage(filepath);
                        secondImage = null;
                    } else {
                        secondImage = new FileReader().readImage(filepath);
                    }
                    imagesPanel.setOriginalImage(image);
                    imagesPanel.setResultImage(image);
                    imagesPanel.setAdditionalResultImage(secondImage);
                    window.pack();
                } catch (Exception ex) {ex.printStackTrace();  }
            }
    }

    static BufferedImage deepCopy(BufferedImage bi) {
        if (bi == null) {
            return null;
        }
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
