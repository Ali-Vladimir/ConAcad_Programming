# ConAcad_Programming
Explore projects from ConAcad. These programs are here to assist future peers with learning and as examples for exploration. Contributions are welcome!!!

### Tips for ConAcad Platform

When working on programs within the ConAcad platform, it's crucial to follow these tips to maximize your learning and success:

1. **Read Everything**: The most important advice is to read everything available on the page—instructions, help sections, tips, languages, descriptions, etc. Each piece of information is there for a reason and can potentially help you solve problems or get started, even if you haven't encountered them before.

### Disclaimer

In this section of the ReadMe, I'll share some tips based on my experience with the platform that might assist you. However, please note that most of these tips should not be used, as they could be considered cheating or taking shortcuts. If you choose to apply any of these tips, you do so at your own risk and responsibility.


## How to Lower Similarity Scores in Programs

Alright, let's start with a basic one. As you already know, within the platform there's a percentage of similarity that the judge determines based on what, in my experience, includes the following:

a. General structure of the program  
b. Methods used  
c. Execution sequence  
d. Subprocesses  
e. Quantities  
f. Names in general  

I'll explain what I mean by each of the above points. To begin with, the judge determines the general structure of the program—how many classes you used, how many objects you created, how many calls to those objects you made, etc. Additionally, it reviews the methods used; if you used methods that were already part of the Java library and are specific to certain uses, like `.row` from `Math` or `.keyboard` from `Scanner`, it also detects that similarity, along with the quantity of methods used. It also reviews their execution, though I'm not entirely sure; by this, I mean the order in which you execute those methods. It detects this based on their position, so if you have a method that multiplies and then a method that subtracts, and you execute them in that order, the judge might detect that execution pattern and add to the similarity percentage.

Because I forgot to mention it earlier, similarity is derived from a sum of points obtained as the code is reviewed. Therefore, theoretically, all programs have a similarity percentage, but it isn't shown until it reaches 70% similarity, and it starts affecting scores from 77% onwards. As you know, the consequence is that you don't receive all the corresponding points on the platform. Similarly, the judge reviews subprocesses, and this is where modularity comes into play. I mean how many actions you're performing within a method. For example, if you have a method called `sum` and within that method you read a number from the console, then add it, and finally print it—all within a method, as I mentioned earlier—this will end up detecting similarity. Similarly, just as it affects methods, it also affects the quantities of variables you use and the data types you use for them. Finally, the judge also reviews the names you've used in the code, such as class names, method names, objects, attributes, variables, parameters, etc.

Now, I'll tell you how you can lower the similarity percentage. If you understood how what I said earlier works, you can come up with creative solutions on your own. But the most common and recommended ways to lower the similarity percentage are as follows:

1. **Create Garbage Methods:** You can create methods that serve no useful purpose—empty methods or methods that do meaningless things unrelated to the program's functioning. You can also execute them later if you wish.
   
2. **Modularize the Code:** If you already have the code, try dividing it and creating more methods or classes to help solve the problem, thereby reducing the request. Alternatively, you can optimize the existing code and place more processes within a method.

3. **Change Names:** I think this is quite basic, but you can change the names of the variables you used to others, perhaps in English or following a standard.

To conclude this first point, I want to clarify a few things. First, something that's useless to do is to modify the code at the ordering level. Let me explain: if you wrote `(method1, method2, method3)` and you think that changing the order to `(method3, method2, method1)` will lower the percentage, it won't for a simple reason: the judge doesn't have eyes and can't see that the code looks different just because it's reversed or something like that. Another important point to emphasize is that you shouldn't actually place too much importance on the similarity percentage. It's very annoying not to get all the points, but if you did everything legally in the end, you'll get all the points regardless of the percentage. Finally, I'll clarify one point. It seems obvious at first glance, but I'll mention it anyway: if you're going to add garbage methods to your code, this will be evident when your code is reviewed. If it does get reviewed, the garbage methods will be there, and you might be questioned for using them.


## How to create a program that fetches the answers

Continuing with the tips, now I'll explain how you can create a simple program that you can integrate into specific programs to fetch and display the test cases for you.

If you haven't noticed yet, when you're working on programs, there are different types in terms of how they provide feedback. Basically, there are 3 types: those that only indicate if the output is correct or incorrect, those that give a percentage of correct outputs, and finally those that show your own output. We'll focus on the latter type, where it's also possible for the program to show the correct answers alongside your incorrect output.

To create a program that collects this information, all we need to do is create a simple program that reads input from the console or any convenient source, and continues reading in a loop while appending this information to a string variable. This will eventually cause an error, and when it does, we can use a try-catch block to catch the exception and print everything that has been collected so far. Voila! We will then have the test cases that the judge is using in our program, giving us a better understanding of what we're doing wrong.

```java
import java.util.Scanner;
public class Recolectadora {
    public static void main(String[] args) {
        Recolectora objeto = new Recolectora();
        objeto.m_acepDatos();
    }
}
class Recolectora {
    Scanner a_teclado;
    String a_informacion = "";
    Recolectora() {
        a_teclado = new Scanner(System.in);
    }
    void m_acepDatos() {
        try {
            while (true) {
                a_informacion = a_informacion + "\n" + a_teclado.nextLine();
            }
        } catch (Exception e) {
            System.out.println(a_informacion);
        }
    }
}
