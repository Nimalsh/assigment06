object Main {
    def encrypt(text: String, shift: Int): String = {
      val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
      text.map { c =>
        val isLowerCase = c.isLower
        val shiftedChar = if (c.isLetter) {
                            val index = alphabet.indexOf(c.toUpper)
                            alphabet((index + shift) % alphabet.length)
                        }
                        else {
                        c
                        }
        if (isLowerCase) shiftedChar.toLower else shiftedChar
      }
    }

    // Decryption function
    def decrypt(encryptedText: String, shift: Int): String = {
      encrypt(encryptedText, -shift)
    }

    def main(args: Array[String]): Unit = {
      println("Enter the text to encrypt : ")
      val text = scala.io.StdIn.readLine()
      val shift = 3

      // Encryption
      val encryptedText = encrypt(text, shift)
      println("Encrypted Text: " + encryptedText)

      // Decryption
      val decryptedText = decrypt(encryptedText, shift)
      println("Decrypted Text: " + decryptedText)
    }

}
