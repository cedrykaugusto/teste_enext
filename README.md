# teste_enext
This project was developed as an evaluation of programming knowledge to work on enext. The codes contained here solve the tasks 1, 2 and "plus" described in https://gist.github.com/sergiofillipi/d049634d4b7d0cb01812322de51c6239.

The project was developed in Java and is divided into three packages:

Model: contains the model classes of the objects identified by the interpretation of the statements.

Controller: contains the class "InterpreterLog.java", where is all the logic regarding the interpretation of the game log file.

Main: Contains the main class of the project that only prints the menu and calls the class "InterpreterLog.java". In the menu there are the options of printing the general report with all games, the report of deaths grouped by cause and the ranking of the players by greater number of kill of each match.

The structure was thought of as follows:

A game has a hashmap of players whose key is the id of the player; A hashmap of deaths caused by the world jack the world does not enter the list of players, but deaths must be accounted for to be in the report. The key of this hash map is the death cause id to facilitate the task plus report; And also contains a hashmap of autokills that are not counted in the kills of the players but also should appear in the reports.

A player has an id, a name, a hashmap where the key is the id of the cause of death and the value is a list of all the kills he caused with that same cause of death; Contains the total number of kills and the number of punishments per autokill or death caused by the world (The task statement does not mention that autokill generates punishment, but comparing the outputs in the log and in the program, this question was identified). The number of kills returned will always be the punishment subtracted from the total.

A kill contains only the id of the cause of death and the player killed.

For translation of the cause of death id, there is a dictionary represented by a hashmap where the key is the id and the value is a string with the name of the cause.
