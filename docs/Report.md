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

### Structure

#### Problem in Context:

A structure for the game needed to be defined since it will be a constant, expansive project and also coded by different people at the same time, needing to have it organized with linear dependencies that are not convoluted.

#### The Pattern

We have applied the **MVC** pattern to solve this problem.
The **Model-View-Controller (MVC)** architecture is a design pattern that structures applications into three main components:
- **Model**: The core of the application's business logic, representing the data and the rules that govern access to and updates of this data.
- **View**: The presentation layer that displays the data from the model to the user in a specific format.
- **Controller**: The interface between Model and View, processing all the business logic and incoming requests, manipulating data using the Model, and interacting with the Views to render the final output.

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

We have applied the **State** pattern. A behavioral design pattern used to change the behavior of the main application class, corresponding to each menu.

#### Consequences

The use of the State Pattern allows the following benefits:

- It’s easier to add future possible States.
- There will be less repeated code.

#### Entities

##### Problem in Context

Different Entities in-game have very similar methods related to all of them. We had to use a way to avoid using too much repeating code and having to only write these common equal methods once.

##### The Pattern

We have applied the **Factory** pattern. Like this, every subclass that uses equal code doesn’t need to reimplement it and can simply be a subclass that implements only what's different.

##### Implementation

Currently, we aim to make the subclasses Monster, PlayerShip, and Bullet of Entity.

##### Consequences

The use of the Factory Method allows the following benefits:

- It’s easier to add future possible subclasses.
- There will be less repeated code overall.

## Testing

### Coverage report


### Link to report


## Self-evaluation




