![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/cover_chapter3.png)

# Fuctional Programming Concepts.

**Que son las higher-order (HOF) functions?**

Las higher-order functions son funciones que cumplen al menos una de estas condiciones:

1. Toman una o más funciones como argumento: Puedes pasar una función como parámetro a otra función.
2. Devuelven una función como resultado: La función genera otra función al ejecutarse.

Ejemplo en Scala 🟥:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/higher_order_function.png)

Aquí, <code>map</code> es de orden superior porque recibe una función anónima (<code>line => line.split(" ").length</code>) y la aplica a cada elemento.

**Por qué son importantes en Big Data?**

En Big Data, donde se manejan datasets masivos (millones o billones de registros), las higher-order functions son clave por estas razones:

1. Procesamiento distribuido

📌 Frameworks como Apache Spark ⭐ dependen de funciones como <code>map</code>, <code>filter</code>, <code>reduce</code>, que son higher-order. Estas se ejecutan en paralelo across nodos de un clúster. Por ejemplo:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/procesamiento_dist.png)

<code>map</code> transforma cada línea en un conteo de palabras, y <code>reduce</code> suma todo, distribuyendo el trabajo.

2. Abstracción y simplicidad:

💡 Permiten escribir código conciso y legible sin bucles manuales. En Big Data, donde iterar manualmente sobre terabytes es inviable, estas funciones abstraen la lógica y delegan la ejecución al framework.
	
3. Inmutabilidad y seguridad.

4. Optimización automática:

🔷 Sistemas como Spark ⭐ optimizan las operaciones definidas por higher-order functions (gracias a su "lazy evaluation"). Por ejemplo, <code>map</code> y <code>filter</code> se combinan en una sola pasada sobre los datos, reduciendo el 	costo computacional.

**Ejemplo práctico en Big Data**
	
Imagina un dataset de transacciones financieras en ☁️ AWS S3 con millones de filas. Quieres filtrar transacciones mayores a $1'000 y sumarlas:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/filter_data.png)

<code>filter</code> y <code>map</code> son higher-order: toman funciones como argumento y se ejecutan en paralelo en el clúster.

***

In a nutshell, the following topics will be covered in this chapter:

- 📍 Introduction to functional programming.
- 🥊 Functional Scala for the data scientists.
- 🌟 Why functional programming and Scala are important for learning Spark?.	
- 🎱 Pure functions and higher-order functions.
- ✨ Using higher-order functions: A real-life use case.
- 💊 Error handling in functional Scala.

## Introduction to functional programming.

This is not a new concept but the <code>Lambda Calculus</code>, which provides the basis of FP, was first introduced in the 1930s. However, in the realm of programming language, the term functional programming refers to a new style of declarative programming paradigm that means programming can be done with the help of control, declarations, or expressions instead of classical statements commonly used in an old programming language, such as C.

## Why Spark ⭐?.

As mentioned earlier, Spark is built on top of the Hadoop 🐘 software and you can deploy Spark ⭐ in different ways:

- **Standalone cluster**: This means that Spark will run on top of Hadoop Distributed File System (HDFS) and space will actually be allocated to HDFS. Spark and MapReduce will run side by side to serve all the Spark jobs.
- **Hadoop YARN cluster**: This means that Spark simply runs on YARN without any root privileges or pre-installations.
- **Mesos cluster**: When a driver program creates a Spark job and starts assigning related tasks for scheduling, Mesos determines which computing nodes will handle which tasks. We assume that you have already configured and installed
Mesos on your machine.
- **Deploy on pay-as-you-go cluster**: You can deploy Spark jobs in real cluster mode on AWS EC2. To make your applications run on Spark ⭐ cluster mode and for better scalability, you can consider Amazon Elastic Compute Cloud (EC2) ☁️ services as Infrastructure as a Service (IaaS) or Platform as a Service (PaaS).

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/arquitectura.png)

## Pure function and higher-order function.

Using a higher-order function is a function one of the following can be
performed:

+ Takes one or more functions as arguments to do some operations.
+ Returns a function as its result.

Todas las demás funciones, excepto las de orden superior, son funciones de primer orden. Sin embargo, desde una perspectiva matemática, las funciones de orden superior también se denominan operadores o funcionales. Por otro lado, si el valor de retorno de una función solo está determinado por su entrada y, por supuesto, sin efectos secundarios observables, se denomina función pura.

## Pure functions.

