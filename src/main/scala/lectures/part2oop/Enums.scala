package lectures.part2oop

object Enums extends App{

  //Available in scala 3+
//  enum Permissions {
//    case READ, WRITE, EXECUTE, NONE
  // def openDocument(): Unit =
//      if (this == READ) println("Opening a document")
//      else println("reading not allowed.")
//  }
//
//  val somePermissions: Permissions = Permissions.READ

  // Constructor arguments
//  enum PermissionsWithBits(bits: Int) {
//    case READ extends PermissionWithBits(4) //100
//    case WRITE extends PermissionWithBits(2) //010
//    case EXECUTE extends PermissionWithBits(1) //001
//    case NONE extends PermissionWithBits(0) //000
//  }

  // can also have companion objects

//  object PermissionWithBits {
//    def fromBits(bits: Int): PermissionWithBits =
//      permissionsWithBits.NONE
//  }

  //standard API
  //print position
//  val somePermissionsOrdinal; = somePermission.ordinal

}
