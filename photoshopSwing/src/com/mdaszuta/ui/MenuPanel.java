package com.mdaszuta.ui;

import com.mdaszuta.algoritms.AlgorithmParams;
import com.mdaszuta.algoritms.AlgorithmType;

import javax.swing.*;
import java.awt.*;

public class MenuPanel {

    private final JPanel main;
    private final JComboBox<AlgorithmType> algorithmTypeJComboBox;
    private final JSlider aValueSlider;
    private final JSlider bValueSlider;
    private final JSlider cValueSlider;

    private final JSlider nValueSlider;

    private final JButton processButton;

    public MenuPanel() {
        main = new JPanel();
        algorithmTypeJComboBox = new JComboBox(AlgorithmType.values());
        aValueSlider = new JSlider();
        aValueSlider.setName("A:");
        bValueSlider = new JSlider();
        bValueSlider.setName("B:");
        cValueSlider = new JSlider();
        cValueSlider.setName("C:");
        nValueSlider = new JSlider();
        nValueSlider.setName("N:");
        nValueSlider.setToolTipText("N");
        processButton = new JButton("Process");
        aValueSlider.setMajorTickSpacing(10);
        aValueSlider.setMinorTickSpacing(1);
        aValueSlider.setPaintTicks(true);
        bValueSlider.setMajorTickSpacing(10);
        bValueSlider.setMinorTickSpacing(1);
        bValueSlider.setPaintTicks(true);
        cValueSlider.setMajorTickSpacing(10);
        cValueSlider.setMinorTickSpacing(1);
        cValueSlider.setPaintTicks(true);
        nValueSlider.setMajorTickSpacing(10);
        nValueSlider.setMinorTickSpacing(1);
        nValueSlider.setPaintTicks(true);
    }

    public void create() {
        main.setLayout(new GridBagLayout());
        final var constraints = new GridBagConstraints();
        setConstraints(constraints, 2, 2, GridBagConstraints.RELATIVE);
        main.setSize(new Dimension(1280, 10));
        main.add(new JLabel("Algorithm:"));
        main.add(algorithmTypeJComboBox);
        main.add(new JLabel("A [0.0:1.0]:"));
        main.add(aValueSlider);
        main.add(new JLabel("B [0.0:1.0]:"));
        main.add(bValueSlider);
        main.add(new JLabel("C [0.0:1.0]:"));
        main.add(cValueSlider);
        main.add(new JLabel("N [0.0:1.0]:"));
        main.add(nValueSlider);
        main.add(processButton);
        main.setVisible(true);
    }

    public JButton getProcessButton() {
        return processButton;
    }


    public JPanel getJPanel() {
        return main;
    }

    public void readParams(AlgorithmParams params) {
        params.setA(toFloat(aValueSlider.getValue()));
        params.setB(toFloat(bValueSlider.getValue()));
        params.setC(toFloat(cValueSlider.getValue()));
        params.setN(toFloat(nValueSlider.getValue()));
        params.setType(algorithmTypeJComboBox.getItemAt(algorithmTypeJComboBox.getSelectedIndex()));
    }
    private float toFloat(int value) {
        return  value / 100.0f;
    }

    private void setConstraints(GridBagConstraints constraints, int x, int y, int fill) {
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.fill = fill;
    }
}