Normalmente, las funciones puras son más pequeñas que las funciones normales (aunque esto depende de otros factores, como el lenguaje de programación) e incluso más fáciles de interpretar y comprender para el cerebro humano, ya que se asemejan a una función matemática.

Sin embargo, se podría argumentar en contra, ya que la mayoría de los desarrolladores aún encuentran la programación imperativa más comprensible. Las funciones puras son mucho más fáciles de implementar y probar. Demostrémoslo con un ejemplo. Supongamos que tenemos las siguientes dos funciones independientes:

```
val pureFunc(cityName: String) = s"I live in $cityName"
val notpureFunc(cityName: String) println(s"I live in $cityName")
```

Entonces, en los dos ejemplos anteriores, si desea testear la función pura <code>pureFunc</code>, simplemente confirmamos el valor de retorno que proviene de la función pura con lo que esperamos según nuestra entrada, como:

```
assert(pureFunc("Dublin") == I live in Dublin
```

Por otro lado, si quisiéramos probar nuestra función impura <code>notpureFunc</code>, necesitaríamos redirigir la salida estándar y aplicarle una aserción. El siguiente consejo práctico es que la programación funcional aumenta la productividad de los programadores porque, como se mencionó anteriormente, las funciones puras son más pequeñas y fáciles de escribir, y se pueden combinar fácilmente. Además, la duplicación de código es mínima y se puede reutilizar fácilmente. Ahora, demuestremos esta ventaja con un mejor ejemplo. Consideremos estas dos funciones:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/pureMul.png)

Sin embargo, la mutabilidad puede tener efectos secundarios; usar una función pura (es decir, sin mutabilidad) nos ayuda a razonar y probar el código:

```
def pureIncrease(x: Int) = x + 1
```

Este es ventajoso y muy fácil de interpretar y usar. Sin embargo, veamos otro ejemplo:

```
var inc = 0
def impureIncrease() = {
	inc += 1
	inc
}
```

Ahora, considere lo confuso que puede ser esto: ¿cuál será el resultado en un entorno multiproceso? Como puede ver, podemos usar fácilmente nuestra función pura, pureMul, para multiplicar cualquier secuencia de números, a diferencia de nuestra función impura notpureMul. Demostremos esto con el siguiente ejemplo:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/reduce_pureMul.png)

El código completo de los ejemplos anteriores se puede mostrar de la siguiente manera (los métodos se llamaron utilizando algunos valores reales):

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/pureAndNotPureFunc.png)

Como se mencionó anteriormente, puede considerar las funciones puras como una de las características más importantes de la programación funcional y como una práctica recomendada; debe construir el núcleo de su aplicación utilizando funciones puras.

**🚨 Functions versus methods**:

En programación, una función es un fragmento de código al que se llama por un nombre. Se pueden pasar datos (como argumento o parámetro) para operar sobre ellos y devolverlos (opcionalmente). Todos los datos que se pasan a una función se pasan explícitamente. Un método, por otro lado, también es un fragmento de código al que se llama por un nombre. Sin embargo, un método siempre está asociado a un objeto.

🧵 Sounds similar? Well! In most cases, a method is identical to a function
except for two key differences:

1. A method is implicitly passed the object on which it was called.
2. A method is able to operate on data that is contained within the class.

Ya se afirmó en el capítulo anterior que un objeto es una instancia de una clase: la clase es la definición y el objeto es una instancia de esos datos.

Ahora es momento de aprender sobre funciones de orden superior. Sin embargo, antes de eso, debemos aprender un concepto más importante en Scala funcional: las **funciones anónimas**. Con esto, también aprenderemos a usar la expresión lambda con Scala funcional.

## Anonymous functions

A veces, en tu código, no conviene definir una función antes de usarla, quizás porque la usarás en un solo lugar. En programación funcional, existe un tipo de función muy adecuado para esta situación: la función anónima. Demostremos el uso de funciones anónimas con el ejemplo anterior de transferencia de dinero:

```
def TransferMoney(money: Double, bankFee: Double => Double): Double = {
	money + bankFee(money)
}
```

Now, let's call the <code>TransferMoney()</code> method with some real value as follow:

```
TransferMoney(100, amount: Double) => amount * 0.05)
```

**🚨 Lambda expression**:

Como ya se mencionó, Scala admite funciones de primera clase, lo que significa que las funciones también pueden expresarse en sintaxis literal de función; las funciones pueden representarse mediante objetos, llamados valores de función. Pruebe la siguiente expresión; esta crea una función sucesora para enteros:

```
scala> var apply = (x: Int) => x + 1
apply: Int => Int = <function1>
```

