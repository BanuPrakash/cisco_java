# JAVA
Banuprakash C

Full Stack Architect, Corporate Trainer

Co-founder & CTO: Lucida Technologies Pvt Ltd., 

https://www.lucidatechnologies.com/

https://www.linkedin.com/in/banu-prakash-50416019/


Emails: 
banuprakashc@yahoo.co.in

banuprakash.cr@gmail.com

banu@lucidatechnologies.com

Repository for Training:
https://github.com/BanuPrakash/CISCO_JAVA

===================================


Softwares Required:
1)  openJDK 17
https://jdk.java.net/java-se-ri/17

Setting UP: https://www.youtube.com/watch?v=p4ijugQ_3EI

java --version

2) IntelliJ Ultimate edition 
https://www.jetbrains.com/idea/download/?section=mac

3) MySQL  [ Prefer on Docker]

Install Docker Desktop

Docker steps:

```
a) docker pull mysql

b) docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit

```
* OOP
* Java Collection Framework and streams
* Concurrency
* Maven build tool and JDBC

==============================

Object Oriented Programming:
* Object : state and behaviour
Tv Object as example: 
state: on / off, channel, volume, brightness, ...
behaviour / action / messages: on/off, changeChannel, increase/decrease ...

Object communicate with other objects by sending messages

What messages an object can accept is exposed thro its interface.

Thinking in Object; Templates for object --> class / function / Type ,...
```
class Tv {
    state
    behaviour
}

function Tv() {
    state
    behaviour
}

Type Tv 

End Type
```

SOLID Design Principle

S --> Single Responsibility
O --> Open Close Principle; component/object should be closed for change but open for extension
L --> Liskov substitution Principle; In Generalization and Specailization relationship, at any point of time and Specialized object can replace a generalized one in order to get the work done.
I --> Interface segreggation; Abstraction 
D --> Dependency Injection; Inversion Of Control; needs Service Providers

=========================================

What is Java?
Java --> Technology; platform provides APIs  to execute byte code
To generate a byte code we write a program and compile it

Java programming language --> java compiler --> byte code
Kotlin programming language --> kotlin compiler --> byte code
Groovy programming language --> groovy compiler --> byte code

===========

Account.java
```
   public class Account {
        private double balance; // state

        // action / message / behaviour / instance method
        // mutation
        public void deposit(double amt) {
            balance += amt;
        }

        // accessor
        public double getBalance() {
            return balance;
        }
   } 
```

javac Account.java --> Account.class

AccountExample.java
```
    public class AccountExample {
        public static void main(String args[]) {
            Account rahulAcc = new Account(); // new keyword for DMA {HEAP}
            rahulAcc.deposit(5000);
            System.out.println(rahulAcc.getBalance());

            Account swethaAcc = new Account(); // new keyword for DMA {HEAP}
            swethaAcc.deposit(9000);
            System.out.println(swethaAcc.getBalance());
        }
    }

```

javac AccountExample.java ---> AccountExample.class

================

JRE: Java Runtime Environment
java AccountExample {make sure this class contains main()}  

```
Part 1: ClassLoader: Secondary Storage --> Primary Storage
* findLoadedClass()
* loadClass() --> defineClass() [ convert byte code to platform specific data structure  / code]

loadClass() checks current folder or CLASSPATH environment variable
set CLASSPATH = \users\banu\projects; \users/banu\libraries;..

* findSystemClass() --> defineClass()

Platform can be Mobile / Elevator / Access Card / Tv / Laptop .. Target machine
byte code --> Platform independent  and architecture neutral; portable
Output of defineClass() is platform specific code
```

data allocated on HEAP area will have default values;
int to 0; double to 0.0; objects to null ; character to null character; boolean to false;

No concept of garbage or junk value in heap area

```
context.behaviour(arguments);
fan.on();
tv.on();
tv.changeChannel(454);
rahulAcc.deposit(5000); ==> deposit(rahulAcc, 5000);
```
============

Logically group objects/classes in building enterprise application
* Entity / model / domain classes
they are used to represent the state which is long lived; beyoud the life of application
they are associated with persistent store like database / file ...
Most of the time one class per table in database.

Example: Uber application
Customer, Driver, Vehicle, Trip, Payment, ...

Example : Amazon
Customer, Product, Supplier, Order, LineItems, ...

Generally these classes won't have any business logic.
they contain constructors, getters, setters, hashCode, equals, toString method

https://datamodels.databases.biz/

* DAO / DAL classes: Data Access Object
They contain CRUD operations
CREATE READ UPDATE DELETE

* Business : business logic

* Service : facade over business and DAO layer
generally they contain transactional code; making coarse grained layer

```
// one call from client / UI
public void transferFunds(Account fromAcc, Account toAcc, double amt) {
    BEGIN Tx
    // check eligibility --> business layer
    // check balance --> call to DAO layer
    // update fromAcc --> call to DAO layer
    // insert into Tx table --> call to DAO layer
    // send SMS 
    COMMIT Tx
}

```
* UI : user interface / client code

* Exception classes
an object which tells
1) What went wrong?
2) Why?
3) Where?

* Utility : helper classes

package: in java it's a folder for logically grouping of classes
they also help in class namespace identification

Date d; // ??

