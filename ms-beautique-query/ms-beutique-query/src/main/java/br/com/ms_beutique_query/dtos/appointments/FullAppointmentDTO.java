package br.com.ms_beutique_query.dtos.appointments;

import br.com.ms_beutique_query.dtos.beautyprocedures.BeautyProcedureDTO;
import br.com.ms_beutique_query.dtos.customers.CustomerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "appointments")
public class FullAppointmentDTO {
    private Long id;
    private LocalDateTime dateTime;
    private Boolean appointmentsOpen;

    private CustomerDTO customer;
    private BeautyProcedureDTO beautyProcedure;
}
