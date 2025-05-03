![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/cover.png)

# 🚀 Scala and Spark for BigData.

## 🎓 History and purpose of Scala.

Scala 🟥 is a general-purpose programming language that comes with support <code>functional programming</code> and strong <code>static type</code> system. The source code of Scala 🟥 is intended to be compiled into <code>Java</code> bytecode, so that the resulting executable code can be run on <code>Java virtual machine</code> (JVM).

Martin Odersky started the design of Scala 🟥 back in 2001 at the **_École Polytechnique Fédérale de Lausanne (EPFL)_**.

## 🗒️ Platform and editors.

En mi caso y en este momento uso:

- 🍥 nvim 11.
- 🟧 IntelliJ Idea 24.1

## 🪛 Installing and setting up Scala.

Before starting, I share with you that the configuration I am going to use is:

- ☕ Java 11.0.26
- 🟥 Scala 2.13.8
- ⭐ Spark 3.5.1

### 👷🏼‍♂️ Installing Java.

 At first, check whether Java is already installed:
 
 <code>$ java -version</code>
 
 If it returns <code>The program java cannot be found in the following packages</code>, Java ☕ hasn't been installed yet. Then you would like to execute the following command to get rid of:

```
$ sudo apt update
$ sudo apt install openjdk-11-jdk
$ java -version
```

After installing, don't forget to set the Java home environmental variable. Just apply the following commands:

<code>$ ls /usr/lib/jvm/ </code>

You should see something like:

<code>java-11-openjdk-amd64</code>

And we declare.

```
$ echo "export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64" >> ~/.bashrc
$ echo "export PATH=$PATH:$JAVA_HOME/bin" >> ~/.bashrc
$ source ~/.bashrc
```

Now, let's see the <code>Java_HOME</code> as follows:

<code>$ echo $JAVA_HOME</code>

You should observe the following result on Terminal:

<code>/usr/lib/jvm/java-11-openjdk-amd64</code>

Now, let's check to make sure that Java has been installed successfully by issuing the following command:

<code>$ java -version</code>

You will get the following output:

```
openjdk version "11.0.26" 2025-01-25
OpenJDK Runtime Environment (build 11.0.26+4-post-Ubuntu-1ubuntu124.04)
```

### 🔥 Installing Scala.

Before starting, let's check to make sure Scala is installed properly.
 
 <code>$ scala -version</code>
 
If Scala 🟥 is already installed on your system, you should get the following message on your terminal:

<code>Scala code runner version 2.13.8 -- Copyright 2002-2021, LAMP/EPFL and Lightbend, Inc.</code>

Scala 🟥 no está disponible en los repositorios oficiales de Ubuntu, por lo que necesitas descargarlo manualmente desde el sitio oficial. 

1. Go 👉🏼 to the official Scala website: [Scala](https://www.scala-lang.org/).
2. Find version 2.13.8 and copy the download link of the file <code>.tgz</code>.
3. Extract the downloaded file

Extract the <code>.tgz</code> file to a suitable directory, such as <code>/usr/local/scala:</code>

```
$ sudo mkdir -p /usr/local/share/scala
$ sudo tar -xvzf scala-2.13.8.tgz -C /usr/local/share/scala
```

4. Configurate envioronment variables:

```
$ echo "export SCALA_HOME=/usr/local/share/scala" >> ~/.bashrc
$ echo "export PATH=$PATH:$SCALA_HOME/bin" >> ~/.bashrc
```

Then, make the change permanent for the session by using the following command:

<code>$ source ~/.bashrc</code>

After the installation has been completed, you should better to verify it using the following command:

<code>$ scala -version</code>

If Scala has successfully been configured on your system, you should get the following message on your terminal:

<code>Scala code runner version 2.13.8 -- Copyright 2002-2021, LAMP/EPFL and Lightbend, Inc.</code>

### ✨ Operators as methods.

An alternative syntax for calling a method taking a single parameter is the use of the infinix syntax.

```
val x = 45
val y = 75

val add1 = x.+(y)
```

More formally, the same can be done using the infix syntax, as follow:

<code>val add2 = x + y</code>

In Scala, methods ending with <code>:</code> are **right-associative**. This means that the object to which the method is applied is the one to its right. For example:

```
val my_list = List(3, 6, 15, 35, 76)
val my_resu1lt = 5 +: my_list			// The outpus is List(5, 3, 6, 15, 35, 76) 
```

### 📋 Methods and parameter lists.

In Scala 🟥, the following is the valid method definition (written in _currie notation_) where a method has two parameter lists:

<code>def sum(x: Int)(y: Int) = x + y</code>

The preceding method cannot be written as:

<code>def sum(x: Int, y: Int) = x + y</code>

Method above 👆🏼, let's say <code>sum2</code>, can have no parameter list at all, as follow:

```
val sum2 = sum(2) _
val result = sum2(5)
```

### 🧵 Constructor in Scala.

Hago un constraste de como se escribe una clase en Java y en Scala:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/constructor_java_vs_scala.png)