The apply variable is now a function that can be used in the usual way as follow:

```
scala> var x = apply(8)
x: Int = 9
```

⚠️ Lo que hemos hecho aquí es simplemente usar el núcleo de una función: la lista de argumentos, seguida de la flecha de función y el cuerpo de la función. Esto no es magia negra, sino una función completa, solo que sin nombre, es decir, anónima. Si se define una función de esta manera, no habrá forma de referirse a ella posteriormente y, por lo tanto, no se podrá llamar a ella posteriormente, ya que sin nombre es anónima. Además, tenemos la llamada **expresión lambda!**. Es simplemente la definición pura y anónima de una función.

## 🚀 Higher-order functions.

In Scala's functional programming, you are allowed to pass functions as parameters and even return a function as a result from another function; this defines what are called higher-order functions.

Let's demonstrate this feature by an example. Consider the following function <code>testHOF</code> that takes another function <code>func</code> and then applies this function to its second argument value:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/hof.png)

Ejecutando el código en REPL tenemos:

```
scala> Test.main(Array())
[10]
```

Tras demostrar los fundamentos de la programación funcional de Scala 🟥, estamos listos para abordar casos más complejos de programación funcional. Como se mencionó anteriormente, podemos definir una función de orden superior como una función que acepta otras funciones como argumentos y las devuelve como resultado. Si tienes experiencia en programación orientada a objetos, te resultará un enfoque muy diferente, pero te resultará más fácil de entender a medida que avancemos.

Let's start by defining a simple function:

```
def quarterMaker(value: Int): Double = value.toDouble/4
```

The previous function is a very simple one. It's a function that accepts an Int value and then returns a quarter of this value in a Double type. Let's define another simple function:

```
def addTwo (value: Int): Int = value + 2
```

The second function <code>addTwo</code> is more trivial than the first one. It accepts an <code>Int</code> value and then adds 2 to it. As you can see, these two functions have something in common. Both of them accept <code>Int</code> and return another processed value that we can call <code>AnyVal</code>. Now, let's define a higher-order function that accepts another function among its parameters:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/applyFuncOnRange.png)

Podemos usar las funciones anteriores con <code>applyFuncOnRange</code>:

```
applyFuncOnRange(0, 5, quarterMaker)
applyFuncOnRange(1, 10, addTwo)
```

🚨 **Scala syntax for loop with range**: The simple syntax of using a for loop with range in Scala is:

```
for (var x <- range) {
	statement(s)
}
```
Here, the <code>range</code> could be a range of numbers and is represented as <code>i</code> to <code>j</code> or sometimes like <code>i</code> until <code>j</code>. The left-arrow <code>-></code> operator is called a generator because it's generating individual values from a range. Let's see a concrete example of this feature:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/usingRange.png)

Before going into more examples, let's define what's called a callback function. A callback function is a function that can be passed as an argument to another function. Other functions are simply normal functions. Let's demonstrate more examples of using different callback functions. Consider the following higher-order function, which is responsible for transferring a specific amount of money from your account:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/TransferMoney.png)

After calling the <code>TransferMoney</code> function on 100:

```
TransferMoney(100, bankFee)
```

The output of the preceding code is as follow:

105.0

Desde una perspectiva de programación funcional, este código no está listo para integrarse en el sistema bancario, ya que requiere aplicar diferentes validaciones a los parámetros monetarios, como que sean positivos y mayores que la cantidad especificada por el banco. Sin embargo, aquí solo demostramos el uso de funciones de alto nivel y funciones de devolución de llamada.

Este ejemplo funciona así: se desea transferir una cantidad específica de dinero a otra cuenta bancaria. El banco aplica una comisión específica según la cantidad transferida, y aquí entra en juego la callback function. Esta toma la cantidad de dinero a transferir y le aplica la comisión bancaria para obtener el importe total.

La <code>TransferMoney</code> function toma dos parámetros: el primero es el dinero a transferir y el segundo es una función de devolución de llamada con la firma <code>Double => Double</code>, que la función aplica al argumento de dinero para determinar la comisión bancaria sobre el dinero transferido.

The complete source code of the preceding examples can be seen as follow (we called methods using some real values):

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/higherOrderFunction.png)

By using callback functions, you are giving extra power to the higher-order function; so, it's a very powerful mechanism to make your program more elegant, flexible, and efficient.

## Function as a return value

As mentioned, higher-order functions also support returning a function as a result. Let's demonstrate this by an example:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/FunctionAsReturnValue.png)

