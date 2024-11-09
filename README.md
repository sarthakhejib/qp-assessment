This Spring boot application is a Grocery-booking application. There are different responsibilities assigned to Admin and User which are further mentioned in breif in the later part of the README.md file.
There are some endpoints which are not mentioned as they are added for testing purpose. This application use MySQL as a primary database for performing CRUD operations with the help of JPA. Also, this application(SpringBoot and MySQL) has been containerise with the help of Docker.

**
API Endpoints Details:
**
Below are the responsibilities of each role, along with their corresponding API endpoints:

**Admin Responsibilities**

**1. Add new grocery items**
Endpoint: POST /api/admin/groceries
Description: Allows an admin to add new items to the system.

**2. View existing grocery items**
Endpoint: GET /api/admin/groceries
Description: Allows the admin to view all grocery items.

**3. Remove grocery items**
Endpoint: DELETE /api/admin/groceries/{id}
Description: Allows the admin to remove an item from the inventory.

**4. Update grocery item details**
Endpoint: PUT /api/admin/groceries/{id}
Description: Allows the admin to update the name, price, or quantity of an item.

**5. Manage inventory levels**
Endpoint: PATCH /api/admin/groceries/{id}/inventory
Description: Allows the admin to update the quantity of a specific item.


**User Responsibilities**

**1. View the list of available grocery items**
Endpoint: GET /api/groceries
Description: Allows users to view all available grocery items.

**2.Book multiple grocery items in a single order**
Endpoint: POST /api/user/orders
Description: Allows users to place an order with multiple grocery items.
