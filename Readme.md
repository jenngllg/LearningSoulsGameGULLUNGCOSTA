__________________________________________________________________________ TP1 __________________________________________________________________________________________________


6. 
La visibilite optimale serait protected car il n'y a pour l'instant qu'un seul package dans lequel se trouvent nos classes Monster et Hero et notre main qui fait appel a ces classes, et qu'elle serait accessible a toute classe qui herite de Hero.


7.
La visibilite optimale serait public car notre main dans le package lsg fera appel aux classes du package characters ou se trouvent les classes Hero et Monster.


__________________________________________________________________________ TP2 __________________________________________________________________________________________________

1. 
getClass() retourne un tableau contenant les objets de la classe
getSimpleName() retourne le nom de la classe
Du coup, this.getClass().getSimpleName() retourne le nom de la classe de l'objet utilise

On doit passer les membres de private a protected car on n'y avait pas acces en dehors de la classe Character. Protected prend en compte les extensions (Hero et Monster extends Character).

6. 
La durabilite de l'epee diminue de un a chaque fois que tapent le monstre et le heros. C'est normal, car on a instancie une seule epee. 

__________________________________________________________________________ TP3 __________________________________________________________________________________________________

1. 
Nous avons mis le get en public et le set en protected

4.
Les classes Hero et Monster presentent une erreur "the type Hero/Monster must implement the inherited abstract method Character.computeProtection()" car la methode est declaree abstraite dans la classe mere (Character, devenue abstraite par la suite car elle possede une methode abstraite), mais pas definie dans les classes qui heritent de cette derniere (Hero/Monster). 

__________________________________________________________________________ TP4 __________________________________________________________________________________________________

3.
Nous n'avons plus besoin de l'attribut menu car MenuBestOfV3 est un HashSet.

HashSet : It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. => l'ordre d'ajout des elements n'est pas garanti, et leur position n'est pas toujours la meme

LinkedHashSet : This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order). => l'ordre des elements est garde car chaque element est lie a l'element se trouvant avant et a celui se trouvant apres lui-meme

__________________________________________________________________________ TP6 __________________________________________________________________________________________________

2. Une exception java.lang.NullPointerException apparait car weapon est null et l'exception n'est pas geree dans attackWith(weapon) (dans la condition if (weapon.isBroken())) => at lsg.characters.Character.attackWith(Character.java:245)
