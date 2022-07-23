# Features and Architecture

## Compiler vs Interpreter

Compiler and Interpreter are two different ways to translate a program from programming or scripting language to machine language. 

A compiler takes entire program and converts it into object code which is typically stored in a file. The object code is also referred as binary code and can be directly executed by the machine after linking. Examples of compiled programming languages are C and C++. 

An Interpreter directly executes instructions written in a programming or scripting language without previously converting them to an object code or machine code. Examples of interpreted languages are Perl, Python and Matlab. 

Following are some interesting facts about interpreters and compilers. 

1) Both compilers and interpreters convert source code (text files) into tokens, both may generate a parse tree, and both may generate immediate instructions. The basic difference is that a compiler system, including a (built in or separate) linker, generates a stand alone machine code program, while an interpreter system instead performs the actions described by the high level program. 

2) Once a program is compiled, its source code is not useful for running the code. For interpreted programs, the source code is needed to run the program every time. 

3) In general, interpreted programs run slower than the compiled programs. 

4) Java programs are first compiled to an intermediate form, then interpreted by the interpreter. 
    

## How Java is Platform Independent
The meaning of platform-independent is that the java compiled code(byte code) can run on all operating systems.
A program is written in a language that is a human-readable language. It may contain words, phrases, etc which the machine does not understand. For the source code to be understood by the machine, it needs to be in a language understood by machines, typically a machine-level language. So, here comes the role of a compiler. The compiler converts the high-level language (human language) into a format understood by the machines. Therefore, a compiler is a program that translates the source code for another program from a programming language into executable code.
This executable code may be a sequence of machine instructions that can be executed by the CPU directly, or it may be an intermediate representation that is interpreted by a virtual machine. This intermediate representation in Java is the Java Byte Code.

Step by step Execution of Java Program:

### 1. Whenever, a program is written in JAVA, the javac compiles it.
### 2. The result of the JAVA compiler is the .class file or the bytecode and not the machine native code (unlike C compiler).
### 3. The bytecode generated is a non-executable code and needs an interpreter to execute on a machine. This interpreter is the JVM and thus the Bytecode is executed by the JVM.
### 4. And finally program runs to give the desired output.

<img src="https://github.com/S4Roy/Java-SE/blob/main/SECTION-4/java-platform-independent.png" alt="java-platform-independent">

In case of C or C++ (language that are not platform independent), the compiler generates an .exe file which is OS dependent. When we try to run this .exe file on another OS it does not run, since it is OS dependent and hence is not compatible with the other OS.

Java is platform-independent but JVM is platform dependent

In Java, the main point here is that the JVM depends on the operating system – so if you are running Mac OS X you will have a different JVM than if you are running Windows or some other operating system. This fact can be verified by trying to download the JVM for your particular machine – when trying to download it, you will be given a list of JVMs corresponding to different operating systems, and you will obviously pick whichever JVM is targeted for the operating system that you are running. So we can conclude that JVM is platform-dependent and it is the reason why Java is able to become “Platform Independent”.
### Important Points:

#### 1. In the case of Java, it is the magic of Bytecode that makes it platform independent.
#### 2. This adds to an important feature in the JAVA language termed as portability. Every system has its own JVM which gets installed automatically when the jdk software is installed. For every operating system separate JVM is available which is capable to read the .class file or byte code.
#### 3. An important point to be noted is that while JAVA is platform-independent language, the JVM is platform-dependent. Different JVM is designed for different OS and byte code is able to run on different OS.

## JVM Architecture

JVM(Java Virtual Machine) acts as a run-time engine to run Java applications. JVM is the one that actually calls the main method present in a java code. JVM is a part of JRE(Java Runtime Environment).

Java applications are called WORA (Write Once Run Anywhere). This means a programmer can develop Java code on one system and can expect it to run on any other Java-enabled system without any adjustment. This is all possible because of JVM.

When we compile a .java file, .class files(contains byte-code) with the same class names present in .java file are generated by the Java compiler. This .class file goes into various steps when we run it. These steps together describe the whole JVM. 

<img src="https://github.com/S4Roy/Java-SE/blob/main/SECTION-4/jvm-3.jpg" alt="jvm">

### Class Loader Subsystem

It is mainly responsible for three activities. 

Loading

Linking

Initialization

Loading: The Class loader reads the “.class” file, generate the corresponding binary data and save it in the method area. For each “.class” file, JVM stores the following information in the method area. 

#### The fully qualified name of the loaded class and its immediate parent class.
#### Whether the “.class” file is related to Class or Interface or Enum.
#### Modifier, Variables and Method information etc.

