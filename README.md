# RideshareProject
My Rideshare Project is structured around four main classes: Person, Car, Station, and Simulator, as well as the tester. The **Person** class does not do anything of its own; it is merely a container and an object to be used by other classes. The **Car** class governs vehicles and contains methods to describe their movement as well as keeping track of the passengers inside it and loading/unloading where appropriate. The **Station** class acts as a container of Persons waiting in queues to go left, right, or are at their destination and stay inside that specific Station permanently. Lastly, the Simulator class has the methods that are intended to be run from the tester, and the main method accesses the whole simulation through this class **only**. The **tester** is pretty self-explanatory, running initial setup methods and then continuously looping the execution for any number of cycles desired.




