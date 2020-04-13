package il.ac.technion.cs.softwaredesign



import il.ac.technion.cs.softwaredesign.storage.read
import il.ac.technion.cs.softwaredesign.storage.write
import java.nio.charset.Charset

val charset = Charset.defaultCharset()

fun keyExists(key: String): Boolean{
    //return true
    val res = read(key.toByteArray(charset))
    if (res === null) return false
    //We are assuming that when deleting a entry from the db, we write to the key an empty bytearray
    if (res.isEmpty())
            return false
    return true
}

fun writeToDB(key: String, value: String){
    write(key.toByteArray(charset), value.toByteArray(charset))
}

//This is an ugly solution but for now it's what we're moving forward with
fun eraseFromDB(key: String){
    write(key.toByteArray(charset), ByteArray(0))
}