package com.ulco.user.dto;

import com.ulco.user.enums.UserGenderEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@ApiModel("Utilisateur")
public class UserDTO {

    @Null(message = "L'id doit être vide.")
    @ApiModelProperty("Identifiant unique de l'utilisateur.")
    private Integer id;

    @Email(message = "Le mail n'a pas un format valide.")
    @NotBlank(message = "Le mail ne peut pas être vide.")
    @ApiModelProperty("Email de l'utilisateur.")
    private String email;

    @NotBlank(message = "Le prenom ne peut pas être vide.")
    @ApiModelProperty("Prenom de l'utilisateur.")
    private String firstname;

    @NotBlank(message = "Le nom ne peut pas être vide.")
    @ApiModelProperty("Nom de l'utilisateur.")
    private String lastname;

    @NotNull(message = "Le sexe doit être M ou F.")
    @ApiModelProperty("Sexe de l'utilisateur.")
    private UserGenderEnum gender;
}
