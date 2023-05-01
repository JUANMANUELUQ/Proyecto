package co.uniquindio.proyecto.model;

public enum Transmision {
	
	AUTOMATICA(0), MANUAL(1);
	
	int valor;
	
	Transmision (int valor){
		this.valor = valor;
	}
	
	
	// CONSTRUCTOR
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
