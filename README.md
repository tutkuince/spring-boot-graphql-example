What is GraphQL?

GraphQL is a query language for APIs created by Facebook in 2012, open-sourced in 2015, and now released as a specification.

GraphQL describes the data offered by an API through a schema that contains:

   - Data types and relationships between them
   - A set of operations:
       - Queries to get data
       - Mutations to create, update, and delete data

Notice that the fields are typed. These types can be scalar types (Int, Float, String, Boolean and ID) or references to other types defined in the specification.

You can also specify if they are required ( **!** ) or if they are an array ( **[]** )

**Query** operations are also treated as types. They declare fields that represent the available operations.

Here's a sample query to get the name of all the rock songs:
```
{
  filterSongsByGenre(genre: "rock") {
    title
  }
}
```

And even request the information of related resources:

```
{
  filterSongsByGenre(genre: "rock") {
    title
    artist {
      name
      country
    }
  }
}
```

These queries are typically sent over HTTP to a single server endpoint (unlike a REST architecture, where there are different endpoints for different resources).

The response is typically sent using JSON. For example, here's a sample response to the first query:

```
{
  "data": {
    "filterSongsByGenre": [
      {"title": "Song #0" },
      {"title": "Song #1" }
    ]
  }
}
```

GraphQL Java Tools works with four types of Resolver classes:

   - GraphQLResolver<T> to resolve complex types.
   - GraphQLQueryResolver to define the operations of the root Query type.
   - GraphQLMutationResolver to define the operations of the root Mutation type.
   - GraphQLSubscriptionResolver to define the operations of the root Subscription type.