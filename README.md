# FlipCommerce

FlipCommerce is an e-commerce application with a wide range of APIs that facilitate various functionalities related to online shopping. The project provides APIs for user management, product listing, shopping cart management, order processing, and payment integration. Additionally, it includes features such as user authentication, product search, and order tracking. The APIs are designed using the Spring Boot framework and follow RESTful principles for easy integration with frontend applications. The GitHub repository contains the source code, allowing for collaboration and further development of the FlipCommerce application.

### The Customer Controller in the FlipCommerce project is responsible for handling customer-related operations. It provides several APIs to interact with customer data. Here is a brief description of each API:
-----------
1. `/add-customer`: This API allows the addition of a new customer. It accepts a `CustomerRequestDto` containing customer details and returns a `CustomerResponseDto` with the newly created customer information.

2. `/all-female-customer`: This API retrieves a list of all female customers. It calls the `allFemaleCustomer` method in the `customerService` to fetch the required data.

3. `/all-male-customer`: This API fetches a list of all male customers below the age of 45. It invokes the `allMaleCustomer` method in the `customerService` to retrieve the relevant customer records.

4. `/customer-at-least-k-orders`: This API returns a list of customers who have placed at least 'k' orders. The parameter 'k' is passed as a request parameter, and the `customerAtLeastKOrders` method in the `customerService` is called to fetch the matching customer data.

These APIs play a crucial role in the functionality of the FlipCommerce e-commerce application, enabling efficient management and retrieval of customer information based on specific criteria.

### The Seller Controller in the FlipCommerce project handles operations related to sellers. It provides various APIs to interact with seller data. Here is an explanation of each API:
-------------
1. `/add-seller`: This API allows the addition of a new seller. It accepts a `SellerRequestDto` containing seller details and returns a response with the newly created seller information.

2. `/update-seller-name-mobileNo`: This API updates the information of a seller based on their email. It takes parameters such as the email ID, name, and mobile number, and invokes the `updateSellerInfo` method in the `sellerService` to perform the update.

3. `/sellers-sell-products-of-a-particular-category/{category}`: This API retrieves a list of all sellers who sell products of a specific category. The `sellersSellProductsOfAParticularCategory` method in the `sellerService` is called to fetch the relevant seller records.

4. `/product-sold-by-seller-in-a-particular-category/{category}`: This API fetches a list of all products sold by a seller in a particular category. It invokes the `productSoldBySellerInAParticularCategory` method in the `sellerService` to retrieve the corresponding product records.

5. `/seller-with-maximum-product`: This API returns a list of sellers who have the maximum number of products. The `sellerMaxProduct` method in the `sellerService` is called to fetch the sellers with the highest product count.

6. `/seller-with-minimum-product`: This API retrieves a list of sellers who have the minimum number of products. The `sellerMinProduct` method in the `sellerService` is called to fetch the sellers with the lowest product count.

7. `/seller-costliest-product`: This API returns a set of sellers who sell the costliest product. The `sellerCostliestProduct` method in the `sellerService` is called to retrieve the sellers with the highest-priced product.

8. `/seller-cheapest-product`: This API fetches a set of sellers who sell the cheapest product. The `sellerCheapestProduct` method in the `sellerService` is called to fetch the sellers with the lowest-priced product.

These APIs provide essential functionalities for managing seller information and retrieving seller data based on various criteria in the FlipCommerce e-commerce application.


### The Product Controller in the FlipCommerce project handles operations related to products. It provides several APIs to manage product information. Here is an explanation of each API:
-----------------------
1. `/add-product`: This API allows the addition of a new product. It accepts a `ProductRequestDto` containing product details and returns a response with the newly created product information. If the seller is not found, it returns a bad request status.

2. `/get-product/category/{category}/price/{price}`: This API retrieves a list of products based on the given category and price. It takes the category and price as path variables and returns a list of `ProductResponseDto` objects matching the criteria.

3. `/product-price-greater-than-500`: This API returns a set of product names in a specific category whose price is greater than 500. It invokes the `productPriceGreaterThan500` method in the `productService` to fetch the relevant product names.

4. `/top-5-costliest-product`: This API retrieves the top 5 costliest products in a specific category. It calls the `top5CostliestProduct` method in the `productService` to fetch the list of product names.

5. `/top-5-cheapest-product`: This API fetches the top 5 cheapest products in a specific category. It invokes the `top5CheapestProduct` method in the `productService` to retrieve the list of product names.

6. `/product-based-on-seller-emailId`: This API fetches all the products of a seller based on their email ID. It takes the email ID as a request parameter and returns a set of product names associated with that seller.

7. `/out-of-stock-products-for-a-particular-category/{category}`: This API retrieves a set of product names that are out of stock for a particular category. It takes the category as a path variable and calls the `outOfStockProductForAParticularCategory` method in the `productService` to fetch the relevant product names.

