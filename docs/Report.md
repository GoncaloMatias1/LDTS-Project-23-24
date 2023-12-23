# LDTS_<T05><G06> - Space Invaders

## Game Description

Space Invaders is a fixed shooter in which the player moves a spaceship horizontally across the bottom of the screen and fires at aliens overhead. The rows of aliens move left and right as a group, shifting downward each time they reach a screen edge.

This project was developed by Gonçalo Barroso (up202207832@fe.up.pt), Gonçalo Matias (up202108703@fe.up.pt), and Rodrigo Arteiro (up202108749@fe.up.pt) for LDTS 2023/24.

## Implemented Features

- **Lives Display**: The amount of lives will be displayed on the bottom corner of the screen.
- **Moving**: The player will be able to move their character left or right. Monsters will also move in a defined zig-zag pattern.
- **Shooting**: The player character will shoot a projectile when the spacebar is pressed. A random enemy in the group will shoot a bullet every time the group moves.
- **Bullet Collision**: When a bullet hits an enemy, the bullet will disappear and the enemy will take damage, vice-versa for the player.
- **Score**: For every enemy destroyed by the player, they are awarded points for their score. At the end of the game, when they lose, if the Score is higher than the previous High Score, it gets replaced. The scores are stored in a separate file, so the High Score is kept even when the game is turned off.
- **Mystery Ships**: Three random ships in each group of enemies must be hit 3 times to get destroyed and give the player more score than normal ships.
- **Shields**: Five groups of three shields, each having their own durability and which can be damaged by any type of projectile.
- **Enemies Respawn**: Every time the group of enemies is destroyed, a new one appears from the start of the screen and new shields are created too.
- **Game Over**: The Game Over screen will only appear when the aliens reach the shields or the player reaches 0 lives.
- **Controls Screen**: A menu that is accessible through the Main Menu gives instructions on how to play and keyboard controls information to the player.

## Planned Features

- **Sound Effects**: Sound effects for when the player shoots or projectiles hit entities.
- **Progressive Difficulty**: With each wave destroyed, the game would get harder and harder to a limit.

## Design

![classesdesign.png](images%2Fclassesdesign.png)

### Structure

#### Problem in Context:

A structure for the game needed to be defined since it will be a constant, expansive project and also coded by different people at the same time, needing to have it organized with linear dependencies that are not convoluted.

#### The Pattern

We have applied the **MVC** pattern to solve this problem.
The **Model-View-Controller (MVC)** architecture is a design pattern that structures applications into three main components:
- **Model**: The core of the application's business logic, representing the data and the rules that govern access to and updates of this data.
- **View**: The presentation layer that displays the data from the model to the user in a specific format.
- **Controller**: The interface between Model and View, processing all the business logic and incoming requests, manipulating data using the Model, and interacting with the Views to render the final output.

![mvc.png](images%2Fmvc.png)

#### Advantages of MVC:
- **Separation of Concerns**: Each component has a distinct responsibility, making it easier to manage complexity and maintain the application.
- **Facilitates Parallel Development**: Developers can work on the model, view, and controller code simultaneously, reducing development time.
- **Ease of Modification**: Changes to the business logic or the UI can be made with minimal impact on the other parts of the application.
- **Support for New Types of Views**: Because the model does not depend on the views, new types of views can be added without changing the model.
  MVC is particularly well-suited for web applications where the view is the HTML or JSON output returned to the browser. However, it's widely applicable across different types of software development projects.

### State

#### Problem in Context

While the game is running, there are different states that it will go through, these being the Main Menu, the Arena, the Game Over screen and the Controls screen. We need a way to manage which one can get to each and what is shown on screen at each step in the application.

#### The Pattern

We have applied the **State** pattern. A behavioral design pattern used to change the behavior of the main application class, corresponding to each menu:
- **Main Menu**: Where the game starts, it can lead to the gameplay, the controls menu or can quit the game.
- **Controls Menu**: A simple screen that shows the objective of the game and the controls, can only lead back to the Main Menu.
- **Arena**: The game itself, this is where the whole gameplay happens, from here the player can lose and lead to the next menu.
- **Game Over Menu**: This menu shows the score obtained by the player and the current highscore, it can lead to the Main Menu or close the game.

#### Advantages of the State Pattern
- **Support for new types of States**: The State pattern allows an object to change its behavior dynamically by changing its internal state. This makes it easy to add or remove states.
- **Readability and Encapsulation**: The State pattern makes the code more readable and expressive. By representing states as separate classes and defining state-specific behavior within those classes, the code becomes more self-explanatory and easier to follow.


## Known code smells

The [ArenaController](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgoncalomatias1%2Fl05gr06%2FController%2FMenu%2FArenaController.java) class, while functional, presents opportunities for enhancement to align with coding best practices. We can consider improving code readability and maintainability by addressing certain aspects, such as organizing complex initialization, reducing the reliance on hard-coded values. These adjustments aim to make the code even more polished and easier to work with, ensuring a smoother development process in the future.

The [ArenaModel](..%2Fsrc%2Fmain%2Fjava%2Fcom%2Fgoncalomatias1%2Fl05gr06%2FModel%2FMenu%2FArenaModel.java) class, while fully functional, offers opportunities for enhancement to align with coding best practices. We can further improve code readability and maintainability by addressing specific areas, such as reducing the presence of magic numbers and refining error-handling logic. These refinements aim to make the code more polished and user-friendly, ensuring a smoother development and maintenance experience for our team.

## Testing

### Coverage report

![TestCoverage.png](images%2FTestCoverage.png)

### Link to Pitest report

[Mutation tests](..%2Fbuild%2Freports%2Fpitest%2Findex.html)

## Self-evaluation
We are very happy with our teamwork and agreements, we came really well as a balanced and trustful team, we all worked on different things but helped in each other's goals:

Gonçalo Matias - 33% / Gonçalo Barroso - 33% / Rodrigo Arteiro - 33%
