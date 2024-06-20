package com.example.demo.model.entity;//


public class Pessoa implements IPessoa{
    private double peso;
    private double altura;
    private String sexo;
    private Integer idade;

    public Pessoa() {
    }

    public Integer getIdade() {
        return this.idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getSexo() {
        return this.sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double calculaIMC() {
        return this.peso / Math.pow(this.altura, 2.0);
    }


    public String verificarSaude() {
        if (this.sexo != null && (this.sexo.equals("Masculino") || this.sexo.equals("Feminino"))) {
            if (this.peso == 0.0) {
                throw new IllegalArgumentException("Peso não digitado!!!");
            } else if (this.altura == 0.0) {
                throw new IllegalArgumentException("Altura não digitada!!!");
            } else {
                double imc = this.calculaIMC();
                if (this.sexo.equals("Masculino")) {
                    if (imc < 20.7) {
                        return "abaixo do peso";
                    } else if (imc < 26.4) {
                        return "no peso normal";
                    } else if (imc < 27.8) {
                        return "marginalmente acima do peso";
                    } else {
                        return imc < 31.1 ? "acima do peso ideal" : "Obeso";
                    }
                } else if (this.sexo.equals("Feminino")) {
                    if (imc < 19.1) {
                        return "abaixo do peso";
                    } else if (imc < 25.8) {
                        return "no peso normal";
                    } else if (imc < 27.3) {
                        return "marginalmente acima do peso";
                    } else {
                        return imc < 32.3 ? "acima do peso ideal" : "Obeso";
                    }
                } else {
                    return null;
                }
            }
        } else {
            throw new NullPointerException("Sexo Invalido");
        }
    }
}
