package lambdas_and_streams.lambdas;

public class ConstructorReferences {
    class Movie{
        public Movie(int id){
            System.out.println(id);
        }

        public Movie(int id, String name){
            System.out.println(id+name);
        }

        interface MovieFactory{
            public Movie create(int id);
        }

        MovieFactory m1 = i -> new Movie(i);
        MovieFactory m2 = Movie::new;

        interface MovieFactory2{
            public Movie create(int id);
        }
        MovieFactory2 m22 = Movie::new;
        public static void main(String[] args) {
            //
        }
    }
}


/*
*  So we learned method references are nothing but shorthand expressions for lambdas. Similar to methods,
*  constructors can also be referenced from a lambda expression with an easy-to-read syntax. So in this session,
*  we are going to learn about constructor references. The fundamental difference between a constructor and a method reference
*  is that the method name is always new in a construct reference. For example, this indicates a simple constructor reference
*  for creating a new array list. So let's walk through an example. Let's say we have a movie class with two constructors, constructor
*  one taking an integer to create a movie, and the second one which takes an integer as well as a string to create a movie. So imagine
*  we have defined a functional interface, say, MovieFactory, which takes in just single integer argument for one of its methods.
*  That means this interface corresponds to the first constructor of the movie class. We can create a lambda expression for this
*  functional interface, as shown here. As you can see, the lambda expression is taking an integer to invoke the new movie class constructor.
*  However, if we take the assistance of constructor references, we can reduce this expression even further. So this is constructor
*  reference in action. Did you notice one thing here? We don't know which constructor the compiler can select by looking at this expression.
*  Is it the first one or the second one? Well, that depends on the context in which the lambda expression or the constructor difference
*  is defined. So in this case, movie new is delivering a MovieFactory interface which has one constructor taking in an integer.
*  So this corresponds to your constructor taking an integer one. So what would you do if you need to define a lambda expression using
*  a constructor reference for the second constructor that takes in an integer as well as a string? Well, we need to declare our
*  intention in a second functional interface which then becomes a lambda expression. So let's see how we can do that. We need to
*  declare our intention in a new function interface which then becomes a lambda expression. As you can see, the MovieFactory too is
*  a new functional interface which has got a create method which exactly takes in two parameters and matches to the constructor,
*  the second one. Now creating a lambda expression using the constructor reference is very easy. So there is another use case.
*  How do we create a constructor reference for arrays? For example, if we have an array of strings, or integers, or objects, how do we
*  create a lambda expression referring to those appropriate constructors? Well, easy-- see this example. We have a string array
*  interface that's got a create method which takes in a size and provides us with a string array. Let's create a lambda expression
*  representing this string array. This is a normal lambda expression for creating a sized array. And this is the string array created
*  using an array constructor reference. So the constructor references really fit well with the theme of easily readable code in Java 8.
*  Do use them appropriately. */