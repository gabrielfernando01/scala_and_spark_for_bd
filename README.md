![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/cover.png)

# 🚀 Scala and Spark for BigData.

## Index

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index00.png)

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index01.png)

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/index02.png)

## 🔥 Background
### ☀️ History and purpose of Scala.

Scala es un lenguaje de programación de propósito general compatible con la <code>fuctional programming</code> y un sólido sistema <code>static type</code>. El código fuente de Scala está diseñado para compilarse en código de bytes de <code>Java</code>, de modo que el código ejecutable resultante pueda ejecutarse en <code>Java Virtual Machine</code>(JVM).

**Martin Odersky** empezó a diseñar Scala al rededor del 2001 en la **_École Polytechnique Fédérale de Lausanne (EPFL)_**.

### 🗒️ IDE and text editor.

- 🍥 nvim 11.
- 🟧 IntelliJ IDEA 2025.1

***

### 🪛 Installing and setting up Scala.

Antes de iniciar te comparto la versiones que estoy ocupando al momento de escribir este repositorio (junio 2025), mismo mes en el que se acaba de liberar <code>Spark 4.0</code>:

- ☕ Java 17.0.15
- 🟥 Scala 2.13.16
- ⭐ Spark 4.0.0

### 👷🏼‍♂️ Installing Java.

**Antes de empezar**

¿Que arquitectura tengo?

bash
```
lscpu
```

Validamos si Java esta instalado en nuestro sistema:
 
 bash
 ```
 java -version
 ```
 
Si nos responde <code>The program java cannot be found in the following packages</code>, quiere decir que Java aún no está instalado. Entonces te invito a ejecutar los siguientes comandos:

bash
```
sudo apt update
sudo apt install openjdk-17-jdk
java --version
```

Tras la instalación, no olvides configurar la variable de entorno <code>JAVA_HOME</code>. Simplemente aplica los siguientes comandos:

<code>$ ls /usr/lib/jvm/ </code>

Deberías ver algo similar a lo siguiente: <code>java-17-openjdk-amd64</code>

Ahora editamos el fichero <code>~/.bashrc</code> o el fichero <code>.profile</code>

Al final del fichero escribimos:
```
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
export PATH=$JAVA_HOME/bin:$PATH
```

Para que los cambios en el fichero <code>~/.bashrc</code> sean permanentes, escribimos:

bash
```
source ~/.bashrc
```

Verifica que las variables estén configuradas correctamente:

<code>$ echo $JAVA_HOME</code>

You should observe the following result on Terminal: <code>/usr/lib/jvm/java-17-openjdk-amd64</code>

Ahora asegurate que efectivamente java fue instalado exitosamente:

bash
```
java -version
```

Deberías de ver el siguiente output:

```
openjdk version "17.0.15" 2025-04-15
OpenJDK Runtime Environment (build 17.0.15+6-Ubuntu-0ubuntu124.04)
OpenJDK 64-Bit Server VM (build 17.0.15+6-Ubuntu-0ubuntu124.04, mixed mode, sharing)
```

***

**☕ Cuando necesites desistalar Java**

⛏️ Identifica el paquete instalado.

bash
```
dpkg --list | grep instalado
```

🔩 Desistalamos el paquete, eliminamos los archivos de configuración, limpar paquetes residuales

bash
```
sudo apt remove <java_version>
sudo apt purge <java_version>
sudo apt autoremove <java_version>
```

**🐸 Validar que Java está desistalado**:

Bash
```
java --version
```

📌 Comentar o eliminar los <code>export PATH</code> dentro del fichero <code>.bashrc</code>

**🍑 Validar que el <code>PATH</code> se elimino correctamente**:

Bash
```
echo $JAVA_HOME
```

***

### 🔥 Install Scala.

**🎯 Antes de empezar**

Validar que tengas instalado <code>sdk</code>, <code>coursier</code>, <code>curl</code>, <code>wget</code>.

bash
```
sdk version      # Para ver si tienes SDKMAN!
coursier --version   # Para Coursier CLI
curl --version       # Para curl
wget --version       # Para wget
```

Antes de inciar, verifica si Scala está instalado.

bash
```
scala -version
```

Si Scala esta instalado en tu sistema verás algo como esto:

