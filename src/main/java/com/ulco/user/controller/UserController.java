package com.ulco.user.controller;

import com.ulco.user.dto.UserDTO;
import com.ulco.user.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Controller REST pour la gestion des utilisateurs.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    @ApiOperation("Récupérer tous les utilisateurs.")
    public List<UserDTO> getAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Récupérer un utilisateur.")
    public UserDTO findById(@PathVariable final Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    @ApiOperation("Créer un utilisateur.")
    public ResponseEntity<Void> save(@RequestBody @Valid final UserDTO userDTO) {
        final UserDTO createdUser = userService.save(userDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour un utilisateur.")
    public void update(@PathVariable final Integer id, @RequestBody @Valid final UserDTO userDTO) {
        userService.update(id, userDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Supprime tous les utilisateurs.")
    public void deleteAll() {
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Supprimer un utilisateur.")
    public void deleteOne(@PathVariable final Integer id) {
        userService.deleteById(id);
    }
}
