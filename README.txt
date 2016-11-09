user: 010872316 (Nguyen, Nghi)
user: 010485683 (Chau, Tsz Sum)
user: 010301928 (Leong, Alec)

Details: 
		(1) This homework assignment was executed with VMWare Workstation 12 Player with Ubunto 64-Bit terminal and Eclipse. 
			Below are the commands to execute the homework assignments using either of the two methods above.
		(2) Section4_<insert student id>_HW5.zip contains the following:
	        (i)  ConnectFour.jar 
				 ConnectFour.jar is an executable jar file for this homework assignment.
	        (ii) Directory 'cs151_connectFour-master' which contains:
		         (1) Directory '.settings' 
		         (2) Directory 'bin' 
		         (3) Directory 'src' 
			     (4) .classpath
			     (5) .DS_Store
			     (6) .project
                 (7) build.fxbuild
				 Directory 'cs151_connectFour-master' is a folder to be imported/pasted into 
				 Eclipse for this homework assignment to be executed via Eclipse.
			   
*************************How to Run Homework 5 Executable Jar File via Terminal*************************

Prequisites:

	Below are the commands to execute the homework assignment executable jar file via terminal
	
	To compile and run the jar file the following syntax is: java -jar ConnectFour.jar <argument_1> <argument_2>
	(1) <argument_1> is an integer argument and it creats an <argument_1> x <argument_1> board
	(2) <argument_2> is an integer argument and determines a number of sequences a player needs to win
	
	Once the application opens this is how the game works:
		
		(1) Player 1 is represented in Green
		(2) Player 2 is represented in Red
		(3) Player 1 makes the first move
			All moves alternate from Player 1 then to Player 2 until the game is over
		(4) To make a move, click on the column you would like to place your piece
		(5) A 'Clear' botton located on the right clears the board game
		(6) Above the 'Clear' button is the count of wins for both players
			Format: (Player 1's Number of Wins in Green):(Player 2's Number of Wins in Red)
		(7) To exit the game either
		    (i) Hold Ctrl + C on the terminal
			or (ii) Close the Java application

alec@alec-virtual-machine:/mnt/hgfs/Desktop$ ls
cs151_connectFour-master.zip
alec@alec-virtual-machine:/mnt/hgfs/Desktop$ unzip cs151_connectFour-master.zip
Archive:  cs151_connectFour-master.zip
  inflating: cs151_connectFour-master/ConnectFour.jar  
   creating: cs151_connectFour-master/cs151_connectFour-master/
  inflating: cs151_connectFour-master/cs151_connectFour-master/.classpath  
  inflating: cs151_connectFour-master/cs151_connectFour-master/.DS_Store  
  inflating: cs151_connectFour-master/cs151_connectFour-master/.project  
   creating: cs151_connectFour-master/cs151_connectFour-master/.settings/
  inflating: cs151_connectFour-master/cs151_connectFour-master/.settings/org.eclipse.jdt.core.prefs  
   creating: cs151_connectFour-master/cs151_connectFour-master/bin/
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/.DS_Store  
   creating: cs151_connectFour-master/cs151_connectFour-master/bin/application/
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/AbstractPlayer.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/BoardGui.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/BoardModel.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/BoardPresenter.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/Chip.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/ConnectFour.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/game.css  
  inflating: cs151_connectFour-master/cs151_connectFour-master/bin/application/Players.class  
  inflating: cs151_connectFour-master/cs151_connectFour-master/build.fxbuild  
  inflating: cs151_connectFour-master/cs151_connectFour-master/README.md  
   creating: cs151_connectFour-master/cs151_connectFour-master/src/
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/.DS_Store  
   creating: cs151_connectFour-master/cs151_connectFour-master/src/application/
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/AbstractPlayer.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/BoardGui.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/BoardModel.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/BoardPresenter.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/Chip.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/ConnectFour.java  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/game.css  
  inflating: cs151_connectFour-master/cs151_connectFour-master/src/application/Players.java
alec@alec-virtual-machine:/mnt/hgfs/Desktop$ ls
cs151_connectFour-master
cs151_connectFour-master.zip
alec@alec-virtual-machine:/mnt/hgfs/Desktop$ cd cs151_connectFour-master/
alec@alec-virtual-machine:/mnt/hgfs/Desktop/ cs151_connectFour-master$ ls
ConnectFour.jar  cs151_connectFour-master
alec@alec-virtual-machine:/mnt/hgfs/Desktop/ cs151_connectFour-master$ java -jar ConnectFour.jar 6 4

The application will now open and the game begins

***********************************How to Run Homework 5 via Eclipse***********************************

Prequisites:

(1) Open Eclipse (Java IDE)
(2) Go to the 'File' tab located on the upper left hand corner
(3) Go to 'Open Projects from File System..' 
(4) Under 'Import source:' go to directory and locate and select the directory 'cs151_connectFour-master'
(5) Then click 'Finish'
(6) A new folder called 'HW5' will appear in 'Package Explorer'
(7) Under the folder 'HW5' go to src->application->ConnectFour.java
(8) Open the file ConnectFour.java
(9) Now go the the 'Run' tab on the top of Eclipse
(10) Select 'Run Configurations' 
(11) Under 'Run Configurations' go to the 'Arguments' tab
(12) Under the 'Arguments' tab go to 'Program arguments'
(13) Your input will be <argument_1><space><argument_2>
	(i)   <argument_1> is an integer argument and it creats an <argument_1> x <argument_1> board
	(ii)  <space> is a single white space character 
	(iii) <argument_2> is an integer argument and determines a number of sequences a player needs to win
	For Example:
		Program arguments:6 4 
(14) Then click run

The application will now open and the game begins

Once the application opens this is how the game works:
	(1) Player 1 is represented in Green
	(2) Player 2 is represented in Red
	(3) Player 1 makes the first move
		All moves alternate from Player 1 then to Player 2 until the game is over
	(4) To make a move, click on the column you would like to place your piece
	(5) A 'Clear' botton located on the right clears the board game
	(6) Above the 'Clear' button is the count of wins for both players
		Format: (Player 1's Number of Wins in Green):(Player 2's Number of Wins in Red)
	(7) To exit the game either
	    (i) Hold Ctrl + C on the terminal
		or (ii) Close the Java application