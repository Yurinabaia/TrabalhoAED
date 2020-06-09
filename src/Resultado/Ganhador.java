package Resultado;

public class Ganhador implements Comparable<Ganhador> 
{
	private String Nome;
	private String Numero;
	private String Municipio;
	private String Partido;
	private String Cargo;
	private int Votos;
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		this.Nome = nome;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		this.Numero = numero;
	}
	public String getMunicipio() {
		return Municipio;
	}
	public void setMunicipio(String municipio) {
		Municipio = municipio;
	}
	public String getPartido() {
		return Partido;
	}
	public void setPartido(String partido) {
		Partido = partido;
	}
	public String getCargo() {
		return Cargo;
	}
	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	public int getVotos() {
		return Votos;
	}
	public void setVotos(int votos) {
		this.Votos = votos;
	}
	
	public Ganhador(String nome, String numero, String municipio, String partido, String cargo, int votos  ) 
	{
		super();
		Nome = nome;
		Numero = numero;
		Municipio = municipio;
		Partido = partido;
		Cargo = cargo;
		Votos = votos;
	}
	
	public int compareTo(Ganhador votosP) 
	{
			if(this.Votos > votosP.Votos){
			return -1;
			}
			else if(this.Votos < votosP.Votos){
			return 1;
			}
			return this.getNome().compareToIgnoreCase(votosP.getNome());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Nome + ";" + Numero + ";" + Municipio + ";" + Partido + ";" + Cargo + ";" + Integer.toString(Votos);
	}
		
}
