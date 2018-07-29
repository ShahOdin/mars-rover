package rover

import rover.Movement._

object AutoPilot {

  //need to think about all the four paths going in different directions not just the line joining them.
  val findShortestPath: Rover => GridCoordinates => List[MovementCommand] = ???

  //most likely a BFF search.
  val findShortestUninterruptedPath: Rover => ObstacleMap => GridCoordinates => Option[List[MovementCommand]] = ???

  val pilotInstructions: List[MovementCommand] => Rover => Rover = {
    commands =>
      commands.foldLeft(_) {
        (rover, command) => rover.move(command)
        //draw/log rover movement here.
      }
  }

}
