package com.anand.springboot.multithread.service;

import com.anand.springboot.multithread.entity.User;
import com.anand.springboot.multithread.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    Object target;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Async
    public CompletableFuture<List<User>> saveUser(MultipartFile file) throws Exception{
        long startTime = System.currentTimeMillis();

            List<User> users = parseCSVFile(file);

            logger.info("Saving User data of Users"+users.size()+" usering thread"+Thread.currentThread().getName());
            users = userRepository.saveAll(users);

        long end = System.currentTimeMillis();
        logger.info("Total time taken for execution:"+(end-startTime));

        return CompletableFuture.completedFuture(users);
    }

    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("Fetching list of users by:"+Thread.currentThread().getName());
        List<User> users = userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }

    private List<User> parseCSVFile(final MultipartFile file)throws Exception{
        final List<User> userList = new ArrayList<>();
        try{
            try(final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))){
                String line;
                while((line = br.readLine())!=null){
                    final String []data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);

                    userList.add(user);
                }
            }
        }catch(IOException e){
            logger.error("Failed to parse CSV File");
            throw new Exception("Failed to Parse CSV File",e);
           }
        return userList;
    }
}
