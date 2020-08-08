package present.verb.perfil.dominio.repositorio;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import present.verb.perfil.aplicacion.consulta.model.PerfilDto;
import present.verb.perfil.dominio.entidad.Perfil;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Long> {

	@Transactional(readOnly = true)
	@Query("SELECT " + "p.id as id," + "p.ultimoIndiceAprendido as ultimoIndiceAprendido,"
			+ "p.repeticionesAltaComoAprendido as repeticionesAltaComoAprendido,"
			+ "p.numeroVerbosPorAprenderDiario as numeroVerbosPorAprenderDiario,"
			+ "p.ultimaFechaAprendio as ultimaFechaAprendio," 
			+ "p.esPreguntaRespuesta as esPreguntaRespuesta" + " FROM Temas p where p.perfil = ?1 and p.nombre=?2")
	PerfilDto obtenerPerfil(Perfil id, String hojaTemaExcel);

	@Transactional
	@Modifying
	@Query("update Temas SET ultimoIndiceAprendido = :ultimoIndiceAprendido, ultimaFechaAprendio=:ultimaFechaAprendio WHERE nombre=:nombre and perfil=:id")
	void actualizar(@Param("id") Perfil id, @Param("nombre") String nombre,
			@Param("ultimoIndiceAprendido") int ultimoIndiceAprendido,
			@Param("ultimaFechaAprendio") LocalDate ultimaFechaAprendio);

	@Transactional
	@Modifying
	@Query("update Temas SET ultimaFechaRutina = :ultimaFechaRutina WHERE perfil=:perfil and nombre=:nombre")
	void actualizarUltimaFechaRutina(@Param("perfil") Perfil perfil,@Param("nombre") String nombre,
			@Param("ultimaFechaRutina") LocalDate ultimaFechaRutina);

	Perfil findByCorreo(String correo);
	
}
