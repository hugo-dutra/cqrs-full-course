package br.com.beautique.api.services.impl;


import br.com.beautique.api.dtos.BeautyProcedureDTO;
import br.com.beautique.api.entities.BeautyProceduresEntity;
import br.com.beautique.api.repositories.BeautyProcedureRepository;
import br.com.beautique.api.services.BeautyProcedureService;
import br.com.beautique.api.services.BrokerService;
import br.com.beautique.api.utils.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BeautyProcedureServiceImpl implements BeautyProcedureService {

    @Autowired
    private BeautyProcedureRepository beautyProcedureRepository;

    @Autowired
    private BrokerService brokerService;

    private final ConverterUtil<BeautyProceduresEntity, BeautyProcedureDTO> converterUtil = new ConverterUtil<>(BeautyProceduresEntity.class, BeautyProcedureDTO.class);

    @Override
    public BeautyProcedureDTO create(BeautyProcedureDTO beautyProcedureDTO) {
        BeautyProceduresEntity beautyproceduresEntity = converterUtil.convertToSource(beautyProcedureDTO);
        BeautyProceduresEntity newBeautyProceduresEntity = beautyProcedureRepository.save(beautyproceduresEntity);
        sendBeautyProceduresToQueue(newBeautyProceduresEntity);
        return converterUtil.convertToTarget(newBeautyProceduresEntity);
    }

    @Override
    public void delete(Long id) {
        Optional<BeautyProceduresEntity> beautyProceduresEntityOptional = beautyProcedureRepository.findById(id);
        if(beautyProceduresEntityOptional.isEmpty()){
            throw new RuntimeException("Beauty Procedure not found");
        }
        beautyProcedureRepository.deleteById(id);
    }

    @Override
    public BeautyProcedureDTO update(BeautyProcedureDTO beautyProcedureDTO) {
        Optional<BeautyProceduresEntity> beautyProceduresEntityOptional = beautyProcedureRepository.findById(beautyProcedureDTO.getId());
        if(beautyProceduresEntityOptional.isEmpty()){
            throw new RuntimeException("Beauty Procedure not found");
        }
        BeautyProceduresEntity beautyProceduresEntity = converterUtil.convertToSource(beautyProcedureDTO);
        beautyProceduresEntity.setAppointments(beautyProceduresEntityOptional.get().getAppointments());
        beautyProceduresEntity.setCreatedAt(beautyProceduresEntityOptional.get().getCreatedAt());

        BeautyProceduresEntity updatedBeautyProcedureEntity = beautyProcedureRepository.save(beautyProceduresEntity);

        sendBeautyProceduresToQueue(updatedBeautyProcedureEntity);

        return converterUtil.convertToTarget(updatedBeautyProcedureEntity);
    }

    private void sendBeautyProceduresToQueue(BeautyProceduresEntity beautyProceduresEntity){
            BeautyProcedureDTO beautyProcedureDTO = BeautyProcedureDTO.builder()
                    .id(beautyProceduresEntity.getId())
                    .name(beautyProceduresEntity.getName())
                    .description(beautyProceduresEntity.getDescription())
                    .price(beautyProceduresEntity.getPrice())
                    .build();
            brokerService.send("beautyProcedures", beautyProcedureDTO);
    }

}
