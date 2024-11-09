### New IO (nio)

Java 7 introduced several classes and interfaces for manipulating file systems.
The NIO api allows developers to access low-level OS operations such as the `WatchService` and the ability to create links in nix operating systems.

Some important classes of the NIO api are listed below.
 - Files : Class consists of static methods that operate on files and directories.
 - FileStore : Storage for files??
 - FileSystem : Provides an interface to a file system and is the factory for objects to access files and other objects in the file system.
 - FileSystems : Factory methods for file systems.
 - LinkPermission : The permission class for link creation operations.
 - Paths : Class consists of static methods that return a Path from a path string or URI.
 - FileVisitor: An interface for visiting files.
 - WatchService: An interface for watching various file-system events such as create, delete and modify.
