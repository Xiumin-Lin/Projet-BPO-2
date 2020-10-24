# Projet-BPO-2
## DUT Informatique, Projet BPO Période D réalisé par Xiumin LIN & Farah DOGHRI

Durant cette deuxième période du Semestre 2, nous avons eu pour tâche de réaliser en cours de BPO un projet en langage JAVA. 
Celui-ci consiste à nous mettre à la place d’une équipe de développeur devant concevoir un logiciel de montage de Film en format TXT. 
Plus précisément, nous devons réaliser une bibliothèque pouvant combiner des films existants sur lesquels on pourra réaliser plusieurs actions tel que l’encadrement d’un film, 
l’incrustation de celui-ci dans un autre, l’extraction d’images d’un film, le collage d’un film avec un autre et enfin, la répétition d’un film autant de fois que l’on souhaite.

Afin de nous guider dans ce projet et de faciliter sa réalisation, il nous est fourni une interface « Film » imposant 4 méthodes obligatoires qu’un film doit posséder :
  * hauteur() permettant de renvoyer la hauteur de l’écran du film
  * largeur() permettant de renvoyer la largeur de l’écran du film
  * suivante() permettant d’obtenir l’image suivante du film s’il en a lorsqu’il est joué
  * rembobiner() permettant de remettre à zéro un film
  
Une classe « Films » est également fourni, offrant un ensemble de méthodes utilitaires qui peuvent être utilisées par un film tel que sa projection ou sa sauvegarde.

Les montages résultants des actions citées précédemment doivent alors agir comme un film normal, c’est-à-dire qu’ils possèdent les méthodes fournis par l’interface « Film » et
peuvent utiliser la classe utilitaire « Films ».

L’interface « Film » est aussi utilisée par une autre équipe chargée du développement de l’interface graphique du logiciel de montage. Ce qui nous contraint à
ne pas pouvoir modifier l’interface « Film ».

D’autre contraintes nous ont été imposées et que l’on devra respecter afin d’éviter toute erreur dans notre code tel que :
  * La résolution d’un film devra toujours être identique pour chaque image qui le compose
  * Les différentes images qui composent un film devront être obtenues par l’appel successif de la méthode suivante()
  
Nous avons également mis en place des règles concernant notre bibliothèque afin que les opérations ne provoquent pas d’erreurs comme par exemple l’interdiction d’utiliser des
films possédant une référence « null » lors des opérations de montage. Nous détaillerons les autres règles dans la partie test de ce dossier. 
