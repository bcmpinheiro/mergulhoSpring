package com.algaworks.algalog.assembler;

import com.algaworks.algalog.domain.model.Incident;
import com.algaworks.algalog.model.IncidentModel;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class IncidentAssembler {

    private ModelMapper modelMapper;

    public IncidentModel toModel (Incident incident) {
        return modelMapper.map(incident, IncidentModel.class);
    }

    public List<IncidentModel> toCollectionModel (List<Incident> incidents) {
        return incidents.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
