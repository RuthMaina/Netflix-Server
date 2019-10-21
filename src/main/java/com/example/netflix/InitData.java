package com.example.netflix;

import com.example.netflix.models.Categories;
import com.example.netflix.models.Users;
import com.example.netflix.repositories.CategoriesRepository;
import com.example.netflix.repositories.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {
    private final UsersRepository usersRepository;
    private final CategoriesRepository categoriesRepository;

    public InitData(UsersRepository usersRepository, CategoriesRepository categoriesRepository) {
        this.usersRepository = usersRepository;
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        createAdmin();
        createCategories();
    }

    public void createAdmin(){
        if (usersRepository.count() == 0) {
            Users admin = new Users("admin", true);
            usersRepository.save(admin);
        }
    }

    public void createCategories(){
        if (categoriesRepository.count() == 0) {
            Categories category = new Categories("Action");
            Categories category1 = new Categories("Adventure");
            Categories category2 = new Categories("Comedy");
            Categories category3 = new Categories("Romance");
            Categories category4 = new Categories("Thriller");
            categoriesRepository.save(category);
            categoriesRepository.save(category1);
            categoriesRepository.save(category2);
            categoriesRepository.save(category3);
            categoriesRepository.save(category4);
        }
    }
}
