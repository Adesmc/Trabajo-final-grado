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
    
 // Método para eliminar una nota por ID
    public boolean eliminarNota(Long id) {
        if (notasRepository.existsById(id)) {
            notasRepository.deleteById(id);
            return true;
        }
        return false;  // Retorna false si la nota no existe
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