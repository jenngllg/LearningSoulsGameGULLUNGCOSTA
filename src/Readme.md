__________________________________________________________________________ TP1 __________________________________________________________________________________________________


6. 
La visibilit� optimale serait protected car il n'y a pour l'instant qu'un seul package dans lequel se trouvent nos classes Monster et Hero et notre main qui fait appel � ces classes, et qu'elle serait accessible � toute classe qui h�rite de Hero.


7.
La visibilit� optimale serait public car notre main dans le package lsg fera appel aux classes du package characters ou se trouvent les classes Hero et Monster.


__________________________________________________________________________ TP2 __________________________________________________________________________________________________

1. 
getClass() retourne un tableau contenant les objets de la classe
getSimpleName() retourne le nom de la classe
Du coup, this.getClass().getSimpleName() retourne le nom de la classe de l'objet utilis�

On doit passer les membres de private � protected car on n'y avait pas acc�s en dehors de la classe Character. Protected prend en compte les extensions (Hero et Monster extends Character).

6. 
La durabilit� de l'�p�e diminue de un � chaque fois que tapent le monstre et le h�ros. C'est normal, car on a instanci� une seule �p�e. 

__________________________________________________________________________ TP3 __________________________________________________________________________________________________

1. 
Nous avons mis le get en public et le set en protected

4.
Les classes Hero et Monster pr�sentent une erreur "the type Hero/Monster must implement the inherited abstract method Character.computeProtection()" car la m�thode est d�clar�e abstraite dans la classe m�re (Character, devenue abstraite par la suite car elle poss�de une m�thode abstraite), mais pas d�finie dans les classes qui h�ritent de cette derni�re (Hero/Monster). 

__________________________________________________________________________ TP4 __________________________________________________________________________________________________

3.
Nous n'avons plus besoin de l'attribut menu car MenuBestOfV3 est un HashSet.

HashSet : It makes no guarantees as to the iteration order of the set; in particular, it does not guarantee that the order will remain constant over time. => l'ordre s'ajout des �l�ments n'est pas garanti, et leur position n'est pas toujours la m�me

LinkedHashSet : This implementation differs from HashSet in that it maintains a doubly-linked list running through all of its entries. This linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order). => l'ordre des �l�ments est gard� car chaque �l�ment est li� � l'�l�ment se trouvant avant et � celui se trouvant apr�s lui-m�me