After loading the “.class” file, JVM creates an object of type Class to represent this file in the heap memory. Please note that this object is of type Class predefined in java.lang package. These Class object can be used by the programmer for getting class level information like the name of the class, parent name, methods and variable information etc. To get this object reference we can use getClass() method of Object class.

    // A Java program to demonstrate working
    // of a Class type object created by JVM
    // to represent .class file in memory.
    import java.lang.reflect.Field;
    import java.lang.reflect.Method;

    // Java code to demonstrate use
    // of Class object created by JVM
    public class Test {
    	public static void main(String[] args)
    	{
    		Student s1 = new Student();
    
    		// Getting hold of Class
    		// object created by JVM.
    		Class c1 = s1.getClass();
    
    		// Printing type of object using c1.
    		System.out.println(c1.getName());
    
    		// getting all methods in an array
    		Method m[] = c1.getDeclaredMethods();
    		for (Method method : m)
    			System.out.println(method.getName());
    
    		// getting all fields in an array
    		Field f[] = c1.getDeclaredFields();
    		for (Field field : f)
    			System.out.println(field.getName());
    	}
    }

    // A sample class whose information
    // is fetched above using its Class object.
    class Student {
    	private String name;
    	private int roll_No;
    
    	public String getName() { return name; }
    	public void setName(String name) { this.name = name; }
    	public int getRoll_no() { return roll_No; }
    	public void setRoll_no(int roll_no)
    	{
    		this.roll_No = roll_no;
    	}
    }

Output

    Student
    getName
    setName
    getRoll_no
    setRoll_no
    name
    roll_No

Note: For every loaded “.class” file, only one object of the class is created. 

    Student s2 = new Student();
    // c2 will point to same object where 
    // c1 is pointing
    Class c2 = s2.getClass();
    System.out.println(c1==c2); // true

Linking: Performs verification, preparation, and (optionally) resolution. 

Verification: It ensures the correctness of the .class file i.e. it checks whether this file is properly formatted and generated by a valid compiler or not. If verification fails, we get run-time exception java.lang.VerifyError. This activity is done by the component ByteCodeVerifier. Once this activity is completed then the class file is ready for compilation.

Preparation: JVM allocates memory for class variables and initializing the memory to default values.

Resolution: It is the process of replacing symbolic references from the type with direct references. It is done by searching into the method area to locate the referenced entity.

Initialization: In this phase, all static variables are assigned with their values defined in the code and static block(if any). This is executed from top to bottom in a class and from parent to child in the class hierarchy. 
In general, there are three class loaders : 

Bootstrap class loader: Every JVM implementation must have a bootstrap class loader, capable of loading trusted classes. It loads core java API classes present in the “JAVA_HOME/jre/lib” directory. This path is popularly known as the bootstrap path. It is implemented in native languages like C, C++.

Extension class loader: It is a child of the bootstrap class loader. It loads the classes present in the extensions directories “JAVA_HOME/jre/lib/ext”(Extension path) or any other directory specified by the java.ext.dirs system property. It is implemented in java by the sun.misc.Launcher$ExtClassLoader class.

System/Application class loader: It is a child of the extension class loader. It is responsible to load classes from the application classpath. It internally uses Environment Variable which mapped to java.class.path. It is also implemented in Java by the sun.misc.Launcher$AppClassLoader class.

    // Java code to demonstrate Class Loader subsystem
    public class Test {
        public static void main(String[] args)
        {
            // String class is loaded by bootstrap loader, and
            // bootstrap loader is not Java object, hence null
            System.out.println(String.class.getClassLoader());

            // Test class is loaded by Application loader
            System.out.println(Test.class.getClassLoader());
        }
    }

Output

    null
    jdk.internal.loader.ClassLoaders$AppClassLoader@8bcc55f

Note: JVM follows the Delegation-Hierarchy principle to load classes. System class loader delegate load request to extension class loader and extension class loader delegate request to the bootstrap class loader. If a class found in the boot-strap path, the class is loaded otherwise request again transfers to the extension class loader and then to the system class loader. At last, if the system class loader fails to load class, then we get run-time exception java.lang.ClassNotFoundException. 

<img src="https://github.com/S4Roy/Java-SE/blob/main/SECTION-4/jvmclassloader.jpg" alt="jvmclassloader">

### JVM Memory 

1. Method area: In the method area, all class level information like class name, immediate parent class name, methods and variables information etc. are stored, including static variables. There is only one method area per JVM, and it is a shared resource.
2. Heap area: Information of all objects is stored in the heap area. There is also one Heap Area per JVM. It is also a shared resource.
3. Stack area: For every thread, JVM creates one run-time stack which is stored here. Every block of this stack is called activation record/stack frame which stores methods calls. All local variables of that method are stored in their corresponding frame. After a thread terminates, its run-time stack will be destroyed by JVM. It is not a shared resource.
4. PC Registers: Store address of current execution instruction of a thread. Obviously, each thread has separate PC Registers.
5. Native method stacks: For every thread, a separate native stack is created. It stores native method information. 

