public class parCodificado {
	private int simbolo;
	private int longSecuencia;
	public parCodificado(int simbolo) {
		this.simbolo = simbolo;
		this.longSecuencia = 0;
	}
	public int getSimbolo() {
		return this.simbolo;
	}
	public int getLongSecuencia() {
		return this.longSecuencia;
	}
	public void aumentarSecuencia() {
		this.longSecuencia++;
	}
	
}
