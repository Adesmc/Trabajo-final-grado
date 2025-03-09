package project.multimedia;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultimediaService {
  



        @Autowired
        private MultimediaRepository multimediaRepository;

        public Multimedia guardarArchivo(String descripcion, String correoElectronico, String tipoArchivo, byte[] archivo) {
            // Crear una nueva instancia de Multimedia con los parámetros proporcionados
            Multimedia multimedia = new Multimedia();
            multimedia.setDescripcion(descripcion);
            multimedia.setCorreoElectronico(correoElectronico);
            multimedia.setTipoArchivo(tipoArchivo);
            multimedia.setArchivo(archivo);

            // Guardar el archivo en la base de datos
            return multimediaRepository.save(multimedia);
        }

  
        public List<Multimedia> obtenerArchivosPorUsuarioYTipo(String correoElectronico, String tipoArchivo) {
            return multimediaRepository.findByCorreoElectronicoAndTipoArchivo(correoElectronico, tipoArchivo);
        }
        
        public boolean eliminarArchivo(Long id, String correoElectronico) {
            Optional<Multimedia> archivo = multimediaRepository.findById(id);
            if (archivo.isPresent() && archivo.get().getCorreoElectronico().equals(correoElectronico)) {
                multimediaRepository.deleteById(id);
                return true;
            }
            return false; 
        }
	


}
