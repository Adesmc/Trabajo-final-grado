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
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarNota(@PathVariable Long id, @RequestParam String correo) {
        // Validar la eliminación de la nota
        boolean eliminado = notasService.eliminarNota(id, correo);
        if (!eliminado) {
            return ResponseEntity.status(404).body("No tienes permiso para eliminar esta nota o no existe.");
        }

        return ResponseEntity.ok("Archivo eliminado correctamente.");
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