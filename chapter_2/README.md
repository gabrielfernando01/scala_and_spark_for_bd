# 2. Object-Oriented Scala 🟥.

Considering the preceding features of OOP languages, in this chapter, we will discuss the basic object-oriented features in Scala 🟥. In a nutshell, the following topics will be covered in this chapter: 

- 🟪 Variable in Scala.
- 🔵 Methods, classes, and objects in Scala.
- 🔸 Packages and package objects.
- 🔷 Traits and trait linerization.
- ☕ Java Interoperability.

### Variables in Scala 🟥.

The formal syntax of declaring a variable in Scala 🟥 is as follows:

<code>val or var VariableName: DataType = Initial_Value</code>

There are two types of variables in Scala 🟥: mutable and immutable that can be defined as follows:

- 🔵 **Mutable:** The ones whose values you can change later.
- 🟣 **Immutable:** The ones whose values you cannot change once they habe been set.

In Scala 🟥 variables, we can three differentes scopes, depending on the place where you have declared them:

- 🟪 **Fields:** These are variables that belong to an instance of a class of your Scala code.
- 🔴 **Methods arguments:** These are variables, and when the method is called, these can be used to pass the value inside a method.
- 💡 **Local variables:** These variables are declared inside a method and are accessible from the inside the method itself.

### Data types in Scala 🟥.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/data_type.png)

## Methods, classes, and object in Scala 🟥.

### Methods in Scala 🟥.

```
def min(x1: Int, x2: Int): Int = {
	if(x1 < x2) x1 else x2
}
```

The preceding declaration of the method takes two variables and returns the smallest among them. In Scala, all the methods must start with the def keyword, which is then followed by a name for this method. Optionally, you can decide not to pass any parameters
to the method or even decide not to return anything. You're probably wondering how the smallest value is returned, but we will get to this later. Also, in Scala, you can define methods without curly braces:

<code>def min(x1: Int, x2: Int): Int = if(x1 < x2) x1 else x2</code>

If your method has a small body, you can declare your method like this. Otherwise, it's preferred to use the curly braces in order to avoid confusion. As mentioned earlier, you can pass no parameters to the method if needed:

<code>def getValueOfPi: Double = 3.14159</code>

Moreover, it has a deep connection with the uniform access principle. Thus, you can also avoid the braces as follows:

<code>def getValueOfPi: Double = 3.14159</code>

There are also some methods which return the value by explicitly mentioning the return types. For example:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/method_return_type.png)

### The return in Scala 🟥.

Before learning how a Scala 🟥 method returns a value, let's recap the structure of a method in Scala:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/structure_method.png)

Now, let's define a method that adds two positive integers and returns the result, which is also an integer value:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/return_scala.png)

As using the keyword <code>return</code> is optional, in Scala 🟥 compiler is designed such that the last assignment will be returned with the absence of the <code>return</code> keyword.

Well done! Now, its time to see how to encapsulate them inside Scala  🟥 method and classes. The next section discusses Scala 🟥 objects.

### Classes in Scala 🟥.

Classes are considered as a blueprint and then you instantiate this class in order to create something that will actually be represented in memory. They can contain methods, values, variables, types, objects, traits, and classes which are collectively called **members**. Let's demonstrate this with the following example:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/class_Animal00.png)

We have two variables <code>animalName</code> **and** <code>animalAge</code> with their setters and getters. Now, how do we use them to solve our purpose? Here come the usages of Scala objects. Now, we will discuss Scala objects, then we will trace back to our next discussion.

### Objects in Scala 🟥.

An **object** in Scala has a slightly different meaning than the traditional OOP one, and this difference should be explained. In particular, in OOP, an object is an instance of a class, while in Scala, anything that is declared as an object cannot be instantiated! The <code>object</code> is a keyword in Scala. The basic syntax for declaring an object in Scala is as follows:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/class_Animal00.png)

This hello world example is pretty similar to the Java ones. The only big difference is that the main method is not inside a class, but instead it's inside an object. In Scala, the keyword object can mean two different things:

- ✨ As in OOP, an object can represent an instance of a class.
- ⚡ A keyword for depicting a very different type of instance object called **Singleton**.

### Singlenton and companion objects.

In this subsection, we will see a comparative analysis between the singleton object in Scala 🟥 and Java ☕. The idea beneath the singleton pattern is to have an implementation that makes sure that only a single instance of a class can exist. Here's an example of the Singleton pattern in Java:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/singlenton_java.png)

The Scala object does a similar thing, and it's well taken care of by the compiler. Since there will be only one instance, there is no way for object creation here:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/singlenton_scala.png)

### Companion objects 

When a <code>singleton object</code> is named the same as a class, it is called a <code>companion object</code>. A companion object must be defined inside the same source file as the class. Let's demonstrate this with the example here:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/companion_object.png)

A Java ☕ equivalent would be similar, as follow:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_2/image/companion_object_java.png)


