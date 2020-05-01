# Programme d'analyse de circuit logique  -- par Thomas Mertz

### Prérequis : ANTLR

1. Récupérer l'archive jar de ANTLR : http://www.antlr.org/download/antlr-4.8-complete.jar
2. Ajoutez les commandes suivantes dans votre .bashrc: 

* Rajoutez le .jar au CLASSPATH. Attention, pas de ~ dans le chemin :export           CLASSPATH=".:mon_chemin/antlr-4.8-complete.jar:$CLASSPATH"
* Créez un alias pour le lancement de antlr4 : alias antlr4='java -jar mon_chemin/antlr-4.8-complete.jar'
* Créez un alias pour le lancement de l'analyse d'un fichier par une grammaire : alias grun='java           org.antlr.v4.gui.TestRig'

Java doit également être installé sur votre machine

### Compilation

Dans le dossier circuits : compiler tous les fichiers java : javac *.java
Dans le dossier racine, exécuter la suite de commandes suivantes :

1. antlr4 CircuitLexer.g4  
2. antlr4 CircuitParser.g4
3. javac *.java

### Exécution

Le plus simple est d'utiliser le fichier file_test.txt comme entrée du programme. Ainsi placer y votre code à analyser puis à exécuter, vous pouvez maintenant lancer la commande suivante :

* grun Circuit prog file_test.txt  

Comme résultat vous obtiendrez l'affichage de vos erreurs de syntaxe si elles existent mais egalement la description de votre circuit si vous utilisez la fonction descr() et le résultat d'exécution (en fonction des arguments) avec la fonction eval().
