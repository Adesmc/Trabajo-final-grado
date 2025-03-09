package project.notas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private NotasService notasService;

    // Endpoint para guardar una nueva nota
    @PostMapping("/guardar")
    public ResponseEntity<Notas> guardarNota(@RequestBody Notas nota) {
        Notas nuevaNota = notasService.guardarNota(nota);
        return ResponseEntity.ok(nuevaNota);
    }
    
 // Método para eliminar una nota por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNota(@PathVariable Long id) {
        boolean eliminado = notasService.eliminarNota(id);
        if (!eliminado) {
            return ResponseEntity.notFound().build();  // Retorna 404 si la nota no existe
        }
        return ResponseEntity.noContent().build();  // Retorna 204 si la eliminación fue exitosa
    }
    
 // Método para actualizar una nota
    @PutMapping("/{id}")
    public ResponseEntity<Notas> actualizarNota(@PathVariable Long id, @RequestBody Notas nuevaNota) {
        // Llamamos al servicio para actualizar la nota
        Notas notaActualizada = notasService.actualizarNota(id, nuevaNota);
        if (notaActualizada == null) {
            return ResponseEntity.notFound().build();  // Retorna 404 si no se encuentra la nota
        }
        return ResponseEntity.ok(notaActualizada);  // Retorna 200 y la nota actualizada
    }
}