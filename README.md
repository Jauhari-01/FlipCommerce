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
