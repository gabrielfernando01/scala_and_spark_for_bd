![](https://raw.githubusercontent.com/gabrielfernando01/scala_and_spark_for_bd/main/image/cover.jpg)

# Scala and Spark for BigData

## Intalling and setting up Scala ⚙️🪛

Before starting, I share with you that the configuration I am going to use is:

- Java 17.0.13
- Scala 2.13.14
- Spark 3.5.1

### Installing Java ☕

 At first, check whether Java is already installed:
 
 <code>$ java -version</code>
 
 If it returns <code>The program java cannot be found in the following packages</code>, Java hasn't been installed yet. Then you would like to execute the following command to get rid of:

```
$ sudo apt update
$ sudo apt install openjdk-17-jdk
$ java -version
```

After installing, don't forget to set the Java home environmental variable. Just apply the following commands:

<code>$ ls /usr/lib/jvm/ </code>

You should see something like:

<code>java-17-openjdk-amd64</code>

And we declare.

```
$ echo "export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64" >> ~/.bashrc
$ echo "export PATH=$PATH:$JAVA_HOME/bin" >> ~/.bashrc
$ source ~/.bashrc
```

Now, let's see the <code>Java_HOME</code> as follows:

<code>$ echo $JAVA_HOME</code>

You should observe the following result on Terminal:

<code>/usr/lib/jvm/java-17-openjdk-amd64</code>

Now, let's check to make sure that Java has been installed successfully by issuing the following command:

<code>$ java -verison</code>

You will get the following output:

```
openjdk version "17.0.13" 2024-10-15
OpenJDK Runtime Environment (build 17.0.13+11-Ubuntu-2ubuntu124.04)
```

### Installing Scala

 Before starting, let's check to make sure Scala is installed properly.
 
 <code>$ scala -version</code>
 
If Scala is already installed on your system, you should get the following message on your terminal:

<code>Scala code runner version 2.13.14 -- Copyright 2002-2024, LAMP/EPFL and Lightbend, Inc.</code>

Scala no está disponible en los repositorios oficiales de Ubuntu, por lo que necesitas descargarlo manualmente desde el sitio oficial. 

1. Go 👉🏼 to the official Scala website: [Scala](https://www.scala-lang.org/).
2. Find version 2.13.14 and copy the download link of the file <code>.tgz</code>.
3. Extract the downloaded file

Extract the <code>.tgz</code> file to a suitable directory, such as <code>/usr/local/scala:</code>

```
$ sudo mkdir -p /usr/local/scala
$ sudo tar -xvzf scala-2.13.14.tgz -C /usr/local/scala
```

4. Configurate envioronment variables:

```
$ echo "export SCALA_HOME=/usr/local/share/scala/scala-2.13.14" >> ~/.bashrc
$ echo "export PATH=$PATH:$SCALA_HOME/bin" >> ~/.bashrc
```

Then, make the change permanent for the session by using the following command:

<code>$ source ~/.bashrc</code>

After the installation has been completed, you should better to verify it using the following command:

<code>$ scala -version</code>

If Scala has successfully been configured on your system, you should get the following message on your terminal:

<code>Scala code runner version 2.13.14 -- Copyright 2002-2024, LAMP/EPFL and Lightbend, Inc.</code>

