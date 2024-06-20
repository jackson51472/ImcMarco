package com.example.demo.model.entity;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PessoaTest {
    private IPessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = EasyMock.createMock(IPessoa.class);
    }

    @Test
    void deveRetornarHomemAbaixoPeso() {
        EasyMock.expect(pessoa.getSexo()).andReturn("Masculino").anyTimes();
        EasyMock.expect(pessoa.getAltura()).andReturn(1.75).anyTimes();
        EasyMock.expect(pessoa.getPeso()).andReturn(55.0).anyTimes();
        EasyMock.expect(pessoa.calculaIMC()).andReturn(17.96).anyTimes();
        EasyMock.expect(pessoa.verificarSaude()).andReturn("Abaixo do peso");

        EasyMock.replay(pessoa);

        Assertions.assertEquals("Abaixo do peso", pessoa.verificarSaude());
        EasyMock.verify(pessoa);
    }

    @Test
    void deveRetornarHomemPesoNormal() {
        this.pessoa.setSexo("Masculino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(26.299999237060547);
        Assertions.assertEquals("no peso normal", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarHomemAcimaPeso() {
        this.pessoa.setSexo("Masculino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(27.700000762939453);
        Assertions.assertEquals("marginalmente acima do peso", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarHomemAcimaPesoIdeal() {
        this.pessoa.setSexo("Masculino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(31.0);
        Assertions.assertEquals("acima do peso ideal", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarHomemObeso() {
        this.pessoa.setSexo("Masculino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(31.200000762939453);
        Assertions.assertEquals("Obeso", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarMulherAbaixoPeso() {
        this.pessoa.setSexo("Feminino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(19.0);
        Assertions.assertEquals("abaixo do peso", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarMulherPesoNormal() {
        this.pessoa.setSexo("Feminino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(25.700000762939453);
        Assertions.assertEquals("no peso normal", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarMulherAcimaPeso() {
        this.pessoa.setSexo("Feminino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(27.200000762939453);
        Assertions.assertEquals("marginalmente acima do peso", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarMulherAcimaPesoIdeal() {
        this.pessoa.setSexo("Feminino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(32.20000076293945);
        Assertions.assertEquals("acima do peso ideal", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarMulherObesa() {
        this.pessoa.setSexo("Feminino");
        this.pessoa.setAltura(1.0);
        this.pessoa.setPeso(32.400001525878906);
        Assertions.assertEquals("Obeso", this.pessoa.verificarSaude());
    }

    @Test
    void deveRetornarSexoInvalido() {
        try {
            this.pessoa.setSexo("gg");
            this.pessoa.verificarSaude();
            Assertions.fail();
        } catch (NullPointerException var2) {
            Assertions.assertEquals("Sexo Invalido", var2.getMessage());
        }

    }

    @Test
    void deveRetornarPesoNaoDigitado() {
        try {
            this.pessoa.setSexo("Masculino");
            this.pessoa.verificarSaude();
            Assertions.fail();
        } catch (IllegalArgumentException var2) {
            Assertions.assertEquals("Peso não digitado!!!", var2.getMessage());
        }

    }

    @Test
    void deveRetornarAlturaNaoDigitada() {
        try {
            this.pessoa.setSexo("Masculino");
            this.pessoa.setPeso(27.700000762939453);
            this.pessoa.verificarSaude();
            Assertions.fail();
        } catch (IllegalArgumentException var2) {
            Assertions.assertEquals("Altura não digitada!!!", var2.getMessage());
        }

    }

}
