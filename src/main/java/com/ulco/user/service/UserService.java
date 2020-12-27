package com.ulco.user.service;

import com.ulco.user.dto.UserDTO;
import com.ulco.user.exception.NotFoundException;
import com.ulco.user.mapper.IUserMapper;
import com.ulco.user.model.UserDO;
import com.ulco.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDTO findById(final Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toUserDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO save(final UserDTO userDTO) {
        final UserDO userToCreate = userMapper.toUserDO(userDTO);
        final UserDO createdUser = userRepository.save(userToCreate);

        return userMapper.toUserDTO(createdUser);
    }

    @Override
    public void update(final Integer id, final UserDTO userDTO) {
        findById(id);

        UserDO userToUpdate = userMapper.toUserDO(userDTO);
        userToUpdate.setId(id);

        userRepository.save(userToUpdate);
    }

    @Override
    public void deleteById(final Integer id) {
        findById(id);
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

}