<img src="https://github.com/S4Roy/Java-SE/blob/main/SECTION-4/jvm-memory-2.jpg" alt="jvm-memory-2">

### Execution Engine 

Execution engine executes the “.class” (bytecode). It reads the byte-code line by line, uses data and information present in various memory area and executes instructions. It can be classified into three parts:

1. Interpreter: It interprets the bytecode line by line and then executes. The disadvantage here is that when one method is called multiple times, every time interpretation is required.
2. Just-In-Time Compiler(JIT) : It is used to increase the efficiency of an interpreter. It compiles the entire bytecode and changes it to native code so whenever the interpreter sees repeated method calls, JIT provides direct native code for that part so re-interpretation is not required, thus efficiency is improved.
3. Garbage Collector: It destroys un-referenced objects. For more on Garbage Collector, refer Garbage Collector.

### Java Native Interface (JNI) : 

It is an interface that interacts with the Native Method Libraries and provides the native libraries(C, C++) required for the execution. It enables JVM to call C/C++ libraries and to be called by C/C++ libraries which may be specific to hardware.

### Native Method Libraries : 

It is a collection of the Native Libraries(C, C++) which are required by the Execution Engine.

## Features of Java

1. Platform Independent:  Compiler converts source code to bytecode and then the JVM executes the bytecode generated by the compiler. This bytecode can run on any platform be it Windows, Linux, or macOS which means if we compile a program on Windows, then we can run it on Linux and vice versa. Each operating system has a different JVM, but the output produced by all the OS is the same after the execution of bytecode. That is why we call java a platform-independent language.

2. Object-Oriented Programming Language:  Organizing the program in the terms of collection of objects is a way of object-oriented programming, each of which represents an instance of the class.

    #### The four main concepts of Object-Oriented programming are:

    #### Abstraction
    #### Encapsulation
    #### Inheritance
    #### Polymorphism
3. Simple:  Java is one of the simple languages as it does not have complex features like pointers, operator overloading, multiple inheritances, and Explicit memory allocation. 

4. Robust:  Java language is robust which means reliable. It is developed in such a way that it puts a lot of effort into checking errors as early as possible, that is why the java compiler is able to detect even those errors that are not easy to detect by another programming language. The main features of java that make it robust are garbage collection, Exception Handling, and memory allocation.

5. Secure:  In java, we don’t have pointers, so we cannot access out-of-bound arrays i.e it shows ArrayIndexOutOfBound Exception if we try to do so. That’s why several security flaws like stack corruption or buffer overflow are impossible to exploit in Java. Also java programs run in an environment that is independent of the os(operating system) environment which makes java programs more secure .

6. Distributed:  We can create distributed applications using the java programming language. Remote Method Invocation and Enterprise Java Beans are used for creating distributed applications in java. The java programs can be easily distributed on one or more systems that are connected to each other through an internet connection.

7. Multithreading:  Java supports multithreading. It is a Java feature that allows concurrent execution of two or more parts of a program for maximum utilization of the CPU.

8. Portable:  As we know, java code written on one machine can be run on another machine. The platform-independent feature of java in which its platform-independent bytecode can be taken to any platform for execution makes java portable.

9. High Performance: Java architecture is defined in such a way that it reduces overhead during the runtime and at some time java uses Just In Time (JIT) compiler where the compiler compiles code on-demand basics where it only compiles those methods that are called making applications to execute faster.

10. Dynamic flexibility: Java being completely object-oriented gives us the flexibility to add classes,  new methods to existing classes and even create new classes through sub-classes. Java even supports functions written in other languages such as C, C++ which are referred to as native methods.

11. Sandbox Execution: Java programs run in a separate space that allows user to execute their applications without affecting the underlying system with help of a bytecode verifier. Bytecode verifier also provides additional security as its role is to check the code for any violation of access.

12. Write Once Run Anywhere: As discussed above java application generates a ‘.class’ file which corresponds to our applications(program) but contains code in binary format. It provides ease t architecture-neutral ease as bytecode is not dependent on any machine architecture. It is the primary reason java is used in the enterprising IT industry globally worldwide.

13. Power of compilation and interpretation: Most languages are designed with purpose either they are compiled language or they are interpreted language. But java integrates arising enormous power as Java compiler compiles the source code to bytecode and JVM  executes this bytecode to machine OS-dependent executable code.