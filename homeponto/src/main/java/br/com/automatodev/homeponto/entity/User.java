package br.com.automatodev.homeponto.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "tb_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;
    
    @Column(name = "id_user")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "user_uid")
    @NotNull(message = "Atributo userUid não pode ser nulo.")
    @NotBlank(message = "Atributo userUid não pode estar em branco.")
    private String userUid;

    @Column(name = "name")
    @NotNull(message = "Atributo name não pode ser nulo.")
    @NotBlank(message = "Atributo name não pode estar em branco.")
    private String name;

    @Column(name = "url_avatar")
    private String urlAvatar;
    
    @Column(name = "email")
    @NotNull(message = "Atributo email não pode ser nulo")
    @NotBlank(message = "Atributo email não pode estar em branco")
    @Email
    private String email;
    
    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_user")
    private List<Job> jobs;

     /* ------------------------------------------------------------------------------------------------------*/
     
    public void addJobs(Job job) {

        if(Objects.isNull(jobs)) {

            this.jobs = new ArrayList<>();
        }

        jobs.add(job);
    }

    /* ------------------------------------------------------------------------------------------------------*/
}
