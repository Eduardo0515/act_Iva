package Iva;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Iva extends JFrame implements ActionListener{
	private String selectIva;
	private JLabel mensaje;
	private JButton boton;
	private JTextField caja;
	private JComboBox iva;
	
	public Iva() {
		super();
		configurarVentana();
		crearComponentes();
	}
	
	private void configurarVentana(){
		this.setTitle("Calculadora Iva");
		this.setSize(300,200);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void crearComponentes() {
		mensaje = new JLabel();
		mensaje.setText("Cantidad");
		mensaje.setBounds(105, 10, 100, 30);
		this.add(mensaje);
		caja = new JTextField();
		caja.setBounds(85, 35, 100, 30);
		this.add(caja);
		mensaje = new JLabel();
		mensaje.setText("Iva");
		mensaje.setBounds(120, 57, 100, 30);
		this.add(mensaje);
		
		String[] ivaList = new String[] {"16","8"};
		JComboBox<String> iva = new JComboBox<>(ivaList);
		iva.setBounds(85, 80, 100, 30);
		iva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectIva = iva.getItemAt(iva.getSelectedIndex());
				System.out.println("El valor de iva es:"+ selectIva);
			}
		});
		this.add(iva);
		
		mensaje.setForeground(Color.BLUE);
		boton = new JButton();
		boton.setText("Calcular");
		boton.setBounds(85, 115, 100, 30);
		boton.addActionListener(this);
		this.add(boton);
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		String resultado = caja.getText();
		JOptionPane.showMessageDialog(this, "El total es "+calculoIva(resultado));
	}
	
	public String calculoIva(String resultado) {
		double num1 = Double.parseDouble(resultado);
		if(selectIva==null) {
			selectIva=JOptionPane.showInputDialog("No ha seleccionado  un Iva, ingrese el Iva que desea");
		} 
		double num2 = Double.parseDouble(selectIva);
		String cadena = String.valueOf(num1*(num2/100)+num1);
		return cadena;
	}
	
	public static void main(String[] args) {
		Iva ventana = new Iva();
		ventana.setVisible(true);	
	}
}