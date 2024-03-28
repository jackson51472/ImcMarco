public class Pessoa {

    private double peso;
    private double altura;

    private String sexo;
    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    private Integer idade;

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public double calculaIMC(){

        return peso / (Math.pow(altura, 2));

    }

    public String verificarVelhice(){
        if (this.idade < 12){
            return "Criança";
        } else if (this.idade < 18) {
            return "Adolescente";
        } else if (this.idade < 40) {
            return "Adulto";
        } else if (this.idade < 60) {
            return "Senhor";
        } else {
            return "Idoso";
        }

    }

    public String verificarSaude(){
        if(this.sexo == null || !this.sexo.equals("Masculino") && !this.sexo.equals("Feminino")){
            throw new NullPointerException("Sexo Invalido");
        }
        if (this.peso == 0.0f){
            throw new IllegalArgumentException("Peso não digitado!!!");
        }
        if (this.altura == 0.0f){
            throw new IllegalArgumentException("Altura não digitada!!!");
        }
        double imc = calculaIMC();

    if (this.sexo.equals("Masculino")){
        if (imc < 20.7 ){
            return "abaixo do peso";
        }
        else if (imc < 26.4) {
            return "no peso normal";
        }
        else if (imc < 27.8) {
            return "marginalmente acima do peso";
        }
        else if (imc < 31.1) {
            return "acima do peso ideal";
        }
        else return "Obeso";
    }
    else if (this.sexo.equals("Feminino")) {
        if (imc < 19.1 ){
            return "abaixo do peso";
        }
        else if (imc < 25.8) {
            return "no peso normal";
        }
        else if (imc < 27.3) {
            return "marginalmente acima do peso";
        }
        else if (imc < 32.3) {
            return "acima do peso ideal";
        }
        else return "Obeso";
    }
    return null;
    }


}