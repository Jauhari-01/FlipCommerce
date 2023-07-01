# FlipCommerce

FlipCommerce is an e-commerce application with a wide range of APIs that facilitate various functionalities related to online shopping. The project provides APIs for user management, product listing, shopping cart management, order processing, and payment integration. Additionally, it includes features such as user authentication, product search, and order tracking. The APIs are designed using the Spring Boot framework and follow RESTful principles for easy integration with frontend applications. The GitHub repository contains the source code, allowing for collaboration and further development of the FlipCommerce application.

### The Customer Controller in the FlipCommerce project is responsible for handling customer-related operations. It provides several APIs to interact with customer data. Here is a brief description of each API:
-----------
1. `/add-customer`: This API allows the addition of a new customer. It accepts a `CustomerRequestDto` containing customer details and returns a `CustomerResponseDto` with the newly created customer information.

2. `/all-female-customer`: This API retrieves a list of all female customers. It calls the `allFemaleCustomer` method in the `customerService` to fetch the required data.

3. `/all-male-customer`: This API fetches a list of all male customers below the age of 45. It invokes the `allMaleCustomer` method in the `customerService` to retrieve the relevant customer records.

4. `/customer-at-least-k-orders`: This API returns a list of customers who have placed at least 'k' orders. The parameter 'k' is passed as a request parameter, and the `customerAtLeastKOrders` method in the `customerService` is called to fetch the matching customer data.

These APIs play a crucial role in the functionality of the FlipCommerce e-commerce application, enabling efficient management and retrieval of customer information based on specific criteria.