8. `/send-email-to-seller-product-out-of-stock`: This API sends an email to the sellers of out-of-stock products. It invokes the `sendEmailToSellerProductOutOfStock` method in the `productService` to send the email and returns a success message.

9. `/delete-product`: This API deletes a product based on its ID. It takes the product ID as a request parameter and calls the `deleteProduct` method in the `productService` to delete the product from the system.

These APIs provide essential functionalities for managing products, retrieving products based on various criteria, and performing actions such as sending emails and deleting products in the FlipCommerce e-commerce application.


### The Order Controller in the FlipCommerce project handles operations related to orders. It provides the following APIs:
---------------
1. `/place-order`: This API allows the placement of a new order. It accepts an `OrderRequestDto` containing order details and returns a response with the newly created order information. If an error occurs, it returns a bad request status along with the error message.

2. `/top-5-orders-with-highest-order-value`: This API retrieves the top 5 orders with the highest order value. It calls the `top5OrdersWithHighestOrderValue` method in the `orderService` to fetch the list of order IDs.

3. `/all-order-of-particular-customer/{emailId}`: This API retrieves all the orders of a particular customer based on their email ID. It takes the email ID as a path variable and calls the `allOrderOfParticularCustomer` method in the `orderService` to fetch the list of order IDs.
4. `/top-5-recently-orders`: This API retrieves the top 5 recently ordered orders of a customer. It calls the `top5RecentlyOrders` method in the `orderService` to fetch the list of order IDs. The list is then reversed using `Collections.reverse` to get the most recent orders at the beginning of the list.

These APIs provide essential functionalities for placing orders, retrieving top orders based on order value, and fetching orders for a specific customer in the FlipCommerce e-commerce application.

### The Card Controller contains the following APIs:
-------------------------
1. `/add-card`: This API is used to add a new card to the system. It takes a `CardRequestDto` object as a request body and calls the `addCard` method in the `cardService` to add the card. If the associated customer is not found, it returns a `CustomerNotFoundException` with a `NOT_FOUND` status.

2. `/card-type-max-number-of-times`: This API retrieves the card type that exists the maximum number of times in the system. It calls the `cardTypeMaxNumberOfTimes` method in the `cardService` to determine the card type and returns it as a response with a `FOUND` status.

3. `/card-type-min-number-of-times`: This API retrieves the card type that exists the minimum number of times in the system. It calls the `cardTypeMinNumberOfTimes` method in the `cardService` to determine the card type and returns it as a response with a `FOUND` status.

These APIs provide functionality related to managing and analyzing card information in the FlipCommerce e-commerce application.

### The Cart Controller includes the following APIs:
---------------------------------------
1. `/add-cart`: This API is used to add an item to the cart. It takes an `ItemRequestDto` object as a request body and calls the `createItem` method in the `itemService` to create the item. Then, it adds the created item to the cart using the `addToCart` method in the `cartService`. If successful, it returns a `CartResponseDto` with a `ACCEPTED` status. If an error occurs, it returns an error message with a `BAD_REQUEST` status.

2. `/checkout-cart`: This API is used to check out the items from the cart and create an order. It takes a `CheckOutCartRequestDto` object as a request body and calls the `checkOutCart` method in the `cartService` to process the cart and create an order. If successful, it returns an `OrderResponseDto` with a `CREATED` status. If an error occurs, it returns an error message with a `BAD_REQUEST` status.

These APIs provide functionality for adding items to the cart and checking out the cart to create orders in the e-commerce application.

### In my project, I had utilized Swagger, DTOs, Transformers, and Exception Handling for efficient development, documentation, and error management.
-----------------
1. Swagger: Swagger is an open-source tool used for designing, building, documenting, and consuming RESTful APIs. By integrating Swagger into your project, you have enhanced the API development process. Swagger provides a user-friendly interface to view and test your APIs, generates API documentation, and simplifies API integration.

2. DTOs (Data Transfer Objects): DTOs are objects used to transfer data between different layers of an application. In your project, you have implemented DTOs to encapsulate the data exchanged between the client and server. DTOs help in decoupling the internal domain model from the external API representation, ensuring clean data transfer and improved maintainability.

3. Transformers: Transformers are components used to convert data between different formats or structures. In your project, you have likely implemented transformers to convert data between DTOs and internal domain objects. Transformers facilitate data mapping and transformation, allowing seamless communication between different layers of the application.

4. Exception Handling: Exception handling is an important aspect of any robust application. In your project, you have implemented exception handling mechanisms to gracefully handle and manage errors. This includes catching and handling exceptions thrown during API execution, providing appropriate error messages and HTTP status codes to the client, and ensuring a smooth user experience even in case of errors.

## By incorporating these features into your project, I have demonstrated strong skills in API development, documentation, data management, and error handling. These practices contribute to the overall quality, usability, and reliability of your application.
