package crypto

trait SlowEquals {

  /**
   * Compares two byte arrays in length-constant time. This comparison method
   * is used so that password hashes cannot be extracted from an on-line 
   * system using a timing attack and then attacked off-line.
   * 
   * @param   a       the first byte array
   * @param   b       the second byte array 
   * @return          true if both byte arrays are the same, false if not
   */
  def equals(
    a : Array[Byte],
    b : Array[Byte]
  ):Boolean = {
    
    var diff = a.length ^ b.length

    for(i <- 0 until a.length if i < b.length)
      diff += a(i) ^ b(i)

    diff == 0
  }
}