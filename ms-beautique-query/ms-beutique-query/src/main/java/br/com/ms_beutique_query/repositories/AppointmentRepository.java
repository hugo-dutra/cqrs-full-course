package br.com.ms_beutique_query.repositories;

import br.com.ms_beutique_query.dtos.appointments.FullAppointmentDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<FullAppointmentDTO, Long> {

    @Query("{ 'customerId' : ?0}")
    List<FullAppointmentDTO> listAppointmentsByCustomerId(Long customerId);
    @Query("{ 'beautyProcedureId' : ?0}")
    List<FullAppointmentDTO> listAppointmentsByBeautyProcedureId(Long beautyProcedureId);

}
