package com.cybertek.implementation;

import com.cybertek.mapper.MapperUtil;
import com.cybertek.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)  // if we want to use mockito we need to use this annotation...
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;

    @Mock
    MapperUtil mapperUtil;

    @InjectMocks // if we use userservice, then we need to inject our dependencies like in real code...
    UserServiceImpl userService;

    @Test
    void deleteByUserName() {
        userService.deleteByUserName("mike@cybertek.com");

        verify(userRepository).deleteByUserName("mike@cybertek.com"); // this line verifies that our user repository deletebyusername method is called...
        verify(userRepository,times(2)).deleteByUserName("mike@cybertek.com"); // it says executed 2 times..
        verify(userRepository,atLeastOnce()).deleteByUserName("mike@cybertek.com");                 // en az 1 kere executed
        verify(userRepository,atMost(5)).deleteByUserName("mike@cybertek.com"); // en fazla 5 kere executed...
    }
}