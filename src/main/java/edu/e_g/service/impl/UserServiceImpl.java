package edu.e_g.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.e_g.dto.User;
import edu.e_g.entity.UserEntity;
import edu.e_g.repository.UserRepository;
import edu.e_g.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    final UserRepository userRepo;
    final ObjectMapper mapper;
//    final BCryptPasswordEncoder encoder;

    @Override
    public Boolean addUser(User user) {
//         user.setPassword(encoder.encode(user.getPassword()));
//         userRepo.save(mapper.convertValue(user, UserEntity.class));
//         log.info("error :",user);
//         return user;
        try {
            userRepo.save(mapper.convertValue(user, UserEntity.class));
            return true;
        }catch (Exception e){
            log.info(" saved error massage : "+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public User getUser() {
        return null;
    }

    @Override
    public User getLastUser() {
        return null;
    }
}
