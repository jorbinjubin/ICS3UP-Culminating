public static void main (String[] args){
    RoadSigns r = new RoadSigns();
    r.splashScreen();
    while (true) {
	r.mainMenu();
	if (r.menuChoice == 1) break;
	else if (r.menuChoice == 2) r.instruction ();
    //     else if (r.menuChoice == 3) r.viewLeaderboard ();
    //     else {
    //         if(!r.skipLearning) r.learning();
    //         if(!r.skipGameLoop) r.maze();
    //         r.gameLoop();
    //     }
    // }
    // r.goodbye ();
}

