package com.example.filmsapp.database;

import android.app.Application;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.filmsapp.database.service.UserService;
import com.example.filmsapp.model.domain.User;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class UserServiceTest {

    private Application application;
    private UserService service;

    @Before
    public void setUp() {
        this.application = (Application) InstrumentationRegistry.getTargetContext().getApplicationContext();
        this.service = new UserService(application);
    }

    @Test
    public void saveTest() {
        User user = new User("bruno_kim", "admin123", "bfelix@indracompany.com");
        long result = service.save(user);
        System.out.println(result);
    }

    @Test
    public void findTest() {
        List<User> list = service.find("bruno_kim");
        assertEquals(list.size(), 4);
    }

    @Test
    public void findAllTest() {
        List<User> list = service.findAll();
        assertNotNull(list);
    }

    @After
    public void finish() {
        if (service != null) {
            service.clear();
        }
    }

}
