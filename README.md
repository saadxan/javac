# javac
A parser &amp; tokenizer for plain C code.

<br>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Command line application that parses and tokenizes plain C code using Java. 

Features:
* Parses and tokenizers given input file of C code via command line arguments
* Tokenizes file passed as 0th argument in command-line
* Optional 1st argument flags of `-verbose` and `-quiet` for special tokenized output

Examples:

```console
saadxan@PC javac % javac *.java
saadxan@PC javac % java Scanner front.in
Next token is: 46         Next lexeme is: procedure  Next code is PROC      
Next token is: 41         Next lexeme is: main       Next code is MAIN      
Next token is: 54         Next lexeme is: {          Next code is LEFT_BRACKET
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: result     Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 10         Next lexeme is: 42         Next code is INT_LIT   
Next token is: 23         Next lexeme is: *          Next code is MULT_OP   
Next token is: 10         Next lexeme is: 13         Next code is INT_LIT   
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 10         Next lexeme is: 37         Next code is INT_LIT   
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 11         Next lexeme is: result     Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 21         Next lexeme is: +          Next code is ADD_OP    
Next token is: 10         Next lexeme is: 47         Next code is INT_LIT   
Next token is: 24         Next lexeme is: /          Next code is DIV_OP    
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 
Next token is: 55         Next lexeme is: }          Next code is RIGHT_BRACKET


```

```console
saadxan@PC javac % javac *.java                
saadxan@PC javac % java Scanner front.in -quiet
[INT, IDENT, SEMICOLON]
[INT, IDENT, SEMICOLON]
[INT, IDENT, SEMICOLON]
[IDENT, ASSIGN_OP, INT_LIT, MULT_OP, INT_LIT, SEMICOLON]
[IDENT, ASSIGN_OP, INT_LIT, SEMICOLON]
[IDENT, ASSIGN_OP, IDENT, ADD_OP, INT_LIT, DIV_OP, IDENT, SEMICOLON]
[PROC, MAIN, LEFT_BRACKET, RIGHT_BRACKET]
```

```console
saadxan@PC javac % javac *.java                  
saadxan@PC javac % java Scanner front.in -verbose
 procedure main {
Next token is: 46         Next lexeme is: procedure  Next code is PROC      
Next token is: 41         Next lexeme is: main       Next code is MAIN      
Next token is: 54         Next lexeme is: {          Next code is LEFT_BRACKET

 int sum;
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 int total;
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 int result;
Next token is: 40         Next lexeme is: int        Next code is INT       
Next token is: 11         Next lexeme is: result     Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 sum = 42 * 13;
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 10         Next lexeme is: 42         Next code is INT_LIT   
Next token is: 23         Next lexeme is: *          Next code is MULT_OP   
Next token is: 10         Next lexeme is: 13         Next code is INT_LIT   
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 total = 37;
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 10         Next lexeme is: 37         Next code is INT_LIT   
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 result = sum + 47 / total;
Next token is: 11         Next lexeme is: result     Next code is IDENT     
Next token is: 20         Next lexeme is: =          Next code is ASSIGN_OP 
Next token is: 11         Next lexeme is: sum        Next code is IDENT     
Next token is: 21         Next lexeme is: +          Next code is ADD_OP    
Next token is: 10         Next lexeme is: 47         Next code is INT_LIT   
Next token is: 24         Next lexeme is: /          Next code is DIV_OP    
Next token is: 11         Next lexeme is: total      Next code is IDENT     
Next token is: 53         Next lexeme is: ;          Next code is SEMICOLON 

 }
Next token is: 55         Next lexeme is: }          Next code is RIGHT_BRACKET

```


<!-- CONTRIBUTING -->
## Contributing

Contributions are integral to the open source community and are the reasons why it's so awesome. If you would like to contribute to this project, you can by: 

1. Fork the Project
2. Create a Feature Branch `git checkout -b new-feature`
3. Add files `git add .`
4. Commit Changes `git commit -m 'msg'`
5. Push to Origin `git push -u origin new-feature`
6. Open a Pull Request



<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.



<!-- ACKNOWLEDGEMENTS -->
## Acknowledgements

* [Example](https://www.example.com)
