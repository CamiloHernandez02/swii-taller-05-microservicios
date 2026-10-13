package com.rica.investigadoresservice.investigadores.aplicacion;
import org.junit.jupiter.api.Test;
import com.rica.investigadoresservice.investigadores.aplicacion.InvestigadorFactory;
import com.rica.investigadoresservice.investigadores.aplicacion.InvestigadorService;
import com.rica.investigadoresservice.investigadores.dominio.Investigador;

import static org.assertj.core.api.Assertions.assertThat;

class InvestigadorServiceConFalsoTest {

    @Test
    void registraYRecuperaUnInvestigadorSinNingunaDependenciaDeSpringNiDeBaseDeDatos() {
        RepositorioInvestigadoresFalso repositorio = new RepositorioInvestigadoresFalso();
        InvestigadorFactory factory = new InvestigadorFactory(repositorio);
        InvestigadorService service = new InvestigadorService(repositorio, factory);

        Investigador guardado = service.registrar("Ana Torres", "ana.torres@uptc.edu.co", "GIT-UPTC");

        assertThat(guardado.getId()).isNotNull();
        assertThat(service.buscarPorId(guardado.getId()).getNombreCompleto()).isEqualTo("Ana Torres");
    }
}
