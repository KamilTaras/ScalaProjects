package lectures.part2OOP

import scala.annotation.unused

object Enums {

  enum Permissions {
    case READ, WRITE, EXECUTE, NONE

    def openDocuments(): Unit =
      if (this == READ) println("oppening document...")
      else println("reading not allowed")
  }

  enum PermissionsWithBits(bits: Int) {
    case READ extends PermissionsWithBits(4)
    case WRITE extends PermissionsWithBits(2)
    case EXECUTE extends PermissionsWithBits(1)
    case NONE extends PermissionsWithBits(0)
  }

  object PermissionsWithBits {
    def fromBits(bits: Int): PermissionsWithBits = PermissionsWithBits.NONE
  }

  val somePermission: Permissions = Permissions.READ
  val somePermissionOrdinal: Int = somePermission.ordinal
  val allPermissions = PermissionsWithBits.values //array of all possible values of the enum
  val readPermission: Permissions = Permissions.valueOf("READ")
  def main(args: Array[String]): Unit = {
    somePermission.openDocuments()
    println(somePermissionOrdinal)
  }

}