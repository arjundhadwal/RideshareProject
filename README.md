# RideshareProject
My Rideshare Project is structured around four main classes: Person, Car, Station, and Simulator, as well as the tester. The **Person** class does not do anything of its own; it is merely a container and an object to be used by other classes. The **Car** class governs vehicles and contains methods to describe their movement as well as keeping track of the passengers inside it and loading/unloading where appropriate. The **Station** class acts as a container of Persons waiting in queues to go left, right, or are at their destination and stay inside that specific Station permanently. Lastly, the Simulator class has the methods that are intended to be run from the tester, and the main method accesses the whole simulation through this class **only**. The **tester** is pretty self-explanatory, running initial setup methods and then continuously looping the execution for any number of cycles desired.

# Enhanced Tester Functionality for Optimizing Car Count
Within the tester, I have implemented a function (one that I am quite proud of) that can run several simulations in quick succession with varying amounts of cars, in order to find out what amount of cars is the most efficient, and what is most profitable. My first tests were a range of 20-40 cars and 50 passengers spawned into the simulation.

I measured efficiency as a ratio of passengers successfully transported per car. What I found was that despite sometimes transporting fewer passengers, simulations with a lower car count were often much more efficient with the cars' use of space, often going as high as 1.5-1.8 passengers succesfully transported per car. In a series of 8 trials, I found that the average "most efficient" car count was 23.125 cars for 50 passengers.

I measured profit using a few parameters: the "revenue" from each passenger was set to $2 per passenger succesfully transported to their destination, and the "operating cost" was one dollar per car. Therefore cars would make a profit as long as they transported 0.5 passengers to their destination per car on average.

What I found from my "profit analysis" algorithm was that the results were quite random, because of the fact that cars and passengers are spawned at random. My average "most profitable" car count was 30, which is also the average of 20 and 40, the upper and lower bounds of the car counts in my testing. I also found, however, that the distribution of the "most profitable" car counts was uneven. The most profitable scenarious could be put into two groups: one where the car count is very small, and cars are efficient with their space, or one where car count is high and each car transports enough passengers to make a decent profit. Despite the average of the "most profitable" scenarios being 30, the low car count scenarios which were not the #1 most profitable scenario consistently pulled in more money than the higher car count scenarios.

**However, due to the randomness of the situations, I decided to run more tests with a much higher passenger count and car count range to see what the data shows. This is because the greater number of variables makes the situation more likely to reflect the actual math at play behind the scenes.** So, I decided to run tests with a range of 125-375 cars and 500 passengers. Here are the results after eight trials:

**Mean most efficient car count: 132.625**

**Mean most proftable car count: 215.375**

Notably, in my second testing range, the groupings of most profitable car count were proportionally much smaller than in the first testing sequence. Efficiency groupings were also improved and more concentrated, and cars consistently transported about 2.2 passengers per at peak efficiency. Randomness was still a factor, but the greater car count seemed to lessen it significantly.

The average "most profitable" car count was, on average, 215.375 cars (in a range of 125-375 and with 500 passengers generated). I suspect that this number is more a function of passenger count than car count, as in the previous test the most profitable car count was around 1/2 the passenger count. In this case, each car earned around 2 dollars.

The average "most efficient" car count was 132, repeating the trend from earlier that low car counts allow them to become full and most effective. However, the efficiency value does not take into account the number of passengers transported in total.

# Conclusion
Perhaps, to more accurately assess the optimization of car efficiency and usage, a scoring system could be created as a product of efficiency, profit, and total passengers ferried. If I was to analyze this data for a rideshare company, I would use the car count displayed in the "most profitable" section because my goal would be to make the most money, and the "most profitable" count best describes the optimization of car use to ferry the highest reasonable number of passengers without over or under spending on cars.

Lastly, here is the link to the Excel sheet that tracked my data: [Spreadsheet](https://docs.google.com/spreadsheets/d/183oSmwOiiiMwpJcSEKjohAMUiBSWlTOQAQRgRnSWGqA/edit?usp=sharing).