package project.multimedia;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.core.io.Resource;

@RestController
@RequestMapping("/sonidos")
public class MultimediaController {

	
	@Autowired
	private MultimediaService multimediaService;

	 // Método para subir un archivo
    @PostMapping("/subir")
    public ResponseEntity<String> subirArchivo(
            @RequestParam String descripcion,
            @RequestParam String correoElectronico,
            @RequestParam String tipoArchivo,
            @RequestParam MultipartFile archivo) {
        
        try {
            // Obtener los bytes del archivo
            byte[] archivoBytes = archivo.getBytes();
            
            // Llamar al servicio para guardar el archivo
            Multimedia multimedia = multimediaService.guardarArchivo(descripcion, correoElectronico, tipoArchivo, archivoBytes);
            
            return new ResponseEntity<>("Archivo subido correctamente con ID: " + multimedia.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al subir el archivo: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @GetMapping("/buscar")
    public List<Multimedia> buscarArchivos(@RequestParam String correoElectronico, @RequestParam String tipoArchivo) {
        return multimediaService.obtenerArchivosPorUsuarioYTipo(correoElectronico, tipoArchivo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarArchivo(@PathVariable Long id, @RequestParam String correoElectronico) {
        boolean eliminado = multimediaService.eliminarArchivo(id, correoElectronico);
        if (eliminado) {
            return ResponseEntity.ok("Archivo eliminado correctamente.");
        } else {
            return ResponseEntity.status(403).body("No tienes permiso para eliminar este archivo o no existe.");
        }
    }
	 }
