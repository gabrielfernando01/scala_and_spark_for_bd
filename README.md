![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/cover.png)

# 🚀 Scala and Spark for BigData.

## Index

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index00.png)

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index01.png)

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index02.png)

## 🎓 History and purpose of Scala.

Scala 🟥 is a general-purpose programming language that comes with support <code>functional programming</code> and strong <code>static type</code> system. The source code of Scala 🟥 is intended to be compiled into <code>Java</code> bytecode, so that the resulting executable code can be run on <code>Java virtual machine</code> (JVM).

**Martin Odersky** started the design of Scala 🟥 back in 2001 at the **_École Polytechnique Fédérale de Lausanne (EPFL)_**.

## 🗒️ IDE and text editor.

- 🍥 nvim 11.
- 🟧 IntelliJ IDEA 24.1

***

## 🪛 Installing and setting up Scala.

Before starting, I share with you that the configuration I am going to use is:

- ☕ Java 11.0.26
- 🟥 Scala 2.13.8
- ⭐ Spark 3.5.1

### 👷🏼‍♂️ Installing Java.

**Antes de empezar**

¿Que arquitectura tengo?

Bash
```
lscpu
```

At first, check whether Java is already installed:
 
 <code>$ java -version</code>
 
If it returns <code>The program java cannot be found in the following packages</code>, Java ☕ hasn't been installed yet. Then you would like to execute the following command to get rid of:

Bash
```
sudo apt update
sudo apt install openjdk-11-jdk
java --version
```

After installing, don't forget to set the Java home environmental variable. Just apply the following commands:

<code>$ ls /usr/lib/jvm/ </code>

You should see something like:

<code>java-11-openjdk-amd64</code>

Ahora editamos el fichero <code>.bashrc</code> o el fichero <code>.profile</code>

Al final del fichero escribimos:
```
export JAVA_HOME=/usr/lib/jvm/java-11-opengldk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

Para que los cambios en el fichero <code>~/.bashrc</code> sean permanentes, escribimos:

Bash
```
source ~/.bashrc
```

Verifica que las variables estén configuradas correctamente:

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

***

**☕ Cuando necesites desistalar Java**

⛏️ Identifica el paquete instalado.

Bash
```
dpkg --list | grep instalado
```

🔩 Desistalamos el paquete, eliminamos los archivos de configuración, limpar paquetes residuales

Bash
```
sudo apt remove <java_version>
sudo apt purge <java_version>
sudo apt autoremove <java_version>
```

🐸 Validar que Java está desistalado:


Bash
```
java --version
```

📌 Comentar o eliminar los <code>export PATH</code> dentro del fichero <code>.bashrc</code>

🍑 Validar que el <code>PATH</code> se elimino correctamente:

Bash
```
echo $JAVA_HOME
```

***

### 🔥 Install Scala.

**🎯 Antes de empezar**

Validar que tengas instalado <code>sdk</code>, <code>coursier</code>, <code>curl</code>, <code>wget</code>.

Bash
```
sdk version      # Para ver si tienes SDKMAN!
coursier --version   # Para Coursier CLI
curl --version       # Para curl
wget --version       # Para wget
```

Before starting, let's check to make sure Scala is installed properly.
 
 <code>$ scala -version</code>

If Scala 🟥 is already installed on your system, you should get the following message on your terminal:

<code>Scala code runner version 2.13.8 -- Copyright 2002-2021, LAMP/EPFL and Lightbend, Inc.</code>
 
 **De cuantas maneras puedo descargar Scala en mi 💻?**
 
 - Por <code>apt</code>, solo tiene la última version estable disponible.
 - Por el sitio oficial 👉🏽 <a href="https://www.scala-lang.org/ " target="_blank" rel="noopener noreferrer">Scala</a>; <code>coursier</code>, <code>sdk</code>, <code>curl</code>, <code>wget</code>.

**⚡ Requisitos previos**

- Tener instalado JRE (Java Run Time Environment) o JDK (Java Development Kit).

```
java --version
```

Mostrar la ruta del ejecutable:

Bash
```
update-alternatives --config java
```

📥 Paso 1: Descarga Scala desde scala-lang.org

Regresando a la página oficial <a href="https://www.scala-lang.org/" target="_blank" rel="noopener noreferrer">Scala</a>. En este caso descargamos la versión 2.13.16 

Seleccionamos el fichero <code>scala-2.13.16.tgz</code>

🗃️ Paso 2: Descomprime el archivo .tgz

Crea una carpeta donde quieras instalar Scala. Por ejemplo:

Bash
```
sudo mkdir -p /usr/local/scala
```

Descomprime ahí el archivo:

Bash
```
sudo tar -xvf scala-2.13.16.tgz -C /usr/local/scala --strip-components=1
```

🛠️ Paso 3: Configura las variables de entorno.

Edita el archivo ~/.bashrc o ~/.zshrc dependiendo de tu shell. 

Bash
```
nvim ~/.bashrc
```

Al final del fichero, agrega:

```
export SCALA_HOME=/usr/local/scala
export PATH=$PATH:$SCALA_HOME/bin
```

🔁 Paso 4: Aplica los cambios

Bash
```
source ~/.bashrc
```

Validar la ubicación del PATH:

Bash
```
echo $SCALA_HOME
```

✅ Paso 5: Verifica la instalación

Bash
```
scala --version
```

Probar el REPL(Read-Eval-Print Loop) de Scala:

Bash
```
scala
```

Salir de REPL

scala
```
:quit
```

***

**Desistalacińn Scala**

🔍 1. Verifica cómo se instaló Scala (opcional pero útil).

Bash
```
which scala
```

🚫 2. Elimina la carpeta donde está instalado Scala (instalación manual).

Bash
```
sudo rm -rf /usr/local/scala
```

🗑️ 3. Limpia las variables de entorno.

Abrir el fichero <code>.bashrc</code> que es donde definimos <code>SCALA_HOME</code> y <code>PATH</code>. Yo uso <code>nvim</code> también puedes usar <code>nano</code> para editar el fichero, es decir, borrar o comentar las siguientes lineas:

```
export SCALA_HOME=/usr/local/scala
export PATH=$PATH:$SCALA_HOME/bin
```

Guardar los cambios:

```
source ~/.bashrc
```

🧹 4. Eliminar posibles residuos como .sbt, .ivy2, etc., si no los necesitas:

Bash
```
rm -rf ~/.sbt ~/.ivy2 ~/.scala_history
````

Validar que Scala se haya desistalado:

Bash
```
scala --version
```

**Opcional**

Con SDKMAN puedes tener instalado Scala 2.12, 2.13 y 3.x al mismo tiempo y cambiar entre ellas fácilmente.

***

### ⭐ Install Spark 3.5.1



***

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

**Nota**: En el ejemplo un singlenton de Scala no puede instanciarce, aunque en este caso se esta instanciando a la clase <code>Person</code>.

Escribo otro caso de singlenton 👇🏼 para Java:

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/Connection_java.png)

### 🚀 Objectos (Scala) en vez de métodos estáticos (Java).

En Scala no existe el método estático, lo que hacemos es definir un <code>object</code>, es decir, un singlenton y dentro del él definimos las funciones (que son los equivalentes a los métodos estáticos en Java), en el siguiente ejemplo se llama a los métodos <code>sum</code> y <code>main</code>.

También comento que en Java lo que hacemos es llamar al método sin necesidad de crear un objeto.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/singlenton.png)

- Insistir en que en Scala solo se ocupa crear un singlenton (un <code>object</code>) para llamar a las funciones.
- En los ejemplos se dan expresiones numericas particulares para ejecutar el ejercicio.

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