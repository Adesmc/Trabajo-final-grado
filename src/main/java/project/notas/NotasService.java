package project.notas;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotasService {
    
    @Autowired
    private NotasRepository notasRepository;

    // Método para guardar una nueva nota
    public Notas guardarNota(Notas nota) {
        return notasRepository.save(nota);
    }
    
    public boolean eliminarNota(Long id, String correoUsuarioAutenticado) {
        Optional<Notas> notaOptional = notasRepository.findById(id);
        if (notaOptional.isPresent()) {
            Notas nota = notaOptional.get();
            
            // Verificar si el correo electrónico de la nota coincide con el del usuario autenticado
            if (!nota.getCorreoElectronico().equals(correoUsuarioAutenticado)) {
                return false; // Si no coinciden, no eliminar
            }

            // Si la validación es correcta, proceder a eliminar la nota
            notasRepository.deleteById(id);
            return true;
        }
        return false; // Si la nota no existe
    }
    
 // Método para actualizar una nota
    public Notas actualizarNota(Long id, Notas nuevaNota) {
        Optional<Notas> notaExistenteOpt = notasRepository.findById(id);  // Buscar la nota por su ID
        if (notaExistenteOpt.isPresent()) {
            Notas notaExistente = notaExistenteOpt.get();

            // Actualizar los campos de la nota existente con los nuevos datos
            notaExistente.setTitulo(nuevaNota.getTitulo());
            notaExistente.setCampanya(nuevaNota.getCampanya());
            notaExistente.setDescripcion(nuevaNota.getDescripcion());
            notaExistente.setCategoria(nuevaNota.getCategoria());
            notaExistente.setDia(nuevaNota.getDia());
            notaExistente.setSesiones(nuevaNota.getSesiones());
            notaExistente.setHora(nuevaNota.getHora());
            notaExistente.setSubcategoria(nuevaNota.getSubcategoria());
            notaExistente.setIcono(nuevaNota.getIcono());

            // Guardar la nota actualizada
            return notasRepository.save(notaExistente);
        } else {
            return null;  // Si no se encuentra la nota, devolvemos null
        }
    }
}