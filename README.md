# Number Scrabble Game
This project is a 1-on-1 Number Scrabble game written in Java, using OOP.
- The objective of the game is to get exactly a sum of 15 using three cells in any direction.
- Two players take turns selecting a position on the board and a number 1-9. (E.g. A5)
- No numbers can be repeated.
- The player to first get 15 using all three cells in any direction __wins__!
- Good luck - have fun!
 

## Read more: [Number Scrabble](https://en.wikipedia.org/wiki/Number_Scrabble)


### Design choices
- The available positions and numbers are not printed, only the board per turn is printed. This has been chosen in order to increase the difficulty of the game. Handling of incorrect input has been created.

### Program details
1. NumberScrabbleClient.java
	- Description
3. InputManager.java
	- Description
5. Game.java
	- Description
7. Board.java
	- Description
9. Cell.java
	- Description
11. Player.java
	- Description
	
### Future ideas
- Currently the game is created using a 3x3 grid and numbers ranging from 1-9.
	- [ ] Potential later implementation: player decides grid size.
- There is currently only 1 option, to play vs another player. 
  Next step is:
   - [ ] implementation of computer(AI) vs player. (Using Minimax?)

