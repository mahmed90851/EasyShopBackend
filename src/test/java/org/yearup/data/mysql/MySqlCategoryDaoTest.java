package org.yearup.data.mysql;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.yearup.models.Category;


import static org.junit.jupiter.api.Assertions.*;

class MySqlCategoryDaoTest extends BaseDaoTestClass {

    private MySqlCategoryDao dao;

    @BeforeEach
    public void setup()
    {
        dao = new MySqlCategoryDao(dataSource);
    }


    @Test
    public void getById_shouldReturn_theCorrectCategory()
    {
        // arrange
        int categoryId = 1;
        Category expected = new Category()
        {{
            setCategoryId(1);
            setName("Electronics");
            setDescription("Explore the latest gadgets and electronic devices.");
        }};

        // act
        var actual = dao.getById(categoryId);

        // assert
        assertEquals(expected.getName(), actual.getName(), "Checking the id to match with id expected");
    }
}