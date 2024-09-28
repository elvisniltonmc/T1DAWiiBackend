package pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaRequestDTO;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.dto.PlacaResponseDTO;
import pe.edu.cibertec.EvaluacionT1DAW_ManchaBackEnd.service.PlacaService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class PlacaServiceImpl implements PlacaService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public PlacaResponseDTO consultarPlaca(PlacaRequestDTO placaRequestDTO) throws IOException {
        PlacaResponseDTO placaResponseDTO = null;
        Resource resource = resourceLoader.getResource("classpath:placas.txt"); // Suponiendo que tus datos de placas están en este archivo

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";"); // Suponiendo que los datos están separados por punto y coma

                if (placaRequestDTO.placa().equals(datos[0])) { // Verifica si la placa coincide
                    placaResponseDTO = new PlacaResponseDTO(datos[1], datos[2], datos[3], datos[4], datos[5]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        if (placaResponseDTO == null) {
            throw new IOException("Placa no encontrada");
        }

        return placaResponseDTO;
    }
}
