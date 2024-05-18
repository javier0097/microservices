package com.example.application.service;

import com.example.application.exceptions.UserNotFountException;
import com.example.application.model.domain.*;
import com.example.application.model.repositories.CompanyRepository;
import com.example.application.model.repositories.PersonRepository;
import com.example.application.model.repositories.UserRepository;
import com.example.application.model.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFountException("User not exist with userId: " + id));

        if (UserType.PERSON.equals(user.getUserType())) {
            Person person = personRepository.findById(id)
                    .orElseThrow(() -> new UserNotFountException("Person not exist with id: " + id));
            return buildUserResponse(user, person.getLastName(), person.getFirstName());
        } else {
            Company company = companyRepository.findById(id)
                    .orElseThrow(() -> new UserNotFountException("Company not exist with id: " + id));
            return buildUserResponse(user, company.getName(), null);
        }
    }

//    @Override
//    public UserRoleResponse findByEmail(String email) {
//        User user = userRepository.findByEmail(email)
//                .orElseThrow(() -> new UserNotFountException("User not exist with email: " + email));
//        return buildUserRoleResponse(user);
//    }

//    private UserRoleResponse buildUserRoleResponse(User user) {
//        List<Role> roles = user.getRoles();
//
//        List<RoleResponse> roleResponses = buildRoleResponseList(roles);
//        if (UserType.PERSON.equals(user.getUserType())) {
//            Person person = findPerson(user.getId());
//            return buildUserRoleResponse(user, person.getLastName(), person.getFirstName(), roleResponses);
//        }
//
//        Company company = findCompany(user.getId());
//        return buildUserRoleResponse(user, company.getName(), null, roleResponses);
//    }

//    private List<RoleResponse> buildRoleResponseList(List<Role> roles) {
//        return roles.stream().map(this::buildRoleResponse).collect(Collectors.toList());
//    }

//    private Person findPerson(Long personId) {
//        return personRepository.findById(personId)
//                .orElseThrow(() -> new UserNotFountException("Person not exist with id: " + personId));
//    }

//    private Company findCompany(Long companyId) {
//        return companyRepository.findById(companyId)
//                .orElseThrow(() -> new UserNotFountException("Company not exist with id: " + companyId));
//    }

//    private UserRoleResponse buildUserRoleResponse(User user, String name1, String name2, List<RoleResponse> roleResponses) {
//        Account account = user.getAccount();
//        UserRoleResponse instance = new UserRoleResponse();
//        instance.setUserId(user.getId());
//        instance.setAccountId(account.getId());
//        instance.setCreatedDate(user.getCreatedDate());
//        instance.setUserType(com.dharbor.bootcamp.users.api.UserType.valueOf(user.getUserType().name()));
//        instance.setEmail(user.getEmail());
//        instance.setPassword(user.getPassword());
//        instance.setName1(name1);
//        instance.setName2(name2);
//        instance.setRoles(roleResponses);
//        return instance;
//    }

    private UserResponse buildUserResponse(User user, String name1, String name2) {
        Account account = user.getAccount();
        UserResponse instance = new UserResponse();
        instance.setUserId(user.getId());
        instance.setAccountId(account.getId());
        instance.setCreatedDate(user.getCreatedDate());
        instance.setUserType(com.example.application.model.domain.UserType.valueOf(user.getUserType().name()));
        instance.setEmail(user.getEmail());
        instance.setName1(name1);
        instance.setName2(name2);
        return instance;
    }

//    private RoleResponse buildRoleResponse(Role role) {
//        RoleResponse instance = new RoleResponse();
//        instance.setRoleId(role.getId());
//        instance.setName(role.getName());
//        return instance;
//    }
}
