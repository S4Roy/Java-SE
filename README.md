# Java-SE
Learning Java Programming Beginner to Advance from Prof. Abdul Bari Sir.

      sudo apt update
  
      sudo apt install default-jdk
  
      javac -version
  
  this javac -version command will return installed javac version : in my case -> javac 11.0.15

    cd Desktop/
    mkdir JAVA
    cd JAVA/
    
Create new JavaFile with .java extention and skeleton should be like 
    
    import java.lang.*;
    class MyFirst{
      public static void main(String args[]){
      System.out.println("Hello World!");
      }
    }
Saved this file as Myfirst.java
Compile using javac  

    javac MyFirst.java

After Compilation MyFirst.class file generated

    java MyFirst
    
Return 

     Hello World!
    
