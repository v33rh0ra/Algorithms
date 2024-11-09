### Fork Join Framework

Designed for tasks that can be broken down and take advantage of multiple processors, 
i.e Divide and Conquer approach.
Following are core classes located in `java.util.concurrent`

- **ForkJoinPool**: An ExecutorService for running, managing and monitoring ForkJoinTask(s).
- **ForkJoinTask**: Represents the abstract task that runs within the ForkJoinPool.
- **RecursiveTask**: A subclass of ForkJoinTask whose compute method returns some value.
- **RecursiveAction**: A subclass of ForkJoinTask whose compute method executes an action and does not return any value.

A trivial example has been defined in the `forkjoin` package, which shows the usage of the fork join framework.
In the example, we calculate the sum of `N` integers.

- **ForkJoinTest** : Creates an array of `N` integers and passes it to the `NumberDividerTask` using `ForkJoinPool.invoke()`.
- **NumberDividerTask** : This task checks if the array size is greater than `MAX_TASK_LEN`. If yes then it recursively divides the array into two halves. Otherwise it passes the array to a `SumCalculatorTask`. Lastly it uses a for loop to sum all the tasks together.
- **SumCalculatorTask** : This task uses a for loop to calcualte the sum of array elements. [O(n) ST]