java.util.Date d1 ...
java.sql.Date d2 ...

```
com
    cisco
        prj
            entity
                Customer.java
                Order.java
                ...
            dao [one per table]
                CustomerDao.java
                OrderDao.java
                ...
            service [one per actor]
                AdminService.java
                CustomerService.java
            utility
                ..
            exception
                ...
            business
                ...
```


IntelliJ --> New Project --> Java --> IntelliJ Project


Primitive types: reside on stack
reference types: reside on heap are

===============

constructors:
1) used to initailze objects
2) can be overloaded: can have different ways to initialize
3) they look like methods  having same name as that of class
4) they implitily returns the created object
5) can't be void
6) compiler creates default constructor if no constructors are written

I need to keep track of how many instances of Account is created
static : class data
instance: object data

rahulAcc.getBalance(); ===> getBalance(rahulAcc); // internally rahulAcc -> this pointer

Account.getCount(); ==> getCount(); // no explict passing of this pointer; hence static methods can't access state

rahulAcc.getCount(); ==> Account.getCount(); 

---

local variables --> stack
instance variables --> heap
static variables --> metaspace / earlier it was called as method area

=================================================

Every class inherits from java.lang.Object class
important methods of Object class:
equals, hashCode, toString, getClass,   wait, notify, notifyAll

entity classes should override equals, hashCode, toString [ used only in development env]

===================================

Relationship between objects / classes

* Generalization and Specialization [ IS A] 
* Association [ HAS A]
* Realization
* Uses A 

Java Build tools:
* Maven
* checkstyle: Coding conventions
* PMD / findBugs: Coding Stds
* SonarQube
* Jenkins [ CI / CD]

PMD / findBugs / SonarQube: --> Copy & Paste Code

https://www.youtube.com/watch?v=hXkzfLaps8s

=========================================

* Generalization and Specialization [ IS A] 
--> Inheritance
--> extends is the keyword in Java
--> every object is inherited from java.lang.Object [implicit]
public class Account
translates to:
public class Account extends Object
--> java doesn't support multiple inheritance
public class A extends B, C { // not valid

====

In Java all instance methods internally are virtual functions; all instance methods are dynamic binding

```
Mobile[] mobiles = new Mobile[100];
...
for(i = 0; i < mobiles.length; i++) {

}
Tv[] tvs = new Tv[1000];
for(i = 0; i < tv.length; i++) {
    
}

```

Product p = new Mobile();
instanceof --> family of

p instanceof Mobile ===> evaluate to true
p instanceof Product ==> true
p instanceof Object ==> true
p instanceof Tv ==> false

p.getClass() ===> Mobile.class

====================================

abstract class and abstract methods:
abstract class: classes which are meant only for generalization; objects of such classes doesn't exist in real world
Examples: Product, Account,..
cannot be instantiated

abstract methods: pure virtual functions; no method body;
all inherited classes need to implement them or mark the inherited class also as abstract

Rule:
* if one of the method is abstract then class has to be declared abstract

* abstract class need not have abstract methods
====

Realization relationship
* A component will realize the behaviour specified by other
* program to contract
* program to interface

In java we do it using interface

interface interfaceName {
    abstract behaviour
}

===========
// all methods in interface are by default public and abstract

```
interface EmployeeDao {
    void addEmployee(Employee e);
    Employee getEmployee(int id);
}

implements ==> Realization

public class EmployeeDaoDbImpl implements EmployeeDao {
    public void addEmployee(Employee e) { insert  }
    public Employee getEmployee(int id) { select }
}


UI code:

click on add button

employeeDao.addEmployee(e);

employeeDao.getEmployee(34);

```

Why program to interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING
4) INTEGRATION
5) LOOSE COUPLING

Scenario 1:
Switching between strategies
MobileDao mobileDao = new MobileDaoDbImpl();
OR
MobileDao mobileDao = new MobileDaoMongoImpl();

Issues: There are many heterogenous clients like Web, Mobile, Desktop, Tv ...
Switching between strageties needs every client code to change.
No abstraction; Why should client know about type of implementation
No consistency; some will update to Mongo, other clients might still be use DB. ---> issue

Solution : Use Factory Pattern
Every client code :
MobileDao mobileDao = MobileDaoFactory.getMobileDao();

Zero changes in client

Scenario 2:
No code changes, even in Factory
Solution: use Configuration files like XML / properties, ...
for XML we need to learn SAX / DOM,
properties file is a key/value pair
MOBILE_DAO=com.cisco.prj.dao.MobileDaoDbImpl



Creating an Object:
1) if we know class name 
new Mobile()

2) if class name is dynamic
str = "com.cisco.prj.entity.Tv"

Class.forName(str).newInstance();

=========================================

Day 2

Recap:
SOLID 
JRE: JVM, Metaspace, Stack, Heap.
Implict "this" reference passed as first argument to instance methods only and not to static methods
instance variables vs static/class variable
constructor, super, static block

Generalization and Specialization relationship --> IS A --> Inheritance --> extends
* Java doesn't support multiple inheritance
* every class inherits java.lang.Object
abstract class and abstract methods

Realization Relationship: implements 
Factory Methods for decoupling

Reflection API:
anyObject.getClass().getMethod(); // gets all the methods including inherited methods of the class for a given object.
method.invoke(object); // if method name is dynamic

