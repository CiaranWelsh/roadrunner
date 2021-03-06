(*

category:        Test
synopsis:        Multiple species references to the same species
componentTags:   Compartment, Reaction, Species
testTags:        Amount, NonUnityStoichiometry
testType:        TimeCourse
levels:          2.1, 2.2, 2.3, 2.4, 2.5, 3.1, 3.2
generatedBy:     Numeric
packagesPresent: 

 In this test, a single reaction has multiple reactants and products that all point to the same species.  This is equivalent to a reaction where all of the species references that point to the same species are collapsed into a single species reference with a stoichiometry equal to the sum of the stoichiometries of the original species references.

The model contains:
* 1 species (A)
* 1 compartment (C)

There is one reaction:

[{width:30em,margin: 1em auto}|  *Reaction*  |  *Rate*  |
| J0: A + 2A + -4A -> 5A + -2A + A + -1A | $1$ |]

The initial conditions are as follows:

[{width:35em,margin: 1em auto}|       | *Value* | *Constant* |
| Initial concentration of species A | $1$ | variable |
| Initial volume of compartment 'C' | $1$ | constant |]

*)
