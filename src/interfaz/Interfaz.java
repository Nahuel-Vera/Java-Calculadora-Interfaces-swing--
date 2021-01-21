package interfaz;
import java.awt.event.*;
import javax.swing.*;




public class Interfaz extends JFrame implements ActionListener{;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton botonExit;
	private JButton botonSuma;
	private JButton botonResta;
	private JButton botonMultiplica;
	private JButton botonDivide;
	private JButton botonFibonacci;
	private JButton boton1;
	private JButton boton2;
	private JTextField cajaTexto;
	private String num;
	private String num2;
	private JLabel mensaje;
	private JLabel mensaje2;
	
//constructor
public Interfaz() {
	setLayout(null);

	//constructor
	mensaje=new JLabel("num es: "+Integer.getInteger(num) );
	mensaje.setBounds(100, 80, 150, 150);
	add(mensaje);
	
	mensaje2=new JLabel("num2 es: "+ Integer.getInteger(num2));
	mensaje2.setBounds(100, 100, 150, 150);
	add(mensaje2);
	
	//constructor
	cajaTexto=new JTextField();
	cajaTexto.setBounds(200,150,100,30);
	add(cajaTexto);
	muchoTexto(cajaTexto);
	

	//boton 1
	boton1=new JButton("guardar num2");
	boton1.setBounds(260, 50, 130, 45);
	add(boton1);
	boton1.addActionListener(this);
	
	//boton 2
	boton2=new JButton("guardar num1");
	boton2.setBounds(120, 50, 130, 45);
	add(boton2);
	boton2.addActionListener(this);
	
	//boton para sucesion de fibonacci
	botonFibonacci=new JButton("Fibonacci");
	botonFibonacci.setBounds(100, 280, 100, 30);
	add(botonFibonacci);
	botonFibonacci.addActionListener(this);
	
	
	//boton para sumar
	botonSuma=new JButton("sumar");
	botonSuma.setBounds(300, 250, 100, 30);
	add(botonSuma);
	botonSuma.addActionListener(this);
	
	//boton para restar
	botonResta=new JButton("Restar");
	botonResta.setBounds(100, 250, 100, 30);
	add(botonResta);
	botonResta.addActionListener(this);
	
	//boton para multiplicar
	botonMultiplica=new JButton("multiplicar");
	botonMultiplica.setBounds(200, 250, 100, 30);
	add(botonMultiplica);
	botonMultiplica.addActionListener(this);
	
	//boton para dividir
	botonDivide=new JButton("dividir");
	botonDivide.setBounds(200, 280, 100, 30);
	add(botonDivide);
	botonDivide.addActionListener(this);
	
	//boton para salir
	botonExit=new JButton("exit");
	//botonExit.setForeground(Color.blue); //color de la letra a azul en este caso (del boton)
	//botonExit.setBackground(Color.black); //color del fondo del boton
	botonExit.setBounds(300,350,100,30);
	add(botonExit);
	botonExit.addActionListener(this);
	}
private void muchoTexto(JTextField a) {
	a.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent e) {
			char c=e.getKeyChar();
			if(c<'0'||c>'9') { //aca se dice que si no esta entre 0 y 9 entra al if
				e.consume(); //y lo que hace es borrar la ultima letra precionada
			}
		}
	});
}

