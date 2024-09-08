package br.com.ms_beutique_query.services;

import br.com.ms_beutique_query.dtos.appointments.FullAppointmentDTO;

import java.util.List;

public interface AppointmentService {

    List<FullAppointmentDTO> listAllAppointments();
    List<FullAppointmentDTO> ListAllAppointmentsByCustomer(Long customerId);
    List<FullAppointmentDTO> listAllAppointmentsByBeautyProcedure(Long beautyProcedureId);

}
