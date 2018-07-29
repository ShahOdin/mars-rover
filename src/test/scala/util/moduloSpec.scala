package util

import org.scalatest.{FlatSpec, Matchers}

class moduloSpec extends FlatSpec with Matchers {

  "Positive modulo" should "return the correct value for negative values smaller than the divisor." in {
    positiveModulo(-1, 3) shouldBe 2
  }

  it should "return the correct value for negative values bigger than the divisor." in {
    positiveModulo(-7, 3) shouldBe 2
  }

  it should "return 0 value for negative values divisible by the divisor." in {
    positiveModulo(-9, 3) shouldBe 0
  }

  it should "return the correct value for positive values smaller than the divisor." in {
    positiveModulo(1 , 3) shouldBe 1
  }

  it should "return the correct value for positive values bigger than the divisor." in {
    positiveModulo(7, 3) shouldBe 1
  }

  it should "return 0 value for positive values divisible by the divisor." in {
    positiveModulo(9, 3) shouldBe 0
  }
}
