/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di_calculadora;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Romi
 */
public class Ventana extends JFrame implements ActionListener {
    ArrayList<Double>listaNumeros = new ArrayList();
    Container container;
    JTextField texto;
    JButton bt_0;
    JButton bt_bol;
    JButton bt_bog;
    JButton bt_raiz;
    JButton bt_coseno;
    JButton bt_seno;
    JButton bt_exponencial;
    JButton bt_porciento;
    JButton bt_multiplicar;
    JButton bt_punto;
    JButton bt_coma;
    JButton bt_sumar;
    JButton bt_resultado;
    JButton bt_restar;
    JButton bt_dividir;
    JPanel panel_sur;
    JPanel panel_nor;
    JPanel panel_surc;
    JPanel panel_surd;
    JPanel panel_surizq;
    JPanel panel_este;
    JPanel panel_oeste;
    JPanel panel_centro;

    public Ventana() {
        initGUI();
    }

    private void initGUI() {

        intancias();
        Numeros();
        configurarContainer();
        setTitle("Calculadora");
        setSize(300, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
        //this.setExtendedState(MAXIMIZED_BOTH);
        // this.pack();
        setVisible(true);

    }

    private void intancias() {
        container = this.getContentPane();
        texto = new JTextField("Resultado");
        bt_0 = new JButton("0");
        
        bt_bog = new JButton("C");
        bt_bol = new JButton("CE");
        bt_raiz = new JButton("√");
        bt_coseno = new JButton("COS");
        bt_seno = new JButton("SIN");
        bt_exponencial = new JButton("EXP");
        bt_porciento = new JButton("%");
        bt_multiplicar = new JButton("*");
        bt_punto = new JButton(".");
        bt_coma = new JButton(",");
        bt_sumar = new JButton("+");
        bt_resultado = new JButton("=");
        bt_restar = new JButton("-");
        bt_dividir = new JButton("/");
        panel_nor = new JPanel();
        panel_sur = new JPanel();
        panel_surc = new JPanel();
        panel_surd = new JPanel();
        panel_surizq = new JPanel();
        panel_este = new JPanel();
        panel_oeste = new JPanel();
        panel_centro = new JPanel();
    }

    private ArrayList<JButton> Numeros() {
        ArrayList<JButton> numeros = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numeros.add(new JButton(Integer.toString(i)));
        }
        return numeros;
    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        // container.add(panelSuperior(), BorderLayout.NORTH);
        container.add(panelDerecho(), BorderLayout.EAST);
        container.add(panelInferior(), BorderLayout.SOUTH);
        container.add(panelIzquierda(), BorderLayout.WEST);
        //container.add(panelIzquierda(), BorderLayout.WEST);
        //container.add(panelCentro(), BorderLayout.CENTER);
    }

    private JPanel panelSuperior() {
        panel_nor.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        return panel_nor;
    }

    private JTextField panelDerecho() {
        texto.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 100));
        return texto;

    }

    private JPanel panelInferior() {
        panel_sur.setLayout(new BorderLayout());
        panel_sur.add(panelInferiorC(), BorderLayout.CENTER);
        panel_sur.add(panelInferiorD(), BorderLayout.EAST);
        return panel_sur;
    }

    private JPanel panelInferiorC() {

        panel_surc.setLayout(new GridLayout(5, 3));

        panel_surc.add(bt_raiz);
        panel_surc.add(bt_exponencial);
        for (JButton obj : Numeros()) {
            panel_surc.add(obj);
        }
        panel_surc.add(bt_porciento);
        panel_surc.add(bt_0);
        panel_surc.add(bt_bol);
        panel_surc.add(bt_punto);
        panel_surc.add(bt_bog);
        panel_surc.add(bt_coma);
        return panel_surc;
    }

    private JPanel panelInferiorD() {

        panel_surd.setLayout(new GridLayout(5, 1));
        panel_surd.add(bt_sumar);
        panel_surd.add(bt_restar);
        panel_surd.add(bt_multiplicar);
        panel_surd.add(bt_dividir);
        panel_surd.add(bt_resultado);
        return panel_surd;
    }

    private JPanel panelIzquierda() {
        panel_surizq.setLayout(new GridLayout(4, 1));
        panel_surizq.add(bt_seno);
        panel_surizq.add(bt_coseno);
        panel_surizq.add(bt_exponencial);
        panel_surizq.add(bt_raiz);
        return panel_surizq;
    }

    private JPanel panelCentro() {
        panel_centro.setLayout(new FlowLayout(50, 50, 50));

        return panel_centro;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case Interfaz_Calculadora.btn_0:   
            case Interfaz_Calculadora.btn_1:
            case Interfaz_Calculadora.btn_2:
            case Interfaz_Calculadora.btn_3:
            case Interfaz_Calculadora.btn_4:
            case Interfaz_Calculadora.btn_5:
            case Interfaz_Calculadora.btn_6:
            case Interfaz_Calculadora.btn_7:
            case Interfaz_Calculadora.btn_8:
            case Interfaz_Calculadora.btn_9:
            case Interfaz_Calculadora.btn_restar:
                resta(listaNumeros);
            case Interfaz_Calculadora.btn_sumar:
                suma(listaNumeros);
            case Interfaz_Calculadora.btn_multiplicar:
                multiplica(listaNumeros);
            case Interfaz_Calculadora.btn_dividir:
                division(listaNumeros);
            case Interfaz_Calculadora.btn_raiz:
            case Interfaz_Calculadora.potencia:
                potencia(listaNumeros);
        }
    }
    
    public double suma(ArrayList<Double> listaNumeros){
        double resultado = 0;
        for (Double listaNumero : listaNumeros) {
            resultado += listaNumero;
        }
        return resultado;
        
    }
    
    public double resta(ArrayList<Double> listaNumeros){
        double resultado = 0;
        for (Double listaNumero : listaNumeros) {
            resultado -= listaNumero;
        }
        return resultado;
        
    }
   
    public double multiplica(ArrayList<Double> listaNumeros){
        double resultado = 0;
        for (Double listaNumero : listaNumeros) {
            resultado *= listaNumero;
        }
        
        return resultado; 
    }
   
    public double potencia(ArrayList<Double> listaNumeros){
        double resultado = 0;        
        for (Double listaNumero : listaNumeros) {
         resultado = Math.pow(listaNumero, listaNumero);   
        }       
        return resultado;    
    }
   
    public double division(ArrayList<Double> listaNumeros){
        double resultado = 0;
        for (Double listaNumero : listaNumeros) {
            resultado /= listaNumero;
        }       
        return resultado;    
    }
    
}

