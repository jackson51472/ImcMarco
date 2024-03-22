import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {
    Pessoa pessoa;
    @BeforeEach
    void setUp() {
        pessoa = new Pessoa();
    }
    @Test
    void deveRetornarHomemAbaixoPeso() {
        pessoa.setSexo("Masculino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(20.6f);
        assertEquals("abaixo do peso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarHomemPesoNormal() {
        pessoa.setSexo("Masculino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(26.3f);
        assertEquals("no peso normal", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarHomemAcimaPeso() {
        pessoa.setSexo("Masculino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(27.7f);
        assertEquals("marginalmente acima do peso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarHomemAcimaPesoIdeal() {
        pessoa.setSexo("Masculino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(31f);
        assertEquals("acima do peso ideal", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarHomemObeso() {
        pessoa.setSexo("Masculino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(31.2f);
        assertEquals("Obeso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarMulherAbaixoPeso() {
        pessoa.setSexo("Feminino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(19f);
        assertEquals("abaixo do peso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarMulherPesoNormal() {
        pessoa.setSexo("Feminino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(25.7f);
        assertEquals("no peso normal", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarMulherAcimaPeso() {
        pessoa.setSexo("Feminino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(27.2f);
        assertEquals("marginalmente acima do peso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarMulherAcimaPesoIdeal() {
        pessoa.setSexo("Feminino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32.2f);
        assertEquals("acima do peso ideal", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarMulherObesa() {
        pessoa.setSexo("Feminino");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32.4f);
        assertEquals("Obeso", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarSexoInvalido() {
        pessoa.setSexo("Masculin");
        pessoa.setAltura(1.0f);
        pessoa.setPeso(32.4f);
        assertEquals("Sexo invalido", pessoa.verificarSaude());
    }
    @Test
    void deveRetornarPessoaCrianca(){
        pessoa.setIdade(11);
        assertEquals("Criança",pessoa.verificarVelhice());
    }
    @Test
    void deveRetornarPessoaAdolecente(){
        pessoa.setIdade(17);
        assertEquals("Adolescente",pessoa.verificarVelhice());
    }
    @Test
    void deveRetornarPessoaAdulta(){
        pessoa.setIdade(39);
        assertEquals("Adulto",pessoa.verificarVelhice());
    }
    @Test
    void deveRetornarPessoaSenhor(){
        pessoa.setIdade(59);
        assertEquals("Senhor",pessoa.verificarVelhice());
    }
    @Test
    void deveRetornarPessoaIdoso(){
        pessoa.setIdade(60);
        assertEquals("Idoso",pessoa.verificarVelhice());
    }
}