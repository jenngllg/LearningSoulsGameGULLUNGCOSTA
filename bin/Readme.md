__________________________________________________________________________ TP1 __________________________________________________________________________________________________


6. 
La visibilité optimale serait protected car il n'y a pour l'instant qu'un seul package dans lequel se trouvent nos classes Monster et Hero et notre main qui fait appel à ces classes, et qu'elle serait accessible à toute classe qui hérite de Hero.


7.
La visibilité optimale serait public car notre main dans le package lsg fera appel aux classes du package characters ou se trouvent les classes Hero et Monster.


__________________________________________________________________________ TP2 __________________________________________________________________________________________________

1. 
getClass() retourne un tableau contenant les objets de la classe
getSimpleName() retourne le nom de la classe
Du coup, this.getClass().getSimpleName() retourne le nom de la classe de l'objet utilisé

On doit passer les membres de private à protected car on n'y avait pas accès en dehors de la classe Character. Protected prend en compte les extensions (Hero et Monster extends Character).

6. 
La durabilité de l'épée diminue de un à chaque fois que tapent le monstre et le héros. C'est normal, car on a instancié une seule épée. 

__________________________________________________________________________ TP3 __________________________________________________________________________________________________

1. 
Nous avons mis le get en public et le set en protected

4.
Les classes Hero et Monster présentent une erreur "the type Hero/Monster must implement the inherited abstract method Character.computeProtection()" car la méthode est déclarée abstraite dans la classe mère (Character, devenue abstraite par la suite car elle possède une méthode abstraite), mais pas définie dans les classes qui héritent de cette dernière (Hero/Monster). 

__________________________________________________________________________ TP4 __________________________________________________________________________________________________

3.
Nous n'avons plus besoin de l'attribut menu car MenuBestOfV3 est un HashSet.

HashSet : It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. => l'ordre s'ajout des éléments n'est pas garanti, et leur position n'est pas toujours la même

LinkedHashSet : This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order). => l'ordre des éléments est gardé car chaque élément est lié à l'élément se trouvant avant et à celui se trouvant après lui-même