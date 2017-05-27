# ga-helloWorld
A simple example of genetic algorithm using _jenetics_ (http://jenetics.io/).

This example shows how a randomly generated string evolves to match a target string. The fitness function (ie the
function evaluating each population member) compute the Levenshtein distance between the target String and the
chromosome string and reward chromosomes closer to the target value.

## Example
| Stream max size  | population  | result | Levenshtein distance |
|---|---|---|---|
| 100  | 50  | heilx rvrcd  | 5
| 200  | 50  | hlellc wolz  | 4
| 500  | 50  | hello ovrld  | 2
| 1000  | 50  | hello wjrld  | 1
| 5000  | 50  | hello world  | 0

## License

[Apache2](LICENSE)

## Author

Sébastien BENARD - benard.se@gmail.com

