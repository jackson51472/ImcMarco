import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {

    Funcionario funcionario;
    @BeforeEach
    void setUp() {
        funcionario = new Funcionario();
    }
    @Test
    void deveRetornarSalarioCorreto(){
        funcionario.setSalario(1000f);
        funcionario.setValorHoraExtra(10f);
        funcionario.setHorario(10);
        assertEquals(1100f, funcionario.calculaSalario());
    }
}