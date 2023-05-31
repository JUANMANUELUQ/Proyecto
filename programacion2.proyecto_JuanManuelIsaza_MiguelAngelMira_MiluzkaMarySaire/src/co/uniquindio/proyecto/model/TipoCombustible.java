package co.uniquindio.proyecto.model;

public enum TipoCombustible {
	
	GASOLINA(0),DIESEL(1),ELECTRICO(2),HIBRIDO(3);
	
	int valor;
	
	TipoCombustible (int valor){
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
