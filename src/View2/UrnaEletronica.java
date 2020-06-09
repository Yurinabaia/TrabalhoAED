package View2;

public class UrnaEletronica 
{	
	private String NomeCandidato;
	private String NumeroCandidato;
	private String Municipio;
	private String Partido;
	private String cargo;
	public String getNomeCandidato() {
		return NomeCandidato;
	}
	public void setNomeCandidato(String nomeCandidato) {
		NomeCandidato = nomeCandidato;
	}
	public String getNumeroCandidato() {
		return NumeroCandidato;
	}
	public void setNumeroCandidato(String numeroCandidato) {
		NumeroCandidato = numeroCandidato;
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
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public UrnaEletronica(String nomeC, String numC, String municipioC, String partidoC, String cargoC) 
	{
		NomeCandidato = nomeC;
		NumeroCandidato = numC;
		Municipio = municipioC;
		Partido = partidoC;
		cargo = cargoC;
		
	}
	public UrnaEletronica() 
	{
		
	}
}
