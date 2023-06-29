# back-wine

### Reference data
https://www.vivino.com/dourthe-grands-terroirs-bordeaux-medium-sweet/w/2120528?year=2010&price_id=24788419

### Wine model fields
- Long id;
- List<String> images;
- String name;
- String varietal;
- double price;
- double bottleVolume;
- int year;
- String country;
- String region;
- String winery;
- String description;
- Map<TasteType, Double> tastes;
- List<String> grapes;
- List<String> interestingFacts;

### Requests
- PUT: /wines/id - update wine
- Post: /wines/create - create wine - only admin
- GET: /wines - get all wines
- GET: /wines/id - get wine by id

### Login
    role: admin
    username: admin
    password :admin

    role: user
    username: user
    password: user
