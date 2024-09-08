package br.com.ms_beutique_query.services.impl;

import br.com.ms_beutique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beutique_query.repositories.AppointmentRepository;
import br.com.ms_beutique_query.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointments() {
        try{
            return appointmentRepository.findAll();
        }catch (Exception e){
          throw new RuntimeException("Error listing all appointments");
        }
    }

    @Override
    public List<FullAppointmentDTO> ListAllAppointmentsByCustomer(Long customerId) {
        try{
            return appointmentRepository.listAppointmentsByCustomerId(customerId);
        }catch (Exception e){
            throw new RuntimeException("Error listint all appointments by customer");
        }
    }

    @Override
    public List<FullAppointmentDTO> listAllAppointmentsByBeautyProcedure(Long beautyProcedureId) {
        try{
            return appointmentRepository.listAppointmentsByBeautyProcedureId(beautyProcedureId);
        }catch (Exception e){
            throw new RuntimeException("Error listint all appointments by beauty procedure");
        }
    }
}
