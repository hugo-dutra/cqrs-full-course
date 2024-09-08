package br.com.ms_beutique_query.controllers;


import br.com.ms_beutique_query.dtos.appointments.FullAppointmentDTO;
import br.com.ms_beutique_query.services.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    @GetMapping()
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointments(){
        return ResponseEntity.ok(appointmentService.listAllAppointments());
    }

    @GetMapping("/customer/{customerId}")
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointmentsByCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(appointmentService.ListAllAppointmentsByCustomer(customerId));
    }

    @GetMapping("/beauty-procedure/{beautyProcedureId}")
    ResponseEntity<List<FullAppointmentDTO>> listAllAppointmentsByBeautyProcedure(@PathVariable Long beautyProcedureId){
        return ResponseEntity.ok(appointmentService.listAllAppointmentsByBeautyProcedure(beautyProcedureId));
    }


}
