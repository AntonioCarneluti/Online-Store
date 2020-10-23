package com.sda.onlinestore.service;

import com.sda.onlinestore.dto.AddressDto;
import com.sda.onlinestore.dto.UserDto;
import com.sda.onlinestore.model.AddressModel;
import com.sda.onlinestore.model.UserModel;
import com.sda.onlinestore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDto userDto) {
        UserModel userModel = new UserModel();
        userModel.setEmail(userDto.getEmail());
        userModel.setUsername(userDto.getUsername());
        userModel.setPassword(userDto.getPassword());


        AddressModel addressModel = new AddressModel();
        AddressDto addressDto = userDto.getAddressDto();
        if(addressDto != null) {
            addressModel.setCountry(addressDto.getCountry());
            addressModel.setCity(addressDto.getCity());
            addressModel.setStreet(addressDto.getStreet());
            addressModel.setZipCode(addressDto.getZipCode());
        }
        userModel.setAddressModel(addressModel);
        userRepository.save(userModel);
    }

    public List<UserDto> getUsers() {
        List<UserModel> userModelList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (UserModel userModel : userModelList) {
            UserDto userDto = new UserDto();
            userDto.setId(userModel.getId());
            userDto.setEmail(userModel.getEmail());
            userDto.setUsername(userModel.getUsername());
            userDto.setPassword(userModel.getPassword());


            AddressDto addressDto = new AddressDto();
            AddressModel addressModel = userModel.getAddressModel();
            if(addressDto != null) {
                addressDto.setId(addressModel.getId());
                addressDto.setCountry(addressModel.getCountry());
                addressDto.setCity(addressModel.getCity());
                addressDto.setStreet(addressModel.getStreet());
                addressDto.setZipCode(addressModel.getZipCode());
            }
            userDto.setAddressDto(addressDto);
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    public void updateUser(UserDto userDto) {
        Optional<UserModel> optionalUserModel = userRepository.findById(userDto.getId());
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            userModel.setEmail(userDto.getEmail());
            userModel.setUsername(userDto.getUsername());
            userModel.setPassword(userDto.getPassword());


            AddressModel addressModel = new AddressModel();
            AddressDto addressDto = userDto.getAddressDto();
            addressModel.setCountry(addressDto.getCountry());
            addressModel.setCity(addressDto.getCity());
            addressModel.setStreet(addressDto.getStreet());
            addressModel.setZipCode(addressDto.getZipCode());

            userModel.setAddressModel(addressModel);
            userRepository.save(userModel);
        }
    }

    public UserDto findUserById(Long id) {
        Optional<UserModel> optionalUserModel = userRepository.findById(id);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            UserDto userDto = new UserDto();
            userDto.setId(userModel.getId());
            userDto.setEmail(userModel.getEmail());
            userDto.setUsername(userModel.getUsername());
            userDto.setPassword(userModel.getPassword());


            AddressDto addressDto = new AddressDto();
            AddressModel addressModel = userModel.getAddressModel();
            if(addressDto != null) {
                addressDto.setId(addressModel.getId());
                addressDto.setCountry(addressModel.getCountry());
                addressDto.setCity(addressModel.getCity());
                addressDto.setStreet(addressModel.getStreet());
                addressDto.setZipCode(addressModel.getZipCode());
            }

            userDto.setAddressDto(addressDto);
            return userDto;
        }
        return null;
    }

    public UserDto findUserByUsername(String username) {
        Optional<UserModel> optionalUserModel = userRepository.getUserModelByUsername(username);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            UserDto userDto = new UserDto();
            userDto.setId(userModel.getId());
            userDto.setEmail(userModel.getEmail());
            userDto.setUsername(userModel.getUsername());
            userDto.setPassword(userModel.getPassword());


            AddressDto addressDto = new AddressDto();
            AddressModel addressModel = userModel.getAddressModel();
            if(addressDto != null) {
                addressDto.setId(addressModel.getId());
                addressDto.setCountry(addressModel.getCountry());
                addressDto.setCity(addressModel.getCity());
                addressDto.setStreet(addressModel.getStreet());
                addressDto.setZipCode(addressModel.getZipCode());
            }

            userDto.setAddressDto(addressDto);
            return userDto;
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
