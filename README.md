# Kotlin maze game
Maze generator game based on kotlin (another implementation of https://github.com/mhero/java-maze)

#### Build: ####

- Install gradle
- Run in terminal command:
	
```bash
./gradlew clean jar
./gradlew build
```

#### Run: ####
	
```bash
java -jar build/libs/kotlin-maze-1.0-SNAPSHOT-standalone.jar
```

#### Includes: ####

- Maze generator
- Game menu
- Trivia topic when enemies encounter
- Auto restart after winning

Instructions:

- Start the program
- Main menu shows, start a new game using 1, load previous game using 2
- You'll be sent to secondary menu, you can navigate the maze using that
- To save, return to manin menu using 5, and save it using 3
- Once you encounter an enemy "X" you'll be prompt with a question

![alt text](https://i.imgur.com/MfA7r4Q.png)



