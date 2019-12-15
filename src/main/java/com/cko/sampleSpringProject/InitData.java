package com.cko.sampleSpringProject;

import com.cko.sampleSpringProject.dao.FilmDAO;
import com.cko.sampleSpringProject.dao.ProductDAO;
import com.cko.sampleSpringProject.model.Authority;
import com.cko.sampleSpringProject.model.Film;
import com.cko.sampleSpringProject.model.Products;
import com.cko.sampleSpringProject.model.User;
import com.cko.sampleSpringProject.service.AuthorityService;
import com.cko.sampleSpringProject.service.SMSCService;
import com.cko.sampleSpringProject.service.UserService;

import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData {

    @Autowired
    UserService userService;

    @Autowired
    AuthorityService authorityService;

    @Autowired
    SMSCService smscSender;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    FilmDAO filmDAO;

    @Autowired
    ProductDAO productDAO;

    Faker faker = new Faker();

    public void initData() {
        //Faker faker = new Faker();
        //Film film = new Film(faker.superhero().name(), 1, 13);
        //filmDAO.save(film);
        //initFilms();
        //initUserAndRoles();
        //Film film = new Film("Rosomaha",9,18);
        //Film films = new Film("Rosomahaaa",9,18);
        //filmDAO.save(film);
        //filmDAO.save(films);
        initFilms();
        initUserAndRoles();
    }

    private void initUserAndRoles() {
        Authority adminAuthority = new Authority("ROLE_ADMIN");
        Authority userAuthority = new Authority("ROLE_USER");
        authorityService.insert(adminAuthority);
        authorityService.insert(userAuthority);

        for (int i = 0; i < 10; i++) {

        }
        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(adminAuthority);
        userService.insert(new User("1@mail.ru", bCryptPasswordEncoder.encode("1"), authorities));
    }
    private void initFilms() {
        for (int i = 0; i < 10; i++) {
            Film film = new Film(faker.superhero().name(), i, i * 2);
            filmDAO.save(film);
        }
    }
    public void initProduct() {
        for (int i = 0; i < 10; i++) {
            Products product = new Products(faker.commerce().productName(), faker.number().numberBetween(0,1000000), faker.number().numberBetween(0,10));
            productDAO.save(product);
        }

    }
}