// we can create object of a class if we don't know the name is advance
Class.forName("fully-qualified-class-name").getConstructor().newInstance();

====================================================================

* Realization Relationship vs Generalization and Specialization
* Interface Segreggation
* interfaces for OCP

Anonymous classes can be created from interface or abstract classes
classes are created on the fly within JRE; once object is created of that class, classdata can be removed from metaspace

If interface has only one method to implement; its called FunctionalInterface; for such interfaces we can use lambda expressions instead of anonymous class approach.

===================================

Introduction to Garbage Collector [GC]
* Any code which works on Virtual Machines / engines it comes with GC; like JavaScript / Java / C# 
* We allocate memory; but don't explictly release them;
* GC is resposible for releasing memory

HEAP

* GC is a low priority thread
GC can be Short term GC {Scaveger} / Full term GC
Short term GC  is responsible to manage / clear un-referenced objects in Eden Area
If objects survive 3 rounds of Short-term GC --> objects need to be moved to old generation
*  long term GC runs for every 3 rounds of Short-term GC; it is responsible for Old Generation

Why we don't use pointers in Virtual Machines / engines?

=================

Exception Handling and JCF

Exception: any abnormal condition that arises during program execution

In java exception is an object whic tells:
1) What went wrong? [ ArithmeticExceptio ]
2) Why? [ / by zero ]
3) Where? [line ,method, class, ...]

Exception in thread "main" java.lang.ArithmeticException: / by zero
	at UncheckedExample.doTask(UncheckedExample.java:10)
	at UncheckedExample.main(UncheckedExample.java:4)

Error type of exceptions: error type of exceptions are one which can't be handled; fix the bug and re-run the application
Examples: OutOfMemoryError, StackOverflowError

Exception type of exceptions: can be handled, can have alternate flow
* Unchecked type of exceptions
    These checked exceptions occur due to issues with JRE;
    these exceptions are supposed to be handled with conditional statements
    Compiler doesn't enforce you to handle that

    Examples: ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException

```
    int data = 100;
        int no = 0;
        System.out.println(data / no); // ArithmeticException

    Solution:
    if(no != 0 ) {
        System.out.println(data / no); 
    }
    Product p = null;
    p.setPrice(3433); // NullPointerException

    Solution:
    if(p != null) {
        p.setPrice(3433); 
    }
    int[] data = {5,1,11};
    System.out.println(data[10]); // ArrayIndexOutOfBoundsException

    Solution:
    int index = 10;

    if(index >= 0 && index < data.length) {
        System.out.println(data[index]);
    }

```

* Checked Type of exception
these exceptions occur due to reasons outside of JRE; like database, OS, file, sockets, Threads, ...
Compiler enforces you to handle these type of exceptions
handling is done using try/catch/finally blocks

Examples: IOException, SocketException, SQLException, ClassNotFoundException, InterruptedException, ...

```
 private static void doTask() {
        System.out.println("doTask() called!!!");
        // a.txt can exist or not
        try {
            FileInputStream fis = new FileInputStream("a.txt");
            // other actions
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
```

Exceptions are pushed up the call stack.

```
main() --> a() --> b() --> c()
```

If exception occurs in c(); it can be handled in c(); if not handled it is propaged/pushed to b();
b() can delegate to a(); can be handled in a() or delegate to main();
if main() doesn't handle it hands it over to DefaultHandler provided for the thread.
If exception is handed over to the DefaultHandler; DefaultHandler prints the error and program terminates

===

In case of Checked type of exception; we need "throws" keyword to specify that exception is propagated up the call chain.

"throw" keyword --> pending

===============================================

Generic Types:

```
public class Rectangle {
    private double width;
    private double height;
}

Rectangle r1 = new Rectangle(4.5, 1.2);

public class IRectangle {
    private int width;
    private int height;
}

IRectangle r2 = new IRectangle(4 , 12);

Solution: 

public class Rectangle<T> {
    private T width;
    private T height;
}

now width and height are of type "T" generic

Rectangle<Double> r1 = new Rectangle<Double>( 4.1, 6.7);
Rectangle<Integer> r2 = new Rectangle<Integer>( 2, 7);
Rectangle<String> r3 = new Rectangle<String>( "A" , "B" );

Integer, Double are TypeWraper classes for int and double
Why?
Generics is not applicaple for primitive types, can be used only for Objects

int x = 10;
Integer iX = x; // Boxing, primitive --> object
...

int y = iX; // unboxing, object --> primitive

```

Compiler erases the type definitions of generics, code gets converted to:

```

public class Rectangle<T> {
    private T width;
    private T height;
}

to

public class Rectangle {
    private Object width;
    private Object height;
}

Example 2: Narrow the generic type

public class Rectangle<T extends Number> {
    private T width;
    private T height;
}


to

public class Rectangle {
    private Number width;
    private Number height;
}

Rectangle<Double> r1 = new Rectangle<Double>( 4.1, 6.7);
Rectangle<Integer> r2 = new Rectangle<Integer>( 2, 7);
Rectangle<String> r3 = new Rectangle<String>( "A" , "B" ); // error
```

Without Generic methods:

