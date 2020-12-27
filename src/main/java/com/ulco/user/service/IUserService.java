package com.ulco.user.service;

import com.ulco.user.dto.UserDTO;

import java.util.List;

/**
 * Interface de gestion pour les utilisateurs.
 */
public interface IUserService {

    /**
     * Retourne l'utilisateur correspondant à l'id.
     *
     * @param id Id de l'utilisateur recherché.
     * @return L'utilisateur correspondant si il existe.
     */
    UserDTO findById(final Integer id);

    /**
     * Permet de récupérer tous les utilisateurs.
     *
     * @return La liste de tous les utilisateurs.
     */
    List<UserDTO> findAll();

    /**
     * Permet la création d'un utilisateur.
     *
     * @param userDTO L'utilisateur que l'on souhaite créer.
     * @return L'utilisateur nouvellement créé.
     */
    UserDTO save(final UserDTO userDTO);

    /**
     * Permet la mise à jour d'un utilisateur.
     *
     * @param id      L'id de l'utilisateur que l'on souhaite modifier.
     * @param userDTO Les attributs du nouvel utilisateur.
     */
    void update(final Integer id, final UserDTO userDTO);

    /**
     * Permet la suppression d'un utilisateur par son id.
     *
     * @param id L'id de l'utilisateur que l'on souhaite supprimer.
     */
    void deleteById(final Integer id);

    /**
     * Suppression de tous les utilisateurs.
     */
    void deleteAll();
}
