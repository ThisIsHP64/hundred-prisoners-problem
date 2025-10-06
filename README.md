# The 100 Prisoners Problem
This program demonstrates the incredible solution to the 100 prisoners problem, a problem first proposed and considered in 2003 by Anna Gál and Peter Bro Miltersen. Even if you understand the semantics of the problem, the solution seems impossible.

## The Problem
One hundred prisoners on death row, numbered in sequence 1-100, are approached by a warden who offers them a last chance. The warden brings the prisoners to a room containing one hundred boxes, whose lids are also numbered in sequence 1-100. Inside each box, the warden has placed a paper slip containing a random prisoner's number. The slips must not be removed from their boxes, but can be viewed by opening a box. The warden tells the prisoners that each of them is allowed to enter the room, one at a time, and open any fifty of the boxes. If the slip inside one of the open boxes contains the number of the prisoner who opened it, that prisoner is escorted out of the room, the room is reset (all boxes are closed), then the next prisoner is allowed to enter. This cycle repeats until any one of the prisoners does not find their number inside any of the fifty boxes they opened, in which case all of the one hundred prisoners are executed. If, however, every prisoner manages to find their number, all are freed.

Before the first prisoner enters the room, the prisoners may strategize. However, they cannot communicate after the first prisoner enters to look in the boxes.

What is their best strategy?

## The Naive Solution
If each prisoner selects fifty boxes at random, this gives the group an astronomically small (0.00000000000000000000000000008%) chance of being freed. Can they do better?

## The Optimal Solution
Astonishingly, they can increase their chances of being freed to over 30% by following this procedure:

1. Each prisoner begins by opening the box whose lid contains their own number.
2. If the slip inside contains the prisoner's number, continue to the next prisoner.
3. If the slip contains a different number, open the box containing that number on the lid.
4. Each prisoner repeats steps 2 and 3 until they have either found their own number or opened fifty boxes.

If a prisoner were able to continue this strategy indefinitely (beyond the fifty box limit), they would inevitably loop back to the box they started with. By starting with their own number, the prisoner guarantees they are on the loop that contains the slip with their number. The only question is whether any loop is longer than fifty boxes. Only one loop could possibly be too long, since at most one can comprise more than half of the total boxes. Doing the calculations reveals that the probability of all of the prisoners being freed using this strategy is approximately 31%.

## The Program
This program demonstrates the difference in probability between the prisoners using the random strategy and the optimal strategy. It does this by performing a large number of trials using each strategy and displaying the results to the console. Adjust the parameter in Main.java to change the number of trials performed using each strategy.

## Questions? Comments?
Reach out to me on Discord @thisishp64. Thank you!
