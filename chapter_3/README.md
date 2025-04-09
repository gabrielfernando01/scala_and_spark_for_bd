![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/cover_chapter3.png)

# Fuctional Programming Concepts.

**Que son las higher-order (HOF) functions?**

Las higher-order functions son funciones que cumplen al menos una de estas condiciones:

1. Toman una o más funciones como argumento: Puedes pasar una función como parámetro a otra función.
2. Devuelven una función como resultado: La función genera otra función al ejecutarse.

Ejemplo en Scala 🟥:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/higher_order_function.png)

Aquí, <code>map</code> es de orden superior porque recibe una función anónima (<code>x => x * 2</code>) y la aplica a cada elemento.

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
