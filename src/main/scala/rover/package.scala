package object rover {

  //we should really be using tagged types but it's not worth it for this exercise.
  type CyclicIndex = Int

  //same with these
  type PositionVector = GridCoordinates
  val PositionVector = GridCoordinates

  type DifferenceVector = GridCoordinates
  val DifferenceVector = GridCoordinates
}