```

public interface IComparable {
    int compare(Object other);
}

public class Circle implements IComparable {
     @Override
    public int compare(Object other) {
        Circle c = (Circle) other;
        return this.radius - c.radius;
    }
}

public abstract class Product implements IComparable {
 @Override
    public int compare(Object other) {
        Product p = (Product) other;
        return (int) (this.price - p.price);
    }
}
```

Generic methods:

```
public interface IComparable<T> {
    int compare(T other);
}

public class Circle implements IComparable<Circle> {
    @Override
    public int compare(Circle other) {
        return this.radius - other.radius;
    }
}

public abstract class Product implements IComparable<Product> {
 @Override
    public int compare(Product other) {
        return (int) (this.price - other.price);
    }
}
```

Java Collection Framework
provides support for data containers / data structures to be used instead of arrays

* Limitations of array container is
1) size is fixed
 Product[] products = new Product[5];

2) can't grow / shrink

3) Adding / removing from arbitrary position is difficult

4) needs contiguos memory

JCF provides:
1) interfaces
2) implementation classes
3) Algorithm / utility classes

Arrays: utility class which contains alg like sort, max, min, binarySearch, ... which can be used for array type of container containing any type of data [string, number, product,..]
Arrays uses Comparable / Comparator for comparision

```
Use Comparable if the comparision logic is part of the object itself.
public interface Comparable<T> {
    public int compareTo(T o);
}

Terminal: ls
Logic to display is provided by the File system of OS

-rw-r--r--@ 1 banuprakash  staff  1063 Dec  9 12:29 Account.java
-rw-r--r--@ 1 banuprakash  staff   510 Dec 10 09:55 Circle.java
-rw-r--r--@ 1 banuprakash  staff  1046 Dec  9 14:18 Mobile.java
-rw-r--r--@ 1 banuprakash  staff  1365 Dec 10 09:56 Product.java
-rw-r--r--@ 1 banuprakash  staff   572 Dec  9 15:38 Tv.java

Use Comparator if the comparision logic is provided by the client application / code.

FileExplorer provided different ways of sorting --> comparision logic  is provided by FileExplorer
@FunctionalInterface
public interface Comparator<T> {
     int compare(T o1, T o2);
}
```


Collection can be:
1) List interface
* ordered collection
* can have duplicate elements
* can be re-ordered [ sort , shuffle, reverse, ..]
* can use index based operation [ add(obj, 3); remove(6); get(10), ...]
* can grow or shrink

Implementation classes:
a) ArrayList
b) LinkedList
c) Legacy : Vector and Stack : not supposed to be used [ issues in this]
d) 3rd party implementations like :VAVR, Apache Collections, ...
https://vavr.io/
https://commons.apache.org/proper/commons-collections/

ArrayList:
* like array it is contiguos memory
* can grow or shrink
* 99% of the time we use this

LinkedList:
* Doubly linked list
* doesn't need contiguos memory
* adding / removing from arbitrary position is more efficient
Cons:
* each node has 8 bytes extra memory occupied

Generally we load paginated results on to memory, so ArrayList which uses contiguos memory is OK to use.

Scenario 1:
// not recommended --> not typesafe
// ArrayList list = new ArrayList(); not advised, program to interface
List list = new ArrayList();
//List list = new LinkedList();
list.add(new Mobile(..));
list.add(new Date());
list.add("Hello");

we need to do type checking before we use

if(list.get(0) instanceof Mobile) {
    Mobile m = (Mobile) list.get(0);
}

Scenario 1: TypeSafe
List<Integer> list = new ArrayList<Integer>(); 
list.add(4);
list.add(12);
list.add("A"); // error

int x = list.get(0); // no need to do typechecking

2) Set
3) Queue


Collections are similar to Arrays utility class but can be used on List type of container instead of array.

=======

Java 8 introduced streams.
stream can be attached to collection / network / file system / database 
Once stream is attached we can use the following High Order Functions 
HOF: functions which accept functions as arguments; treat functions as first class member like primitive or object
Commonly used HOF:
* filter: to get subset based on predicate
filter(predicateFn)
* map: to transform the data
map(transformFn)
* forEach(actionFn)
* reduce(aggregateFn)

https://rxmarbles.com/

Terminal functions are :forEach, reduce, collect
Intermediary functions: filter, map, skip, limit, flatMap
we can use n number of Intermediary functions in the chain in any order

Note: data flows thro stream only if we have terminal function;

=============

Set
* unique collection
* index based operation is not supported
* re-order is not supported; can't sort/ shuffle / reverse
* order of elements is decided based on type of set implementation
Popular Set implementations:
1) HashSet
2) LinkedHashSet
3) TreeSet


Any hash based data containers uses hashCode() and equals() to identifying duplicates and ordering
equals() will be called only when hashcode collides

HashCode: Numerical value of an object
* Similar objects should have same hashCode
* objects which are not similar can also have same hashCode [ possibility]

Object class internally uses address of object as hashCode --> not correct;
equals works like == operator
So we need to override these methods

// Rarely used; avoid it; internally it's a RedBlack Tree
TreeSet uses Comparable / Comparator for identifying duplicates and ordering