Ahora para ejecutar los script correspondientes usamos en el REPL o consola interactiva correspondiente:

```
jshell > Person.main(null);
```


```
scala > Person.main(Array())
```

### 🚀 Objects instead of static methods.

As mentioned earlier, <code>static</code> does not exist in Scala 🟥. You cannot do <code>static</code> imports and neither can you cannot add static methods to classes. In Scala 🟥, when you define an object with the same name as the class and in the same source file, then the object is said to be the companion of that class. 

**Ejemplo en Java ☕: Método Estático.**

En Java ☕, un método estático pertenece a la clase en lugar de a una instancia específica. Esto significa que puedes llamar al método sin necesidad de crear un objeto de la clase.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/static_method_java.png)

- El método <code>suma</code> es estático (<code>static</code>), lo que significa que no nece	sitas crear una instancia de la clase <code>calculadora</code> para usarlo.
- Puedes llamar al método directamente usando el nombre de la clase: <code>Calculadora.sum(5, 3)</code>.

***

In Scala 🟥, when you define an object with the same name as the class and in the same source file, then the object is said to be the companion of that class. Functions that you define in this companion object of a class are like static methods of a class in Java ☕:

En Scala, no existe la palabra clave <code>static</code>. En su lugar, se utiliza un **objeto singleton** (un objeto definido con la palabra clave <code>object</code>) para lograr un comportamiento similar al de los métodos estáticos en Java ☕.

**Código en Scala 🟥:**

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/singlenton_object.png)

- En Scala 🟥, un </code>object</code> es un singleton, lo que significa que solo puede existir una instancia de ese objeto en todo el programa.
- Los métodos definidos dentro de un </code>object</code> son accesibles directamente, sin necesidad de crear una instancia, lo que los hace equivalentes a los métodos estáticos en Java.
- En este caso, el método <code>suma</code> se define dentro del objeto <code>Calculadora</code>, y puedes llamarlo directamente como <code>Calculadora.suma(5, 3)</code>.

### Traits ⌚7

Scala 🟥 provides a great functionality for you in order to extends and enrich your classes behaviors. These traits are similar to the interfaces in which you define the function prototype or signature.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/trait.png)

### Scala 🟥 for beginners.

**Your first line code**

As a first example, we will use the pretty common <code>Hello, world!</code> program in order to show you how to use Scala and its tools without knowing much about it.

```
object HelloWorld {
	def main(args: Array[String]): Unit = {
		println("Hello, world!)
	}
}
```

Now, save the code with a name, say <code>HelloWorld.scala</code>

Let's compile the source file as follows:

```
$ scalac HelloWorld.scala
$ scala HelloWorld
```

The following is the same <code>Hello, world!</code> example, but using the <code>App</code> trait:

```
#!/usr/bin/env scala
object HelloWorld extends App {
    println("Hello, world!")
}
```

The preceding script can be run directly from the commmand shell:

<code>$ ./script.sh</code>

Note: we assume here that the file <code>script.sh</code> has the execute permission:

<code>$ sudo chmod +x script.sh</code>

Then, the search path for the scala command is specified in the <code>$PATH</code> environment variable.