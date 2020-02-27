# javablade

#### COMMANDS
```
sudo apt install openjdk-8-jdk
sudo apt install maven

vim .bashrc 
vim .zshrc 
export JAVA_HOME="/usr/lib/jvm/java-8-openjdk-amd64"
export PATH="$PATH:/usr/lib/jvm/java-8-openjdk-amd64/bin"

cd /etc/maven
vim settings.xml
<mirror>
        <id>alimaven</id>
        <name>aliyun maven</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>
        <mirrorOf>central</mirrorOf>        
</mirror>

<profile>  
    <id>jdk-1.8</id>  
           <activation>  
     <activeByDefault>true</activeByDefault>  
     <jdk>1.8</jdk>  
   </activation>  
  <properties>  
    <maven.compiler.source>1.8</maven.compiler.source>  
    <maven.compiler.target>1.8</maven.compiler.target>  
    <maven.compiler.compilerVersion>1.8</maven.compiler.compilerVersion>  
  </properties>
</profile>



mvn archetype:generate -DgroupId=company -DartifactId=app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


pom.xml
<build>
        <finalName>app</finalName>
        <plugins>
            <plugin>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.2</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
        <plugin>
                <artifactId>maven-assembly-plugin</artifactId>
                <configuration>
                <descriptorRefs>
                <descriptorRef>jar-with-dependencies</descriptorRef>
                </descriptorRefs>
                </configuration>
                </plugin>
        </plugins>
</build>    
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
</properties>

mvn clean package
mvn compile
mvn package
mvn install assembly:assembly
java -cp target/app-jar-with-dependencies.jar company.App
```


