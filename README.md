--Afin de réaliser le projet dans un bon environnement, nous avons utilisé les bases de données de PostgreSql


Lors du lancement du programme, on affiche :
        ->l'heure à laquelle le programme est lancé.
        ->un choix entre les différents USERs ainsi que la possibilité d'arrêter le programme.

Pour chaque User, une authentification doit se faire vers la base de données avec le Login et le Password.
Si User existe, alors on accède à son menu.

Pour l'admin, nous avons fait un menu de SuperUser, Ajout, suppression et modification de :
                                ->Slot
                                ->Building
                                ->floor
                                -Professor
                                -Student
                                
pour le professeur, consultation de son planning, demande de réservation d'un créneau pour un cours.


Pour le student, affichage de l'emploi de temps par groupe et pour une semaine donnée en paramètre.