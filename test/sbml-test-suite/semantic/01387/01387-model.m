(*

category:        Test
synopsis:        A replaced species reference (itself in a replaced reaction) whose ID is used in a reaction.
componentTags:   Compartment, Reaction, Species, comp:ModelDefinition, comp:ReplacedElement, comp:Submodel
testTags:        Amount, NonUnityStoichiometry, SpeciesReferenceInMath, comp:SubmodelOutput
testType:        TimeCourse
levels:          3.1, 3.2
generatedBy:     Analytic
packagesPresent: comp

 In this model, a replaced submodel species reference (itself in a replaced reaction) is used in another reaction.

The 'flattened' version of this hierarchical model contains:
* 1 species (S1)
* 1 compartment (C)
* 1 species reference (J1_sr)

There are 2 reactions:

[{width:30em,margin: 1em auto}|  *Reaction*  |  *Rate*  |
| J1: -> 5S1 | $1$ |
| A__J2: S1 -> | $J1_sr$ |]

The initial conditions are as follows:

[{width:35em,margin: 1em auto}|       | *Value* | *Constant* |
| Initial concentration of species S1 | $3$ | variable |
| Initial volume of compartment 'C' | $1$ | constant |]

Note: The test data for this model was generated from an analytical
solution of the system of equations.

*)