instead we use a combination of HashSet and List for Ordering
```
  Set<Product> products = new HashSet<>();
  products.add(new Product(42, "LG AC", 45000.00, "ELEC"));
  products.add(new Product(89, "Sony Bravia", 245000.00, "TV"));

  // collections are inter-operable
  List<Product> prodList = new ArrayList<>(products); // valid
  Collections.sort(prodList);
```
       
Map container stores the data in the form of key/value pair like Dictionary
* HashMap
* TreeMap
* Hashtable [deprecated / old/ legacy/ same issues as Vector and Stack]

Key has to be unique, values can be duplicated.

Map produces Set of Keys and List of Values

===================

Arrays are Co-variant
Collections of JCF are not co-variant

```
Covariant simply means if X is subtype of Y then X[] will also be sub type of Y[]. Arrays are covariant As string is subtype of Object So

String[] is subtype of Object[]

Invariant simply means irrespective of X being subtype of Y or not ,

 List<X> will not be subType of List<Y>.

```

Annotation / Threads / Database 

=============================

Day 3

Recap:
* Exception Handling
* Java Collection Framework
Prefer Set for Association
```
    public class Customer {
        email, firstName, lastName, ..
        private Set<Order> order  new LinkedHashSet(); // associated
    }
    public class Order {
        id, order_date, total
        private Set<LineItem> items = new LinkedHashSet(); // associated
    }

    public class LineItem {
        id 
        product 
        amount
        quantity
    }

```

LinkedHashSet: uses hashCode() and equals() for duplicate identification, 
but it is ordered like List

===================================================

Annotation: metadata ==> @annotationName
Example: @Override

* Who is using it?
1) COMPILER
2) ClassLoader
3) Runtime

* Where can I use it?
1) TYPE: class / interface / Annotation / Enum
2) method
3) field 
4) parameters

@Override is method level annotation and used by Compiler
Compiler checks the method signature in the parent class; 
if signature matches it compiles else doesn't compile

After compilation the bytecode won't have @Override metadata

```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}
```

Custom Annotation Example:
```
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface WebOS {
}

@WebOS
public class PubG extends Game {
    ...
}

Compiler compiles and creates a bytecode. Compiler is not intreseted in the metadata.
metadata is kept in bytecode

We need to customize the ClassLoader

loadClass() {
    here check the metadata and decide to allow the PubG to be loaded or not.
}
```

Let's create few annotations to simulate ORM concept
Object Relational Mapping
Object <---> relataional database Tables
Annotation will help in generated DDL and DML statements.

```
@Table(name="tbook")
public class Book {

    @Column(name="BOOK_ID", type="NUMERIC(12)")
    public int getId() {

    }

    @Column(name="TITLE")
    public String getName() {

    }
}
```

Annotations can have properties. No state and behaviour

@Table(name="tbook"); name is a property 

x = name(); // getter
name="tbook"; // setter

ORM Frameworks: Hibernate, toplink, KODO, OpenJPA, EclipseLink, ...
============================

Java Concurrency : Multithreaded applications

Process: Program in execution; every process needs a unit of work --> Thread

Single Threaded application: there is only one unit of work --> Main Thread 
Notepad, Calculator, Settings, ..

From java's perspective we have a Stack for main thread 

Multithreaded application: there can be multiple units of work executing conucrrently are 
time-slicing given to them
Examples: IntelliJ, Word, Browsers, ...

From java's perspective we have a Stack for main thread, and stacks for each of the thread.

In Word application:
we have main thread --> typing
spellcheck --> thread
grammercheck --> thread
auto-saving --> thread 

Why do we need Multithreaded application?
* Avoid starvation
* Sharing resources
word document before saving to Disk will be in HEAP area; 
the same document is used for editing, spell check, grammer check
Thread are light-weight process 
* Decoupling logic 
In Scenario where exception occurs in spellcheck thread; only that thread dies; 
other thread continues it's execution

=============================
Main Thread; main() method is an entry point;
Entry point for every other thread is run(); 
this is the method which will be pushed on to the stack
```
    interface Runnable {
        void run();
    }

 // Capable to run part of the code conucrrently ==> HAS A
    class SpellCheck implements Runnable {
        ...
        public void run() {
            ..
        }
    }
```

Thread class: to control life-cycle of thread
* start() -> start0()

* stop() deprecated 
* sleep(long ms)
* yield()
* interrupt()
* join()
* suspend() deprecated
* resume() deprecated

```

public class Thread implements Runnable {
    default run() method ..
}

// IS A
class SpellCheckThread extends Thread {
    public void run() {

    }
}

class GrammerCheckThread extends Thread {
    public void run() {
        
    }
}
```
SpellCheckThread t1 = new SpellCheckThread();
GrammerCheckThread t2 = new GrammerCheckThread();

Dead state

Exceptions are not handled
and propagated to 
DefaultHandler
============================

JRE waits for the last Non-Daemon thread to finish it's execution before it terminates.
By default all threads created from main() are non-daemon 

JRE doesn't wait for Daemon threads to finish it's execution.
Daemon threads: helper threads which shouldn't contain main logic ; 
update time every 1 second in gaming application

```
class TimerThread extends Thread {
    public void run() {
        while(true) {
            Thread.sleep(1000);
            update time on Console
        }
    }
}
```

Thread[Thread-0,5,main]
Name ofthe Thread: Thread-0
priority: 5 [ 1 - 10]
Thread Group: main 
By default 2 groups: main and system 
GC, SignalDispatcher, ReferenceHandler --> System group 

