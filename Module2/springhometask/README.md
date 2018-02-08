# Home Task #5
    Practical task:
    Create Spring based module, which handles event tickets booking. Result of the task should be Maven based project. 
    
    Based on attached source code model:
    1. Implement three service classes - UserService, EventService, TicketService which should contain user, event and booking related functionality accordingly. Create implementation of Bookingfacade interface which should delegate method calls to services mentioned above.
    
    2. Implement DAO objects for each of the domain model entities (User, Event, Ticket). They should store and retrieve data from a common in-memory storage - java map. Each entity should be stored under separate namespace, so you could list particular entity types. Example for ticket - map entry {"ticket:<ticketId>" -> {<Ticket object>}}. E.g. {"ticket:12345" -> {"id" : 12345, "place" : 23, .....}}
    
    3. Configure spring application context based on xml config file.
    
    4. Storage should be implemented as a separate spring bean, which contains a map inside it. Don't try to inject the map into DAO's directly.
    
    5. Storage bean should be inserted into DAO's beans using autowiring.
    
    6. Services beans should be injected into facade using constructor based injections.
    
    7. Rest of the injections should be done in a setter-based way.
    
    8. Cover code with unit tests.
    
    9. Code should contain proper logging
    
    9. Create several integration tests that instantiate the Application Context using spring-test module and perform some real-life scenario (e.g. create user, then create event, then book ticket for this event for the user, then cancel it)
    
    Extra task (optional, should be done when previous items are complete): 
    1. Use "p" namespace to define properties
    2. Implement ability to initialize storage with some prepared data from file during the application start (use spring bean post-processing features). Path to the concrete file should be set using property placeholder and external property file. 


# Steps :
1. Implement service classes : `EventServiceImpl, UserServiceImpl, TicketServiceImpl, BookingServiceImpl`.
2. Implemented DAO objects for all model entities.
3. Implemented three service classes - UserService, EventService, TicketService.
4. Added `getItemsFromPages` and unit tests.
5. Configured spring application context based on xml file.
6. Storage has been inserted into DAO's beans using `@Autowired`.
7. Storage was implemented as a separate spring bean, which contains map inside.
8. Added static-factory method `createUser`.
9. Added static DAO objects with in-memory storage java map.
10. Added User tests.
11. Added Event tests.
12. Moved common methods of UserTest, EventTests in one file.
13. Added TicketTests.
14. Added proper logging.
15. Added TestRealScenario.
16. Extra task : Use "p" namespace to define properties.
17. Implemented getting data from json files.
18. Changing repository hashMap in order to add prefix to key.
19. Fix unit tests -> added prefix in getById, update and create methods.


