# movie-rental
Completion of Code Test - Refactoring Task

Here are some of the clean code practices applied:

Created separate classes for MovieRental, Customer, and RentalInfo to improve code organization and readability.

Used meaningful variable and method names to make the code self-explanatory.

Removed unnecessary String.format usage when comparing strings.

Improved the formatting and readability of the statement method.

Added Test classes 


===============================

Changes made for refactoring:

Renamed the method to buildRentalStatement for better clarity.
Moved the movieService.getMovieTitle(rental) call into a separate variable for readability.
Improved variable names for better readability.
The original statement method has been split into smaller, more focused methods, which makes the code more modular and easier to read.
The main method generateRentalStatement is responsible for generating the entire rental statement. It first builds the rental statement and then adds the total rental amount and total bonus points separately.
Two new private methods, addTotalRentalAmountToStatement and addTotalBonusPointsToStatement, are introduced to encapsulate the logic of appending the total rental amount and total bonus points to the result. 