Pink vs Green Threads:
In the context of computer programming, "pink threads" is not a commonly used term, 
while "green threads" refer to a type of thread managed by a virtual machine (VM) 
instead of directly by the operating system, 
essentially meaning they are lightweight threads scheduled at the application level 
rather than the kernel level; 
making them faster to create but potentially less efficient for CPU-intensive 
tasks compared to native OS threads.

=====

Thread Safety
* A member is said to be thread safe if it doesn't get corrupted in multi-threaded environment 

local variable --> Stack --> Each thread has a separate stack --> Thread safe
instance variable --> HEAP --> all threads share heap --> Not Thread Safe 
Account account = new Account(5000);
static variable -> Metaspace --> shared by all threads --> Not Thread Safe 

Immutable objects --> Thread Safe -- reside on HEAP 
Volatile variables are Thread safe --> reside on HEAP 
volatile --> marker to specific that the member should not be optimized

Only Atomic members can be marked as volatile; boolean are Atomic;
int, double, .. are not Atomic;

int x  = 4;
x++;
move 32 bits to left
x--;
move 32 bits to right...

AtomicInteger, AtomicLong are atomic variable --> can be marked as volatile

===========

Whenever an object is created, in the heap area along the state in ther header a "LOCK" is avaailable.
Make use of this lock to avoid data corruption.

keyword "synchronized" to mark a protected resource; enforce thred to acquiring lock before entering a 
protected resource.

Interthread communication --> wait(); notify() ; notifyAll()

========

wait() vs sleep()

sleep() --> Idle State --> here lock is not released
wait() --> wait state --> here lock is released.

calling wait() from non-synchronized method/ block throws IllegalMonitorStateException
Monitor --> Lock 

notify() --> makes one of the thread in wait-state to Runnable --> No fairness involved
notifyAll() --> makes all the threads in wait-state to Runnable.

===================

Doug Lea introduced many APIs in Java version 5 to overcome issues with Java Threads.

Java Threads Issues:
1) Thread  / Runnable doesn't return back a value
2) Starting and stopping threads --> latency issue; Thread pool 
3) Object has only one lock 
4) Many a times it gets into deadlock situation
5) Only owner of lock can release it. It would have been good, ADMIN can release a lock,..
6) No timeout for wait period of lock acquire 

Object has only one lock :
```
public class Account {
    private double balance;
    private UserProfile userProfile;
    ...
}
```
If any tx is happening no thread can change UserProfile also.
or UserProfile is getting modified, we can't have tx.

Good to have balanceLock and profileLock separate. 

ReentrantLock, ReadWriteLock

```
Thread acquires lock for a(); same lock is used for execute b();
synchronized a() {
    b();
}

synchronized b() {
    
}

```

synchronized Block:
```
public class BankingService {
    public  void transferFunds(Account fromAcc, Account toAcc, double amt) {
        synchronized(fromAcc) { // lock fromAcc
            synchronized(toAcc) { // lock toAcc
                fromAcc.withdraw(amt);
                toAcc.deposit(amt);
            } // unlock toAcc
        } // unlock fromAcc
    }
}

DeadLock:
T1 --> SB101 to SB410 , 5000
T2 --> SB410 to SB101 , 4000

synchronized(fromAcc) { T1 acquires SB101 and T2 acquires SB410

synchronized(toAcc) { T1 wants SB410 and T2 wants SB101

```

Solution with Doug Lea:

```
public class BankingService {
    public  void transferFunds(Account fromAcc, Account toAcc, double amt) { 
        try {
             if(fromAcc.balanceLock.tryLock(1, TimeUnit.SECOND)) {
                try {
                    if(toAcc.balanceLock.tryLock(1, TimeUnit.SECOND)) {
                         fromAcc.withdraw(amt);
                         toAcc.deposit(amt);
                    }
                } finally {
                    toAcc.balanceLock.unlock();
                }
             }
        } finally {
            fromAcc.balanceLock.unlock();
        }
       
    }
}

```

Aggregator
MakeMyTrip/ Agoda/ HolidayIQ

Callable interface
The Callable interface is similar to Runnable, in that both are designed for classes whose 
instances are potentially executed by another thread. 
A Runnable, however, does not return a result and cannot throw a checked exception.

```
public interface Callable<V> {
    V call() throws Exception;
}

```

Day 4

Recap:
Annotation: metadata which can be used by Compiler, ClassLoader or Runtime
Java Reflection API can't access private members, hence we didn't use Field level annotation.

Method[] methods = class.getDeclaredMethods(); // public 

@Column
private String title;

Java Reflection API can't access this metadata;

Frameworks like Spring / Hibernate, ... will use different bytecode instrumentation libraries to aaccess
private members like bytebuddy, JavaAssist, CGLib...

Java Concurrency:
Runnable, Thread class, life-cycle of thread.
Thread Safety, synchronized keyword at method level and block level
wait() is an method of Object which can be used to make thread go to wait state by releasing the lock
notify(); notifyAll(); to inform the threads in wait state that state has changed and it need not be in wait state; make it Runnable

join(); barrier --> caller thread has to wait for other thread to finish it's execution.

Doug Lea: Lock Api, Exector, ExecutorService , Callable and Future. 

