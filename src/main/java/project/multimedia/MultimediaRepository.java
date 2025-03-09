package project.multimedia;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;


@Repository
public interface MultimediaRepository extends JpaRepository<Multimedia, Long>{

	

	 List<Multimedia> findByCorreoElectronico(String correoElectronico);
	 
	 List<Multimedia> findByCorreoElectronicoAndTipoArchivo(String correoElectronico, String tipoArchivo);

	}


