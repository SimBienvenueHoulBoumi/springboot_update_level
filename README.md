## Notes

# Initialisation
```bash
# creer un projet mvn sur vscode
 - CMD + P sur mac ou Crlt + P sous windows puis entrer ">"
 - taper "maven new projet" pour créer un projet maven
 - choisir "maven-archetype-quickstart" pour avoir un projet racine vide
 - choisir un nom du projet (ex: exmvn)
 - choisir le nom de lartefact id souvent pareil au nom du projet 
 - dans la console choisir la version (laisser par defaut pour un nouveau projet)
 - confirmer les configurations
 - appuyer sur la touche "Entrer" pour valider
 - penser a mettre a jour la version de maven dans le pom.xml
```

# Premier demarrage
```bash
# paramettrer le plugin qui génère le jar pour pointer
# vers le fichier principal
# App.java
- se rendre dans le pom.xml au niveau de la session "plugins"
- chercher "maven-jar-plugin"
- juste après la session "version" ajouter pour la mise en place du plugin qui génère le jar:
   <artifactId>maven-jar-plugin</artifactId>
   <version>3.0.2</version>
   <configuration>
      <archive>
        <manifest>
           <addClasspath>true</addClasspath>
           <classpathPrefix>lib/</classpathPrefix>
           <mainClass>exmvn.App</mainClass> # nom de la class qui contient le main
        </manifest>
      </archive>
   </configuration>
```

# Commande utiles
```bash
# générer le package pour préparer le déploiement
mnv package # le jar est mis dans le repertoire target/

# simuler l'exécution
java -jar target/[nom_du_projet]-[version_du_projet].jar
```
# Convention
```bash
# url inversée de l'entreprise . nom du projet
com.simdev.exmnv
```
