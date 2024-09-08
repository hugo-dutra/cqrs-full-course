package br.com.beautique.ms_sync.services;

import br.com.beautique.ms_sync.dtos.appointments.FullAppointmentDTO;
import br.com.beautique.ms_sync.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.beautique.ms_sync.dtos.customers.CustomerDTO;

public interface AppointmentService {
    void saveAppointment(FullAppointmentDTO appointment);
    void updateAppointmentCustomer(CustomerDTO customer);
    void updateAppointmentBeautyProcedures(BeautyProcedureDTO beautyProcedureDTO);
}