<code>Scala code runner version 2.13.16 -- Copyright 2002-2021, LAMP/EPFL and Lightbend, Inc.</code>
 
 **De cuantas maneras puedo descargar Scala en mi 💻?**
 
 - Por <code>apt</code>, solo tiene la última version estable disponible.
 - Por el sitio oficial 👉🏽 <a href="https://www.scala-lang.org/ " target="_blank" rel="noopener noreferrer">Scala</a>; <code>coursier</code>, <code>sdk</code>, <code>curl</code>, <code>wget</code>.

**⚡ Requisitos previos**

- Tener instalado JRE (Java Run Time Environment) o JDK (Java Development Kit).

bash
```
java --version
```

Mostrar la ruta del ejecutable:

bash
```
update-alternatives --config java
```

**📥 Paso 1**: Descarga Scala desde scala-lang.org

Regresando a la página oficial <a href="https://www.scala-lang.org/" target="_blank" rel="noopener noreferrer">Scala</a>. En este caso descargamos la versión 2.13.16 

Seleccionamos el fichero <code>scala-2.13.16.tgz</code>

**🗃️ Paso 2**: Descomprime el archivo .tgz

Crea una carpeta donde quieras instalar Scala. Por ejemplo:

bash
```
sudo mkdir -p /usr/local/scala
```

Descomprime ahí el archivo:

bash
```
sudo tar -xvf scala-2.13.16.tgz -C /usr/local/scala --strip-components=1
```

**🛠️ Paso 3**: Configura las variables de entorno.

Edita el archivo ~/.bashrc o ~/.zshrc dependiendo de tu shell. 

bash
```
nvim ~/.bashrc
```

Al final del fichero, agrega:

```
export SCALA_HOME=/usr/local/scala
export PATH=$PATH:$SCALA_HOME/bin
```

**🔁 Paso 4**: Aplica los cambios

Bash
```
source ~/.bashrc
```

Validar la ubicación del PATH:

bash
```
echo $SCALA_HOME
```

**✅ Paso 5**: Verifica la instalación

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

### ⭐ Install Spark 4.0.0

1. Descarga la última versión de Apache Spark desde el sitio oficial:

bash
```
wget https://downloads.apache.org/spark/spark-4.0.0/spark-4.0.0-bin-hadoop3.tgz
```

2. Descomprime el archivo:

bash
```
tar -xzf spark-3.5.0-bin-hadoop3.tgz
```

3. Mueve el contenido descomprimido a <code>/opt/spark</code>:

bash
```
sudo mkdir -p /opt/spark && sudo mv spark-3.5.0-bin-hadoop3/* /opt/spark/
```

4. Configura las variables de entorno en <code>~/.bashrc</code>:

bash
```
echo 'export SPARK_HOME=/opt/spark' >> ~/.bashrc && echo 'export PATH=$PATH:$SPARK_HOME/bin' >> ~/.bashrc && source ~/.bashrc
```

5. Verifica la instalación ejecutando:
```
spark-shell --version
```

***

## Capitulo 1. Introducción a Scala.

### ✨ Operators as methods.

Una sintaxis alternativa para llamar a un método que toma un solo parámetro es el uso de la sintaxis infinix.

```
val x = 45
val y = 75

val add1 = x.+(y)
```

De manera más formal, se puede hacer lo mismo utilizando la sintaxis infija, de la siguiente manera:

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

Comparemos un como se declara un constuctor en Java y como en Scala , los constructores sí existen , pero tienen una sintaxis más concisa y flexible que en otros lenguajes como Java.

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

### 🚀 Object (singleton) en vez de métodos estáticos en Java.

En Scala no existe el método estático, lo que hacemos es definir un <code>object</code>, es decir, un singleton y dentro del él definimos variable y funciones (que son los equivalentes a los atributos y métodos estáticos en Java), en el siguiente ejemplo se llama a los métodos <code>sum</code> y <code>main</code>.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/singlenton.png)

### 🪟 Traits

Los Traits en Scala son una mezcla entre interfaces y clases abstractas de otros lenguajes. Sirven para definir métodos y propiedades que pueden ser reutilizados por otras clases u objetos. A diferencia de las clases, un Trait puede incluir tanto código implementado como métodos abstractos (sin implementación). Las clases pueden heredar de uno o más Traits usando la palabra clave <code>with</code>, lo que permite una especie de herencia múltiple flexible. Esto los hace ideales para compartir comportamiento entre clases sin necesidad de una jerarquía estricta de herencia.

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/Bird.png)

**Otro ejemplo del uso de Trait**

![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/log.png)

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