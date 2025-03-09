# Fuctional Programming Concepts.


**Que son las higher-order (HOF) functions?**

Las higher-order functions son funciones que cumplen al menos una de estas condiciones:

1. Toman una o más funciones como argumento: Puedes pasar una función como parámetro a otra función.
2. Devuelven una función como resultado: La función genera otra función al ejecutarse.

Ejemplo en Scala 🟥:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/higher_order_fucntion.png)

Aquí, <code>map</code> es de orden superior porque recibe una función anónima (<code>x => x * 2</code>) y la aplica a cada elemento.

**Por qué son importantes en Big Data?**

En Big Data, donde se manejan datasets masivos (millones o billones de registros), las higher-order functions son clave por estas razones:

1. Procesamiento distribuido

	📌 Frameworks como Apache Spark 💥 dependen de funciones como <code>map</code>, <code>filter</code>, <code>reduce</code>, que son higher-order. Estas se ejecutan en paralelo across nodos de un clúster. Por ejemplo:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/procesamiento_dist.png)

<code>map</code> transforma cada línea en un conteo de palabras, y <code>reduce</code> suma todo, distribuyendo el trabajo.

2. Abstracción y simplicidad:

	💡 Permiten escribir código conciso y legible sin bucles manuales. En Big Data, donde iterar manualmente sobre terabytes es inviable, estas funciones abstraen la lógica y delegan la ejecución al framework.
	
3. Inmutabilidad y segurida:

4. Optimización automática:

	🔷 Sistemas como Spark 💥 optimizan las operaciones definidas por higher-order functions (gracias a su "lazy evaluation"). Por ejemplo, <code>map</code> y <code>filter</code> se combinan en una sola pasada sobre los datos, reduciendo el costo computacional.
	
**Ejemplo práctico en Big Data**

Imagina un dataset de transacciones financieras en AWS S3 con millones de filas. Quieres filtrar transacciones mayores a $1000 y sumarlas:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/chapter_3/image/filter_data.png)

<code>filter</code> y <code>map</code> son higher-order: toman funciones como argumento y se ejecutan en paralelo en el clúster.

***

In a nutshell, the following topics will be covered in this chapter:

	- 📍 Introduction to functional programming.
	- 🥊 Functional Scala for the data scientists.
	- 🌟 Why functional programming and Scala are important for learning Spark?.
	