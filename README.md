Title: Projet Tetris - Info121  
Author: Fares Jean-Marc  
    Affani Mehdi

# Projet Tetris

# Piece.java par AFFANI Mehdi :
L’un des premiers soucis auquel j’ai eu à faire avec piece.java est l’ArrayList Skirt. Parmi les premières fonctions à coder, je pense que c’est la plus compliquée. J’ai d’abord pensé à créer un tableau temporaire stockant les abscisses déjà rencontrées par la boucle for, puis après un moment j’ai réalisé qu’il manquait une condition importante que j’ai rajouté via un « else if ». Un peu plus tard, j’ai rencontré quelques autres soucis avec cette partie, après une rotation, puisque les coordonnées des points du Tetris n’étaient pas rangées dans le bon ordre.
Puis j’ai eu du mal à visualiser l’effet d’une rotation sur une pièce, j’ai dû m’y prendre à plusieurs reprises avant de réussir. Les instructions du sujet me proposaient de faire une symétrie horizontale et verticale, ce que j’avais commencé par faire, mais je me suis rendu compte que ce n’était comme ça qu’une pièce agissait lors d’une rotation. En effet, après inversion des coordonnées des abscisses et des ordonnées il n’est pas nécessaire d’effectuer deux symétries, mais qu’une seule. Après symétrie par rapport à l’axe des ordonnées, la pièce a effectué une rotation contre le sens des aiguilles d’une montre.
Après avoir réussi, j’ai rencontré des soucis de dépassement des ArrayList à cause de la rotation. Les pièces ne s’alignaient pas à gauche après la rotation. Après l’avoir compris, j’ai pu modifier légèrement le code afin qu’il fasse en sorte que les pièces soient toujours alignées. J’ai ensuite eu des soucis avec les tests qui échouaient malgré le fait que les deux « body » comportaient les mêmes nombres. C’était parce que l’ArrayList Skirt était vide. Après avoir corrigé le problème avec Skirt, j’ai de nouveau eu droit à une erreur de dépassement. M’étant cassé la tête avec la rotation, et la fonction étant très peu lisible, j’ai décidé de la supprimer et recommencer de nouveau.
Cette fois ci, j’ai décidé d’utiliser un tableau afin de pouvoir jongler avec les coordonnées plus facilement. Je comptais transformer le tableau en chaine de caractère que je passerai ensuite en paramètre d’une pièce. Bien sûr, ça ne s’est pas passé comme prévu, même si je m’attendais à une erreur puisque cette fois ci je n’avais pas mis en place de système d’alignement des pièces. Je me suis rendu compte que le système d’alignement n’était pas nécessaire, et que le problème venait d’ailleurs. Ce n’est plus une surprise, il y avait dépassement au niveau de Skirt. Au lieu de recommencer Skirt à zéro une autre fois, après avoir compris d’où venait le souci, j’ai modifié ma fonction de rotation afin qu’elle trie les coordonnées par ordre croissant des abscisses des points qu’elle stockait. Restocker ces points dans un tableau qui serait ensuite converti en chaine de charactères me semblait un peu stupide, j’ai donc décidé de créer une ArrayList où y stocker les points rangés dans l’ordre croissant.
Les autres fonctions n’ont pas posé beaucoup de difficultés, même si ParsePoints et toString ont nécessité beaucoup de recherches afin de mettre en œuvre les méthodes imaginées.

# Board.java par FARES Jean-Marc :

# JBrainTetris.java par AFFANI Mehdi :
La difficulté principale de cette classe était la documentation. Une grande partie de ce qu’il fallait faire était assez bien expliqué dans l’énoncé du projet, malheureusement, si on n’avait pas lu et compris toutes les classes du projet, et effectué quelques recherches sur les interfaces, cases et autres fonctions utilisées dans cette classe, on avait du mal à comprendre ce qu’il fallait y faire.
Du à l’utilisation de plusieurs fonctions de même noms, il était parfois nécessaire de mentionner de quelles classes on appelait certaines fonctions, ce que je n’avais pas l’habitude de faire.
CreateControlPanel, où la deuxième fonction de cette classe sur laquelle j’ai travaillé, m’a posé des soucis à cause des raisons que j’ai donné plus haut. Je ne connaissais pas assez les fonctions que je pouvais utiliser. J’ai du m’y prendre plusieurs fois, et la modifier à plusieurs reprises avant de la recommencer de zéro quand il a fallu ajouter l’adversaire. Le problème principal était le changeListener qui m’a nécessité beaucoup de temps pour comprendre comment je pouvais l’utiliser correctement.
PickNextPiece et PickWorstPiece j’ai codé en parallèle. J’ai mis un moment avant de comprendre que je devais comprendre et utiliser le suffixe « super » pour réduire le nombre de ligne de la fonction PickNextPiece et la faire fonctionner correctement. 