====================================

Future vs CompletableFuture

Future and CompletableFuture are both abstractions for representing a result that will be available in the future,
CompletableFuture extends CompletionStage.

Using CompletableFuture we can change actions
task1() --> task2() --> task3() --->

With Future, it is difficult to chain multiple asynchronous operations together 
or to combine the results of multiple operations. 

result1 = future1.get(); //blocking code

Future f2 = executorService.submit(new SecondTask(result1));

result2 = f2.get();

With a Future object, you must call the get() method to retrieve the result, 
but this method blocks until the result is available. 
In contrast, with a CompletableFuture object, 
you can use various non-blocking methods to retrieve the result, 
such as thenApply(), thenAccept(), or join()


CompletableFuture, on the other hand, provides methods such as thenCompose(), thenCombine(), 
and allOf() that make it easy to compose multiple asynchronous operations and 
to handle their results in a non-blocking way.

ForkJoinPool
===================

Docker Desktop
Maven and JDBC -> MySQL database 

Docker: Virtualization using Linux platform
Image: Softwares
containers: RUNNING the application download as image


docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql

image: mysql
container name: local-mysql
-e : Environment
-p: expose the port
 
-p 1234:3306

on docker application is running on 3306 and exposed as 1234

=======
Get Bash terminal to the container:

```
docker exec -it local-mysql bash 

# mysql -u root -p
Enter password:  Welcome123
mysql> create database JAVA_CISCO;
mysql> use JAVA_CISCO;
mysql> create table products(id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double);
mysql> insert into products values(0, 'iPhone 15', 89000.00);
mysql> insert into products values(0, 'Samsung Fold', 145000.00);

mysql> select * from products;
+----+--------------+--------+
| id | name         | price  |
+----+--------------+--------+
|  1 | iPhone 15    |  89000 |
|  2 | Samsung Fold | 145000 |
+----+--------------+--------+

```
jar --> Java Archive

Java Build tools : Maven / Gradle 
Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM)
* Manage Dependencies
Without maven i can download the libraries available in the for "jar" on to my machine and configure to be used in project.
* Transative Dependencies: a12.jar --> b52.jar --> c51.jar 
* Standard File structure which helps my projects to be imported into any IDEs
* helps execute goals; compile , testing, build 


pom.xml
JAR file is identified using all the below combination
https://mvnrepository.com/

<dependency>
    <groupId>com.uber</groupId>
    <artifactId>payment</artifactId>
    <version>1.18</version>
</dependency>

File --> New Project --> Java and Maven

============

Java <---> MySQL

JDBC: Java Database Connectivity --> Integration Library to interact with RDBMS

Java <---> JDBC <----> RDBMS

JDBC libraries provides interfaces; implementation classes are provided by database vendors

Steps:
1) Load database vendors provided Drivers one time for project; static block
Class.forName("com.mysql.cj.jdbc.Driver");
Class.forName("org.oracle.Driver");

2) Establish a database Connectivity
DriverManager is a Factory method;
depending on URL it creates MySQLConnection / OracleConnection ..
Connection is an interface 
Connection con = DriverManager.getConnection(URL, USER, PWD);

URL:
jdbc:mysql://localhost:3306/JAVA_CISCO
jdbc:oracle:thin:@localhost:1521@JAVA_CISCO

3) Send SQL statements
3.1) Statement
use this if it's the same SQL for every request
select * from employees
3.2) PreparedStatement 
use this if SQL uses IN parameters [ parameters comming as request]
select * from employees where id = ?
insert into employees values (?, ? , ?)

Don't use SQL concatination and use Statement to form SQL;
SQLInjection
String query = "SELECT * FROM accounts WHERE custID='" + request.getParameter("id") + "'";
the attacker modifies the ‘id’ parameter value in their browser to send: ' UNION SLEEP(10);--.

3.3) CallableStatement
use this to invoke stored procedure/functions of RDBMS 
for secure application

```
CREATE PROCEDURE SelectAllCustomers @City nvarchar(30), @PostalCode nvarchar(10)
AS
SELECT * FROM Customers WHERE City = @City AND PostalCode = @PostalCode
// triggers
GO;

Java:
call(SelectAllCustomers('DELHI', '1245011'));

```

int executeUpdate(SQL); // insert, delete and Update SQL ; return value indicates how many rows are affected
// return value of 0 --> no matching criteria; -1 indicates issue with SQL 
ResultSet executeQuery(SQL); // select 

ResultSetMetadata --> use this to get metadata of ResultSet; like number Columns; data type of columns..

4) Always release resources in finally block; 
like closing database Connection; close socket Connection; file close;
finally block is a compulsory execute code; executes if exception occurs or not. 

=============================

final keyword:
```
1) to declare a constant
final int x = 10;
x++; // error 

2) to declare a constant pointer;
final Product p = new Product();
p.setPrice(999); // valid 

p = new Product(); // error 

3) to prevent inheritance 

public final class Tv extends Product {

}

public class SmartTv extends Tv { // error 

4) to prevent override 

public class Product {
    public final double getPrice() {
        ..
    }
}

public class Mobile extends Product {
    ...
    @Override
    public  double getPrice() { // error
        ..
    }
}

```

