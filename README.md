# Slippery Slot Machines
## COSC 150 - Advanced Programming

- [Goals](#goals)
- [Description](#description)
- [Specification and requirements](#specification-and-requirements)
- [Provided files](#provided-files)
- [Grading rubric](#grading-rubric)

## Goals

In order to complete this assignment, I needed to:
- Understand how to model decision-making behavior in UML
  - Create a UML activity diagram expressing the payout-deciding behavior used in this assignment.
- Understand how to create a unit test suite for a Java class
  - Consider the logical aspects of designing unit tests for a slot machine
  - Implement your test cases using JUnit 5
- Understand how to implement a design specification and validate it with unit tests
  - Implement a slot machine using the provided specifications

## Description

In this assignment, you take the role of an online developer for Slippery Slot Machine Company. SSMC creates themed slot machine apps, at the core of which is a program which generates random slot machine spins and computes corresponding payouts.

SSMC has already generated a specification (below) of the rules for their slot machines, and several developers have implemented versions of their slot machine that claim to correctly implement these rules. Your task is to develop a comprehensive set of unit tests to verify these implementations' correctness. In addition, you will provide your own implementation of the rules (validated by your own test cases, of course).

## Specification and requirements

#### The SlipperySlot rules

In this assginment, I implemented a Slippery Slot Machine that functions according to the following rules: 
- A single play costs $2 and produces a set of five numbers taking values between 1 and 50 (inclusive) as uniformly-distributed, i.i.d. random variables.
- Once the five number spin has been generated, an associated payoff is computed by applying the rules below.
  - Rules 1-5 are mutually-exclusive -- at most one of these rules may apply at a time, and each rule may apply exactly once per spin (choose the highest-paying rule which applies).
  - Rules 6-8 may apply in combination with any of rules 1-5 or with each other, but at most once per spin (each).
  
The payout rules are:
1. If all five numbers are the same, pay $1000000.
2. If four numbers are the same (and the fifth number does not match), pay $10000.
3. If three numbers are the same AND the remaining two numbers match each other (but not the previous three -- a "full house"), pay $5000.
4. If three numbers are the same and the remaining two numbers are different (both from the set of three and each other), pay $100
5. If any two numbers are the same (but no previous rule applies), pay $10.
  - Note that rule 5 is applied at most once per spin, even if the spin contains two distinct pairs of matching numbers.
6. If one or more of the five numbers is a perfect (integer) square, add $7 to the payout (at most once per spin).
7. If one or more of the five numbers is 42, add $2 (at most once per spin).
8. If one or more of the five numbers is a power of two, add $3 (at most once per spin).

#### The SlipperySlot API

My implementation of a SlipperySlot enacts the rules above through the following two public methods:
- `int[] pullTheLever()`
  - This method generates a single spin of the slot machine. Its return value is an array of five integer values, each lying between 1 and 50 (inclusive) and chosen to be appropriately random.

- `int payOff( int[] values )`
  - This method takes as input an array representing a single spin (same form as the return value of `pullTheLever()`). It's return value is the correct payoff of that spin, computed according to the rules above.

### Requirements

I had to create the following files and add them to my repository:
- `ActivityDiagram.pdf`, a UML activity diagram which models the behavior of the `payOff` method described above.
  - Your diagram may assume that the five-number spin has been provided (as input to the function).
  - Your diagram should describe the logic used to detect each of the rules above.
  - You may choose to create a "nested activity" diagram (that is, an interaction overview diagram) where high-level decision blocks (like "is this a full house?") are elaborated on in a subsequent diagram.
  
This diagram will be *hand-graded* by me after the design document due date; the automatic grader will only test for its existence.

- `TestSlipperySlot.java`, a JUnit 5 test suite which contains JUnit tests on the `payOff` method of the SlipperySlot Machine.
  - Your test suite should target a class named `SlipperySlot` (e.g., when instantating a slot machine for testing).
  - Your test suite should be comprehensive enough to catch a flaw in the implementation of any of the `payOff` rules above.
  - For sanity's sake, you may assume that `payOff` does not contain "malicious" code that triggers an error only when detecting a specific combination (e.g., "23-19-19-10-31"); instead, your tests should look for "unintentional" programming errors.

- `BetterSlot.java`, an implementation of the rules described above. Your `BetterSlot` class must provide the two public methods described above.
  - Your `BetterSlot` may have additional (private) implementation as you see fit, so long as it fulfils the public API described above.
  - Your `BetterSlot` is not required to provide a `main` method, but may do so for your own testing purposes.
  - You are *strongly* encouraged to run your JUnit tests against your `BetterSlot` implementation; however, be sure that your final commit has the tests targeting a `SlipperySlot` instance.
     
