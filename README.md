# gilded-rose-kata
Refactoring of the gilded-rose-kata

To compile it execute: 
-> mvn clean compile
To test it execute: 
-> mvn clean test

I added tests to cover the different cases that followed the requirements especified in GildedRoseRequirements.txt
Then I refactored UpdateQuality method and verify that the tests were still OK.
Afterwards I added new tests to cover the new requirement for conjured items.
Finally I implemented the code in order to passed the conjured items tests.

* I modified TexttestFixture to compare the outcome with a file due to enviroments restrictions.
