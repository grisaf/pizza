# pizza

Architecture
============

The tools used are:

  - Gradle
  - Spring Data
  - Spring MVC

For the database persistance, it is configured for PostgreSQL.

The application has the following package structure:

- Main application
    - `org.exercise.pizza`
- Model
    - `org.exercise.pizza.model`
- DAOs (repositories)
    - `org.exercise.pizza.dao`
- Services
    - `org.exercise.pizza.service`
- Controllers
    - `org.exercise.pizza.controller`
- Parameters
    - `org.exercise.pizza.parameters`
- DB Initialization
    - `org.exercise.pizza.initdb`
- Utils
    - `org.exercise.pizza.util`
- Factory
    - `org.exercise.pizza.factory`

Running
=======

It is necessary to create the database with the command:

    createdb pizza

The username and password are configured on the file `aplication.yml`

Once it is configured, the execution is with the command:

    gradle bootRun

Assumptions
===========

- Since the ingredients and the types can change everyday, and some old orders can have a relationship with them, they are not being deleted, instead, they are changed to inactive status.

- The orders can have four status:
  - New: when the order is just registered
  - Prepared: when the order has been already prepared and it is ready for the customer
  - Delivered: when the order has been delivered to the customer.
  - Cancelled: when the order should not be prepared anymore.

- For a new pizza order, the customer can remove some ingredients from the pizza type, and also add some extra ingredients.

- Every pizza size has a diameter that is always the same, and also has a default number of slices, but in the pizza order, the number of slices can be modified. If the number of slices is not specified, or it is set to -1, it takes the default number of slices for the size.

- The orders can have a comment, it can be any request that the customer asks with the order, besides the options.

- The cheeses, sauces, crusts and sizes has always the same data, so it is not possible to change them.

- Some data is already populated every time the application starts.

Endpoints
=========

Cheese
------

- List

      GET /api/cheese/

Crust
-----

- List

      GET /api/crust/

Sauce
-----

- List

      GET /api/sauce/

Size
----

- List

      GET /api/size/

Ingredients
-----------

- List

      GET /api/ingredient/

- Get

      GET /api/ingredient/{id}

- Add

      POST /api/ingredient/

      {
        "name": String
      }

- Update

      PUT /api/ingredient/{id}

      {
        "name": String
      }

- Disable

      DELETE /api/ingredient/{id}


Product Types
-------------

- List

      GET /api/producttype/

- Get

      GET /api/producttype/{id}

- Add

      POST /api/producttype/

      {
        "name": String
      }

- Update

      PUT /api/producttype/{id}

      {
        "name": String
      }

- Disable

      DELETE /api/producttype/{id}

- Order

      POST /api/producttype/{id}/order

      {
        "comment": String
      }

Pizza Types
-----------

- List

      GET /api/pizzatype/

- Get

      GET /api/pizzatype/{id}

- Add

      POST /api/pizzatype/

      {
        "name": String,
        "ingredients": Array
      }

- Update

      PUT /api/pizzatype/{id}

      {
        "name": String,
        "ingredients": Array
      }

- Disable

      DELETE /api/pizzatype/{id}

- Order

      POST /api/pizzatype/{id}/order

      {
        "remove": Array,
        "extra": Array,
        "cheese": String,
        "sauce": String,
        "crust": String,
        "size": String,
        "slices": Integer,
        "comment": String
      }

Product Order
-------------

- List

      GET /api/productorder/

- Get

      GET /api/productorder/{id}

- Prepare

      GET /api/productorder/{id}/prepare

- Deliver

      GET /api/productorder/{id}/deliver

- Cancel

      GET /api/productorder/{id}/cancel

Pizza Order
-----------

- List

      GET /api/pizzaorder/

- Get

      GET /api/pizzaorder/{id}

- Prepare

      GET /api/pizzaorder/{id}/prepare

- Deliver

      GET /api/pizzaorder/{id}/deliver

- Cancel

      GET /api/pizzaorder/{id}/cancel


Example
=======

The pizza type with the id 1 is the Hawaiian, with the default ingredients ham and pineapple, but we can ask to remove the ham and add as extra some olives.
The personal size for pizza has a default number of slices to 4, but we can ask to cut in 6 slices.
Finally, we can ask to put the extra olives only on half of the pizza, and we set that in the comment.
This will be the request:

    GET /api/pizzatype/1/order

    {
      "cheese": "mozzarella",
      "sauce": "ragu",
      "extra": ["olives"],
      "remove": ["ham"],
      "crust": "thin",
      "size": "personal",
      "slices": 6,
      "comment":"only half with olives"
    }

And the response will be:

    {
      "id": 1,
      "pizzaType": {
        "id": 1,
        "name": "hawaiian",
        "ingredients": [
          {
            "id": 1,
            "name": "ham",
            "active": true
          },
          {
            "id": 2,
            "name": "pineapple",
            "active": true
          }
        ],
        "active": true
      },
      "ingredients": [
        {
          "id": 2,
          "name": "pineapple",
          "active": true
        },
        {
          "id": 6,
          "name": "olives",
          "active": true
        }
      ],
      "cheese": {
        "id": 1,
        "name": "mozzarella"
      },
      "sauce": {
        "id": 2,
        "name": "ragu"
      },
      "crust": {
        "id": 1,
        "name": "thin"
      },
      "size": {
        "id": 1,
        "name": "personal",
        "diameter": 10,
        "slices": 4
      },
      "slices": 6,
      "comment": "only half with olives",
      "status": "new"
    }