public static void main(String args[]) {
	Interfaz ventana=new Interfaz();
	primerInterfaz(ventana);
	salirApp(ventana);

	}

	
	//procesos
	public static void primerInterfaz(Interfaz ventana) {
		//Interfaz ventana=new Interfaz();
		//tamaño de la app (ej 800x600)
		ventana.setBounds(0, 0, 500, 480);
		ventana.setVisible(true);
		ventana.setLocationRelativeTo(null);
	}
	
	//fibonacci-------------------------------------------------------------------------- 
	public int fibonacci(int n)
	{
	    if (n>1){
	       return fibonacci(n-1) + fibonacci(n-2);  //agarra posiciones de n: osea n-1 es la posicion anterior, no n-1
	    }
	    else if (n==1) {  // caso base
	        return 1;
	    }
	    else if (n==0){  // caso base
	        return 0;
	    }
	    else{ //error
	        return -1;
	    }
	}
	// --------------------------------------------------------------------------------
	
	public static void salirApp(Interfaz ventana) {
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	//funcionalidad de botones
	public void agregarNum(ActionEvent e) {
		if(e.getSource()==boton1) {
			num2=cajaTexto.getText();
			cajaTexto.setText("");
			System.out.println(num2);
			mensaje2.setText("num2 es: "+num2);
		}
	}
	public void agregarNum2(ActionEvent e) {
		if(e.getSource()==boton2){
			num=cajaTexto.getText(); //guardo el Texto de la caja en una variable para utilizer
			cajaTexto.setText("");
			System.out.println(num);
			mensaje.setText("num es: "+num);
		}
	}
	public void funcionDeRestar(ActionEvent e) {
		if(e.getSource()==botonResta&&num!=null&&num2!=null) {
			int result=Integer.parseInt(num)-Integer.parseInt(num2);
			JOptionPane.showMessageDialog(null, "La resta es: "+result);
		}
		else if(e.getSource()==botonResta&&num==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num1 por favor.");
		}
		else if(e.getSource()==botonResta&&num2==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num2 por favor.");
		}
	}
	public void funcionDeSumar(ActionEvent e) {
		if(e.getSource()==botonSuma&&num!=null&&num2!=null) {
			int result=Integer.parseInt(num)+Integer.parseInt(num2);
			JOptionPane.showMessageDialog(null, "la suma es: "+result);
		}
		else if(e.getSource()==botonSuma&&num==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num1 por favor.");
		}
		else if(e.getSource()==botonSuma&&num2==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num2 por favor.");
		}
	}
	public void funcionDeMultiplicar(ActionEvent e) {
		if(e.getSource()==botonMultiplica&&num!=null&&num2!=null) {
			int result=Integer.parseInt(num)*Integer.parseInt(num2);
			JOptionPane.showMessageDialog(null, "la multiplicacion es: "+result);
		}
		else if(e.getSource()==botonMultiplica&&num==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num1 por favor.");
		}
		else if(e.getSource()==botonMultiplica&&num2==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num2 por favor.");
		}
	}
	public void funcionDeDividir(ActionEvent e) {
		if(e.getSource()==botonDivide&&num!=null&&num2!=null&&Integer.parseInt(num2)!=0) {
			float result=Float.parseFloat(num)/Float.parseFloat(num2);
			JOptionPane.showMessageDialog(null, "la divicion es: "+result);
		}
		else if(e.getSource()==botonDivide&&num==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num1 por favor.");
		}
		else if(e.getSource()==botonDivide&&num2==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num2 por favor.");
		}
		else if(e.getSource()==botonDivide&&Integer.parseInt(num2)==0) {
			JOptionPane.showMessageDialog(null, "no se puede dividir con denominador 0"
												+ "\npor favor utilice otro denominador");
		}
	}
	public void sucesionDeFibonacci(ActionEvent e) {
		if(e.getSource()==botonFibonacci&&num2==null&&num==null) {
			JOptionPane.showMessageDialog(null, "ingrese un num2 por favor.");
		}
		else if(e.getSource()==botonFibonacci&&num!=null&&num2==null) {
			JOptionPane.showMessageDialog(null, "guarde un num2 como final para la sucesion.");
		}
		else if(e.getSource()==botonFibonacci&&Integer.parseInt(num2)>=1) {
			
			String result;
			for(int j=0;j<Integer.parseInt(num2);j++) {
				System.out.print(fibonacci(j)+" ");
				result=Integer.toString(fibonacci(j));
				JOptionPane.showMessageDialog(null, result);	
				}
			}
		
		else if(e.getSource()==botonFibonacci&&Integer.parseInt(num2)<=0) {
			JOptionPane.showMessageDialog(null, "debe ingresar un num2 mayor o igual a 1 para realizar la susecion de fibonacci"
										+ "\n y su numero ingresado fue: "+Integer.parseInt(num2));
		}
	}
	public void funcionSalir(ActionEvent e) {
		if(e.getSource()==botonExit) {
			System.exit(0);
		}
	}
	
	@Override //activador de botones
	public void actionPerformed(ActionEvent e) {
		agregarNum(e);
		agregarNum2(e);
		funcionDeRestar(e);
		funcionDeSumar(e);
		funcionDeMultiplicar(e);
		funcionDeDividir(e);
		sucesionDeFibonacci(e);
		funcionSalir(e);
	}
}
