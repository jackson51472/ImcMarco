public class Funcionario extends Pessoa {

    private String nome;
    private Float valorHoraExtra;
    private Float salario;
    private Integer horario;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Float getValorHoraExtra() {
        return valorHoraExtra;
    }
    public void setValorHoraExtra(Float valorHoraExtra) {
        this.valorHoraExtra = valorHoraExtra;
    }
    public Integer getHorario() {
        return horario;
    }
    public void setHorario(Integer horario) {
        this.horario = horario;
    }
    public Float getSalario() {
        return salario;
    }
    public void setSalario(Float salario) {
        this.salario = salario;
    }
    public Float calculaHoraExtra(){
        return this.valorHoraExtra * this.horario;
    }
    public Float calculaSalario(){

        return this.salario = this.salario + calculaHoraExtra();
    }

}
