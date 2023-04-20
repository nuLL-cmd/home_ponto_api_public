package br.com.automatodev.homeponto.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity(name = "tb_job")
public class Job implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "id_job")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJob;
    
    @Column(name = "name_joib")
    @NotNull(message = "Nome do JOB não pode ser nulo.")
    @NotBlank(message = "Nome do JOB não pode estar em branco.")
    private String nameJob;

    @Column(name = "corporate_name")
    @NotNull(message = "Nome da empresa não pode ser nulo.")
    @NotBlank(message = "Nome da empresa não pode estar em branco.")
    private String corporateName;

    @NotNull(message = "Data de início no JOB não pode ser nula.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "dd-MM-yyy", timezone = "UTC")
    private Instant startJob;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =  "dd-MM-yyy", timezone = "UTC")
    private Instant endJob;
    
}
