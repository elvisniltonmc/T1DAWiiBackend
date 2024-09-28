package pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.service;

import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaRequestDTO;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaResponseDTO;

import java.io.IOException;

public interface PlacaService {


    PlacaResponseDTO consultarPlaca(PlacaRequestDTO placaRequestDTO) throws IOException;
}
