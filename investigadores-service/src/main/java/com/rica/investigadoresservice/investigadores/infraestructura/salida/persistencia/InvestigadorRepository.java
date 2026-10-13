package com.rica.investigadoresservice.investigadores.infraestructura.salida.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rica.investigadoresservice.investigadores.dominio.CorreoInstitucional;
import com.rica.investigadoresservice.investigadores.dominio.Investigador;

public interface InvestigadorRepository extends JpaRepository<Investigador, Long> {

    boolean existsByCorreoInstitucional_Valor(String valor);

    Investigador findByCorreoInstitucional(CorreoInstitucional correoInstitucional);
}
