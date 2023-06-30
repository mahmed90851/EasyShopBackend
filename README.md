# EasyShop Backend

This repository contains the backend code for EasyShop, an online shop application. The backend is responsible for handling user registration, login, category management, product search, and other related functionalities. The project has been divided into two phases, each focusing on specific tasks and bug fixes.

## Project Overview

EasyShop is an online shop application with an existing frontend. The frontend and backend work together to provide a complete online shopping experience. The backend code is written in Java and utilizes MySQL as the database.

## Phases

### Phase 1

In this phase, the main focus was on implementing the following methods:

#### MySqlCategoryDao

- `getAllCategories()`: Retrieves all categories from the database.
- `getById()`: Fetches a category by its ID.
- `create()`: Adds a new category to the database.
- `update()`: Updates an existing category in the database.
- `delete()`: Deletes a category from the database.

#### CategoriesController

- `getAll()`: Retrieves all categories.
- `getById()`: Fetches a category by its ID.
- `getProductsById()`: Retrieves products belonging to a specific category.
- `addCategory()`: Adds a new category (requires admin privilege).
- `updateCategory()`: Updates an existing category (requires admin privilege).
- `deleteCategory()`: Deletes a category (requires admin privilege).

Note: Only administrators have permission to add, update, and delete categories.

### Phase 2

This phase involved fixing two bugs and improving the search functionality:

#### Bug 1 - Search Functionality

The search function was not returning the expected results due to a missing clause in the SQL query. The fix involved adding the following clause to the query:

```
"   AND (price <= ? OR ? = -1) " // Added to search for products within the price range.
```

Additionally, the search method required setting the appropriate parameters for the maximum price:

```
statement.setBigDecimal(3, maxPrice);
statement.setBigDecimal(4, maxPrice);
```

#### Bug 2 - Product Update

The second bug caused the creation of a new product instead of updating an existing one when the admin attempted to update a product. The fix involved modifying the code inside the `ProductController` class, specifically the `updateProduct()` method. The code was changed to update an existing product instead of creating a new one:

```
productDao.update(id, product); // Updates an existing product.
```

## How to Run the Project

To run the EasyShop backend project, follow these steps:

1. Clone this repository to your local machine.
2. Set up the frontend component separately by following the instructions provided in the frontend folder.
3. Launch the index.html file of the frontend in a browser to access the web application.
4. Make sure to have Java and MySQL installed on your system.
5. Set up the MySQL database and update the necessary configuration in the backend code.
6. Build and run the backend code using your preferred Java development environment.

