package dev.chitra.EcommerceProductService.service;

import dev.chitra.EcommerceProductService.Repository.CategoryRepository;
import dev.chitra.EcommerceProductService.entity.Category;
import dev.chitra.EcommerceProductService.entity.Product;
import dev.chitra.EcommerceProductService.exception.CategoryNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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


    NOTE: test methods are always void
     */

    @BeforeEach
    public void setUp() {
        /*
        this method is not required now a days
        it will help initialize and add all required mocks
         */
        MockitoAnnotations.initMocks(this);
    }

/*
    going to write a first test of a method -getTotalPrice
    in the method , we plan to test 4 checks

    1. whether is there any products available in given categoryId
        --hence we are having a list of products with one category as MOCK
      */

    @Test
    public void testTotalPriceOfPdtOFOneCategoty()
    {
        /*ARRANGE*/
        //this method will return the total of all pdts of one cat
        UUID catId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(catId)).thenReturn(mockCategoryWithManyProducts());
        //note that findByID will return Optional, hence the below method will return optional
        //Hey Mockito, with the given dummy UUID, with the dummy repo, you try to access the dummy method return the result
        double expectedCost=400.0;

        /* ACT*/
        double actualCost=categoryService.getTotalPrice(catId);
        /*ASSERT*/
        Assertions.assertEquals(expectedCost,actualCost);
    }

    public Optional<Category> mockCategoryWithManyProducts()
    {
        UUID categoryId = UUID.randomUUID();
        Category category = new Category();
        category.setId(categoryId);
        category.setName("CategoryMock Name");
        //to have a list of pdts - create a MOCK

        Product product1 = new Product();
        product1.setId(UUID.randomUUID());
        product1.setName("ProductMock Name");
        product1.setCategory(category);
        product1.setPrice(100.00);

        Product product2 = new Product();
        product2.setId(UUID.randomUUID());
        product2.setName("ProductMock Name2");
        product2.setCategory(category);
        product2.setPrice(300.00);

        List<Product> listofProducts = Arrays.asList(product1, product2);
        category.setProducts(listofProducts);
        return Optional.of(category);
    }

    /*
    1. whether is there 0 products available in given categoryId
        --hence we are having no product with a category as MOCK

     */

    public Optional<Category> mockCategoryWithZeroProducts()
    {
        UUID categoryId = UUID.randomUUID();
        Category category = new Category();
        category.setId(categoryId);
        category.setName("CategoryMock Name");
         List<Product> listofProducts = Arrays.asList();
         category.setProducts(listofProducts);
         return Optional.of(category);
    }

    @Test
    public void testTotalPriceOfZeroProductOFOneCategoty()
    {
        /*ARRANGE*/
        //this method will return the total of all pdts of one cat
        UUID catId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(catId)).thenReturn(mockCategoryWithZeroProducts());
        double expectedCost=0.0;

        /*ACT*/
        double actualCost=categoryService.getTotalPrice(catId);


        //checks- if either a checks fail, the test ll fail

        /*ASSERT*/
        Assertions.assertEquals(expectedCost,actualCost);
        Mockito.verify(categoryRepository).findById(catId); // this is a verification of what we called the UUID
    }

    //3. check whether the catiD is valid
    public void categoryNotFoundExceptionTest()
    {
        //arrange
        UUID catId = UUID.randomUUID();
        Mockito.when(categoryRepository.findById(catId)).thenReturn(Optional.empty());

        //act and assert -- why are we giving method getTotalPrice
        //because we are verifying the CatID existance when ever we execute getTotalPrice method
        Assertions.assertThrows(CategoryNotFoundException.class,
                ()-> categoryService.getTotalPrice(catId));
    }
}
