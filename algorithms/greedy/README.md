###Greedy
* Greedy makes locally optimal choice at every iteration.
* For example, if the problem is to minimize the sum of elements, then an optimal choice would be to go for minimum of two elements at a given time.
* The term "local" means - when it considers only the available options at the current step, and doesn't consider any consequences that may happen in the future from this decision.
* Most of the problems under this would be of finding maximum or minimum.
* In most of the problems, we would look to store the input elements, in order to find the min/max.
* in many greedy problems, you will be sorting the input at the start. Again, this is because we want to greedily choose the max/min elements in many problems, and sorting the input makes this convenient.
* Also, heap problems can be considered greedy as they too find min/max of elements.
* "Greedy" isn't a data structure and it isn't any single algorithm either, but more of a way to approach a problem.

####Note
* In majority of the cases, greedy approach would result in an answer that is close to the correct answer.
* So, it becomes challenging to figure out when to use this approach and when to avoid it.
* A good example is the travelling salesman problem

#### Problems
* [Destroying Asteroids](DestroyingAsteroids.java)
* [Partition Array Such That Maximum Difference Is K](PartitionArray.java)
* [IPO](Ipo.java)
* [Boats to save people](BoatsToSavePeople.java)