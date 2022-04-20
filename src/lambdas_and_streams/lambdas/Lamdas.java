package lambdas_and_streams.lambdas;

// following is a functional interface.
// functional interface: it is nothing but an interface with one and only one abstract method.
// lambdas can work only with such inerfaces
// functional interface annotation helps us protect the interface definition of a functional interface at compile time
@FunctionalInterface
interface ILamda{
    void lamdaFunc();
//    void lambda2();
}

public class Lamdas {
    public static void main(String[] args) {
        ILamda interfaceMethodImplementor = () -> System.out.println("Hello");

        interfaceMethodImplementor.lamdaFunc();
    }
}

/*
*  In this session, we are going to learn about capturing lambdas. So far we have defined and used
*  lambda expressions that uses its own parameters. But there are some instances where lambda expressions
*  can use the parameters from the enclosing scope, maybe from the method or maybe the instance or static
*  variables defined in the class. So this type of lambda expression, which uses the
*  parameters from the enclosing scope, is called a capturing lambda.  Remember, when we working with anonymous classes,
*  any enclosing method parameters which are used in the anonymous classes, they must be declared as final, right?
*  Well, that restriction is now relaxed. We don't have to put a final modifier before the parameter. However,
*  there is one catch. Although you don't have to put a modifier as final in front of the variable, you are expected
*  to make it effectively final. What does it mean? Well, look at the status variable. I reassigned this variable.
*  I have reassigned this variable with another value. Look. Immediately, we got an error. It simply says the local
*  variable status defined in the enclosing scope must be final or effectively final. What it is saying is that,
*  although we haven't declared the status as final, you are not maintaining that as a final variable, so it is our
*  duty that the status has to be maintained as effectively final. So what does it mean? Well, simply put, once a
*  variable has been given a value, you cannot change. You are not expected to change in the method [INAUDIBLE] once
*  a variable has been given to you. So in an effect, although we are not setting the final modifier to the variable,
*  you are not expected to change the value. That's it.
*
*  Local variables are treated effectively as immutable objects,
*  or assigned one and only once. There is a valid reason behind this strange behavior. We know that local variables exist
*  on stack memory as opposed to heap for class or instance variables. And hence, they are treated as thread safe, as no
*  other thread can have access to the stack part apart from itself. However, there may have been a situation where the
*  lambda expression is still running although the thread that's created the lambda expression may have been recycled and
*  long gone. Hence, the lambda expression is required to capture the values of these local variables. It has to be closing
*  the values. In the case of local variables, compiler will assist us and will not allow to reassign or change of local variables.
*  So purely, it says they are illegal if we change the values. However, this restriction does not apply to a class or instance variable.
*  Let's see this. Look at this example. We have an instance variable called count. And we also have a local variable called localCount.
*  We create a lambda inside a for loop. In that lambda, we are trying to access the instance variable and mutate it. There is no complaining
*  nature of the lambda expression in this case. However, this will not pass. It simply says that your local variable is not following the
*  rule of making it the final or effectively final nature. Does it mean that changing the count, changing the instance variable is correct
*  in a lambda expression? No. Unfortunately, compiler will not assist you.

* *  But this is not a thread safety code. So it is up to
*  the developer's responsibility to make sure that the local variables, as well as the instance and static variables, are not to be
*  mutated in a lambda expression. So in an effect, it is our responsibility to maintain the effectively final state. So I would strongly
*  advise to follow the local variables path for class or instance variables too. There is a highly likelihood of concurrency bugs to be
*  surfacing up should you deal with the class and instance variables inappropriately, like this here. So you should manage
*  them very carefully. */
