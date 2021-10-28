package com.example.multithreading.service;

import com.example.multithreading.entity.UserEntity;
import com.example.multithreading.model.User;
import com.example.multithreading.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Async
    public CompletableFuture<List<User>> saveUser(MultipartFile multipartFile) throws Exception{
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(multipartFile);Thread n = new Thread();
        List<UserEntity> userEntities = users
                .stream()
                .map(user -> new UserEntity(user.getName(), user.getEmail(), user.getGender()))
                .collect(Collectors.toList());
        log.info("Saving list of users of size: " + userEntities.size() + " " + Thread.currentThread().getName());
        userEntities = userRepository.saveAll(userEntities);
        users = userEntities
                .stream()
                .map(userEntity -> new User(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getGender()))
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        log.info("Total time taken: " + (end-start));
        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> getAllUsers(){
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities
                .stream()
                .map(userEntity -> new User(userEntity.getName(), userEntity.getEmail(), userEntity.getGender()))
                .collect(Collectors.toList());
        log.info("Get list of users by: " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCSVFile(MultipartFile multipartFile) throws Exception {
        List<User> users = new ArrayList<>();
        try(final BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(multipartFile.getInputStream()))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                final String[] data = line.split(",");
                final User user= new User(data[0], data[1], data[2]);
                users.add(user);
            }
            return users;
        }
        catch (FileNotFoundException e){
            log.error("File Not Found");
            throw new Exception("File Not Found");
        }
        catch (IOException e){
            log.error("Error in reading CSV file");
            throw new Exception("Error in reading CSV file");
        }

    }
}
