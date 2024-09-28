package pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaRequestDTO;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaResponseDTO;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.service.PlacaService;

import java.io.IOException;

@RestController
@RequestMapping("/consultar")
public class ConsultaPlacaController {

    @Autowired
    private PlacaService placaService;

    @PostMapping("/placa")
    public PlacaResponseDTO consultarPlaca(@RequestBody PlacaRequestDTO placaRequestDTO) {
        try {

            PlacaResponseDTO placaResponseDTO = placaService.consultarPlaca(placaRequestDTO);
            if (placaResponseDTO != null) {
                return placaResponseDTO;
            } else {

                return new PlacaResponseDTO("Error", "No se encontró la placa", "", "", ""); // Manejo de error
            }
        } catch (IOException e) {

            return new PlacaResponseDTO("Error", "Ocurrió un error al consultar la placa", "", "", "");
        }
    }
}
