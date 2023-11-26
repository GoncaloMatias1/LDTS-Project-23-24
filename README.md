## LDTS_T05G06 - Space Invaders

> Space Invaders is a fixed shooter in which the player moves a laser cannon horizontally across the bottom of the screen and fires at aliens overhead. The aliens begin as five rows of eleven that move left and right as a group, shifting downward each time they reach a screen edge.

This project was developed by Gonçalo Barroso (up202207832@fe.up.pt), Gonçalo Matias (up202108703@fe.up.pt), and Rodrigo Arteiro (up202108749@fe.up.pt) for LDTS 2023⁄24.

### PLANNED FEATURES

- **Game Over** - The Game Over screen will only appear when the aliens reach the end or the player reach 0 lives
- **Lives Display** - The amount of lives will be displayed on the bottom corner of the screen
- **Moving** - The player will be able to move their character left or right. And monsters will move too.
- **Shooting** - The player character will shoot a projectile when the spacebar  is pressed. Similar to the player, the enemies will shoot in time intervals.
- **Bullet Collision** - When a bullet hits an enemy, the bullet will disappear and the enemy will take damage and vice-versa for the player. If the player bullet hits an enemy bullet, both will disappear.

### DESIGN

#### Structure

**Problem in Context**

A structure for the game needed to be defined.

**The Pattern**

We have applied the **MVC** pattern. For each concern, the interface, the controls and the calculation methods are all in different classes.

**Consequences**

The use of the MVC Pattern in the current design allows the following benefits:

Less convoluted individual classes
Easier future implementation of new methods, knowing which is needed for each


#### State

**Problem in Context**

While the game is running, there are different states that it will go through, these being the Main Menu, the Arena, the Game Over screen and the Controls screen. We need a way to manage which one can get to each and what is shown on screen at each time.

**The Pattern**

We have applied the **State** pattern. Like this, the Application class doesn’t have to have each state class's implementation and only its superclass as a reference.

**Consequences**

The use of the State Pattern allows the following benefits:

It’s easier to add future possible States
There will be less repeated code

#### Entities

**Problem in Context**

Different Entities in-game have very similar methods related to all of them. We had to use a way to avoid using too much repeating code and having to only write these common equal methods once.

**The Pattern**

We have applied the **Factory** pattern. Like this, every subclass that uses equal code doesn’t need to reimplement it and can simply be a subclass that implements only what's different

**Implementation**

Currently we aim to make the subclasses Monster, PlayerShip and Bullet of Entity

**Consequences**

The use of the Factory Method allows the following benefits:

It’s easier to add future possible subclasses
There will be less repeated code overall

