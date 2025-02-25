package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CategoryServiceImplTest {

    @Mock ///whatever dependency the actual class -CategoryServiceImplTest have, will comne under @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks //this @InjectMock will have the actual service class , hence it will always hae one entry
    private CategoryServiceImpl categoryService;

    /*
    @Before - used for setup env eg: DB connection
    @After - destroy the env

    @BeforeEach - used for setup specific test
    @AfterEach - used for destroy setup for specific test

    hence every class in Test will have one @Before,@After
    where as, @BeforeEach and @AfterEach will run every test cases

     */

    @BeforeEach
    public void setUp() {
        /*
        this method is not required now a days
        it will help initialize and add all required mocks
         */
        MockitoAnnotations.initMocks(this);
    }


    //going to write a first test
    

}