Whenever exceptions are propagated; wrap the orinigal exception:
  throw new PersistenceException("unable to add product", e);


use e.printStackTrace(); only in development stage; not in production

```
mysql> create table customers (email varchar(100) PRIMARY KEY, first_name varchar(100));


mysql> insert into customers values ('raj@cisco.com','Rajesh');


mysql> insert into customers values ('rani@cisco.com','Rani');



CREATE TABLE orders (
    oid int NOT NULL PRIMARY KEY  AUTO_INCREMENT,
    order_date TIMESTAMP,
    total double,
    customer_fk varchar(100),
    FOREIGN KEY (customer_fk) REFERENCES customers(email)
);


CREATE TABLE items (
    item_id int PRIMARY KEY  AUTO_INCREMENT,
    order_fk int NOT NULL,
    product_fk int NOT NULL,
    quantity int,
    amount double,
    FOREIGN KEY (order_fk) REFERENCES orders(oid),
    FOREIGN KEY (product_fk) REFERENCES products(id)
);

alter table products add column qty int;
update products set qty = 100 where 1=1;
```


=============

Day 5

Recap:
JDBC --> Integration library to connect ot database
DriverManager -> getConnection() which is used to connect to database; we don't use this in enterprise application; instead we use DataSource [pool of database connection]

Problem with DriverManager -> getConnection(); latency in establishing connection and closing connection; another issue with this is we can't have limited connections
* Statement
* PreparedStatement
* ResultSet 
* Begin Transaction con.setAutoCommit(false)
* end transaction con.commit() or con.rollback()

==================

Upgrade the application to Web application;

WebServer: works on HTTP protocol using Request/Response programming model; web servers can serve static resources [ html/ pdf/ images/ css / js]
If server needs to send dynamic content then WebServer needs to have engines/web container configured
ServletContainer : web container or engine to serve dynamic content using Java Technology
PHP, .NET , NODEJS, ...

Eclipse Jetty/ Apache Tomcat is a Java web server and Java Servlet container.

Code running within Servlet Container has to be a Servlet API
```
interface Servlet{}

class GenericServlet implements Servlet {}

class HttpServlet extends GenericServlet {}

As a programmer we need to implement Servlet or extend GenericServlet or extend HttpServlet and customize

Example:
public class ProductServlet extends HttpServlet{
    ...
}

METHOD of Requests can be:
GET --> READ [Address bar / hyperlinks are by default GET request]
POST --> CREATE
PUT/ PATCH --> UPDATE
DELETE --> DELETE


Thread Pool

GET http://abc.com:8080/products


HttpServletRequest object: encapaulates all information comming from client; like data entered in form / browser / OS

HttpServletResponse object can be used to write data back to client.

Once Response is sent back to client HttpServletRequest object and HttpServletResponse object are destroyed;

Servlet Containers are managing the life of objects; Servlet , Request, Response
We don't do new ProductServlet();
Servlet Containers are working like IoC --> Inversion Of Control --> for Dependency Injection; they inject objects like request and response to Servlet

```
Deployment Descriptor: Configurations to servlet container / engine / web container

web.xml file is a deployment descriptor / one per one web application

Part 1: use the below data to create instances of Servlet
```
<servlet>
    <servlet-name> One </servle-name>
    <servlet-class> pkg.ProductServlet </servlet-class>
</servlet>
<servlet>
    <servlet-name> Two </servle-name>
    <servlet-class> pkg.CustomerServlet </servlet-class>
</servlet>

```

Part 2: Do the mapping

```
    <servlet-mapping>
         <servlet-name> One </servle-name>
         <url-pattern> /products </url-pattern>
    </servlet-mapping>
     <servlet-mapping>
         <servlet-name> Two </servle-name>
         <url-pattern> /customers </url-pattern>
    </servlet-mapping>
```


Alternatively we can use annotation:

```
@WebServlet("/products")
public class ProductServlet extends HttpServlet{
    ...
}
```

Deploying the code on Web Container / Servlet Container / Servlet engine:
We need a "war" file; Web Archive

folder structure of war file:
```
    databaseapp
        |
        static files [ html / css / js]
        |
        WEB-INF
            |
            web.xml
            |
            classes
                |
                pkg
                    |
                    ProductServlet.class
                    OrderServlet.class
                    CustomerServlet.class

```

war can be deployed on web container
place the war in "apache-tomcat-10.1.10/webapps" or in jetty /jboss/weblogic/wepshere/glassfish

Maven Goals:
maven-compiler-plugin
mvn compile

maven-war-plugin
mvn package

embedded JETTY server can be executed by Maven itself
mvn clean
mvn jetty:run
 --> mvn package
  --> mvn compile

========

Maven --> Execute Goals
mvn jetty:run  for 8080 
http://localhost:8080/products

OR
mvn jetty:run -Djetty.port=9999
http://localhost:9999/products



File Project Structure --> Modules --> database/Web

Web Resource Directory +

we should be able to get "webapp" folder

database/src/main/webapp folder ==> this is the place where static resources like html / css /js / jsp pages should reside

database/src/main/webapp/index.html ==> landing page
```
http://localhost:8080/
  <a href="products">List Products</a> ==> ProductServlet
  <a href="productForm.html">Add a Product</a> ==> static resource productForm.html
```
































