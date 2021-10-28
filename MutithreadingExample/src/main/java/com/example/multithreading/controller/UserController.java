package com.example.multithreading.controller;

import com.example.multithreading.model.User;
import com.example.multithreading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/save-users", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> saveUsers(@RequestParam MultipartFile[] files) throws Exception {
        CompletableFuture<List<User>> users = new CompletableFuture<>();
        for (MultipartFile multipartFile: files){
            users = userService.saveUser(multipartFile);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(users.get());
    }

    @GetMapping(value = "/get-users", produces = MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity<List<User>>> findAllUsers() throws Exception{
        return userService.getAllUsers().thenApply(users -> ResponseEntity.status(HttpStatus.OK).body(users));
    }

    @GetMapping(value = "/get-users1", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getUsers() throws ExecutionException, InterruptedException {
        CompletableFuture<List<User>> users1 = userService.getAllUsers();
        CompletableFuture<List<User>> users2 = userService.getAllUsers();
        CompletableFuture<List<User>> users3 = userService.getAllUsers();
        List< User> response = Stream.of(users1, users2, users3).flatMap(listCompletableFuture -> listCompletableFuture.join().stream()).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
